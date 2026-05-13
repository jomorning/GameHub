package com.gameHub.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gameHub.domain.PostForm;
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
	public void setNewRecruit(PostForm postForm) {
		String SQL = "INSERT INTO recruit(post_no, recruit_position, recruit_max_member) VALUES(?,?,?)";
		System.out.println("받은 PostNO(PK): " + postForm.getPostNo());
		template.update(SQL, postForm.getPostNo(), postForm.getRecruitPosition(), postForm.getRecruitMaxMember());
	}

	@Override
	public void setEditRecruit(PostForm postForm) {
		String SQL = "UPDATE recruit SET recruit_position = ?, recruit_status = ?, recruit_max_member = ? WHERE post_no = ?";
		template.update(SQL, postForm.getRecruitPosition(), postForm.getRecruitStatus(), postForm.getRecruitMaxMember(), postForm.getPostNo());
	}

}
