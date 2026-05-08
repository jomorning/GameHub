<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 정보 수정</title>
</head>
<body>
	<c:url value="/game/search" var="gamesURL"/>
	<a href="${gamesURL}">게임 목록</a>
	<c:url value="/game/${editGame.gameNo}" var="editGameURL"/>
	<form:form modelAttribute="editGame" action="${editGameURL}" method="PUT">
		<h3>게임 정보 수정</h3>
		<p>변경할 게임명: <form:input path="gameName"/><br>
		<p>변경할 장르: <form:input path="genre"/><br>
		<p>변경할 연령 제한: <form:input type="number" path="gameAgeRating"/><br>
		<p>변경할 개발사: <form:textarea path="gameDescription" placeholder="내용을 입력하세요."/><br>
		<p>변경할 개발사: <form:input path="gameDeveloper"/><br>
		<p>변경할 배급사: <form:input path="gamePublisher"/><br>
		<p>변경할 출시일: <form:input type="date" path="gameReleaseDate"/>
		<br>
		<button>게임 정보 수정</button>
	</form:form>
</body>
</html>