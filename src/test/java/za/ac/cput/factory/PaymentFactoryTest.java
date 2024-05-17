package za.ac.cput.factory;
//Luyolo Skoma
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentInfo;
import za.ac.cput.util.Helper;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentFactoryTest {

    @Test
    public void testCreatePaymentSuccess() {
        // Create a PaymentInfo object to use in the Payment creation
        PaymentInfo paymentInfo = new PaymentInfo.Builder()
                .setPaymentInfoId(Helper.generateId())
                .setRentalDuration("1 day")
                .setInsuranceFee("100")
                .setRentalDescription("Daily rental")
                .setScooterId("Scooter123")
                .build();

        // Create a Payment object using the PaymentFactory
        Payment payment = PaymentFactory.createPayment(
                Helper.generateId(),
                "Customer123",
                500.0,
                new Date(),
                "Completed",
                paymentInfo
        );

        assertNotNull(payment);
        assertEquals("Customer123", payment.getCustomerId());
        assertEquals(500.0, payment.getAmountPaid());
        assertNotNull(payment.getPaymentDate());
        assertEquals("Completed", payment.getPaymentStatus());
        assertNotNull(payment.getPaymentInfo());
        assertEquals(paymentInfo, payment.getPaymentInfo());
    }

    @Test
    public void testCreatePaymentFailure() {
        // Create a PaymentInfo object to use in the Payment creation
        PaymentInfo paymentInfo = new PaymentInfo.Builder()
                .setPaymentInfoId(Helper.generateId())
                .setRentalDuration("1 day")
                .setInsuranceFee("100")
                .setRentalDescription("Daily rental")
                .setScooterId("Scooter123")
                .build();

        // Test with invalid paymentId (empty string)
        Payment payment = PaymentFactory.createPayment(
                "",
                "Customer123",
                500.0,
                new Date(),
                "Completed",
                paymentInfo
        );
        assertNull(payment);

        // Test with invalid customerId (empty string)
        payment = PaymentFactory.createPayment(
                Helper.generateId(),
                "",
                500.0,
                new Date(),
                "Completed",
                paymentInfo
        );
        assertNull(payment);

        // Test with null paymentDate
        payment = PaymentFactory.createPayment(
                Helper.generateId(),
                "Customer123",
                500.0,
                null,
                "Completed",
                paymentInfo
        );
        assertNull(payment);

        // Test with invalid paymentStatus (empty string)
        payment = PaymentFactory.createPayment(
                Helper.generateId(),
                "Customer123",
                500.0,
                new Date(),
                "",
                paymentInfo
        );
        assertNull(payment);

        // Test with null paymentInfo
        payment = PaymentFactory.createPayment(
                Helper.generateId(),
                "Customer123",
                500.0,
                new Date(),
                "Completed",
                null
        );
        assertNull(payment);
    }
}
