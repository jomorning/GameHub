package com.gameHub.exception;

@SuppressWarnings("serial")
public class NoRecruitFoundException extends RuntimeException {
	
	private int invalidRecruitNo;

	public NoRecruitFoundException(int invalidRecruitNo) {
		this.invalidRecruitNo = invalidRecruitNo;
	}

	public int getInvalidRecruitNo() {
		return invalidRecruitNo;
	}

}
