package com.gameHub.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gameHub.domain.RecruitApply;

@Repository
public class RecruitApplyRepositoryImpl implements RecruitApplyRepository {
	
	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	private void updateCurrentMember(int postNo) {
		String SQL_s = "SELECT COUNT(*) FROM recruit_apply WHERE post_no = ?";
		int currentMemberCount = template.queryForObject(SQL_s, Integer.class, postNo);
		String SQL_u = "UPDATE recruit SET recruit_current_member = ? WHERE post_no = ?";
		template.update(SQL_u, currentMemberCount, postNo);
	}

	@Override
	public RecruitApply getApplyByNo(int applyNo) {
		String SQL = "SELECT * FROM recruit_apply WHERE apply_no = ?";
		List<RecruitApply> applyByNoTemp = template.query(SQL, new RecruitApplyRowMapper(false), applyNo);		
		RecruitApply applyByNo = applyByNoTemp.get(0);
		return applyByNo;
	}

	@Override
	public RecruitApply getApplyByPostAndUser(int postNo, int userNo) {
		String SQL = "SELECT * FROM recruit_apply WHERE post_no = ? AND user_no = ?";
		List<RecruitApply> applyByPostAndUserTemp = template.query(SQL, new RecruitApplyRowMapper(false), postNo, userNo);
		
		if (applyByPostAndUserTemp.isEmpty()) {
			return null;
		}
		
		RecruitApply applyByPostAndUser = applyByPostAndUserTemp.get(0);
		return applyByPostAndUser;
	}

	@Override
	public List<RecruitApply> getAppliesByRecruit(int postNo) {
		String SQL = "SELECT recruit_apply.apply_no, recruit_apply.user_no, app_user.user_id, recruit_apply.post_no, recruit_apply.apply_status, recruit_apply.apply_created_at, recruit_apply.apply_updated_at FROM recruit_apply JOIN app_user ON recruit_apply.user_no = app_user.user_no WHERE post_no = ?";
		List<RecruitApply> appliesByRecruit = template.query(SQL, new RecruitApplyRowMapper(true), postNo);
		return appliesByRecruit;
	}

	@Override
	public void setNewApply(RecruitApply newApply) {
		String SQL = "INSERT INTO recruit_apply(user_no, post_no) VALUES(?,?)";
		template.update(SQL, newApply.getUserNo(), newApply.getPostNo());
		updateCurrentMember(newApply.getPostNo());
	}

	@Override
	public void setDeleteApply(int postNo, int userNo) {
		String SQL = "DELETE FROM recruit_apply WHERE post_no = ? AND user_no = ?"; 
		template.update(SQL, postNo, userNo);
		updateCurrentMember(postNo);
	}

}
