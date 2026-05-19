package com.gameHub.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

// newPost, newRecruit 을 위한 @ModelAttribute 용 객체 클래스임. (공통 게시판 폼 DTO)
public class PostForm {
	
	private int postNo;
	private int userNo;
	private String userName;
	private int gameNo;
	private String gameName;
	private String postType;
	private String postTitle;
	private String postContent;
	private String recruitPosition;
	private String recruitStatus;
	private int recruitMaxMember;
	
	private List<MultipartFile> savedFileList;
	private List<String> uploadedFileNameList;
	
	public PostForm() {
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
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

	public List<MultipartFile> getSavedFileList() {
		return savedFileList;
	}

	public void setSavedFileList(List<MultipartFile> savedFileList) {
		this.savedFileList = savedFileList;
	}

	public List<String> getUploadedFileNameList() {
		return uploadedFileNameList;
	}

	public void setUploadedFileNameList(List<String> uploadedFileNameList) {
		this.uploadedFileNameList = uploadedFileNameList;
	}

}
