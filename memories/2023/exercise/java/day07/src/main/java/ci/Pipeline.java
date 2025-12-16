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
        var pipelineStatus = new PipelineStatus();
        var testStep = new TestStep("tests", log);
        var deployStep = new DeployStep("deploy", log);
        var reportStep = new ReportStep("report", log, emailer, config);

        testStep.run(project, pipelineStatus);
        deployStep.run(project, pipelineStatus);
        reportStep.run(project, pipelineStatus);
    }

}
