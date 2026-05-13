package com.gameHub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gameHub.domain.RecruitApply;

public class RecruitApplyRowMapper implements RowMapper<RecruitApply> {

	@Override
	public RecruitApply mapRow(ResultSet rs, int rowNum) throws SQLException {
		RecruitApply recruitApply = new RecruitApply();
		recruitApply.setApplyNo(rs.getInt("apply_no"));
		recruitApply.setUserNo(rs.getInt("user_no"));
		recruitApply.setPostNo(rs.getInt("post_no"));
		recruitApply.setApplyStatus(rs.getString("apply_status"));
		recruitApply.setApplyCreatedAt(rs.getTimestamp("apply_created_at").toLocalDateTime());
		recruitApply.setApplyUpdatedAt(rs.getTimestamp("apply_updated_at").toLocalDateTime());
		return recruitApply;
	}
}
