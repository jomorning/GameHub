<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<c:url value="/post/search" var="postsURL"/>
	<a href="${postsURL}">게시글 목록</a>
	<c:url value="/post/${editPostForm.postNo}" var="editPostURL"/>
	<form:form modelAttribute="editPostForm" action="${editPostURL}" method="PUT">
		<h3>게시글 수정</h3>
		<p>게시글 종류: <form:input path="postType" readonly="true"/><br>
		<p>제목 수정: <form:input path="postTitle"/><br>
		<p>본문 수정: <form:textarea path="postContent"/><br>
		
		<div id="recruitField">
		<p>모집 상태:
		<select name="recruitStatus">
			<option value="OPEN">모집 시작</option>
    		<option value="CLOSED">모집 마감</option>
    		<option value="COMPLETED">모집 종료</option>
    		<option value="CANCELED">모집 취소</option>
		</select>
		<p>모집 포지션: <form:input path="recruitPosition"/><br>
		<p>모집 인원: <form:input type="number" path="recruitMaxMember"/><br>
		</div>
		<br>
		<button>게시글 수정</button>
	</form:form>
</body>
</html>