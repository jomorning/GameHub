package com.gameHub.domain;

import java.time.LocalDateTime;

public class CommentResponseDTO {
	
	private int commentNo;
	private String userId;
	private String commentContent;
	private LocalDateTime commentCreatedAt;
	private LocalDateTime commentUpdatedAt;
	
	public CommentResponseDTO() {
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
