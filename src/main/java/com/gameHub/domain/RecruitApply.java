package com.gameHub.domain;

import java.time.LocalDateTime;

public class RecruitApply {
	
	private int applyNo;
	private int userNo;
	private String userId;
	private int postNo;
	private String applyStatus;
	private LocalDateTime applyCreatedAt;
	private LocalDateTime applyUpdatedAt;
	
	public RecruitApply() {
	}

	public int getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public LocalDateTime getApplyCreatedAt() {
		return applyCreatedAt;
	}

	public void setApplyCreatedAt(LocalDateTime applyCreatedAt) {
		this.applyCreatedAt = applyCreatedAt;
	}

	public LocalDateTime getApplyUpdatedAt() {
		return applyUpdatedAt;
	}

	public void setApplyUpdatedAt(LocalDateTime applyUpdatedAt) {
		this.applyUpdatedAt = applyUpdatedAt;
	}

}
