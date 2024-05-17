package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    private String profileId;
    private String name;
    private String phoneNumber;
    private String licenseNumber;
    private String dateOfBirth;
    private String address;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    protected Profile() {
    }

    private Profile(Builder builder) {
        this.profileId = builder.profileId;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.licenseNumber = builder.licenseNumber;
        this.dateOfBirth = builder.dateOfBirth;
        this.address = builder.address;
        this.customer = builder.customer;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(profileId, profile.profileId) && Objects.equals(name, profile.name) && Objects.equals(phoneNumber, profile.phoneNumber) && Objects.equals(licenseNumber, profile.licenseNumber) && Objects.equals(dateOfBirth, profile.dateOfBirth) && Objects.equals(address, profile.address) && Objects.equals(customer, profile.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileId, name, phoneNumber, licenseNumber, dateOfBirth, address, customer);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId='" + profileId + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", customer=" + customer +
                '}';
    }

    public static class Builder {
        private String profileId;
        private String name;
        private String phoneNumber;
        private String licenseNumber;
        private String dateOfBirth;
        private String address;
        private Customer customer;

        public Builder setProfileId(String profileId) {
            this.profileId = profileId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setLicenseNumber(String licenseNumber) {
            this.licenseNumber = licenseNumber;
            return this;
        }

        public Builder setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder copy(Profile profile) {
            this.profileId = profile.profileId;
            this.name = profile.name;
            this.phoneNumber = profile.phoneNumber;
            this.licenseNumber = profile.licenseNumber;
            this.dateOfBirth = profile.dateOfBirth;
            this.address = profile.address;
            this.customer = profile.customer;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }
    }
}
