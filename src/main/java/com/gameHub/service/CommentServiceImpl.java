package com.gameHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Comment;
import com.gameHub.domain.CommentResponseDTO;
import com.gameHub.exception.NoCommentFoundException;
import com.gameHub.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<CommentResponseDTO> getCommentsByPost(int postNo) {
		List<CommentResponseDTO> commentsByPost = commentRepository.getCommentsByPost(postNo) ;
		return commentsByPost;
	}

	@Override
	public Comment getCommentByNo(int commentNo) {
		Comment commentByNo = commentRepository.getCommentByNo(commentNo);
		
		if (commentByNo == null) {
			throw new NoCommentFoundException(commentNo);
		}
		
		return commentByNo;
	}

	@Override
	public void setNewComment(Comment newComment) {
		// 임시 댓글 등록자 UserNo. 3 (jomorning)
		newComment.setUserNo(3);
		commentRepository.setNewComment(newComment);
	}

	@Override
	public void setEditComment(Comment editComment, int commentNo) {
		commentRepository.setEditComment(editComment, commentNo);
	}

	@Override
	public void setDeleteComment(int commentNo) {
		commentRepository.setDeleteComment(commentNo);
	}

}
