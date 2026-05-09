package com.gameHub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gameHub.domain.Post;

public class PostRowMapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		Post post = new Post();
		post.setPostNo(rs.getInt("post_no"));
		post.setUserNo(rs.getInt("userNo"));
		post.setGameNo(rs.getInt("game_no"));
		post.setPostType(rs.getString("post_type"));
		post.setPostTitle(rs.getString("post_title"));
		post.setPostContent(rs.getString("post_content"));
		post.setViewCount(rs.getInt("view_count"));
		post.setLikeCount(rs.getInt("like_count"));
		post.setCommentCount(rs.getInt("comment_count"));
		post.setPostCreatedAt(rs.getTimestamp("post_created_at").toLocalDateTime());
		post.setPostUpdatedAt(rs.getTimestamp("post_updated_at").toLocalDateTime());
		return post;
	}
}
