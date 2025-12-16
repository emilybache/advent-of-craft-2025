package ci;

public record TestStepResult(boolean testsPassed)  implements PipelineStepResult {
}
