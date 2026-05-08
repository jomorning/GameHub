package com.gameHub.exception;

@SuppressWarnings("serial")
public class NoGameFoundException extends RuntimeException {
	
	private int invalidGameNo;

	public NoGameFoundException(int invalidGameNo) {
		this.invalidGameNo = invalidGameNo;
	}

	public int getInvalidGameNo() {
		return invalidGameNo;
	}

}
