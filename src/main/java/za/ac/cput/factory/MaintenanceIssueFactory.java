package za.ac.cput.factory;

import za.ac.cput.domain.MaintenanceIssue;
import za.ac.cput.util.Helper;

public class MaintenanceIssueFactory {

    public static MaintenanceIssue buildMaintenanceIssue(String issueId, String scooterId, String reportedDate, String issueDescription, boolean resolved) {
        if (Helper.isNullOrEmpty(issueId) || Helper.isNullOrEmpty(scooterId) || Helper.isNullOrEmpty(reportedDate) || Helper.isNullOrEmpty(issueDescription)) {
            return null;
        }
        return new MaintenanceIssue.Builder()
                .setIssueId(issueId)
                .setScooterId(scooterId)
                .setReportedDate(reportedDate)
                .setIssueDescription(issueDescription)
                .setResolved(resolved)
                .build();
    }

    public static MaintenanceIssue build(String scooterId, String reportedDate, String issueDescription, boolean resolved) {
        if (Helper.isNullOrEmpty(scooterId) || Helper.isNullOrEmpty(reportedDate) || Helper.isNullOrEmpty(issueDescription)) {
            return null;
        }
        String issueId = Helper.generateId();
        return new MaintenanceIssue.Builder()
                .setIssueId(issueId)
                .setScooterId(scooterId)
                .setReportedDate(reportedDate)
                .setIssueDescription(issueDescription)
                .setResolved(resolved)
                .build();
    }
}

