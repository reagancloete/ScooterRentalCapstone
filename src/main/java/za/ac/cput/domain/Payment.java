package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.Objects;

@Entity
public class Payment {
  @Id
  private String paymentId;

  private String customerId;

  private double amountPaid;

  private Date paymentDate;

  private String paymentStatus;

  @OneToOne
  private PaymentInfo paymentInfo;


  protected Payment() {
  }

  public Payment(Builder builder){
    this.paymentId = builder.paymentId;
    this.customerId = builder.customerId;
    this.amountPaid = builder.amountPaid;
    this.paymentDate = builder.paymentDate;
    this.paymentStatus = builder.paymentStatus;
    this.paymentInfo = builder.paymentInfo;

  }


  public String getCustomerId() {
    return customerId;
  }

  public String getPaymentId() {
    return paymentId;
  }

  public double getAmountPaid() {
    return amountPaid;
  }

  public Date getPaymentDate() {
    return paymentDate;
  }

  public String getPaymentStatus() {
    return paymentStatus;
  }

  public PaymentInfo getPaymentInfo() {
    return paymentInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Payment payment = (Payment) o;
    return Double.compare(amountPaid, payment.amountPaid) == 0 && Objects.equals(paymentId, payment.paymentId) && Objects.equals(customerId, payment.customerId) && Objects.equals(paymentDate, payment.paymentDate) && Objects.equals(paymentStatus, payment.paymentStatus) && Objects.equals(paymentInfo, payment.paymentInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentId, customerId, amountPaid, paymentDate, paymentStatus, paymentInfo);
  }

  @Override
  public String toString() {
    return "Payment{" +
            "paymentId='" + paymentId + '\'' +
            ", customerId='" + customerId + '\'' +
            ", amountPaid=" + amountPaid +
            ", paymentDate=" + paymentDate +
            ", paymentStatus='" + paymentStatus + '\'' +
            ", paymentInfo=" + paymentInfo +
            '}';
  }

  public static class Builder{
    private String paymentId;
    private String customerId;
    private double amountPaid;
    private Date paymentDate;
    private String paymentStatus;
    private PaymentInfo paymentInfo;

    public Builder setPaymentId(String paymentId) {
      this.paymentId = paymentId;
      return this;
    }

    public Builder setCustomerId(String customerId) {
      this.customerId = customerId;
      return this;
    }

    public Builder setAmountPaid(double amountPaid) {
      this.amountPaid = amountPaid;
      return this;
    }

    public Builder setPaymentStatus(String paymentStatus) {
      this.paymentStatus = paymentStatus;
      return this;
    }

    public Builder setPaymentDate(Date paymentDate) {
      this.paymentDate = paymentDate;
      return this;
    }

    public Builder setPaymentInfo(PaymentInfo paymentInfo) {
      this.paymentInfo = paymentInfo;
      return this;
    }

    public Builder copy(Payment e){
     this.paymentId = e.paymentId;
     this.customerId = e.customerId;
     this.amountPaid = e.amountPaid;
     this.paymentDate = e.paymentDate;
     this.paymentStatus = e.paymentStatus;
     this.paymentInfo = e.paymentInfo;
     return this;
   }

   public Payment build(){return new Payment(this);}

  }




}
