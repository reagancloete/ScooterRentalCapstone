package za.ac.cput.factory;

import za.ac.cput.domain.PaymentInfo;
import za.ac.cput.util.Helper;

import java.util.Date;

public class PaymentFactory {
    public static Payment createPayment(String paymentId, String customerId, double amountPaid, Date paymentDate, String paymentStatus, PaymentInfo paymentInfo) {
        if (Helper.isNullOrEmpty(paymentId) || Helper.isNullOrEmpty(customerId) || paymentDate == null || Helper.isNullOrEmpty(paymentStatus) || paymentInfo == null) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setCustomerId(customerId)
                .setAmountPaid(amountPaid)
                .setPaymentDate(paymentDate)
                .setPaymentStatus(paymentStatus)
                .setPaymentInfo(paymentInfo)
                .build();
    }
}
