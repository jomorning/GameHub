package com.gameHub.repository;

import com.gameHub.domain.PostForm;
import com.gameHub.domain.Recruit;

public interface RecruitRepository {
	
	Recruit getRecruitByPost(int postNo);
	
	void setNewRecruit(PostForm postForm);
	
	void setEditRecruit(PostForm postForm);

}
