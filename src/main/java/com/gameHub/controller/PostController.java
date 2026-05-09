package com.gameHub.controller;

import java.util.List;
import java.util.Map;

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

import com.gameHub.domain.Post;
import com.gameHub.domain.PostSearchDTO;
import com.gameHub.exception.NoPostFoundException;
import com.gameHub.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/post/search")
	public String searchPosts(@ModelAttribute("postSearchDTO") PostSearchDTO postSearchDTO, Model model) {		
		List<Post> postsBySearch = postService.searchPosts(postSearchDTO);
		model.addAttribute("posts", postsBySearch);
		return "posts";
	}
	
	@GetMapping("/post/{postNo}")
	public String getPostByNo(@PathVariable("postNo") int postNo, Model model) {
		Post postByNo = postService.getPostByNo(postNo);
		model.addAttribute("postByNo", postByNo);
		return "post";
	}
	
	@ExceptionHandler(value={(NoPostFoundException.class)})
	public String noPostFoundHandler(NoPostFoundException exception, Model model) {
		model.addAttribute("invalidPostNo", exception.getInvalidPostNo());
		return "noPostFoundException";
	}
	
	@GetMapping("/post/new")
	public String getNewPostForm(@ModelAttribute("newPost") Post newPost) {
		return "newPost";
	}
	
	@PostMapping("/post")
	public String submitNewPostForm(@ModelAttribute("newPost") Post newPost) {
		postService.setNewPost(newPost);
		return "redirect:/post/search";
	}
	
	@GetMapping("/post/{postNo}/edit")
	public String getEditPostForm(@PathVariable("postNo") int postNo, Model model) {
		Post postByNo = postService.getPostByNo(postNo);
		model.addAttribute("editPost", postByNo);
		return "editPost";
	}
	
	@PutMapping("/post/{postNo}")
	public String submitEditPostForm(@ModelAttribute("editPost") Post editPost) {		
		postService.setEditPost(editPost);	
		// 로직 추가 필요함. 수정 전 폼 유지 등...
		return "redirect:/post/" + editPost.getPostNo();
	}
	
	@DeleteMapping("/post/{postNo}")
	public String submitDeletePostForm(@PathVariable("postNo") int postNo) {
		postService.setDeletePost(postNo);
		return "redirect:/post/search";
	}

}
