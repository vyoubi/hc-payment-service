package de.haegerconsulting.internShop.hcpaymentservice.serviceImpls;

import de.haegerconsulting.internShop.hcpaymentservice.entities.Payment;
import de.haegerconsulting.internShop.hcpaymentservice.repositories.PaymentRepository;
import de.haegerconsulting.internShop.hcpaymentservice.services.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment doPay(Payment payment) {
        payment.setPaymentStatus(paymentStatus());
        payment.setTxId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    @Override
    public String paymentStatus() {
        // TODO redirect to paypal or stripe services
        return new Random().nextBoolean()?"success":"failure";
    }
}
