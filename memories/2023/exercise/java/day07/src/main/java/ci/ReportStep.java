package ci;

import ci.dependencies.Config;
import ci.dependencies.Emailer;
import ci.dependencies.Logger;
import ci.dependencies.Project;

public record ReportStep(String name, Logger log, Emailer emailer, Config config) implements PipelineStep {
    public void run(Project project, PipelineStatus pipelineStatus) {
        if (config.sendEmailSummary()) {
            log.info("Sending email");
            if (pipelineStatus.getTestStepResult().testsPassed()) {
                if (pipelineStatus.getDeployResult().deploySuccessful()) {
                    emailer.send("Deployment completed successfully");
                } else {
                    emailer.send("Deployment failed");
                }
            } else {
                emailer.send("Tests failed");
            }
        } else {
            log.info("Email disabled");
        }
        pipelineStatus.reportReportStepResult(new ReportStepResult());
    }
}
