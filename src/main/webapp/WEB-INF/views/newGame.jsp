<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 등록</title>
</head>
<body>
	<a href="<c:url value='/main'/>">메인으로 돌아가기</a>
	
	<c:url value="/game" var="newGameURL"/>
	<form:form modelAttribute="newGame" action="${newGameURL}" enctype="multipart/form-data">
		<h3>게임 등록</h3>
		<p>게임명: <form:input path="gameName"/><br>
		<p>장르: <form:input path="genre"/><br>
		<p>연령 제한: <form:input type="number" path="gameAgeRating"/><br>
		<p>게임 설명: <form:textarea path="gameDescription" placeholder="내용을 입력하세요."/><br>
		<p>개발사: <form:input path="gameDeveloper"/><br>
		<p>배급사: <form:input path="gamePublisher"/><br>
		<p>출시일: <form:input type="date" path="gameReleaseDate"/>
		<p>대표 이미지: <form:input type="file" path="savedFile"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<br>
		<button>게임 등록</button>
	</form:form>
</body>
</html>