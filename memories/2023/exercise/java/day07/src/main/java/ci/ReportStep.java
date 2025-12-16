package ci;

import ci.dependencies.Config;
import ci.dependencies.Emailer;
import ci.dependencies.Logger;

public record ReportStep(Logger log, Emailer emailer, Config config) implements PipelineStep {
    ReportStepResult run(TestStepResult result, DeployStepResult deployResult) {
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
        return new ReportStepResult();
    }
}
