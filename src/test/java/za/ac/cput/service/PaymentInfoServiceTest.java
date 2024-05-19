package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.PaymentInfo;
import za.ac.cput.factory.PaymentInfoFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentInfoServiceTest {

    @Autowired
    private PaymentInfoService paymentInfoService;

    private static PaymentInfo paymentInfo1 = PaymentInfoFactory.createPaymentInfo("30 days", "100", "Rental for scooter", "SC123");
    private static PaymentInfo paymentInfo2 = PaymentInfoFactory.createPaymentInfo("15 days", "50", "Rental for bike", "BK456");

    @Test
    @Order(1)
    void a_setup() {
        assertNotNull(paymentInfo1, "PaymentInfo1 should not be null");
        System.out.println("Setup paymentInfo1: " + paymentInfo1);

        assertNotNull(paymentInfo2, "PaymentInfo2 should not be null");
        System.out.println("Setup paymentInfo2: " + paymentInfo2);
    }

    @Test
    @Order(2)
    void b_create() {
        PaymentInfo created1 = paymentInfoService.create(paymentInfo1);
        assertNotNull(created1, "Created1 should not be null");
        System.out.println("Created paymentInfo1: " + created1);

        PaymentInfo created2 = paymentInfoService.create(paymentInfo2);
        assertNotNull(created2, "Created2 should not be null");
        System.out.println("Created paymentInfo2: " + created2);
    }

    @Test
    @Order(3)
    void c_read() {
        PaymentInfo read = paymentInfoService.read(paymentInfo2.getPaymentInfoId());
        assertNotNull(read, "Read paymentInfo2 should not be null");
        System.out.println("Read paymentInfo2: " + read);
    }

    @Test
    @Order(4)
    void d_update() {
        PaymentInfo newPaymentInfo = new PaymentInfo.Builder()
                .copy(paymentInfo2)
                .setRentalDuration("20 days")
                .build();
        PaymentInfo updated = paymentInfoService.update(newPaymentInfo);
        assertNotNull(updated, "Updated paymentInfo2 should not be null");
        System.out.println("Updated paymentInfo2: " + updated);
    }

    @Test
    @Order(5)
    void f_delete() {
        paymentInfoService.delete(paymentInfo1);
        assertNull(paymentInfoService.read(paymentInfo1.getPaymentInfoId()), "Deleted paymentInfo1 should be null");
        System.out.println("Deleted paymentInfo1: " + paymentInfo1);

        paymentInfoService.delete(paymentInfo2);
        assertNull(paymentInfoService.read(paymentInfo2.getPaymentInfoId()), "Deleted paymentInfo2 should be null");
        System.out.println("Deleted paymentInfo2: " + paymentInfo2);
    }

    @Test
    @Order(6)
    void e_getAll() {
        System.out.println("All PaymentInfo: " + paymentInfoService.getall());
    }
}
