<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoCommentFound</title>
</head>
<body>
	<h3>NoCommentFound 예외 발생</h3>
	존재하지 않는 댓글 번호: ${invalidCommentNo}
	<br>
	<c:url value="/post/search" var="postsURL"/>
	<a href="${postsURL}">게시글 목록</a>
</body>
</html>