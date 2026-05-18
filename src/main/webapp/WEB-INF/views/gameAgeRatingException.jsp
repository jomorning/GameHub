<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GameAgeRating</title>
</head>
<body>
	<h3>GameAgeRating 예외 발생</h3>
	연령 제한: ${gameAgeRating} 세
	<br>
	게임명: ${gameName}
	<br>
	해당 게임 커뮤니티에 접근할 수 없습니다.
	<br>
	<c:url value="/game/search" var="gamesURL"/>
	<a href="${gamesURL}">게임 목록</a>
	<br>
	<c:url value="/post/search" var="postsURL"/>
	<a href="${postsURL}">게시글 목록</a>
</body>
</html>