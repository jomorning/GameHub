package com.gameHub.repository;

import java.util.List;

import com.gameHub.domain.RecruitApply;

public interface RecruitApplyRepository {
	
	RecruitApply getApplyByNo(int applyNo);
	
	RecruitApply getApplyByPostAndUser(int postNo, int userNo);
	
	List<RecruitApply> getAppliesByRecruit(int postNo);
	
	void setNewApply(RecruitApply newApply);
	
	void setDeleteApply(int postNo, int userNo);

}
