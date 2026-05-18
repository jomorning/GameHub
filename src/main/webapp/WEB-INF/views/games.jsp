<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 목록</title>
</head>
<body>

	<a href="<c:url value='/'/>">메인으로 돌아가기</a>
	
	<c:url value="/game/search" var="searchGameURL"/>
	
	<form:form modelAttribute="game" method="GET" action="${searchGameURL}">
		<h3>게임 정보 검색</h3>
			게임명: <form:input path="gameName"/><br>
			장르: <form:input path="genre"/><br>
			개발사: <form:input path="gameDeveloper"/><br>
			배급사: <form:input path="gamePublisher"/><br>
		<button>조회</button>
		<a href="${searchGameURL}">초기화</a>
	</form:form>

	<c:forEach var="games" items="${games}">
		<p>게임명: ${games.gameName}
		<p>장르: ${games.genre}
		<p>개발사: ${games.gameDeveloper}
		<p>배급사: ${games.gamePublisher}<br>
		
		<c:url value="/game/${games.gameNo}" var="gameURL"/>
		<a href="${gameURL}">상세 정보</a>
		
		<c:url value="/post/search?keyword=${games.gameName}" var="guidesURL"/>
		<a href="${guidesURL}">해당 게임으로 게시글 검색</a>
		
		<hr>
	</c:forEach>
	
	<c:forEach var="page" begin="1" end="${totalPages}">
		<a href="<c:url value='/game/search?pageNum=${page}'/>">${page}</a>
	</c:forEach>

</body>
</html>