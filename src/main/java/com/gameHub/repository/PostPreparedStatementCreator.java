package com.gameHub.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;

import com.gameHub.domain.Post;

public class PostPreparedStatementCreator implements PreparedStatementCreator {
	
	private String SQL;
	Post newPost;

	public PostPreparedStatementCreator(String SQL, Post newPost) {
		super();
		this.SQL = SQL;
		this.newPost = newPost;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		
		PreparedStatement pstmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
		
		pstmt.setInt(1, newPost.getUserNo());
		pstmt.setInt(2, newPost.getGameNo());
		pstmt.setString(3, newPost.getPostType());
		pstmt.setString(4, newPost.getPostTitle());
		pstmt.setString(5, newPost.getPostContent());
		return pstmt;
	}

}
