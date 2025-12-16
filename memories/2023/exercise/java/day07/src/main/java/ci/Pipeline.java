package ci;

import ci.dependencies.Config;
import ci.dependencies.Emailer;
import ci.dependencies.Logger;
import ci.dependencies.Project;

public class Pipeline {
    private final Config config;
    private final Emailer emailer;
    private final Logger log;

    public Pipeline(Config config, Emailer emailer, Logger log) {
        this.config = config;
        this.emailer = emailer;
        this.log = log;
    }

    public void run(Project project) {
        var result = doTestStep(project);
        var deployResult = doDeployStep(project, result);
        doReportStep(result, deployResult);
    }

    private TestStepResult doTestStep(Project project) {
        boolean testsPassed;
        if (project.hasTests()) {
            if ("success".equals(project.runTests())) {
                log.info("Tests passed");
                testsPassed = true;
            } else {
                log.error("Tests failed");
                testsPassed = false;
            }
        } else {
            log.info("No tests");
            testsPassed = true;
        }
        return new TestStepResult(testsPassed);
    }

    private DeployStepResult doDeployStep(Project project, TestStepResult result) {
        boolean deploySuccessful;
        if (result.testsPassed()) {
            if ("success".equals(project.deploy())) {
                log.info("Deployment successful");
                deploySuccessful = true;
            } else {
                log.error("Deployment failed");
                deploySuccessful = false;
            }
        } else {
            deploySuccessful = false;
        }
        return new DeployStepResult(deploySuccessful);
    }

    private void doReportStep(TestStepResult result, DeployStepResult deployResult) {
        if (config.sendEmailSummary()) {
            log.info("Sending email");
            if (result.testsPassed()) {
                if (deployResult.deploySuccessful()) {
                    emailer.send("Deployment completed successfully");
                } else {
                    emailer.send("Deployment failed");
                }
            } else {
                emailer.send("Tests failed");
            }
        } else {
            log.info("Email disabled");
        }
    }

}
