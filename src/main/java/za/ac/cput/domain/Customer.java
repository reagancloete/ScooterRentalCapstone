package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private String customerId;
    private String email;
    private String password;
    private String registrationDate;
    private String role;

    protected Customer() {
    }

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.email = builder.email;
        this.password = builder.password;
        this.registrationDate = builder.registrationDate;
        this.role = builder.role;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password) && Objects.equals(registrationDate, customer.registrationDate) && Objects.equals(role, customer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, password, registrationDate, role);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static class Builder {
        private String customerId;
        private String email;
        private String password;
        private String registrationDate;
        private String role;

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.email = customer.email;
            this.password = customer.password;
            this.registrationDate = customer.registrationDate;
            this.role = customer.role;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
