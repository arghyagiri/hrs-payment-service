package com.tcs.training.payment.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentChannel {

	UPI("UPI"),
	RTGS("RTGS"),
	SWIFT("SWIFT"),
	MASTERCARD("MASTERCARD"),
	VISA("VISA"),
	NEFT("NEFT");

	private final String name;

	@Override
	public String toString() {
		return this.name;
	}

}
