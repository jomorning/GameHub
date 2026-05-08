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
	<c:url value="/user/search" var="usersURL"/>
	<a href="${usersURL}">전체 사용자 목록</a>
	<br>
	<h3>사용자 상세 정보</h3>
	<p>사용자 번호: ${userByNo.userNo}
	<p>사용자 ID: ${userByNo.userId}
	<p>사용자 PW: ${userByNo.userPw}
	<p>사용자 이름: ${userByNo.userName}
	<p>사용자 별명: ${userByNo.userNickname}
	<p>사용자 생년월일: ${userByNo.userBirthDate}
	<p>사용자 이메일: ${userByNo.userEmail}
	<p>사용자 권한: ${userByNo.userRole}
	<p>사용자 생성T: ${userByNo.userCreatedAt}
	<br>
	<c:url value="/user/${userByNo.userNo}/edit" var="editUserURL"/>
	<a href="${editUserURL}">회원 정보 수정</a>
	
	<c:url value="/user/${userByNo.userNo}" var="deleteUserURL"/>
	<form:form action="${deleteUserURL}" method="DELETE">
		<button>회원 삭제</button>
	</form:form>
	
</body>
</html>