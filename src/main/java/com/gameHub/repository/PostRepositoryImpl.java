package com.gameHub.repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gameHub.domain.Post;

@Repository
public class PostRepositoryImpl implements PostRepository {

	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Post> getAllPosts() {
		String SQL = "SELECT * FROM post";
		List<Post> allPosts = template.query(SQL, new PostRowMapper());
		return allPosts;
	}

	@Override
	public Post getPostByNo(int postNo) {
		String SQL = "SELECT * FROM post WHERE post_no = ?";
		List<Post> postByNoTemp = template.query(SQL, new PostRowMapper(), postNo);
		
		if (postByNoTemp.isEmpty()) {
			return null;
		}
		
		Post postByNo = postByNoTemp.get(0);
		return postByNo;
	}

	@Override
	public List<Post> getPostsByUserNo(int userNo) {
		String SQL = "SELECT * FROM post WHERE user_no = ?";
		List<Post> postsByUserNo = template.query(SQL, new PostRowMapper(), userNo);
		return postsByUserNo;
	}

	@Override
	public List<Post> getPostsByGameNo(int gameNo) {
		String SQL = "SELECT * FROM post WHERE game_no = ?";
		List<Post> postsByGameNo = template.query(SQL, new PostRowMapper(), gameNo);
		return postsByGameNo;
	}

	@Override
	public List<Post> getPostsByType(String postType) {
		String SQL = "SELECT * FROM post WHERE post_type = ?";
		List<Post> postsByType = template.query(SQL, new PostRowMapper(), postType);
		return postsByType;
	}

	@Override
	public List<Post> getPostsByTitle(String postTitle) {
		String SQL = "SELECT * FROM post WHERE post_title LIKE ?";
		List<Post> postsByTitle = template.query(SQL, new PostRowMapper(), "%" + postTitle + "%");
		return postsByTitle;	
	}
	
	@Override
	public List<Post> getPostsByContent(String postContent) {
		String SQL = "SELECT * FROM post WHERE post_content LIKE ?";
		List<Post> postsByContent = template.query(SQL, new PostRowMapper(), "%" + postContent + "%");
		return postsByContent;	
	}

	@Override
	public List<Post> getPostsByViewCount(int viewCount, int limit) {
		String SQL = "SELECT * FROM post WHERE view_count > ? LIMIT ?";
		List<Post> postsByViewCount = template.query(SQL, new PostRowMapper(), viewCount, limit);
		return postsByViewCount;	
	}

	@Override
	public List<Post> getPostsByLikeCount(int likeCount, int limit) {
		String SQL = "SELECT * FROM post WHERE like_count > ? LIMIT ?";
		List<Post> postsByLikeCount = template.query(SQL, new PostRowMapper(), likeCount, limit);
		return postsByLikeCount;	
	}

	@Override
	public List<Post> getPostsByCommentCount(int commentCount, int limit) {
		String SQL = "SELECT * FROM post WHERE comment_count > ? LIMIT ?";
		List<Post> postsByCommentCount = template.query(SQL, new PostRowMapper(), commentCount, limit);
		return postsByCommentCount;
	}

	@Override
	public List<Post> getPostsByCreatedAt(LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNewPost(Post newPost) {
		String SQL = "INSERT INTO post(user_no, game_no, post_type, post_title, post_content) VALUES(?,?,?,?,?)";
		template.update(SQL, newPost.getUserNo(), newPost.getGameNo(), newPost.getPostType(), newPost.getPostTitle(), newPost.getPostContent());
	}

	@Override
	public void setEditPost(Post editPost) {
		String SQL = "UPDATE post SET post_title = ?, post_content = ? WHERE post_no = ?";
		template.update(SQL, editPost.getPostTitle(), editPost.getPostContent(), editPost.getPostNo());
	}

	@Override
	public void setDeletePost(int postNo) {
		String SQL = "DELETE FROM post WHERE post_no = ?";
		template.update(SQL, postNo);
	}

}
