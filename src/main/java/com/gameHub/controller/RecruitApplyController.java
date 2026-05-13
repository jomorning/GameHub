package com.gameHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gameHub.domain.RecruitApply;
import com.gameHub.service.RecruitApplyService;

@Controller
public class RecruitApplyController {
	
	@Autowired
	RecruitApplyService recruitApplyService;
	
	@PostMapping("/post/{postNo}/apply")
	public String submitNewApply(@PathVariable("postNo") int postNo, @ModelAttribute("newRecruitApply") RecruitApply newApply) {
		newApply.setPostNo(postNo);
		// 임시 모집 지원자 UserNo. 4
		newApply.setUserNo(4);
		recruitApplyService.setNewApply(newApply);
		return "redirect:/post/" + postNo;
	}
	
	@DeleteMapping("/post/{postNo}/apply/{userNo}")
	public String submitDeleteApply(@PathVariable("postNo") int postNo, @PathVariable("userNo") int userNo) {
		recruitApplyService.setDeleteApply(postNo, userNo);
		return "redirect:/post/" + postNo;
	}

}
