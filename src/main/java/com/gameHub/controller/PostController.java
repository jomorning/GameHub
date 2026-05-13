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
import com.gameHub.exception.NoPostFoundException;
import com.gameHub.service.CommentService;
import com.gameHub.service.PostService;
import com.gameHub.service.RecruitService;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	RecruitService recruitService;
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/post/search")
	public String searchPosts(@RequestParam(required=false, value="keyword") String keyword, Model model) {		
		List<PostResponseDTO> postsBySearch = postService.searchPosts(keyword);
		model.addAttribute("posts", postsBySearch);
		return "posts";
	}
	
	
	@GetMapping("/post/{postNo}")
	public String getPostByNo(@PathVariable("postNo") int postNo, Model model, @ModelAttribute("newComment") Comment newComment) {
		// post.jsp processURL 는 Post 컨트롤러 및 Comment 컨트롤러가 매핑되어 있으므로,
		// 두 컨트롤러에 post.jsp form 태그에 대한 Model.addAttribute() 바인딩 또는 @ModelAttribute 바인딩을 명시적으로 해야 함.
		// 바인딩 누락 시, newComment 에 대한 바인딩 객체를 인식하지 못 함.
		Post postByNo = postService.getPostByNo(postNo);
		List<CommentResponseDTO> commentsByPost = commentService.getCommentsByPost(postNo);
		model.addAttribute("postByNo", postByNo);
		model.addAttribute("commentsByPost", commentsByPost);
		
		if (postByNo.getPostType().equals("RECRUIT")) {
			Recruit recruitByPost = recruitService.getRecruitByPost(postNo);
			model.addAttribute("recruitByPost", recruitByPost);
		}
		
		return "post";
	}
	
	@ExceptionHandler(value={(NoPostFoundException.class)})
	public String noPostFoundHandler(NoPostFoundException exception, Model model) {
		model.addAttribute("invalidPostNo", exception.getInvalidPostNo());
		return "noPostFoundException";
	}
	
	@GetMapping("/post/new")
	public String getNewPostForm(@ModelAttribute("postForm") PostForm postForm) {
		return "newPost";
	}
	
	@PostMapping("/post")
	public String submitNewPostForm(@ModelAttribute("postForm") PostForm postForm) {
		postService.setNewPost(postForm);
		return "redirect:/post/" + postForm.getPostNo();
	}
	
	@GetMapping("/post/{postNo}/edit")
	public String getEditPostForm(@PathVariable("postNo") int postNo, @ModelAttribute("editPostForm") PostForm editPostForm, Model model) {
		Post postByNo = postService.getPostByNo(postNo);
		Recruit recruitByNo = recruitService.getRecruitByPost(postNo);
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
	public String submitEditPostForm(@ModelAttribute("editPostForm") PostForm editPostForm) {
		postService.setEditPost(editPostForm);	
		return "redirect:/post/" + editPostForm.getPostNo();
	}
	
	@DeleteMapping("/post/{postNo}")
	public String submitDeletePostForm(@PathVariable("postNo") int postNo) {
		postService.setDeletePost(postNo);
		return "redirect:/post/search";
	}

}
