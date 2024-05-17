package za.ac.cput.domain;
/*
* Sibabalwe Ngandana
* 220193894
* */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class MaintenanceActivity {
    @Id
    private String activityID;
    private String scooterId;
    private String maintenanceDate;
    private String maintenanceDescription;

    public MaintenanceActivity() {
    }

    public MaintenanceActivity(Builder builder){
        this.activityID = builder.activityID;
        this.scooterId = builder.scooterId;
        this.maintenanceDate = builder.maintenanceDate;
        this.maintenanceDescription = builder.maintenanceDescription;
    }

    public String getActivityID() {
        return activityID;
    }

    public String getScooterId() {
        return scooterId;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public String getMaintenanceDescription() {
        return maintenanceDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaintenanceActivity that)) return false;
        return Objects.equals(getActivityID(), that.getActivityID()) &&
                Objects.equals(getScooterId(), that.getScooterId()) &&
                Objects.equals(getMaintenanceDate(), that.getMaintenanceDate()) &&
                Objects.equals(getMaintenanceDescription(), that.getMaintenanceDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivityID(), getScooterId(), getMaintenanceDate(), getMaintenanceDescription());
    }

    @Override
    public String toString() {
        return "MaintenanceActivity{" +
                "activityID='" + activityID + '\'' +
                ", scooterId='" + scooterId + '\'' +
                ", maintenanceDate='" + maintenanceDate + '\'' +
                ", maintenanceDescription='" + maintenanceDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String activityID;
        private String scooterId;
        private String maintenanceDate;
        private String maintenanceDescription;

        public Builder setActivityID(String activityID) {
            this.activityID = activityID;
            return this;
        }

        public Builder setScooterId(String scooterId) {
            this.scooterId = scooterId;
            return this;
        }

        public Builder setMaintenanceDate(String maintenanceDate) {
            this.maintenanceDate = maintenanceDate;
            return this;
        }

        public Builder setMaintenanceDescription(String maintenanceDescription) {
            this.maintenanceDescription = maintenanceDescription;
            return this;
        }

        public Builder copy(MaintenanceActivity maintenanceActivity) {
            this.activityID = maintenanceActivity.activityID;
            this.scooterId = maintenanceActivity.scooterId;
            this.maintenanceDate = maintenanceActivity.maintenanceDate;
            this.maintenanceDescription = maintenanceActivity.maintenanceDescription;
            return this;
        }

        public MaintenanceActivity build() {
            return new MaintenanceActivity(this);
        }
    }
}
