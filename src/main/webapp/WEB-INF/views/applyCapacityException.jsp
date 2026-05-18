<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ApplyCapacity</title>
</head>
<body>
	<h3>ApplyCapacity 예외 발생</h3>
	해당 모집에 빈 자리가 없습니다: 사용자 ID: ${deniedUserId} 는 지원 불가합니다.
	<br>
	<c:url value="/post/${postNo}" var="postsURL"/>
	<a href="${postsURL}">게시글로 돌아가기</a>
</body>
</html>