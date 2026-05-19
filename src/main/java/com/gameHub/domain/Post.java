package com.gameHub.domain;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

public class Post {
	
	private int postNo;
	private int userNo;
	private String userName;
	private int gameNo;
	private String gameName;
	private String postType;
	private String postTitle;
	private String postContent;
	private int viewCount;
	private int likeCount;
	private int commentCount;
	private LocalDateTime postCreatedAt;
	private LocalDateTime postUpdatedAt;
	
	private MultipartFile savedFile;
	private String savedFileName;
	
	public Post() {
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

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public LocalDateTime getPostCreatedAt() {
		return postCreatedAt;
	}

	public void setPostCreatedAt(LocalDateTime postCreatedAt) {
		this.postCreatedAt = postCreatedAt;
	}

	public LocalDateTime getPostUpdatedAt() {
		return postUpdatedAt;
	}

	public void setPostUpdatedAt(LocalDateTime postUpdatedAt) {
		this.postUpdatedAt = postUpdatedAt;
	}

	public MultipartFile getSavedFile() {
		return savedFile;
	}

	public void setSavedFile(MultipartFile savedFile) {
		this.savedFile = savedFile;
	}

	public String getSavedFileName() {
		return savedFileName;
	}

	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}

}
