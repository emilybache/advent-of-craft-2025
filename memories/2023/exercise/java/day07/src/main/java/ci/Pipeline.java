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
        var testStep = new TestStep(log);
        var deployStep = new DeployStep(log);
        var reportStep = new ReportStep(log, emailer, config);

        var result = testStep.run(project);
        var deployResult = deployStep.run(project, result);
        reportStep.run(result, deployResult);
    }

}
