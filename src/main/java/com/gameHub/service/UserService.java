package com.gameHub.service;

import java.util.List;

import com.gameHub.domain.User;
import com.gameHub.domain.UserSearchDTO;

public interface UserService {

	List<User> getAllUsers();

	User getUserByNo(int userNo);
	
	List<User> searchUsers(UserSearchDTO userSearchDTO);
	
	void setNewUser(User newUser);
	
	void setEditUser(User editUser);
	
	void setDeleteUser(int userNo);

}
