<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>${postByNo.postTitle}</title>
</head>
<body>
	<c:url value="/post/search" var="postsURL"/>
	<a href="${postsURL}">게시글 목록</a>
	<br>
	<h3>${postByNo.postType}</h3>
	모집 상태: ${recruitByPost.recruitStatus}
	<h2>${postByNo.postTitle}</h2>
	<h4>#${postByNo.gameName}</h4>
	<hr>
	게시글 등록: ${postByNo.postCreatedAt}
	<br>
	게시글 수정: ${postByNo.postUpdatedAt}
	<br>
	댓글수: <span id="commentCount">${postByNo.commentCount}</span> | 좋아요: <span id="likeCount">${postByNo.likeCount}</span> | 조회수: <span id="viewCount">${postByNo.viewCount}</span>
	<hr>
	${postByNo.postContent}
	<hr>
	
	<c:url value="/post/${postByNo.postNo}/like" var="newLikeURL"/>
	<button type="button" id="likeButton">좋아요</button>

	<c:url value="/post/${postByNo.postNo}/like" var="deleteLikeURL"/>
	<button type="button" id="likeDropButton">좋아요 취소</button>
	
	<c:url value="/post/${postByNo.postNo}/apply" var="newApplyURL"/>
	<form:form action="${newApplyURL}">
		<button type="button" id="applyButton">참가하기</button>
	</form:form>
	
	<c:url value="/post/${postByNo.postNo}/apply/${applyByNo.userNo}" var="deleteApplyURL"/>
	<form:form action="${deleteApplyURL}" method="DELETE">
		<button type="button" id="applyDropButton">참가 취소</button>
	</form:form>
	
	현재 인원: ${recruitByPost.recruitMaxMember}
	현재 인원: <span id="recruitMaxMember"></span>
	<br>
	모집 인원: ${recruitByPost.recruitCurrentMember}
	모집 인원: <span id="recruitCurrentMember"></span>
	<hr>
	
	
	${applyAvailable}
	
	참가:
	<c:forEach var="appliedUsers" items="${appliesByRecruit}">
		${appliedUsers.userId}
	</c:forEach>
	
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
		</h5>
		
		<c:url value="/post/${postByNo.postNo}/comment/${comments.commentNo}/edit" var="editCommentURL"/>
		<a href="${editCommentURL}">댓글 수정</a>
		
		<c:url value="/post/${postByNo.postNo}/comment/${comments.commentNo}" var="deleteCommentURL"/>
		<form:form action="${deleteCommentURL}" method="DELETE">
			<button>댓글 삭제</button>
		</form:form>
		
	</c:forEach>
	
	<div id="commentArea">
	
	</div>
	
		<h4>댓글 등록하기</h4>
		<input type="text" id="newCommentContent"/>
		<button type="button" id="newCommentButton">댓글 등록</button>
	
	<c:url value="/post/${postByNo.postNo}/comment/count?${_csrf.parameterName}=${_csrf.token}" var="commentCountURL"/>
	<c:url value="/post/${postByNo.postNo}/like?${_csrf.parameterName}=${_csrf.token}" var="newLikeURL"/>
	<c:url value="/post/${postByNo.postNo}/like?${_csrf.parameterName}=${_csrf.token}" var="deleteLikeURL"/>
	<c:url value="/post/${postByNo.postNo}/comment?${_csrf.parameterName}=${_csrf.token}" var="newCommentURL"/>
	<script>
	const commentCount = document.getElementById("commentCount");
	const likeCount = document.getElementById("likeCount");
	const viewCount = document.getElementById("viewCount");
	const recruitMaxMember = document.getElementById("recruitMaxMember");
	const recruitCurrentMember = document.getElementById("recruitCurrentMember");
	const likeButton = document.getElementById("likeButton");
	const likeDropButton = document.getElementById("likeDropButton");
	const applyButton = document.getElementById("applyButton");
	const applyDropButton = document.getElementById("applyDropButton");
	const newCommentContent = document.getElementById("newCommentContent");
	const newCommentButton = document.getElementById("newCommentButton");
	const commentArea = document.getElementById("commentArea");
	
	likeButton.addEventListener("click", function() {
		$.ajax({
			url: "${newLikeURL}",
			type: "POST",
			success: function(likeCountByPost) {
				likeCount.innerHTML = likeCountByPost;
			}
		});
	});
	
	likeDropButton.addEventListener("click", function() {
		$.ajax({
			url: "${deleteLikeURL}",
			type: "DELETE",
			success: function(likeCountByPost) {
				likeCount.innerHTML = likeCountByPost;
			}
		});
	});
	
	newCommentButton.addEventListener("click", function() {
		let newComment = { "commentContent": newCommentContent.value }
		$.ajax({
			url: "${newCommentURL}",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(newComment),
			success: function(latestComment) {
				
				}
				
				
				
			}
		});			
	});
	</script>
</body>
</html>