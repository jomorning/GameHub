package com.gameHub.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.gameHub.domain.Comment;
import com.gameHub.domain.CommentResponseDTO;
import com.gameHub.domain.Post;
import com.gameHub.domain.PostForm;
import com.gameHub.domain.PostResponseDTO;
import com.gameHub.domain.Recruit;
import com.gameHub.domain.RecruitApply;
import com.gameHub.exception.GameAgeRatingException;
import com.gameHub.exception.NoPostFoundException;
import com.gameHub.exception.NoRecruitFoundException;
import com.gameHub.service.CommentService;
import com.gameHub.service.PostService;
import com.gameHub.service.RecruitApplyService;
import com.gameHub.service.RecruitService;
import com.gameHub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RecruitService recruitService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	RecruitApplyService recruitApplyService;
	
	@GetMapping("/post/search")
	public String searchPosts(@RequestParam(required=false, value="keyword") String keyword, Model model) {		
		List<PostResponseDTO> postsBySearch = postService.searchPosts(keyword);
		model.addAttribute("posts", postsBySearch);
		return "posts";
	}
	
	@GetMapping("/post/{postNo}")
	public String getPostByNo(@PathVariable("postNo") int postNo, Model model, @ModelAttribute("newComment") Comment newComment, HttpSession session) {
		
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		
		// post.jsp 내부에 Comment 객체 바인딩으로 인해
		// Model.addAttribute() 바인딩 또는 @ModelAttribute 바인딩을 명시적으로 해야 함.
		// 바인딩 누락 시, newComment 에 대한 바인딩 객체를 인식하지 못 함.
		Post postByNo = postService.getPostByNo(postNo);
		List<CommentResponseDTO> commentsByPost = commentService.getCommentsByPost(postNo);
		model.addAttribute("postByNo", postByNo);
		model.addAttribute("commentsByPost", commentsByPost);
		
		if (postByNo.getPostType().equals("RECRUIT")) {
			Recruit recruitByPost = recruitService.getRecruitByPost(postNo);
			model.addAttribute("recruitByPost", recruitByPost);
			
			RecruitApply applyByNo = recruitApplyService.getApplyByPostAndUser(postNo, loginUserNo);
			model.addAttribute("applyByNo", applyByNo);
			
			List<RecruitApply> appliesByRecruit = recruitApplyService.getAppliesByRecruit(postNo);
			model.addAttribute("appliesByRecruit", appliesByRecruit);
		}
		
		return "post";
	}
	
	@ExceptionHandler(value={(NoPostFoundException.class)})
	public String noPostFoundHandler(NoPostFoundException exception, Model model) {
		model.addAttribute("invalidPostNo", exception.getInvalidPostNo());
		return "noPostFoundException";
	}
	
	@ExceptionHandler(value={(NoRecruitFoundException.class)})
	public String noRecruitFoundHandler(NoRecruitFoundException exception, Model model) {
		model.addAttribute("invalidRecruitNo", exception.getInvalidRecruitNo());
		return "noRecruitFoundException";
	}
	
	@ExceptionHandler(value={(GameAgeRatingException.class)})
	public String gameAgeRatingHandler(GameAgeRatingException exception, Model model) {
		model.addAttribute("gameName", exception.getGameName());
		model.addAttribute("gameAgeRating", exception.getGameAgeRating());
		return "gameAgeRatingException";
	}
	
	@GetMapping("/post/new")
	public String getNewPostForm(@ModelAttribute("postForm") PostForm postForm) {
		return "newPost";
	}
	
	@PostMapping("/post")
	public String submitNewPostForm(@ModelAttribute("postForm") PostForm postForm, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		postForm.setUserNo(loginUserNo);
		postService.setNewPost(postForm);
		return "redirect:/post/" + postForm.getPostNo();
	}
	
	@GetMapping("/post/{postNo}/edit")
	public String getEditPostForm(@PathVariable("postNo") int postNo, @ModelAttribute("editPostForm") PostForm editPostForm, Model model) {
		Post postByNo = postService.getPostByNo(postNo);
		Recruit recruitByNo = recruitService.getRecruitByPost(postNo);
		editPostForm.setUserNo(postByNo.getUserNo());
		editPostForm.setPostType(postByNo.getPostType());
		editPostForm.setPostTitle(postByNo.getPostTitle());
		editPostForm.setPostContent(postByNo.getPostContent());
		editPostForm.setRecruitPosition(recruitByNo.getRecruitPosition());
		editPostForm.setRecruitStatus(recruitByNo.getRecruitStatus());
		editPostForm.setRecruitMaxMember(recruitByNo.getRecruitMaxMember());
		model.addAttribute("editPostForm", editPostForm);
		return "editPost";
	}
	
	@PutMapping("/post/{postNo}")
	public String submitEditPostForm(@ModelAttribute("editPostForm") PostForm editPostForm, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		postService.setEditPost(editPostForm, loginUserNo);	
		return "redirect:/post/" + editPostForm.getPostNo();
	}
	
	@DeleteMapping("/post/{postNo}")
	public String submitDeletePostForm(@PathVariable("postNo") int postNo, HttpSession session) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		String loginUserId = (String) session.getAttribute("loginUserId");
		postService.setDeletePost(postNo, loginUserNo, loginUserId);
		return "redirect:/post/search";
	}

}
