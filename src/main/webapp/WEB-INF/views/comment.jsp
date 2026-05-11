<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 번호 조회</title>
</head>
<body>
	댓글 번호 : ${commentByNo.commentNo}<br>
	작성자 번호 : ${commentByNo.userNo}<br>
	게시글 번호 : ${commentByNo.postNo}<br>
	댓글 내용 : ${commentByNo.commentContent}<br>
	댓글 생성T : ${commentByNo.commentCreatedAt}<br>
	댓글 수정T : ${commentByNo.commentUpdatedAt}
</body>
</html>