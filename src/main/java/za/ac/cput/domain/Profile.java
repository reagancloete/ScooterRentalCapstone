package za.ac.cput.domain;

public class Profile {
    private String profileId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String role;

    public Profile(String profileId, String firstName, String lastName, String phoneNumber, String emailAddress, String address, String role) {
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.role = role;
    }

    // Getters and setters
    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Builder class
    public static class Builder {
        private String profileId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String emailAddress;
        private String address;
        private String role;

        public Builder setProfileId(String profileId) {
            this.profileId = profileId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Profile build() {
            return new Profile(profileId, firstName, lastName, phoneNumber, emailAddress, address, role);
        }
    }
}
