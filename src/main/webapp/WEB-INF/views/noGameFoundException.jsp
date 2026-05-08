<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoGameFound</title>
</head>
<body>
	<h3>NoGameFound 예외 발생</h3>
	존재하지 않는 게임 번호: ${invalidGameNo}
	<br>
	<c:url value="/game/search" var="gamesURL"/>
	<a href="${gamesURL}">게임 목록</a>
</body>
</html>