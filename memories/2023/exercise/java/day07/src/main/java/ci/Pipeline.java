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
        var testStep = new TestStep();
        var deployStep = new DeployStep();
        var reportStep = new ReportStep();

        var result = testStep.doTestStep(project, log);
        var deployResult = deployStep.doDeployStep(project, result, log);
        reportStep.doReportStep(result, deployResult, log, emailer, config);
    }

}
