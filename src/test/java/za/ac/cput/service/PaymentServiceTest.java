package za.ac.cput.service;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentInfo;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.factory.PaymentInfoFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentServiceTest {
    @Autowired
    private PaymentService paymentService;

    private static Payment payment1;
    private static Payment payment2;
    private static PaymentInfo paymentInfo1;
    private static PaymentInfo paymentInfo2;

    @Test
    @Order(1)
    void a_setup() {
        paymentInfo1 = PaymentInfoFactory.createPaymentInfo("30 days", "100", "Rental for scooter", "SC123");
        assertNotNull(paymentInfo1);
        System.out.println(paymentInfo1);

        paymentInfo2 = PaymentInfoFactory.createPaymentInfo("15 days", "50", "Rental for bike", "BK456");
        assertNotNull(paymentInfo2);
        System.out.println(paymentInfo2);

        payment1 = PaymentFactory.createPayment("P123", "C123", 1000.0, new Date(), "Paid", paymentInfo1);
        assertNotNull(payment1);
        System.out.println(payment1);

        payment2 = PaymentFactory.createPayment("P124", "C124", 500.0, new Date(), "Pending", paymentInfo2);
        assertNotNull(payment2);
        System.out.println(payment2);
    }

    @Test
    @Order(2)
    void b_create() {
        Payment created1 = paymentService.create(payment1);
        assertNotNull(created1);
        System.out.println(created1);

        Payment created2 = paymentService.create(payment2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void c_read() {
        Payment read = paymentService.read(payment2.getPaymentId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void d_update() {
        Payment newPayment = new Payment.Builder().copy(payment2).setPaymentStatus("Completed").build();
        Payment updated = paymentService.update(newPayment);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void f_delete() {
        paymentService.delete(payment1);
        assertNull(paymentService.read(payment1.getPaymentId()));
        System.out.println("Payment deleted: " + payment1);

        paymentService.delete(payment2);
        assertNull(paymentService.read(payment2.getPaymentId()));
        System.out.println("Payment deleted: " + payment2);
    }

    @Test
    @Order(6)
    void e_getAll() {
        System.out.println(paymentService.getall());
    }
}
