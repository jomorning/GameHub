package com.gameHub.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gameHub.domain.User;
import com.gameHub.domain.UserSearchDTO;

public interface UserService {
	
	int countAllUsers();

	List<User> getAllUsers();

	User getUserByNo(int userNo);
	
	User getUserById(String userId);
	
	List<User> searchUsers(UserSearchDTO userSearchDTO);
	
	void saveImageFile(User user, MultipartFile file);
	
	void setNewUser(User newUser);
	
	void setEditUser(User editUser);
	
	void setDeleteUser(int userNo);

}
