package com.gameHub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Game;
import com.gameHub.domain.Post;
import com.gameHub.domain.PostResponseDTO;
import com.gameHub.domain.User;
import com.gameHub.exception.NoPostFoundException;
import com.gameHub.repository.GameRepository;
import com.gameHub.repository.PostRepository;
import com.gameHub.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	GameRepository gameRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<PostResponseDTO> searchPosts(String keyword) {
		List<PostResponseDTO> postsBySearch = new ArrayList<>();
		postsBySearch = postRepository.getJoinedPosts(keyword);
		return postsBySearch;
	}

	@Override
	public Post getPostByNo(int postNo) {
		Post postByNo = postRepository.getPostByNo(postNo);

		if (postByNo == null) {
			throw new NoPostFoundException(postNo);
		}

		// 게시글의 gameNo 를 기준으로 GameRepository 의 gameName 변환
		Game postGame = gameRepository.getGameByNo(postByNo.getGameNo());
		String postGameName = postGame.getGameName();
		postByNo.setGameName(postGameName);
		return postByNo;
	}

	@Override
	public void setNewPost(Post newPost) {
		String newPostGameName = newPost.getGameName();
		Game newPostGame = gameRepository.getGameByName(newPostGameName);
		newPost.setGameNo(newPostGame.getGameNo());
		// 임시 게시글 등록자 UserNo. 3 (jomorning)
		newPost.setUserNo(3);
		postRepository.setNewPost(newPost);
	}

	@Override
	public void setEditPost(Post editPost) {
		postRepository.setEditPost(editPost);
	}

	@Override
	public void setDeletePost(int postNo) {
		postRepository.setDeletePost(postNo);
	}

}
