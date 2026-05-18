package com.gameHub.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostLikeRepositoryImpl implements PostLikeRepository {
	
	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public int getLikeCountByPost(int postNo) {
		String SQL = "SELECT COUNT(*) FROM post_like WHERE post_no = ?";
		int likeCountByPost = template.queryForObject(SQL, Integer.class, postNo);
		return likeCountByPost;
	}

	@Override
	public void setNewLike(int postNo, int userNo) {
		String SQL = "INSERT INTO post_like(post_no, user_no) VALUES(?,?)";
		template.update(SQL, postNo, userNo); 
	}

	@Override
	public void setDeleteLike(int postNo, int userNo) {
		String SQL = "DELETE FROM post_like WHERE post_no = ? AND user_no = ?";
		template.update(SQL, postNo, userNo);
	}

}
