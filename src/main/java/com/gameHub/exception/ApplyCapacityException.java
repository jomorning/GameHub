package com.gameHub.exception;

@SuppressWarnings("serial")
public class ApplyCapacityException extends RuntimeException {
	
	private String deniedUserId;

	public ApplyCapacityException(String deniedUserId) {
		this.deniedUserId = deniedUserId;
	}

	public String getDeniedUserId() {
		return deniedUserId;
	}

}
