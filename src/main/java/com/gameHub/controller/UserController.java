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

import com.gameHub.domain.User;
import com.gameHub.domain.UserSearchDTO;
import com.gameHub.exception.NoUserFoundException;
import com.gameHub.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/search")
	public String searchUsers(@ModelAttribute("userSearchDTO") UserSearchDTO userSearchDTO, Model model) {
		List<User> usersBySearch = userService.searchUsers(userSearchDTO);
		model.addAttribute("users",usersBySearch);
		return "users";
	}
	
	@GetMapping("/user/{userNo}")
	public String getUserByNo(@PathVariable("userNo") int userNo, Model model) {
		User userByNo = userService.getUserByNo(userNo);
		model.addAttribute("userByNo", userByNo);
		return "user";
	}
	
	@ExceptionHandler(value= {(NoUserFoundException.class)})
	public String noUserFoundHandler(NoUserFoundException exception, Model model) {
		model.addAttribute("invalidUserNo", exception.getInvalidUserNo());
		return "noUserFoundException";
	}
	
	@GetMapping("/user/new")
	public String getNewUserForm(@ModelAttribute("newUser") User newUser) {
		return "newUser";
	}
	
	@PostMapping("/user")
	public String submitNewUserForm(@ModelAttribute("newUser") User newUser) {
		userService.setNewUser(newUser);
		return "redirect:/user/search";
	}
	
	@GetMapping("/user/{userNo}/edit")
	public String getEditUserForm(@PathVariable("userNo") int userNo, Model model) {
		User userByNo = userService.getUserByNo(userNo);
		model.addAttribute("editUser", userByNo);
		return "editUser";
	}
	
	@PutMapping("/user/{userNo}")
	public String submitEditUserForm(@ModelAttribute("editUser") User editUser) {
		userService.setEditUser(editUser);
		return "redirect:/user/" + editUser.getUserNo();
	}
	
	@DeleteMapping("/user/{userNo}")
	public String submitDeleteUserForm(@PathVariable("userNo") int userNo) {
		userService.setDeleteUser(userNo);
		return "redirect:/user/search";
	}

}
