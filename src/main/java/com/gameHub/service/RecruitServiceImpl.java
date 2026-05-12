package com.gameHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Recruit;
import com.gameHub.repository.RecruitRepository;

@Service
public class RecruitServiceImpl implements RecruitService {
	
	@Autowired
	RecruitRepository recruitRepository;

	@Override
	public Recruit getRecruitByPost(int postNo) {
		Recruit recruitByPost = recruitRepository.getRecruitByPost(postNo);
		return recruitByPost;
	}

	@Override
	public void setNewRecruit(Recruit newRecruit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEditRecruit(Recruit editRecruit) {
		// TODO Auto-generated method stub

	}

}
