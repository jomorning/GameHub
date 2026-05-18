package com.gameHub.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		String savedFileName = userRepository.getSavedFileName(userNo);
		
		if (userByNo == null) {
			throw new NoUserFoundException(userNo);
		}
		
		userByNo.setSavedFileName(savedFileName);
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
	public void saveImageFile(User user, MultipartFile file) {
		MultipartFile imageFile = file;
		
		if (imageFile != null && !imageFile.isEmpty()) {
			String originalName = imageFile.getOriginalFilename();
			String savedName = UUID.randomUUID().toString() + "_" + originalName;
			File savedImageFile = new File("C:\\upload\\app_user", savedName);
			
			try {
				imageFile.transferTo(savedImageFile);
				user.setSavedFileName(savedName);
				System.out.println("이미지 업로드 성공: [" + savedImageFile.getPath() + "]");
			} catch (Exception e) {
				throw new RuntimeException("이미지 업로드 실패", e);
			}
			
		} else {
			System.out.println("이미지 변경 없음");
		}
		
	}

	@Override
	public void setNewUser(User newUser) {
		saveImageFile(newUser, newUser.getSavedFile());
		userRepository.setNewUser(newUser);
	}

	@Override
	public void setEditUser(User editUser) {
		
		User originUser = userRepository.getUserByNo(editUser.getUserNo());
		String originFileName = userRepository.getSavedFileName(editUser.getUserNo());
		
		if (editUser.getUserPw() == null || editUser.getUserPw().isEmpty()) {
			editUser.setUserPw(originUser.getUserPw());
		}
		
		if (editUser.getUserBirthDate() == null) {
			editUser.setUserBirthDate(originUser.getUserBirthDate());
		}
		
		if (editUser.getSavedFile() == null || editUser.getSavedFile().isEmpty()) {
			editUser.setSavedFileName(originFileName);
		}
		
		saveImageFile(editUser, editUser.getSavedFile());
		userRepository.setEditUser(editUser);
	}

	@Override
	public void setDeleteUser(int userNo) {
		userRepository.setDeleteUser(userNo);
	}

}
