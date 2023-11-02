package com.tcs.training.payment.entity;

import com.tcs.training.payment.model.PaymentChannel;
import com.tcs.training.payment.model.PaymentStatus;
import com.tcs.training.payment.model.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PAYMENTS")
public class Payment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID paymentId;

	@Column(nullable = false)
	private Long customerId;

	@Column(nullable = false)
	private BigDecimal amount;

	@Column(nullable = false)
	private PaymentChannel paymentChannel;

	@Column(nullable = false)
	private PaymentStatus paymentStatus;

	@Column(nullable = false)
	private PaymentType paymentType;
}
