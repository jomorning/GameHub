package com.gameHub.repository;

import java.util.List;

import com.gameHub.domain.User;
import com.gameHub.domain.UserSearchDTO;

public interface UserRepository {
	
	int countAllUsers();

	List<User> getAllUsers();

	User getUserByNo(int userNo);
	
	User getUserById(String userId);
	
	List<User> searchUsersByDetail(UserSearchDTO userSearchDTO);
	
	List<User> searchUsersByCondition(UserSearchDTO userSearchDTO);
	
	void setNewUser(User newUser);
	
	void setEditUser(User editUser);
	
	void setDeleteUser(int userNo);
	
}
