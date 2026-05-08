package com.gameHub.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
	
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userNickname;
	private LocalDate userBirthDate;
	private String userEmail;
	private String userRole;
	private LocalDateTime userCreatedAt;
	
	public User() {
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
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public LocalDate getUserBirthDate() {
		return userBirthDate;
	}
	public void setUserBirthDate(LocalDate userBirthDate) {
		this.userBirthDate = userBirthDate;
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
	public LocalDateTime getUserCreatedAt() {
		return userCreatedAt;
	}
	public void setUserCreatedAt(LocalDateTime userCreatedAt) {
		this.userCreatedAt = userCreatedAt;
	}
	
}
