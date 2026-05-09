package com.gameHub.service;

import java.util.List;

import com.gameHub.domain.Post;
import com.gameHub.domain.PostSearchDTO;

public interface PostService {
	
	List<Post> searchPosts(PostSearchDTO postSearchDTO);
	
	Post getPostByNo(int postNo);
	
	/*
	
	List<Post> getPostsByType(String postType);
	
	List<Post> getPostsByTitle(String postTitle);
	
	List<Post> getPostsByContent(String postContent);
	
	List<Post> getPostsByViewCount(String viewCount);
	
	List<Post> getPostsByLikeCount(String likeCount);
	
	List<Post> getPostsByCommentCount(String commentCount);
	
	List<Post> getPostsByCreatedAt(LocalDateTime startTime, LocalDateTime endTime);
	
	*/
	
	void setNewPost(Post newPost);
	
	void setEditPost(Post editPost);

	void setDeletePost(int postNo);

}
