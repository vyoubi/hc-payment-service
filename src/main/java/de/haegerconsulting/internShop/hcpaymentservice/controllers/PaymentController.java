package de.haegerconsulting.internShop.hcpaymentservice.controllers;

import de.haegerconsulting.internShop.hcpaymentservice.entities.Payment;
import de.haegerconsulting.internShop.hcpaymentservice.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments/")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;
    private final StreamBridge streamBridge;

    @PostMapping("/doPay/")
    public Payment doPayment(@RequestBody Payment payment){

        Payment pay = service.doPay(payment);

        streamBridge.send("notificationEventSupplier-out-0", pay.getPaymentStatus());
        return pay;
    }
}
