<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<c:url value="/user/search" var="usersURL"/>
	<a href="${usersURL}">사용자 목록</a>
	<c:url value="/user/${editUser.userNo}" var="editUserURL"/>
	<form:form modelAttribute="editUser" action="${editUserURL}" method="PUT" enctype="multipart/form-data">
		<h3>회원 정보 수정</h3>
		<p>사용자 관리번호: <form:input type="number" path="userNo" readonly="true"/>
		<p>변경할 아이디: <form:input path="userId"/>
		<p>변경할 비밀번호: <form:password path="userPw"/>
		<p>변경할 이름: <form:input path="userName"/>
		<p>변경할 별명: <form:input path="userNickname"/>
		<p>변경할 생년월일: <form:input type="date" path="userBirthDate"/>
		<p>변경할 이메일: <form:input type="email" path="userEmail"/>
		<p>프로필 이미지: <form:input type="file" path="savedFile"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<br>
		<button>회원 정보 수정</button>
		
	</form:form>
</body>
</html>