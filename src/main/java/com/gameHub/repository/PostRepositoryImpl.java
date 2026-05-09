package com.gameHub.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gameHub.domain.Post;
import com.gameHub.domain.PostSearchDTO;

@Repository
public class PostRepositoryImpl implements PostRepository {

	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Post> searchPosts(PostSearchDTO postSearchDTO) {

		return null;
	}

	@Override
	public Post getPostByNo(int postNo) {
		String SQL = "SELECT * FROM post WHERE post_no = ?";
		List<Post> postByNoTemp = template.query(SQL, new PostRowMapper(), postNo);
		
		if (postByNoTemp.isEmpty()) {
			return null;
		}
		
		Post postByNo = postByNoTemp.get(0);
		return postByNo;
	}

	@Override
	public void setNewPost(Post newPost) {
		String SQL = "INSERT INTO post(user_no, game_no, post_type, post_title, post_content) VALUES(?,?,?,?,?)";
		template.update(SQL, newPost.getUserNo(), newPost.getGameNo(), newPost.getPostType(), newPost.getPostTitle(), newPost.getPostContent());
	}

	@Override
	public void setEditPost(Post editPost) {
		String SQL = "UPDATE post SET game_no = ?, post_title = ?, post_content = ?";
		template.update(SQL, editPost.getGameNo(), editPost.getPostTitle(), editPost.getPostContent());
	}

	@Override
	public void setDeletePost(int postNo) {
		String SQL = "DELETE FROM post WHERE post_no = ?";
		template.update(SQL, postNo);
	}

}
