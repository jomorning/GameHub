package com.gameHub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Game;
import com.gameHub.domain.Post;
import com.gameHub.domain.PostSearchDTO;
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
	public List<Post> searchPosts(PostSearchDTO postSearchDTO) {

		List<Post> postsBySearch = new ArrayList<>();

		String keyword = postSearchDTO.getKeyword();
		System.out.println("keyword: " + keyword);

		if (keyword == null || keyword.isEmpty()) {
			List<Post> allPosts = postRepository.getAllPosts();
			postsBySearch.addAll(allPosts);
			return postsBySearch;
		}

		// 검색 키워드의 userName 을 기준으로 UserRepository 의 userNo 변환
		User postUser = userRepository.getUserByName(postSearchDTO.getKeyword());
		if (postUser != null) {
			int postUserNo = postUser.getUserNo();
			System.out.println("postUserNo: " + postUserNo);
			if (!postRepository.getPostsByUserNo(postUserNo).isEmpty()) {
				postsBySearch.addAll(postRepository.getPostsByUserNo(postUserNo));
			}
		}

		// 검색 키워드의 gameName 을 기준으로 GameRepository 의 gameNo 변환
		Game postGame = gameRepository.getGameByName(postSearchDTO.getKeyword());
		if (postGame != null) {
			int postGameNo = postGame.getGameNo();
			System.out.println("postGameNo: " + postGameNo);
			if (!postRepository.getPostsByGameNo(postGameNo).isEmpty()) {
				postsBySearch.addAll(postRepository.getPostsByGameNo(postGameNo));
			}
		}

		if (!postRepository.getPostsByTitle(postSearchDTO.getKeyword()).isEmpty()) {
			postsBySearch.addAll(postRepository.getPostsByTitle(postSearchDTO.getKeyword()));
			System.out.println("제목검색결과: " + postRepository.getPostsByTitle(postSearchDTO.getKeyword()));
		}

		if (!postRepository.getPostsByContent(postSearchDTO.getKeyword()).isEmpty()) {
			postsBySearch.addAll(postRepository.getPostsByContent(postSearchDTO.getKeyword()));
			System.out.println("본문검색결과: " + postRepository.getPostsByContent(postSearchDTO.getKeyword()));
		}

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
		// 임시 게시글 등록자 UserNo. 999
		newPost.setUserNo(999);
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
