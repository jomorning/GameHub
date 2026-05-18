<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<a href="<c:url value='/'/>">메인으로 돌아가기</a>
	
	<c:url value="/login" var="loginURL"/>
	<form action="${loginURL}" method="POST">
		<p>아이디: <input type="text" name="userId" placeholder="아이디 입력"/>
		<p>비밀번호: <input type="password" name="userPw" placeholder="비밀번호 입력"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<h3>${failureReason}</h3>
		<button>로그인</button>
	</form>
</body>
</html>