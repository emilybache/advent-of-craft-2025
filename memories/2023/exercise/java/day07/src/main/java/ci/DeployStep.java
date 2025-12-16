package ci;

import ci.dependencies.Logger;
import ci.dependencies.Project;

public record DeployStep(Logger log) implements PipelineStep {
    DeployStepResult run(Project project, TestStepResult result) {
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
