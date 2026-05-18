package com.gameHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.repository.PostLikeRepository;

@Service
public class PostLikeServiceImpl implements PostLikeService {

	@Autowired
	PostLikeRepository postLikeRepository;
	
	@Override
	public void setNewLike(int postNo, int userNo) {
		postLikeRepository.setNewLike(postNo, userNo);
	}

	@Override
	public void setDeleteLike(int postNo, int userNo) {
		postLikeRepository.setDeleteLike(postNo, userNo);
	}

}
