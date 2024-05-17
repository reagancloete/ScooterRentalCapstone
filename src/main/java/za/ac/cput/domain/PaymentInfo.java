package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class PaymentInfo implements Serializable {
    @Id
    private String paymentInfoId;
    private String rentalDuration;
    private String insuranceFee;
    private String rentalDescription;
    private String scooterId;



    // Private constructor for the builder
    private PaymentInfo(Builder builder) {
        this.paymentInfoId = builder.paymentInfoId;
        this.rentalDuration = builder.rentalDuration;
        this.insuranceFee = builder.insuranceFee;
        this.rentalDescription = builder.rentalDescription;
        this.scooterId = builder.scooterId;
    }

    // Protected no-arg constructor for JPA
    protected PaymentInfo() {
    }

    // Getters
    public String getPaymentInfoId() {
        return paymentInfoId;
    }

    public String getRentalDuration() {
        return rentalDuration;
    }

    public String getInsuranceFee() {
        return insuranceFee;
    }

    public String getRentalDescription() {
        return rentalDescription;
    }

    public String getScooterId() {
        return scooterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentInfo that = (PaymentInfo) o;
        return Objects.equals(paymentInfoId, that.paymentInfoId) && Objects.equals(rentalDuration, that.rentalDuration) && Objects.equals(insuranceFee, that.insuranceFee) && Objects.equals(rentalDescription, that.rentalDescription) && Objects.equals(scooterId, that.scooterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentInfoId, rentalDuration, insuranceFee, rentalDescription, scooterId);
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "paymentInfoId='" + paymentInfoId + '\'' +
                ", rentalDuration='" + rentalDuration + '\'' +
                ", insuranceFee='" + insuranceFee + '\'' +
                ", rentalDescription='" + rentalDescription + '\'' +
                ", scooterId='" + scooterId + '\'' +
                '}';
    }

    // Builder Class
    public static class Builder {
        private String paymentInfoId;
        private String rentalDuration;
        private String insuranceFee;
        private String rentalDescription;
        private String scooterId;

        public Builder setPaymentInfoId(String paymentInfoId) {
            this.paymentInfoId = paymentInfoId;
            return this;
        }

        public Builder setRentalDuration(String rentalDuration) {
            this.rentalDuration = rentalDuration;
            return this;
        }

        public Builder setInsuranceFee(String insuranceFee) {
            this.insuranceFee = insuranceFee;
            return this;
        }

        public Builder setRentalDescription(String rentalDescription) {
            this.rentalDescription = rentalDescription;
            return this;
        }

        public Builder setScooterId(String scooterId) {
            this.scooterId = scooterId;
            return this;
        }

        public PaymentInfo build() {
            return new PaymentInfo(this);
        }
    }

}
