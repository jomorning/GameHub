package com.gameHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Recruit;
import com.gameHub.exception.NoRecruitFoundException;
import com.gameHub.repository.RecruitRepository;

@Service
public class RecruitServiceImpl implements RecruitService {
	
	@Autowired
	RecruitRepository recruitRepository;

	@Override
	public Recruit getRecruitByPost(int postNo) {
		Recruit recruitByPost = recruitRepository.getRecruitByPost(postNo);
		
		if (recruitByPost == null) {
			throw new NoRecruitFoundException(postNo);
		}
		
		return recruitByPost;
	}

}
