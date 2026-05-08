<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoUserFound</title>
</head>
<body>
	<h3>NoUserFound 예외 발생</h3>
	존재하지 않는 사용자 번호: ${invalidUserNo}
	<br>
	<c:url value="/user/search" var="usersURL"/>
	<a href="${usersURL}">전체 사용자 목록</a>
</body>
</html>