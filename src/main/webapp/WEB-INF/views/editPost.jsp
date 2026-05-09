<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공략 게시글 수정</title>
</head>
<body>
	<c:url value="/post/search" var="postsURL"/>
	<a href="${postsURL}">공략 게시글 목록</a>
	<c:url value="/post/${editPost.postNo}" var="editPostURL"/>
	<form:form modelAttribute="editPost" action="${editPostURL}" method="PUT">
		<h3>게시글 수정</h3>
		<p>제목 수정: <form:input path="postTitle"/><br>
		<p>본문 수정: <form:textarea path="postContent"/><br>
		<br>
		<button>게시글 수정</button>
	</form:form>
</body>
</html>