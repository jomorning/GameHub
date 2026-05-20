package com.gameHub.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gameHub.domain.Comment;
import com.gameHub.domain.CommentResponseDTO;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
	
	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Comment getCommentByNo(int commentNo) {
		String SQL = "SELECT * FROM comment WHERE comment_no = ?";
		List<Comment> commentByNoTemp = template.query(SQL, new CommentRowMapper(), commentNo);
		
		if (commentByNoTemp.isEmpty()) {
			return null;
		}
		
		Comment commentByNo = commentByNoTemp.get(0);
		return commentByNo;
	}

	@Override
	public CommentResponseDTO getLatestCommentByPost(int postNo) {
		String SQL_s = "SELECT LAST_INSERT_ID FROM comment";
		int latestCommentNo = template.queryForObject(SQL_s, Integer.class);
		return latestCommentNo
	}

	@Override
	public List<CommentResponseDTO> getCommentsByPost(int postNo) {
		String SQL = "SELECT comment.comment_no, app_user.user_id, comment.comment_content, comment.comment_created_at, comment.comment_updated_at FROM comment JOIN post ON comment.post_no = post.post_no JOIN app_user ON comment.user_no = app_user.user_no WHERE post.post_no = ?";
		List<CommentResponseDTO> commentsByPost = template.query(SQL, new JoinedCommentsRowMapper(), postNo);
		return commentsByPost;
	}

	@Override
	public int getCommentCountByPost(int postNo) {
		String SQL = "SELECT COUNT(*) FROM comment WHERE post_no = ?";
		int commentCountByPost = template.queryForObject(SQL, Integer.class, postNo); 
		return commentCountByPost;
	}

	@Override
	public void setNewComment(Comment newComment) {
		String SQL = "INSERT INTO comment(user_no, post_no, comment_content) VALUES(?,?,?)";
		template.update(SQL, newComment.getUserNo(), newComment.getPostNo(), newComment.getCommentContent());
	}

	@Override
	public void setEditComment(Comment editComment, int commentNo) {
		String SQL = "UPDATE comment SET comment_content = ? WHERE comment_no = ?";
		template.update(SQL, editComment.getCommentContent(), commentNo);
	}

	@Override
	public int setDeleteComment(int commentNo) {
		String SQL = "DELETE FROM comment WHERE comment_no = ?";
		template.update(SQL, commentNo);
	}

}
