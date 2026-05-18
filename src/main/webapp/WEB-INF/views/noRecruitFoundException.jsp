<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoRecruitFound</title>
</head>
<body>
	<h3>NoRecruitFound 예외 발생</h3>
	존재하지 않는 Recruit 번호: ${invalidRecruitNo}
	
	<p> DB 내부 postNo 는 존재하나, post.postNo 를 참조하는 recruit.post_no 가 존재하지 않을 수 있음.
	<p> DB 내부 해당 post 인스턴스를 삭제해야 함. 
	<br>
	<c:url value="/post/search" var="postsURL"/>
	<a href="${postsURL}">게시글 목록</a>
</body>
</html>