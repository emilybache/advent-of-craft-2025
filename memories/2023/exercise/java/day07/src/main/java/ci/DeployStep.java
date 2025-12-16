package ci;

import ci.dependencies.Logger;
import ci.dependencies.Project;

public record DeployStep() {
    DeployStepResult doDeployStep(Project project, TestStepResult result, Logger log) {
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
