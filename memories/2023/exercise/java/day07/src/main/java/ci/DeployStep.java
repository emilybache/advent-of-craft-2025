package ci;

import ci.dependencies.Logger;
import ci.dependencies.Project;

public record DeployStep(String name, Logger log) implements PipelineStep {
    DeployStepResult run(Project project, TestStepResult result, PipelineStatus pipelineStatus) {
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
}
