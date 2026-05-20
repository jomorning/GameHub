package com.gameHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.repository.PostLikeRepository;

@Service
public class PostLikeServiceImpl implements PostLikeService {

	@Autowired
	PostLikeRepository postLikeRepository;
	
	@Override
	public int setNewLike(int postNo, int userNo) {
		return postLikeRepository.setNewLike(postNo, userNo);
	}

	@Override
	public int setDeleteLike(int postNo, int userNo) {
		return postLikeRepository.setDeleteLike(postNo, userNo);
	}

}
