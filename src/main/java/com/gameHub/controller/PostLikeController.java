package com.gameHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gameHub.service.PostLikeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostLikeController {
	
	@Autowired
	PostLikeService postLikeService;
	
	@ResponseBody
	@PostMapping("post/{postNo}/like")
	public int submitNewLike(@PathVariable("postNo") int postNo, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		int likeCountByPost = postLikeService.setNewLike(postNo, loginUserNo);
		return likeCountByPost;
	}
	
	@ResponseBody
	@DeleteMapping("post/{postNo}/like")
	public int submitDeleteLike(@PathVariable("postNo") int postNo, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		int likeCountByPost = postLikeService.setDeleteLike(postNo, loginUserNo);
		return likeCountByPost;
	}

}
