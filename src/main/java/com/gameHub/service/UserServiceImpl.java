package com.gameHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.User;
import com.gameHub.domain.UserSearchDTO;
import com.gameHub.exception.NoUserFoundException;
import com.gameHub.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public int countAllUsers() {
		int countAllUsers = userRepository.countAllUsers();
		return countAllUsers;
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.getAllUsers();
		return allUsers;
	}

	@Override
	public User getUserByNo(int userNo) {
		User userByNo = userRepository.getUserByNo(userNo);
		
		if (userByNo == null) {
			throw new NoUserFoundException(userNo);
		}
		
		return userByNo;
	}

	@Override
	public User getUserById(String userId) {
		User userById = userRepository.getUserById(userId);
		return userById;
	}

	@Override
	public List<User> searchUsers(UserSearchDTO userSearchDTO) {
		
		List<User> usersBySearch = null;
		
		int pageNum = userSearchDTO.getPageNum();
		int limit = userSearchDTO.getLimit();
		userSearchDTO.setStartNum(limit * (pageNum - 1));
		
		switch (userSearchDTO.getSearchMode()) {
		case "detail":
			usersBySearch = userRepository.searchUsersByDetail(userSearchDTO);
			break;
		case "condition":
			usersBySearch = userRepository.searchUsersByCondition(userSearchDTO);
			break;
		}
		
		return usersBySearch;
	}

	@Override
	public void setNewUser(User newUser) {
		userRepository.setNewUser(newUser);
	}

	@Override
	public void setEditUser(User editUser) {
		
		User originUser = userRepository.getUserByNo(editUser.getUserNo());
		
		if (editUser.getUserPw() == null || editUser.getUserPw().isEmpty()) {
			editUser.setUserPw(originUser.getUserPw());
		}
		
		if (editUser.getUserBirthDate() == null) {
			editUser.setUserBirthDate(originUser.getUserBirthDate());
		}
		
		userRepository.setEditUser(editUser);
	}

	@Override
	public void setDeleteUser(int userNo) {
		userRepository.setDeleteUser(userNo);
	}
	
	
	
}
