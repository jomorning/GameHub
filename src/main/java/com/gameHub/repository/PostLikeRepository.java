package com.gameHub.repository;

public interface PostLikeRepository {
	
	int getLikeCountByPost(int postNo);

	int setNewLike(int postNo, int userNo);
	
	int setDeleteLike(int postNo, int userNo);
}
