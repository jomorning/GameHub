package com.gameHub.domain;

import java.time.LocalDateTime;

public class PostResponseDTO {
	
	private int postNo;
	private String userId;
	private String gameName;
	private String postType;
	private String postTitle;
	private String postContent;
	private int viewCount;
	private int likeCount;
	private int commentCount;
	private LocalDateTime postCreatedAt;
	private LocalDateTime postUpdatedAt;
	
	public PostResponseDTO() {
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

}
