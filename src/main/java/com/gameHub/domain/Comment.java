package com.gameHub.domain;

import java.time.LocalDateTime;

public class Comment {
	
	private int commentNo;
	private int userNo;
	private int postNo;
	private String commentContent;
	private LocalDateTime commentCreatedAt;
	private LocalDateTime commentUpdatedAt;
	
	public Comment() {
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public LocalDateTime getCommentCreatedAt() {
		return commentCreatedAt;
	}

	public void setCommentCreatedAt(LocalDateTime commentCreatedAt) {
		this.commentCreatedAt = commentCreatedAt;
	}

	public LocalDateTime getCommentUpdatedAt() {
		return commentUpdatedAt;
	}

	public void setCommentUpdatedAt(LocalDateTime commentUpdatedAt) {
		this.commentUpdatedAt = commentUpdatedAt;
	}

}
