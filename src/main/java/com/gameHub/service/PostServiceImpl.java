package com.gameHub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Game;
import com.gameHub.domain.Post;
import com.gameHub.domain.PostForm;
import com.gameHub.domain.PostResponseDTO;
import com.gameHub.exception.NoPostFoundException;
import com.gameHub.repository.CommentRepository;
import com.gameHub.repository.GameRepository;
import com.gameHub.repository.PostLikeRepository;
import com.gameHub.repository.PostRepository;
import com.gameHub.repository.RecruitRepository;
import com.gameHub.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	GameRepository gameRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RecruitRepository recruitRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	PostLikeRepository postLikeRepository;

	@Override
	public List<PostResponseDTO> searchPosts(String keyword) {
		List<PostResponseDTO> postsBySearch = new ArrayList<>();
		postsBySearch = postRepository.getJoinedPosts(keyword);

		for (int i = 0; i < postsBySearch.size(); i++) {
			int postsNo = postsBySearch.get(i).getPostNo();
			int commentCountByPost = commentRepository.getCommentCountByPost(postsNo);
			int likeCountByPost = postLikeRepository.getLikeCountByPost(postsNo);
			postsBySearch.get(i).setCommentCount(commentCountByPost);
			postsBySearch.get(i).setLikeCount(likeCountByPost);
		}

		return postsBySearch;
	}

	@Override
	public Post getPostByNo(int postNo) {
		Post postByNo = postRepository.getPostByNo(postNo);
		
		if (postByNo == null) {
			throw new NoPostFoundException(postNo);
		}
		
		Game postGame = gameRepository.getGameByNo(postByNo.getGameNo());
		String postGameName = postGame.getGameName();
		postByNo.setGameName(postGameName);
		int commentCountByPost = commentRepository.getCommentCountByPost(postNo);
		int likeCountByPost = postLikeRepository.getLikeCountByPost(postNo);
		postByNo.setCommentCount(commentCountByPost);
		postByNo.setLikeCount(likeCountByPost);
		return postByNo;
	}

	@Override
	public void setNewPost(PostForm postForm) {
		String newPostGameName = postForm.getGameName();
		Game newPostGame = gameRepository.getGameByName(newPostGameName);
		postForm.setGameNo(newPostGame.getGameNo()); 
		int returnedPostNo = postRepository.setNewPost(postForm);
		postForm.setPostNo(returnedPostNo);

		if (postForm.getPostType().equals("RECRUIT")) {
			recruitRepository.setNewRecruit(postForm);
		}
	}

	@Override
	public void setEditPost(PostForm postForm, int loginUserNo) {
		if (postForm.getUserNo() == loginUserNo) {
			postRepository.setEditPost(postForm);

			if (postForm.getPostType().equals("RECRUIT")) {
				recruitRepository.setEditRecruit(postForm);
			}
		}
	}

	@Override
	public void setDeletePost(int postNo, int loginUserNo, String loginUserId) {
		Post postByNo = postRepository.getPostByNo(postNo);

		if (postByNo.getUserNo() == loginUserNo || (loginUserNo == 1 && "admin".equals(loginUserId))) {
			postRepository.setDeletePost(postNo);
		}
	}

}
