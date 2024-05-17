package za.ac.cput.factory;
//Luyolo Skoma
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.PaymentInfo;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentInfoFactoryTest {

    @Test
    public void testCreatePaymentInfoSuccess() {
        PaymentInfo paymentInfo = PaymentInfoFactory.createPaymentInfo(
                "1 day",
                "100",
                "Daily rental",
                "Scooter123"
        );

        assertNotNull(paymentInfo);
        assertEquals("1 day", paymentInfo.getRentalDuration());
        assertEquals("100", paymentInfo.getInsuranceFee());
        assertEquals("Daily rental", paymentInfo.getRentalDescription());
        assertEquals("Scooter123", paymentInfo.getScooterId());
        assertNotNull(paymentInfo.getPaymentInfoId()); // Ensure ID is generated
    }

    @Test
    public void testCreatePaymentInfoFailure() {
        PaymentInfo paymentInfo = PaymentInfoFactory.createPaymentInfo(
                "", // Empty rentalDuration
                "100",
                "Daily rental",
                "Scooter123"
        );

        assertNull(paymentInfo);

        paymentInfo = PaymentInfoFactory.createPaymentInfo(
                "1 day",
                "", // Empty insuranceFee
                "Daily rental",
                "Scooter123"
        );

        assertNull(paymentInfo);

        paymentInfo = PaymentInfoFactory.createPaymentInfo(
                "1 day",
                "100",
                "", // Empty rentalDescription
                "Scooter123"
        );

        assertNull(paymentInfo);

        paymentInfo = PaymentInfoFactory.createPaymentInfo(
                "1 day",
                "100",
                "Daily rental",
                "" // Empty scooterId
        );

        assertNull(paymentInfo);
    }
}
