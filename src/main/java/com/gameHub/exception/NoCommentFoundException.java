package com.gameHub.exception;

@SuppressWarnings("serial")
public class NoCommentFoundException extends RuntimeException {
	
	private int invalidCommentNo;

	public NoCommentFoundException(int invalidCommentNo) {
		this.invalidCommentNo = invalidCommentNo;
	}

	public int getInvalidCommentNo() {
		return invalidCommentNo;
	}

}
