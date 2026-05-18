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

import com.gameHub.domain.User;
import com.gameHub.domain.UserSearchDTO;
import com.gameHub.exception.NoUserFoundException;
import com.gameHub.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/search")
	public String searchUsers(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="limit", defaultValue="5") int limit, @ModelAttribute("userSearchDTO") UserSearchDTO userSearchDTO, Model model) {
		
		userSearchDTO.setPageNum(pageNum);
		userSearchDTO.setLimit(limit);
		
		List<User> usersBySearch = userService.searchUsers(userSearchDTO);
		
		int countAllUsers = userService.countAllUsers();
		int totalPages = (countAllUsers % limit) == 0 ? countAllUsers / limit : (countAllUsers / limit) + 1;
		model.addAttribute("users", usersBySearch);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("userSearchDTO", userSearchDTO);
		return "users";
	}
	
	@GetMapping("/user/{userNo}")
	public String getUserByNo(@PathVariable("userNo") int userNo, Model model) {
		User userByNo = userService.getUserByNo(userNo);
		model.addAttribute("userByNo", userByNo);
		return "user";
	}
	
	@ExceptionHandler(value={(NoUserFoundException.class)})
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
