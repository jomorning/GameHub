package com.gameHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gameHub.service.PostLikeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostLikeController {
	
	@Autowired
	PostLikeService postLikeService;
	
	@PostMapping("post/{postNo}/like")
	public String submitNewLike(@PathVariable("postNo") int postNo, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		postLikeService.setNewLike(postNo, loginUserNo);
		return "redirect:/post/" + postNo;
	}
	
	@DeleteMapping("post/{postNo}/like")
	public String submitDeleteLike(@PathVariable("postNo") int postNo, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		postLikeService.setDeleteLike(postNo, loginUserNo);
		return "redirect:/post/" + postNo;
	}

}
