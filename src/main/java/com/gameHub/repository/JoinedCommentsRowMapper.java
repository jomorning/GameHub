package com.gameHub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gameHub.domain.CommentResponseDTO;
import com.gameHub.domain.PostResponseDTO;

public class JoinedCommentsRowMapper implements RowMapper<CommentResponseDTO> {

	@Override
	public CommentResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
		commentResponseDTO.setCommentNo(rs.getInt("comment.comment_no"));
		commentResponseDTO.setUserId(rs.getString("app_user.user_id"));
		commentResponseDTO.setCommentContent(rs.getString("comment.comment_content"));
		commentResponseDTO.setCommentCreatedAt(rs.getTimestamp("comment_created_at").toLocalDateTime());
		commentResponseDTO.setCommentUpdatedAt(rs.getTimestamp("comment_updated_at").toLocalDateTime());
		return commentResponseDTO;
	}
}
