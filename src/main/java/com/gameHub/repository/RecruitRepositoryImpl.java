package com.gameHub.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gameHub.domain.PostForm;
import com.gameHub.domain.Recruit;

@Repository
public class RecruitRepositoryImpl implements RecruitRepository {
	
	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	private void updateCurrentMember(int postNo) {
		String SQLforCurrentMember = "SELECT COUNT(*) FROM recruit_apply WHERE post_no = ?";
		int returnedCurrentMember = template.queryForObject(SQLforCurrentMember, Integer.class, postNo);
		String SQLforUpdateCurrentMember = "UPDATE recruit SET recruit_current_member = ? WHERE post_no = ?";
		template.update(SQLforUpdateCurrentMember, returnedCurrentMember, postNo);
	}

	@Override
	public Recruit getRecruitByPost(int postNo) {
		String SQL = "SELECT * FROM recruit WHERE post_no = ?";
		List<Recruit> recruitByPostTemp = template.query(SQL, new RecruitRowMapper(), postNo);
		
		if (recruitByPostTemp.isEmpty()) {
			return null;
		}
		
		Recruit recruitByPost = recruitByPostTemp.get(0);
		updateCurrentMember(postNo);
		return recruitByPost;
	}

	@Override
	public void setNewRecruit(PostForm postForm) {
		System.out.println("받은 PostNO(PK): " + postForm.getPostNo());
		String SQL = "INSERT INTO recruit(post_no, recruit_position, recruit_max_member) VALUES(?,?,?)";
		template.update(SQL, postForm.getPostNo(), postForm.getRecruitPosition(), postForm.getRecruitMaxMember());
		String SQLforAddDefaultAppliedUser = "INSERT INTO recruit_apply(user_no, post_no) VALUES(?,?)";
		template.update(SQLforAddDefaultAppliedUser, postForm.getUserNo(), postForm.getPostNo());
	}

	@Override
	public void setEditRecruit(PostForm postForm) {
		String SQL = "UPDATE recruit SET recruit_position = ?, recruit_status = ?, recruit_max_member = ? WHERE post_no = ?";
		template.update(SQL, postForm.getRecruitPosition(), postForm.getRecruitStatus(), postForm.getRecruitMaxMember(), postForm.getPostNo());
	}

}
