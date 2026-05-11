package com.gameHub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gameHub.domain.PostResponseDTO;

public class JoinedPostsRowMapper implements RowMapper<PostResponseDTO> {

	@Override
	public PostResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostResponseDTO postResponseDTO = new PostResponseDTO();
		postResponseDTO.setPostNo(rs.getInt("post.post_no"));
		postResponseDTO.setUserId(rs.getString("app_user.user_id"));
		postResponseDTO.setGameName(rs.getString("game.game_name"));
		postResponseDTO.setPostType(rs.getString("post.post_type"));
		postResponseDTO.setPostType(rs.getString("post.post_type"));
		postResponseDTO.setPostTitle(rs.getString("post.post_title"));
		postResponseDTO.setPostContent(rs.getString("post.post_content"));
		postResponseDTO.setViewCount(rs.getInt("post.view_count"));
		postResponseDTO.setLikeCount(rs.getInt("post.like_count"));
		postResponseDTO.setCommentCount(rs.getInt("post.comment_count"));
		postResponseDTO.setPostCreatedAt(rs.getTimestamp("post.post_created_at").toLocalDateTime());
		postResponseDTO.setPostUpdatedAt(rs.getTimestamp("post.post_updated_at").toLocalDateTime());
		return postResponseDTO;
	}
}
