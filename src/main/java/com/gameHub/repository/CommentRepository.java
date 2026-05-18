package com.gameHub.repository;

import java.util.List;

import com.gameHub.domain.Comment;
import com.gameHub.domain.CommentResponseDTO;

public interface CommentRepository {
	
	Comment getCommentByNo(int commentNo);
	
	List<CommentResponseDTO> getCommentsByPost(int postNo);
	
	int getCommentCountByPost(int postNo);
	
	void setNewComment(Comment newComment);
	
	void setEditComment(Comment editComment, int commentNo);
	
	void setDeleteComment(int commentNo);

}
