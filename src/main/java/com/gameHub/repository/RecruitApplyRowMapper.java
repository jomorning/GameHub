package com.gameHub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gameHub.domain.RecruitApply;

public class RecruitApplyRowMapper implements RowMapper<RecruitApply> {
	
	Boolean isJoined;

	public RecruitApplyRowMapper(Boolean isJoined) {
		this.isJoined = isJoined;
	}

	@Override
	public RecruitApply mapRow(ResultSet rs, int rowNum) throws SQLException {
		RecruitApply recruitApply = new RecruitApply();
		recruitApply.setApplyNo(rs.getInt("recruit_apply.apply_no"));
		recruitApply.setUserNo(rs.getInt("recruit_apply.user_no"));
		
		if (isJoined) {
			recruitApply.setUserId(rs.getString("app_user.user_id"));
		}
		
		recruitApply.setPostNo(rs.getInt("recruit_apply.post_no"));
		recruitApply.setApplyStatus(rs.getString("recruit_apply.apply_status"));
		recruitApply.setApplyCreatedAt(rs.getTimestamp("recruit_apply.apply_created_at").toLocalDateTime());
		recruitApply.setApplyUpdatedAt(rs.getTimestamp("recruit_apply.apply_updated_at").toLocalDateTime());
		return recruitApply;
	}
}
