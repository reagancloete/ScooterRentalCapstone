package za.ac.cput.domain;

/*
 * Sibabalwe Ngandana
 * 220193894
 * */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class MaintenanceIssue {
    @Id
    private String issueId;
    private String scooterId;
    private String reportedDate;
    private String issueDescription;
    private boolean resolved;

    protected MaintenanceIssue() {
    }

    public MaintenanceIssue(Builder builder) {
        this.issueId = builder.issueId;
        this.scooterId = builder.scooterId;
        this.reportedDate = builder.reportedDate;
        this.issueDescription = builder.issueDescription;
        this.resolved = builder.resolved;
    }

    public String getIssueId() {
        return issueId;
    }

    public String getScooterId() {
        return scooterId;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public boolean isResolved() {
        return resolved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaintenanceIssue)) return false;
        MaintenanceIssue that = (MaintenanceIssue) o;
        return resolved == that.resolved &&
                Objects.equals(issueId, that.issueId) &&
                Objects.equals(scooterId, that.scooterId) &&
                Objects.equals(reportedDate, that.reportedDate) &&
                Objects.equals(issueDescription, that.issueDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId, scooterId, reportedDate, issueDescription, resolved);
    }

    @Override
    public String toString() {
        return "MaintenanceIssue{" +
                "issueId='" + issueId + '\'' +
                ", scooterId='" + scooterId + '\'' +
                ", reportedDate='" + reportedDate + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", resolved=" + resolved +
                '}';
    }

    public static class Builder {
        private String issueId;
        private String scooterId;
        private String reportedDate;
        private String issueDescription;
        private boolean resolved;

        public Builder setIssueId(String issueId) {
            this.issueId = issueId;
            return this;
        }

        public Builder setScooterId(String scooterId) {
            this.scooterId = scooterId;
            return this;
        }

        public Builder setReportedDate(String reportedDate) {
            this.reportedDate = reportedDate;
            return this;
        }

        public Builder setIssueDescription(String issueDescription) {
            this.issueDescription = issueDescription;
            return this;
        }

        public Builder setResolved(boolean resolved) {
            this.resolved = resolved;
            return this;
        }

        public Builder copy(MaintenanceIssue maintenanceIssue) {
            this.issueId = maintenanceIssue.issueId;
            this.scooterId = maintenanceIssue.scooterId;
            this.reportedDate = maintenanceIssue.reportedDate;
            this.issueDescription = maintenanceIssue.issueDescription;
            this.resolved = maintenanceIssue.resolved;
            return this;
        }

        public MaintenanceIssue build() {
            return new MaintenanceIssue(this);
        }
    }
}
