package com.gameHub.service;

import java.util.List;

import com.gameHub.domain.Comment;
import com.gameHub.domain.CommentResponseDTO;

public interface CommentService {
	
	Comment getCommentByNo(int commentNo);

	List<CommentResponseDTO> getCommentsByPost(int postNo);
	
	int getCommentCountByPost(int postNo);
	
	void setNewComment(Comment newComment);
	
	void setEditComment(Comment editComment, int commentNo);
	
	void setDeleteComment(int commentNo);

}
