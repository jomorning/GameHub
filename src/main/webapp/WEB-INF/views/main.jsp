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
	<a href="${usersURL}">전체 사용자 목록</a>
	
	<c:url value="/user/new" var="newUserURL"/>
	<a href="${newUserURL}">회원 가입</a>
</body>
</html>