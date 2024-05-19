package za.ac.cput.service;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.PaymentInfo;
import za.ac.cput.repository.PaymentInfoRepository;


import java.util.List;

@Service
public class PaymentInfoService implements IPaymentInfoService{
    private PaymentInfoRepository repository;

    @Autowired
    PaymentInfoService(PaymentInfoRepository repository){this.repository = repository;}

    @Override
    public PaymentInfo create(PaymentInfo paymentInfo) {return repository.save(paymentInfo);}

    @Override
    public PaymentInfo read(String id) {return repository.findById(id).orElse(null);}

    @Override
    public PaymentInfo update(PaymentInfo paymentInfo) {return repository.save(paymentInfo);}

    @Override
    public void delete(PaymentInfo paymentInfo) {
        repository.delete(paymentInfo);
    }
    @Override
    public List<PaymentInfo> getall() {return repository.findAll();}


}
