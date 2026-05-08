<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<a href="<c:url value='/'/>">메인으로 돌아가기</a>
	
	<c:url value="/user" var="newUserURL"/>
	<form:form modelAttribute="newUser" action="${newUserURL}">
		<h3>회원 가입</h3>
		<p>사용할 아이디: <form:input path="userId"/>
		<p>비밀번호: <form:password path="userPw"/>
		<p>이름: <form:input path="userName"/>
		<p>사용할 별명: <form:input path="userNickname"/>
		<p>생년월일: <form:input type="date" path="userBirthDate"/>
		<p>이메일: <form:input type="email" path="userEmail"/>
		<br>
		<button>회원 가입</button>
	</form:form>
</body>
</html>