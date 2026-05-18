package com.gameHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Post;
import com.gameHub.domain.Recruit;
import com.gameHub.domain.RecruitApply;
import com.gameHub.exception.ApplyCapacityException;
import com.gameHub.repository.PostRepository;
import com.gameHub.repository.RecruitApplyRepository;
import com.gameHub.repository.RecruitRepository;
import com.gameHub.repository.UserRepository;

@Service
public class RecruitApplyServiceImpl implements RecruitApplyService {

	@Autowired
	RecruitApplyRepository recruitApplyRepository;

	@Autowired
	RecruitRepository recruitRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

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
		Recruit recruitByPost = recruitRepository.getRecruitByPost(newApply.getPostNo());   
		int recruitCurrentMember = recruitByPost.getRecruitCurrentMember();
		int recruitMaxMember = recruitByPost.getRecruitMaxMember();
		
		if (recruitCurrentMember >= 1 && recruitCurrentMember < recruitMaxMember) {
			recruitApplyRepository.setNewApply(newApply);
		} else {
			throw new ApplyCapacityException(newApply.getUserId());
		}

	}

	@Override
	public void setDeleteApply(int postNo, int userNo) {
		Post postByNo = postRepository.getPostByNo(postNo);

		// 게시글 작성자 본인이 모집 취소 불가.
		if (userNo != postByNo.getUserNo()) {
			recruitApplyRepository.setDeleteApply(postNo, userNo);
		}
	}

}
