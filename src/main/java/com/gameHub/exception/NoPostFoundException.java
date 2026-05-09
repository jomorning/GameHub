package com.gameHub.exception;

@SuppressWarnings("serial")
public class NoPostFoundException extends RuntimeException {
	
	private int invalidPostNo;

	public NoPostFoundException(int invalidPostNo) {
		this.invalidPostNo = invalidPostNo;
	}

	public int getInvalidPostNo() {
		return invalidPostNo;
	}

}
