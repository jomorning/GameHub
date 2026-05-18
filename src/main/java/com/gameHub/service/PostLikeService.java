package com.gameHub.service;

public interface PostLikeService {

	void setNewLike(int postNo, int userNo);
	
	void setDeleteLike(int postNo, int userNo);

}
