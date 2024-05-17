package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class PaymentInfo implements Serializable {
    @Id
    private String paymentInfoId;
    private String rentalDuration;
    private String insuranceFee;
    private String rentalDescription;
    private String scooterId;

    protected PaymentInfo() {
    }

    private PaymentInfo(Builder builder) {
        this.paymentInfoId = builder.paymentInfoId;
        this.rentalDuration = builder.rentalDuration;
        this.insuranceFee = builder.insuranceFee;
        this.rentalDescription = builder.rentalDescription;
        this.scooterId = builder.scooterId;
    }

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
        return paymentInfoId.equals(that.paymentInfoId);
    }

    @Override
    public int hashCode() {
        return paymentInfoId.hashCode();
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

        public Builder copy(PaymentInfo paymentInfo) {
            this.paymentInfoId = paymentInfo.paymentInfoId;
            this.rentalDuration = paymentInfo.rentalDuration;
            this.insuranceFee = paymentInfo.insuranceFee;
            this.rentalDescription = paymentInfo.rentalDescription;
            this.scooterId = paymentInfo.scooterId;
            return this;
        }

        public PaymentInfo build() {
            return new PaymentInfo(this);
        }
    }
}
