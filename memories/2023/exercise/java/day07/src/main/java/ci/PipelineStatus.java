package ci;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PipelineStatus {
    TestStepResult testResults;
    private DeployStepResult deployResult;

    public void reportTestResults(TestStepResult testResults) {
        this.testResults = testResults;
    }

    public TestStepResult getTestStepResult() {
        return this.testResults;
    }

    public void reportDeployResults(DeployStepResult deployResult) {
        this.deployResult = deployResult;
    }

    public DeployStepResult getDeployResult() {
        return deployResult;
    }
}
