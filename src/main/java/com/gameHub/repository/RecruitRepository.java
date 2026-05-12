package com.gameHub.repository;

import com.gameHub.domain.Recruit;

public interface RecruitRepository {
	
	Recruit getRecruitByPost(int postNo);
	
	void setNewRecruit(Recruit newRecruit);
	
	void setEditRecruit(Recruit editRecruit);

}
