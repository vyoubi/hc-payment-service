package de.haegerconsulting.internShop.hcpaymentservice.repositories;

import de.haegerconsulting.internShop.hcpaymentservice.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
