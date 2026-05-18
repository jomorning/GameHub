package com.gameHub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gameHub.domain.Recruit;

public class RecruitRowMapper implements RowMapper<Recruit> {

	@Override
	public Recruit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Recruit recruit = new Recruit();
		recruit.setPostNo(rs.getInt("post_no"));
		recruit.setRecruitPosition(rs.getString("recruit_position"));
		recruit.setRecruitStatus(rs.getString("recruit_status"));
		recruit.setRecruitMaxMember(rs.getInt("recruit_max_member"));
		recruit.setRecruitCurrentMember(rs.getInt("recruit_current_member"));
		return recruit;
	}

}
