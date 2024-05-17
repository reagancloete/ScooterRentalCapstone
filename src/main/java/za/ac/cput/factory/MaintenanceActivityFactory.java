package za.ac.cput.factory;

import za.ac.cput.domain.MaintenanceActivity;
import za.ac.cput.domain.ScooterType;
import za.ac.cput.util.Helper;

public class MaintenanceActivityFactory {
    public static MaintenanceActivity buildMaintenanceActivity(String activityID, String scooterId, String maintenanceDate, String maintenanceDescription, ScooterType scooterType) {
        if (Helper.isNullOrEmpty(activityID) || Helper.isNullOrEmpty(scooterId) || Helper.isNullOrEmpty(maintenanceDate) || Helper.isNullOrEmpty(maintenanceDescription) || scooterType == null) {
            return null;
        }

        return new MaintenanceActivity.Builder()
                .setActivityID(activityID)
                .setScooterId(scooterId)
                .setMaintenanceDate(maintenanceDate)
                .setMaintenanceDescription(maintenanceDescription)
                //.setScooterType(scooterType)
                .build();
    }

    public static MaintenanceActivity build(String scooterId, String maintenanceDate, String maintenanceDescription, ScooterType scooterType) {
        if (Helper.isNullOrEmpty(scooterId) || Helper.isNullOrEmpty(maintenanceDate) || Helper.isNullOrEmpty(maintenanceDescription) || scooterType == null) {
            return null;
        }
        String activityID = Helper.generateId();
        return new MaintenanceActivity.Builder()
                .setActivityID(activityID)
                .setScooterId(scooterId)
                .setMaintenanceDate(maintenanceDate)
                .setMaintenanceDescription(maintenanceDescription)
                //.setScooterType(scooterType)
                .build();
    }
}
