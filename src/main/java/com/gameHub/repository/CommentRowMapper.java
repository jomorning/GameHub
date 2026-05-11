package com.gameHub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gameHub.domain.Comment;
import com.gameHub.domain.CommentResponseDTO;

public class CommentRowMapper implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment comment = new Comment();
		comment.setCommentNo(rs.getInt("comment_no"));
		comment.setUserNo(rs.getInt("user_no"));
		comment.setPostNo(rs.getInt("post_no"));
		comment.setCommentContent(rs.getString("comment_content"));
		comment.setCommentCreatedAt(rs.getTimestamp("comment_created_at").toLocalDateTime());
		comment.setCommentUpdatedAt(rs.getTimestamp("comment_updated_at").toLocalDateTime());
		return comment;
	}
}
