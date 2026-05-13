package com.gameHub.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.gameHub.domain.Post;
import com.gameHub.domain.PostForm;
import com.gameHub.domain.PostResponseDTO;

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
	
	List<PostResponseDTO> getJoinedPosts(String keyword);
	
	int setNewPost(PostForm postForm);
	
	void setEditPost(PostForm postForm);
	
	void setDeletePost(int postNo);
	
}
