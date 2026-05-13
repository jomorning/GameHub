<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<a href="<c:url value='/'/>">메인으로 돌아가기</a>
	
	<c:url value="/post" var="newPostURL"/>
	<form:form modelAttribute="postForm" action="${newPostURL}">
		<h3>게시글 작성</h3>
		<p>게시글 선택:
		<select name="postType">
			<option value="GUIDE">게임 공략</option>
    		<option value="RECRUIT">파티원 모집</option>
    		<option value="NOTICE">공지 등록</option>
		</select>
		<p>게임명: <form:input path="gameName"/><br>
		<p>제목: <form:input path="postTitle"/><br>
		<p>본문: <form:textarea path="postContent"/><br>
		
		<div id="recruitField">
		<p>모집 포지션: <form:input path="recruitPosition"/><br>
		<p>모집 인원: <form:input type="number" path="recruitMaxMember"/><br>
		</div>
		<br>
		<button>게시글 등록</button>
	</form:form>
</body>
</html>