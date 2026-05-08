<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<c:url value="/user/search" var="usersURL"/>
	<a href="${usersURL}">[ADMIN] 전체 사용자 목록</a>
	<br>
	<c:url value="/user/new" var="newUserURL"/>
	<a href="${newUserURL}">회원 가입</a>
	<br>
	<c:url value="/game/search" var="gamesURL"/>
	<a href="${gamesURL}">게임 목록</a>
	<br>
	<c:url value="/game/new" var="newGameURL"/>
	<a href="${newGameURL}">[ADMIN] 게임 등록</a>
	<br>
</body>
</html>