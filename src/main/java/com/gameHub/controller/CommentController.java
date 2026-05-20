package com.gameHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gameHub.domain.Comment;
import com.gameHub.domain.CommentResponseDTO;
import com.gameHub.exception.NoCommentFoundException;
import com.gameHub.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@ResponseBody
	@GetMapping("/post/{postNo}/comment/count")
	public int getCommentCountByPost(@PathVariable("postNo") int postNo) {
		int commentCountByPost = commentService.getCommentCountByPost(postNo);
		return commentCountByPost;
	}
	
	@GetMapping("/post/{postNo}/comment/{commentNo}")
	public String getCommentByNo(@PathVariable("commentNo") int commentNo, Model model) {
		Comment commentByNo = commentService.getCommentByNo(commentNo);
		model.addAttribute("commentByNo", commentByNo);
		return "comment";
	}
	
	@ExceptionHandler(value={(NoCommentFoundException.class)})
	public String noCommentFoundHandler(NoCommentFoundException exception, Model model) {
		model.addAttribute("invalidCommentNo", exception.getInvalidCommentNo());
		return "noCommentFoundException";
	}
	
	@GetMapping("/post/{postNo}/comment/new")
	public String getNewCommentForm(@ModelAttribute("newComment") Comment newComment) {
		return "post";
	}
	
	@ResponseBody
	@PostMapping("/post/{postNo}/comment")
	public CommentResponseDTO submitNewCommentForm(@RequestBody Comment newComment, @PathVariable("postNo") int postNo, Model model, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		newComment.setUserNo(loginUserNo);
		newComment.setPostNo(postNo);
		commentService.setNewComment(newComment);
		
		int commentCountByPost = commentService.getCommentCountByPost(postNo);
		
		CommentResponseDTO latestComment = commentService.getCommentByNo(latestComment);
		
		// return commentCountByPost;
		return latestComment;
	}
	
	@GetMapping("/post/{postNo}/comment/{commentNo}/edit")
	public String getEditCommentForm(@ModelAttribute("editComment") Comment editComment, @PathVariable("postNo") int postNo, @PathVariable("commentNo") int commentNo, Model model) {
		Comment commentByNo = commentService.getCommentByNo(commentNo);
		model.addAttribute("editComment", commentByNo);
		return "editComment";
	}
	
	@PutMapping("/post/{postNo}/comment/{commentNo}")
	public String submitEditCommentForm(@ModelAttribute("editComment") Comment editComment, @PathVariable("postNo") int postNo, @PathVariable("commentNo") int commentNo) {
		commentService.setEditComment(editComment, commentNo);
		return "redirect:/post/" + postNo;
	}
	
	@DeleteMapping("/post/{postNo}/comment/{commentNo}")
	public String submitDeleteCommentForm(@PathVariable("postNo") int postNo, @PathVariable("commentNo") int commentNo) {
		commentService.setDeleteComment(commentNo);
		return "redirect:/post/" + postNo;
	}

}