package ci;

import ci.dependencies.Project;
import ci.dependencies.TestStatus;
import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static ci.dependencies.TestStatus.PASSING_TESTS;

public class PipelineApprovalTest {

    @Test
    void pipeline() {
        TestStatus[] testStatuses = {PASSING_TESTS, TestStatus.NO_TESTS, TestStatus.FAILING_TESTS};
        Boolean[] sendSummaries = {true, false};
        Boolean[] buildsSuccessfullies = {true, false};

        CombinationApprovals.verifyAllCombinations(
                this::doPipelineRun,
                testStatuses,
                sendSummaries,
                buildsSuccessfullies
        );
    }

    private String doPipelineRun(TestStatus testStatus, boolean sendSummary, boolean buildsSuccessfully) {
        var spy = new StringBuilder("\n");
        var config = new DefaultConfig(sendSummary);
        var emailer = new CapturingEmailer(spy);
        var log = new CapturingLogger(spy);
        var pipeline = new Pipeline(config, emailer, log);

        var project = Project.builder()
                .setTestStatus(testStatus)
                .setDeploysSuccessfully(buildsSuccessfully)
                .build();

        pipeline.run(project);
        return spy.toString();
    }

}
