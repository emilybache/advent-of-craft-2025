package ci;

import ci.dependencies.Logger;
import ci.dependencies.Project;

public record TestStep(String name, Logger log) implements PipelineStep {

    TestStepResult run(Project project) {
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
}
