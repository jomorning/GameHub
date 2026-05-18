package com.gameHub.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gameHub.domain.User;
import com.gameHub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String redirectMain() {
		return "redirect:/main";
	}

	@GetMapping("/main")
	public String main(@RequestParam(value = "login", required = false) String isLogin, Principal principal,
			HttpSession session) {

		if ("true".equals(isLogin) && !isLogin.isEmpty()) {
			String loginUserId = principal.getName();
			User userById = userService.getUserById(loginUserId);
			int loginUserNo = userById.getUserNo();
			
			LocalDate userBirthDate = userById.getUserBirthDate();
			int userAge = (LocalDate.now().getYear() - userBirthDate.getYear());
			
			System.out.println("로그인 유저 ID: " + loginUserId);
			System.out.println("로그인 유저 No: " + loginUserNo);
			System.out.println("로그인 유저 Birth: " + userBirthDate);
			System.out.println("로그인 유저 Age: " + userAge);
			
			session.setAttribute("loginUserId", loginUserId);
			session.setAttribute("loginUserNo", loginUserNo);
		}

		return "main";

	}

	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}

	@GetMapping("/login/failed")
	public String loginFailed(Model model) {
		model.addAttribute("failureReason", "아이디 또는 비밀번호가 일치하지 않습니다.");
		return "login";
	}

}
