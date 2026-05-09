<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoPostFound</title>
</head>
<body>
	<h3>NoPostFound 예외 발생</h3>
	존재하지 않는 게시글 번호: ${invalidPostNo}
	<br>
	<c:url value="/post/search" var="postsURL"/>
	<a href="${postsURL}">게시글 목록</a>
</body>
</html>