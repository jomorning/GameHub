<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 상세 정보</title>
</head>
<body>
	<c:url value="/game/search" var="gamesURL"/>
	<a href="${gamesURL}">게임 목록</a>
	<br>
	<h3>게임 상세 정보</h3>
	<img src="<c:url value='/upload/game/${gameByNo.savedFileName}'/>" style="width: 20%">
	<p>게임명: ${gameByNo.gameName}
	<p>장르: ${gameByNo.genre}
	<p>연령 제한: ${gameByNo.gameAgeRating}
	<p>게임 설명: ${gameByNo.gameDescription}
	<p>개발사: ${gameByNo.gameDeveloper}
	<p>배급사: ${gameByNo.gamePublisher}
	<p>출시일: ${gameByNo.gameReleaseDate}
	<br>
	<c:url value="/game/${gameByNo.gameNo}/edit" var="editGameURL"/>
	<a href="${editGameURL}">[ADMIN] 게임 정보 수정</a>
	
	<c:url value="/game/${gameByNo.gameNo}" var="deleteGameURL"/>
	<form:form action="${deleteGameURL}" method="DELETE">
		<button>[ADMIN] 게임 삭제</button>
	</form:form>
	
</body>
</html>