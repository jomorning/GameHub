<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<a href="<c:url value='/'/>">메인으로 돌아가기</a>
	
	<c:url value="/post/new" var="newPostURL"/>
	<a href="${newPostURL}">게시글 등록</a>
	
	<c:url value="/post/search" var="postsURL"/>
	
	<form action="${postsURL}">
		<h3>게시글 검색</h3>
			키워드 검색: <input type="text" name="keyword"/>
		<button>검색</button>
	</form>
	<hr>
	<c:forEach var="posts" items="${posts}">
		<p>제목: ${posts.postTitle}
		<p>게임: ${posts.gameName}
		<p>${posts.postType} 
		<p>작성자: ${posts.userId}
		<p>댓글 ${posts.commentCount} 개 | 좋아요 ${posts.likeCount} 개 | 조회수 ${posts.viewCount} 개   
		
		<c:url value="/post/${posts.postNo}" var="postURL"/>
		<br>
		<a href="${postURL}">게시글 읽기</a>
		<hr>
	</c:forEach>

</body>
</html>