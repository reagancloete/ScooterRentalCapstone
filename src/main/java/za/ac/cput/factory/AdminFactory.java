package za.ac.cput.factory;


import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

public class AdminFactory {

    public static Admin buildAdmin(String adminID, String jobDescription) {
        if (!Helper.testString(adminID) || !Helper.testString(jobDescription)) {
            throw new IllegalArgumentException("Admin ID and job description not null");
        }
        return new Admin.Builder()
                .setAdminID(adminID)
                .setJob_description(jobDescription)
                .build();
    }
}

