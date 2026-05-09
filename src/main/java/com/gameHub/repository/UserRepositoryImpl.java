package com.gameHub.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gameHub.domain.User;
import com.gameHub.domain.UserSearchDTO;
import com.gameHub.exception.NoUserFoundException;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getAllUsers() {
		String SQL = "SELECT * FROM app_user";
		List<User> allUsers = template.query(SQL, new UserRowMapper());
		return allUsers;
	}

	@Override
	public User getUserByNo(int userNo) {
		String SQL = "SELECT * FROM app_user WHERE user_no = ?";
		List<User> userByNoTemp = template.query(SQL, new UserRowMapper(), userNo);
		
		if (userByNoTemp.isEmpty()) {
			return null;
		}
		
		User userByNo = userByNoTemp.get(0);
		return userByNo;
	}

	@Override
	public List<User> searchUsersByDetail(UserSearchDTO userSearchDTO) {
		StringBuilder SQL = new StringBuilder("SELECT * FROM app_user WHERE 1=1");
		List<Object> params = new ArrayList<>();

		if (userSearchDTO.getUserId() != null && !userSearchDTO.getUserId().isEmpty()) {
			SQL.append(" AND user_id LIKE ? ");
			params.add(userSearchDTO.getUserId() + "%");
		}

		if (userSearchDTO.getUserName() != null && !userSearchDTO.getUserName().isEmpty()) {
			SQL.append(" AND user_Name LIKE ? ");
			params.add(userSearchDTO.getUserName() + "%");
		}

		if (userSearchDTO.getUserEmail() != null && !userSearchDTO.getUserEmail().isEmpty()) {
			SQL.append(" AND user_email LIKE ? ");
			params.add(userSearchDTO.getUserEmail() + "%");
		}

		List<User> usersByDetail = template.query(SQL.toString(), new UserRowMapper(), params.toArray());
		return usersByDetail;
	}

	@Override
	public List<User> searchUsersByCondition(UserSearchDTO userSearchDTO) {
		StringBuilder SQL = new StringBuilder("SELECT * FROM app_user WHERE 1=1");
		List<Object> params = new ArrayList<>();

		if (userSearchDTO.getUserRole() != null && !userSearchDTO.getUserRole().isEmpty()) {
			SQL.append(" AND user_role = ? ");
			params.add(userSearchDTO.getUserRole());
		}

		if (userSearchDTO.getUserName() != null && !userSearchDTO.getUserName().isEmpty()) {
			SQL.append(" AND user_Name LIKE ? ");
			params.add(userSearchDTO.getUserName() + "%");
		}

		if (userSearchDTO.getMinUserAge() != null && userSearchDTO.getMaxUserAge() != null) {
			
			// 쿼리 파라미터의 나이 정수값을 DB DATE 타입의 생년월일로 변환
			LocalDate today = LocalDate.now();
			LocalDate minBirthDate = today.minusYears(userSearchDTO.getMaxUserAge());
			LocalDate maxBirthDate = today.minusYears(userSearchDTO.getMinUserAge());

			SQL.append(" AND user_birth_date BETWEEN ? AND ? ");
			params.add(Date.valueOf(minBirthDate));
			params.add(Date.valueOf(maxBirthDate));
		}
		
		if (userSearchDTO.getStartCreatedTime() != null && userSearchDTO.getEndCreatedTime() != null) {
			SQL.append(" AND user_created_at BETWEEN ? AND ? ");
			params.add(userSearchDTO.getStartCreatedTime());
			params.add(userSearchDTO.getEndCreatedTime());
		}

		List<User> usersByCondition = template.query(SQL.toString(), new UserRowMapper(), params.toArray());
		return usersByCondition;
	}

	@Override
	public void setNewUser(User newUser) {
		String SQL = "INSERT INTO app_user(user_id, user_pw, user_name, user_nickname, user_birth_date, user_email) VALUES(?,?,?,?,?,?)";
		template.update(SQL, newUser.getUserId(), newUser.getUserPw(), newUser.getUserName(), newUser.getUserNickname(), newUser.getUserBirthDate(), newUser.getUserEmail());
	}

	@Override
	public void setEditUser(User editUser) {
		String SQL = "UPDATE app_user SET user_id = ?, user_pw = ?, user_name = ?, user_nickname = ?, user_birth_date = ?, user_email = ? WHERE user_no = ?";
		template.update(SQL, editUser.getUserId(), editUser.getUserPw(), editUser.getUserName(), editUser.getUserNickname(), editUser.getUserBirthDate(), editUser.getUserEmail(), editUser.getUserNo());
	}

	@Override
	public void setDeleteUser(int userNo) {
		String SQL = "DELETE FROM app_user WHERE user_no = ?";
		template.update(SQL, userNo);
		
	}
	
	

}
