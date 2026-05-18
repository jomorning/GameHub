package com.gameHub.domain;

import java.time.LocalDateTime;

public class UserSearchDTO {
	
	private String searchMode;
	private String userId;
	private String userName;
	private String userEmail;
	private String userRole;
	private Integer minUserAge;
	private Integer maxUserAge;
	private LocalDateTime startCreatedTime;
	private LocalDateTime endCreatedTime;
	
	// 페이징 기능 구현
	private int pageNum;
	private int startNum;
	private int limit;
	
	
	public UserSearchDTO() {
		searchMode = "detail";
	}


	public String getSearchMode() {
		return searchMode;
	}


	public void setSearchMode(String searchMode) {
		this.searchMode = searchMode;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public Integer getMinUserAge() {
		return minUserAge;
	}


	public void setMinUserAge(Integer minUserAge) {
		this.minUserAge = minUserAge;
	}


	public Integer getMaxUserAge() {
		return maxUserAge;
	}


	public void setMaxUserAge(Integer maxUserAge) {
		this.maxUserAge = maxUserAge;
	}


	public LocalDateTime getStartCreatedTime() {
		return startCreatedTime;
	}


	public void setStartCreatedTime(LocalDateTime startCreatedTime) {
		this.startCreatedTime = startCreatedTime;
	}


	public LocalDateTime getEndCreatedTime() {
		return endCreatedTime;
	}


	public void setEndCreatedTime(LocalDateTime endCreatedTime) {
		this.endCreatedTime = endCreatedTime;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getStartNum() {
		return startNum;
	}


	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
