package com.gameHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gameHub.domain.Comment;
import com.gameHub.domain.CommentResponseDTO;
import com.gameHub.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/post/{postNo}/comment/new")
	public String getNewCommentForm(@ModelAttribute("newComment") Comment newComment) {
		return "post";
	}
	
	@PostMapping("/post/{postNo}/comment")
	public String submitNewCommentForm(@ModelAttribute("newComment") Comment newComment, @PathVariable("postNo") int postNo) {
		commentService.setNewComment(newComment);
		return "redirect:/post/" + postNo;
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