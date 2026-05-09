package com.gameHub.domain;

import java.time.LocalDateTime;

public class Post {
	
	private int postNo;
	private Integer userNo;
	private Integer gameNo;
	private String postType;
	private String postTitle;
	private String postContent;
	private Integer viewCount;
	private Integer likeCount;
	private Integer commentCount;
	private LocalDateTime postCreatedAt;
	private LocalDateTime postUpdatedAt;
	
	public Post() {
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getGameNo() {
		return gameNo;
	}

	public void setGameNo(Integer gameNo) {
		this.gameNo = gameNo;
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

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
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
