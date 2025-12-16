package ci;

import ci.dependencies.Config;
import ci.dependencies.Emailer;
import ci.dependencies.Logger;
import ci.dependencies.Project;

import java.util.List;

public class Pipeline {
    private final Config config;
    private final Emailer emailer;
    private final Logger log;

    public Pipeline(Config config, Emailer emailer, Logger log) {
        this.config = config;
        this.emailer = emailer;
        this.log = log;
    }

    /**
     * This is supposed to be the functional core
     */
    public void run(Project project) {
        var steps = createBuildPipeline();
        var pipelineStatus = new PipelineStatus();
        for (var step: steps) {
            step.run(project, pipelineStatus);
        }
    }

    /**
     * This is supposed to be the imperative shell
     */
    private List<PipelineStep> createBuildPipeline() {
        var testStep = new TestStep("tests", log);
        var deployStep = new DeployStep("deploy", log);
        var reportStep = new ReportStep("report", log, emailer, config);

        return List.of(
                testStep, deployStep, reportStep
        );
    }

}
