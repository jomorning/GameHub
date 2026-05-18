<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>
</head>
<body>
	<a href="<c:url value='/'/>">메인으로 돌아가기</a>
	
	<c:url value="/user/search" var="usersURL"/>
	
	<form:form modelAttribute="userSearchDTO" method="GET" action="${usersURL}">
		<h3>사용자 정보 검색</h3>
			<label for="detail">상세정보 검색</label>
			<form:radiobutton path="searchMode" id="detail" value="detail"/><br>
			ID 검색: <form:input path="userId"/><br>
			이름 검색: <form:input path="userName"/><br>
			이메일 검색: <form:input path="userEmail"/><br>
		
		<h3>조건 검색</h3>
			<label for="condition">조건별 조회</label>
			<form:radiobutton path="searchMode" id="condition" value="condition"/><br>
			<label for="searchSelectAdmin">관리자 권한 검색</label>
			<form:radiobutton path="userRole" id="searchSelectAdmin" value="ROLE_ADMIN"/>
			<label for="searchSelectUser">사용자 권한 검색</label>
			<form:radiobutton path="userRole" id="searchSelectUser" value="ROLE_USER"/><br>
			최소 나이 검색: <form:input type="number" path="minUserAge"/>
			최대 나이 검색: <form:input type="number" path="maxUserAge"/><br>
			사용자생성시작T: <form:input type="datetime-local" path="startCreatedTime"/>
			사용자생성종료T: <form:input type="datetime-local" path="endCreatedTime"/>
			<br>
		<button>조회</button>
		<a href="${usersURL}">초기화</a>
	</form:form>

	<c:forEach var="users" items="${users}">
		<p>사용자 번호: ${users.userNo}
		<p>사용자 ID: ${users.userId}
		<p>사용자 이름: ${users.userName}
		<p>사용자 권한: ${users.userRole}<br>
		
		<c:url value="/user/${users.userNo}" var="userURL"/>
		<a href="${userURL}">상세 정보</a>
		<hr>
	</c:forEach>
	
	<c:forEach var="page" begin="1" end="${totalPages}">
		<a href="<c:url value='/user/search?pageNum=${page}'/>">${page}</a>
	</c:forEach>

</body>
</html>