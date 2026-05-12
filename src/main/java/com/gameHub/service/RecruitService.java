package com.gameHub.service;

import com.gameHub.domain.Recruit;

public interface RecruitService {

	Recruit getRecruitByPost(int postNo);

	void setNewRecruit(Recruit newRecruit);

	void setEditRecruit(Recruit editRecruit);

}
