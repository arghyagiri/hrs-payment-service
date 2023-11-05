package com.tcs.training.payment.service;

import com.tcs.training.model.exception.NoDataFoundException;
import com.tcs.training.payment.entity.Payment;
import com.tcs.training.payment.model.PaymentStatus;
import com.tcs.training.payment.model.PaymentType;
import com.tcs.training.payment.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

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
		}
		else {
			payment.setPaymentStatus(PaymentStatus.FAILED);
		}
		return paymentRepository.save(payment);
	}

	@Transactional
	public Payment refund(UUID paymentId) {
		Payment payment = paymentRepository.getReferenceById(paymentId);
		if(payment != null) {
			payment.setPaymentType(PaymentType.REFUND);
			return paymentRepository.save(payment);
		} else {
			throw new NoDataFoundException(
					String.format("Payment Refund failed as payment reference %s is not found", payment.getPaymentId()));
		}
	}

	public boolean isSuccessful(){
		Random random = new Random();
		return random.nextBoolean();
	}

}
