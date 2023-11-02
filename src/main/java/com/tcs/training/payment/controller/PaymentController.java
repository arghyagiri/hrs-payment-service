package com.tcs.training.payment.controller;

import com.tcs.training.payment.entity.Payment;
import com.tcs.training.payment.repository.PaymentRepository;
import com.tcs.training.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;
	private final PaymentRepository paymentRepository;

	@GetMapping("/{id}")
	public Payment getPaymentDetailsByUId(@PathVariable UUID id) {
		return paymentRepository.getReferenceById(id);
	}

	@PostMapping("/pay")
	public Payment processPayment(@RequestBody Payment payment) {
		payment.setPaymentId(null);
		return paymentService.pay(payment);
	}


	@PostMapping("/refund")
	public Payment processRefund(@RequestBody Payment payment) {
		payment.setPaymentId(null);
		return paymentService.refund(payment);
	}

}
