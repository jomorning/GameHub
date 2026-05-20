package com.gameHub.service;

public interface PostLikeService {

	int setNewLike(int postNo, int userNo);
	
	int setDeleteLike(int postNo, int userNo);

}
