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

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public int countAllUsers() {
		String SQL = "SELECT COUNT(*) FROM app_user";
		int countAllUsers = template.queryForObject(SQL, Integer.class);
		return countAllUsers;
	}

	@Override
	public List<User> getAllUsers() {
		String SQL = "SELECT * FROM app_user";
		List<User> allUsers = template.query(SQL, new UserRowMapper(false));
		return allUsers;
	}

	@Override
	public String getSavedFileName(int referenceNo) {
		String SQL = "SELECT saved_name FROM image WHERE reference_no = ?";
		String savedFileName = template.queryForObject(SQL, String.class, referenceNo);
		return savedFileName;
	}

	@Override
	public User getUserByNo(int userNo) {
		String SQL = "SELECT * FROM app_user WHERE user_no = ?";
		List<User> userByNoTemp = template.query(SQL, new UserRowMapper(false), userNo);
		
		if (userByNoTemp.isEmpty()) {
			return null;
		}
		
		User userByNo = userByNoTemp.get(0);
		return userByNo;
	}

	@Override
	public User getUserById(String userId) {
		String SQL = "SELECT * FROM app_user WHERE user_id = ?";
		List<User> userByIdTemp = template.query(SQL, new UserRowMapper(false), userId);
		
		if (userByIdTemp.isEmpty()) {
			return null;
		}
		
		User userById = userByIdTemp.get(0);
		return userById;
	}

	@Override
	public List<User> searchUsersByDetail(UserSearchDTO userSearchDTO) {
		StringBuilder SQL = new StringBuilder("SELECT * FROM app_user JOIN image ON app_user.user_no = image.reference_no WHERE 1=1");
		List<Object> params = new ArrayList<>();

		if (userSearchDTO.getUserId() != null && !userSearchDTO.getUserId().isEmpty()) {
			SQL.append(" AND user_id LIKE ? ");
			params.add(userSearchDTO.getUserId() + "%");
		}

		if (userSearchDTO.getUserName() != null && !userSearchDTO.getUserName().isEmpty()) {
			SQL.append(" AND user_name LIKE ? ");
			params.add(userSearchDTO.getUserName() + "%");
		}

		if (userSearchDTO.getUserEmail() != null && !userSearchDTO.getUserEmail().isEmpty()) {
			SQL.append(" AND user_email LIKE ? ");
			params.add(userSearchDTO.getUserEmail() + "%");
		}
		
		SQL.append(" ORDER BY app_user.user_no LIMIT ?, ?");
		params.add(userSearchDTO.getStartNum());
		params.add(userSearchDTO.getLimit());

		List<User> usersByDetail = template.query(SQL.toString(), new UserRowMapper(true), params.toArray());
		return usersByDetail;
	}

	@Override
	public List<User> searchUsersByCondition(UserSearchDTO userSearchDTO) {
		StringBuilder SQL = new StringBuilder("SELECT * FROM app_user JOIN image ON app_user.user_no = image.reference_no WHERE 1=1");
		List<Object> params = new ArrayList<>();

		if (userSearchDTO.getUserRole() != null && !userSearchDTO.getUserRole().isEmpty()) {
			SQL.append(" AND user_role = ? ");
			params.add(userSearchDTO.getUserRole());
		}

		if (userSearchDTO.getUserName() != null && !userSearchDTO.getUserName().isEmpty()) {
			SQL.append(" AND user_name LIKE ? ");
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
		
		SQL.append(" ORDER BY app_user.user_no LIMIT ?, ?");
		params.add(userSearchDTO.getStartNum());
		params.add(userSearchDTO.getLimit());

		List<User> usersByCondition = template.query(SQL.toString(), new UserRowMapper(true), params.toArray());
		return usersByCondition;
	}

	@Override
	public void setNewUser(User newUser) {
		String SQL = "INSERT INTO app_user(user_id, user_pw, user_name, user_nickname, user_birth_date, user_email) VALUES(?,?,?,?,?,?)";
		template.update(SQL, newUser.getUserId(), newUser.getUserPw(), newUser.getUserName(), newUser.getUserNickname(), newUser.getUserBirthDate(), newUser.getUserEmail());
		
		String SQLforReturnPK = "SELECT LAST_INSERT_ID()";
		Integer returnedUserNo = template.queryForObject(SQLforReturnPK, Integer.class);
		
		String SQL_i = "INSERT INTO image(reference_no, image_type, saved_name, file_path) VALUES(?,?,?,?)";
		template.update(SQL_i, returnedUserNo, "app_user", newUser.getSavedFileName(), "C:\\upload\\app_user\\" + newUser.getSavedFileName());
	}

	@Override
	public void setEditUser(User editUser) {
		String SQL = "UPDATE app_user SET user_id = ?, user_pw = ?, user_name = ?, user_nickname = ?, user_birth_date = ?, user_email = ? WHERE user_no = ?";
		template.update(SQL, editUser.getUserId(), editUser.getUserPw(), editUser.getUserName(), editUser.getUserNickname(), editUser.getUserBirthDate(), editUser.getUserEmail(), editUser.getUserNo());
		String SQL_u = "UPDATE image SET saved_name = ?, file_path = ? WHERE reference_no = ?";
		template.update(SQL_u, editUser.getSavedFileName(), "C:\\upload\\app_user\\" + editUser.getSavedFileName(), editUser.getUserNo());
	}

	@Override
	public void setDeleteUser(int userNo) {
		String SQL = "DELETE FROM app_user WHERE user_no = ?";
		template.update(SQL, userNo);
		String SQL_d = "DELETE FROM image WHERE reference_no = ?";
		template.update(SQL_d, userNo);
	}

}
