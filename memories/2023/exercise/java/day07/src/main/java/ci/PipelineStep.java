package ci;

import ci.dependencies.Project;

public interface PipelineStep {
    String name();
    void run(Project project, PipelineStatus pipelineStatus);
}
