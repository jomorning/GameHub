package com.gameHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gameHub.domain.RecruitApply;
import com.gameHub.exception.ApplyCapacityException;
import com.gameHub.service.RecruitApplyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RecruitApplyController {
	
	@Autowired
	RecruitApplyService recruitApplyService;
	
	@PostMapping("/post/{postNo}/apply")
	public String submitNewApply(@PathVariable("postNo") int postNo, RecruitApply newApply, HttpSession session, Model model) {
		int loginUserNo = (Integer) session.getAttribute("loginUserNo");
		String loginUserId = (String) session.getAttribute("loginUserId");
		newApply.setPostNo(postNo);
		newApply.setUserNo(loginUserNo);
		newApply.setUserId(loginUserId);
		recruitApplyService.setNewApply(newApply);
		model.addAttribute("postNo", postNo);
		return "redirect:/post/" + postNo;
	}
	
	@ExceptionHandler(value={(ApplyCapacityException.class)})
	public String ApplyCapacityHandler(ApplyCapacityException exception, Model model) {
		model.addAttribute("deniedUserId", exception.getDeniedUserId());
		return "applyCapacityException";
	}
	
	@DeleteMapping("/post/{postNo}/apply/{userNo}")
	public String submitDeleteApply(@PathVariable("postNo") int postNo, @PathVariable("userNo") int userNo) {
		recruitApplyService.setDeleteApply(postNo, userNo);
		return "redirect:/post/" + postNo;
	}

}
