package com.gameHub.repository;

import java.util.List;

import com.gameHub.domain.Comment;
import com.gameHub.domain.CommentResponseDTO;

public interface CommentRepository {
	
	List<CommentResponseDTO> getCommentsByPost(int postNo);
	
	Comment getCommentByNo(int commentNo);
	
	void setNewComment(Comment newComment);
	
	void setEditComment(Comment editComment, int commentNo);
	
	void setDeleteComment(int commentNo);

}
