package com.gameHub.repository;

public interface PostLikeRepository {
	
	int getLikeCountByPost(int postNo);

	void setNewLike(int postNo, int userNo);
	
	void setDeleteLike(int postNo, int userNo);
}
