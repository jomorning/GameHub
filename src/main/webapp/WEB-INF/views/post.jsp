<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공략 게시글 상세 정보</title>
</head>
<body>
	<c:url value="/post/search" var="postsURL"/>
	<a href="${postsURL}">공략 게시글 목록</a>
	<br>
	<h3>${postByNo.postTitle}</h3>
	<h4>#${postByNo.gameName}</h4>
	<hr>
	게시글 등록: ${postByNo.postCreatedAt}
	<br>
	게시글 수정: ${postByNo.postUpdatedAt}
	<br>
	조회수: ${postByNo.viewCount}
	<hr>
	${postByNo.postContent}
	<hr>
	<c:url value="/post/${postByNo.postNo}/edit" var="editPostURL"/>
	<a href="${editPostURL}">게시글 수정</a>
	
	<c:url value="/post/${postByNo.postNo}" var="deletePostURL"/>
	<form:form action="${deletePostURL}" method="DELETE">
		<button>게시글 삭제</button>
	</form:form>
	
	<hr>
	<hr>
	
	<c:forEach var="comments" items="${commentsByPost}">
		<h5>
		${comments.userId}<br>
		${comments.commentContent}<br>
		생성: ${comments.commentCreatedAt}<br>
		수정: ${comments.commentUpdatedAt}
		
		<br>
		[DEVELOPER] commentNo: ${comments.commentNo}
		</h5>
		
		<c:url value="/post/${postByNo.postNo}/comment/${comments.commentNo}/edit" var="editCommentURL"/>
		<a href="${editCommentURL}">댓글 수정</a>
		
		<c:url value="/post/${postByNo.postNo}/comment/${comments.commentNo}" var="deleteCommentURL"/>
		<form:form action="${deleteCommentURL}" method="DELETE">
			<button>댓글 삭제</button>
		</form:form>
		
	</c:forEach>
	
	<c:url value="/post/${postByNo.postNo}/comment" var="newCommentURL"/>
	<form:form modelAttribute="newComment" action="${newCommentURL}">
		<h4>댓글 등록하기</h4>
		<form:textarea path="commentContent"/>
		<button>댓글 등록</button>
		
		
	</form:form>
	
</body>
</html>