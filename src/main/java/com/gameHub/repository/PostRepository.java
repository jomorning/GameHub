package com.gameHub.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.gameHub.domain.Post;
import com.gameHub.domain.PostSearchDTO;

public interface PostRepository {
	
	List<Post> getAllPosts();
	
	Post getPostByNo(int postNo);
	
	List<Post> getPostsByUserNo(int userNo);
	
	List<Post> getPostsByGameNo(int gameNo);
	
	List<Post> getPostsByType(String postType);
	
	List<Post> getPostsByTitle(String postTitle);
	
	List<Post> getPostsByContent(String postContent);
	
	List<Post> getPostsByViewCount(int viewCount, int limit);
	
	List<Post> getPostsByLikeCount(int likeCount, int limit);
	
	List<Post> getPostsByCommentCount(int commentCount, int limit);
	
	List<Post> getPostsByCreatedAt(LocalDateTime startTime, LocalDateTime endTime);
	
	void setNewPost(Post newPost);
	
	void setEditPost(Post editPost);
	
	void setDeletePost(int postNo);
	
}
