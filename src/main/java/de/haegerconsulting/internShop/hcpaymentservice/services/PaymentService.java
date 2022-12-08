package de.haegerconsulting.internShop.hcpaymentservice.services;

import de.haegerconsulting.internShop.hcpaymentservice.entities.Payment;

public interface PaymentService {

    Payment doPay(Payment payment);
    String paymentStatus();
}
