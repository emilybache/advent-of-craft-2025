package ci;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PipelineStatus {
    private final HashMap<String, PipelineStepResult> results = new HashMap<>();

    public void reportStepResult(PipelineStep pipelineStep, PipelineStepResult result) {
        results.put(pipelineStep.name(), result);
    }

}
