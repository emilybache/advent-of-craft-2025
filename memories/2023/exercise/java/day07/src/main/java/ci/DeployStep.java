package ci;

import ci.dependencies.Logger;
import ci.dependencies.Project;

public record DeployStep(String name, Logger log) implements PipelineStep {
    DeployStepResult run(Project project, PipelineStatus pipelineStatus) {
        boolean deploySuccessful;
        var testStepResult = pipelineStatus.getTestStepResult();
        if (testStepResult.testsPassed()) {
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
        DeployStepResult deployStepResult = new DeployStepResult(deploySuccessful);
        pipelineStatus.reportDeployResults(deployStepResult);
        return deployStepResult;
    }
}
