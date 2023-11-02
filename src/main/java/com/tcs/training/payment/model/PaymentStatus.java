package com.tcs.training.payment.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentStatus {

	FAILED("FAILED"),
	SUCCESS("SUCCESS");

	private final String name;

	public String toString() {
		return this.name;
	}

}
