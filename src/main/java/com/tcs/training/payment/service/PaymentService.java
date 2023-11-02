package com.tcs.training.payment.service;

import com.tcs.training.payment.entity.Payment;
import com.tcs.training.payment.model.PaymentStatus;
import com.tcs.training.payment.model.PaymentType;
import com.tcs.training.payment.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

	private final PaymentRepository paymentRepository;

	@Transactional
	public Payment pay(Payment payment) {
		payment.setPaymentType(PaymentType.PAY);
		payment.setPaymentStatus(PaymentStatus.FAILED);
		if(isSuccessful()){
			payment.setPaymentStatus(PaymentStatus.SUCCESS);
			return paymentRepository.save(payment);
		}
		else {
			throw new RuntimeException("Payment Failed. Please try again.");
		}
	}

	@Transactional
	public Payment refund(Payment payment) {
		payment.setPaymentType(PaymentType.REFUND);
		return paymentRepository.save(payment);
	}

	public boolean isSuccessful(){
		Random random = new Random();
		return random.nextBoolean();
	}

}
