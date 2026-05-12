package com.gameHub.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gameHub.domain.Recruit;
import com.gameHub.domain.RecruitRowMapper;

@Repository
public class RecruitRepositoryImpl implements RecruitRepository {
	
	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public Recruit getRecruitByPost(int postNo) {
		String SQL = "SELECT * FROM recruit WHERE post_no = ?";
		List<Recruit> recruitByPostTemp = template.query(SQL, new RecruitRowMapper(), postNo);
		Recruit recruitByPost = recruitByPostTemp.get(0);
		return recruitByPost;
	}

	@Override
	public void setNewRecruit(Recruit newRecruit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEditRecruit(Recruit editRecruit) {
		// TODO Auto-generated method stub

	}

}
