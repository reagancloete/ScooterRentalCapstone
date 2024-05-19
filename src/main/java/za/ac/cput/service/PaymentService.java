package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.EmployeeRepository;
import za.ac.cput.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService implements IPaymentService{
    private PaymentRepository repository;

    @Autowired
    PaymentService(PaymentRepository repository){this.repository = repository;}

    @Override
    public Payment create(Payment payment) {return repository.save(payment);}

    @Override
    public Payment read(String id) {return repository.findById(id).orElse(null);}

    @Override
    public Payment update(Payment payment) {return repository.save(payment);}

    @Override
    public void delete(Payment payment) {
        repository.delete(payment);
    }
    @Override
    public List<Payment> getall() {return repository.findAll();}


}

