package com.gameHub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gameHub.domain.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserNo(rs.getInt("user_no"));
		user.setUserId(rs.getString("user_id"));
		user.setUserPw(rs.getString("user_pw"));
		user.setUserName(rs.getString("user_Name"));
		user.setUserNickname(rs.getString("user_Nickname"));
		user.setUserBirthDate(rs.getDate("user_birth_date").toLocalDate());
		user.setUserEmail(rs.getString("user_email"));
		user.setUserRole(rs.getString("user_role"));
		user.setUserCreatedAt(rs.getTimestamp("user_created_at").toLocalDateTime());
		return user;
	}
	
	

}
