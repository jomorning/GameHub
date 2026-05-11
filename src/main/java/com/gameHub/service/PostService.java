package com.gameHub.service;

import java.util.List;

import com.gameHub.domain.Post;
import com.gameHub.domain.PostResponseDTO;

public interface PostService {
	
	List<PostResponseDTO> searchPosts(String keyword);
	
	Post getPostByNo(int postNo);
	
	void setNewPost(Post newPost);
	
	void setEditPost(Post editPost);

	void setDeletePost(int postNo);

}
