package com.gameHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Recruit;
import com.gameHub.domain.RecruitApply;
import com.gameHub.repository.RecruitApplyRepository;
import com.gameHub.repository.RecruitRepository;

@Service
public class RecruitApplyServiceImpl implements RecruitApplyService {
	
	@Autowired
	RecruitApplyRepository recruitApplyRepository;
	
	@Autowired
	RecruitRepository recruitRepository;

	@Override
	public RecruitApply getApplyByNo(int applyNo) {
		RecruitApply applyByNo = recruitApplyRepository.getApplyByNo(applyNo);
		return applyByNo;
	}

	@Override
	public RecruitApply getApplyByPostAndUser(int postNo, int userNo) {
		RecruitApply applyByPostAndUser = recruitApplyRepository.getApplyByPostAndUser(postNo, userNo);
		return applyByPostAndUser;
	}

	@Override
	public List<RecruitApply> getAppliesByRecruit(int postNo) {
		List<RecruitApply> appliesByRecruit = recruitApplyRepository.getAppliesByRecruit(postNo);
		return appliesByRecruit;
	}

	@Override
	public void setNewApply(RecruitApply newApply) {
		recruitApplyRepository.setNewApply(newApply);
	}

	@Override
	public void setDeleteApply(int postNo, int userNo) {
		recruitApplyRepository.setDeleteApply(postNo, userNo); 

	}

}
