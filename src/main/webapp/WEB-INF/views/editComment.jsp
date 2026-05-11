<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>
</head>
<body>
	<c:url value="/post/${postNo}/comment/${editComment.commentNo}" var="editCommentURL"/>
	<form:form modelAttribute="editComment" action="${editCommentURL}" method="PUT">
		<h4>댓글 수정하기</h4>
		<form:textarea path="commentContent"/>
		<button>댓글 등록</button>
	</form:form>
</body>
</html>