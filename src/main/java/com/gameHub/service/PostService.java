package com.gameHub.service;

import java.util.List;

import com.gameHub.domain.Post;
import com.gameHub.domain.PostSearchDTO;

public interface PostService {
	
	List<Post> searchPosts(PostSearchDTO postSearchDTO);
	
	Post getPostByNo(int postNo);
	
	void setNewPost(Post newPost);
	
	void setEditPost(Post editPost);

	void setDeletePost(int postNo);

}
