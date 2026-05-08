package com.gameHub.exception;

@SuppressWarnings("serial")
public class NoUserFoundException extends RuntimeException {
	
	private int invalidUserNo;

	public NoUserFoundException(int invalidUserNo) {
		this.invalidUserNo = invalidUserNo;
	}

	public int getInvalidUserNo() {
		return invalidUserNo;
	}

}
