package com.gameHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Post;
import com.gameHub.domain.PostSearchDTO;
import com.gameHub.exception.NoPostFoundException;
import com.gameHub.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	@Override
	public List<Post> searchPosts(PostSearchDTO postSearchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostByNo(int postNo) {
		Post postByNo = postRepository.getPostByNo(postNo);

		if (postByNo == null) {
			throw new NoPostFoundException(postNo);
		}

		return postByNo;
	}

	@Override
	public void setNewPost(Post newPost) {
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
