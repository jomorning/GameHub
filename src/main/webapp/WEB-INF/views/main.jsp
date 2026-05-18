<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<c:url value="/login" var="loginURL"/>
	<a href="${loginURL}">로그인</a>
	<br>
		
	<c:url value="/user/new" var="newUserURL"/>
	<a href="${newUserURL}">회원 가입</a>
	<br>
	
	<c:url value="/game/search" var="gamesURL"/>
	<a href="${gamesURL}">게임 목록</a>
	<br>
	
	<c:url value="/post/search" var="postsURL"/>
	<a href="${postsURL}">게시글 목록</a>
	<br>
	
	<c:url value="/post/new" var="newPostURL"/>
	<a href="${newPostURL}">게시글 등록</a>
	<br>
	
	<c:url value="/user/search" var="usersURL"/>
	<a href="${usersURL}">[ADMIN] 사용자 목록</a>
	<br>
	
	<c:url value="/game/new" var="newGameURL"/>
	<a href="${newGameURL}">[ADMIN] 게임 등록</a>
	<br>
	
	<c:url value="/logout" var="logoutURL"/>
	<form:form action="${logoutURL}" method="post">
	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit">로그아웃</button>
	</form:form>
	
</body>
</html>