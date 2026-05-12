package com.gameHub.domain;

public class Recruit {
	
	private int postNo;
	private String recruitPosition;
	private String recruitStatus;
	private int recruitMaxMember;
	private int recruitCurrentMember;
	
	public Recruit() {
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getRecruitPosition() {
		return recruitPosition;
	}

	public void setRecruitPosition(String recruitPosition) {
		this.recruitPosition = recruitPosition;
	}

	public String getRecruitStatus() {
		return recruitStatus;
	}

	public void setRecruitStatus(String recruitStatus) {
		this.recruitStatus = recruitStatus;
	}

	public int getRecruitMaxMember() {
		return recruitMaxMember;
	}

	public void setRecruitMaxMember(int recruitMaxMember) {
		this.recruitMaxMember = recruitMaxMember;
	}

	public int getRecruitCurrentMember() {
		return recruitCurrentMember;
	}

	public void setRecruitCurrentMember(int recruitCurrentMember) {
		this.recruitCurrentMember = recruitCurrentMember;
	}

}
