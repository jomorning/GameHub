<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<a href="<c:url value='/main'/>">메인으로 돌아가기</a>
	
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
		
		<div contenteditable="true" id="editor" style="border: 1px solid"></div>
		<input type="file" id="imgInput"/>
		<button type="button" id="uploadBtn">이미지 업로드</button>
		
		<div id="recruitField">
		<p>모집 포지션: <form:input path="recruitPosition"/><br>
		<p>모집 인원: <form:input type="number" path="recruitMaxMember"/><br>
		</div>
		<br>
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
		<button id="submitBtn">게시글 등록</button>
	</form:form>
	<c:url value="/upload/post/" var="uploadURL"/>
	
	<script>
		const imageInput = document.getElementById("imgInput");
		const uploadBtn = document.getElementById("uploadBtn");
		const submitBtn = document.getElementById("submitBtn");
		const textarea = document.getElementById("postContent");
		const editor = document.getElementById("editor");
		const postForm = document.getElementById("postForm");
		
		uploadBtn.addEventListener("click", function() {
			let file = imgInput.files[0];
			let formData = new FormData();
			formData.append("file", file);
			uploadImage(formData);		
		});
		
		function uploadImage(formData) {
			$.ajax({
				// POST, PUT 요청 form 태그 내에 csrf 작성
				// 멀티파트에서는 쿼리스트링 형식으로 작성 (URL)
				url: "<c:url value='/upload?${_csrf.parameterName}=${_csrf.token}'/>",
				type: "POST",
				data: formData,
				processData: false,
				contentType: false,
				success: function(data) {
					let imageName = data;
					insertImage(imageName);
				},
				error: function() {
					alert("파일 업로드 실패");
				}
			});
		}
		
		function insertImage(imageName) {
			const imgTag = "<img src='${uploadURL}" + imageName + "'/><br>"
			editor.innerHTML = editor.innerHTML + imgTag;
			addInputImage(imageName);	
		}
		
		function addInputImage(imageName) {
			const inputImageTag = document.createElement('input');
			inputImageTag.type= "hidden"
			inputImageTag.name = "uploadedFileNameList";
			inputImageTag.value = imageName;
			postForm.appendChild(inputImageTag);
		}
		
		postForm.addEventListener("submit", function() {
			textarea.value = editor.innerHTML;
			postForm.submit();
		});
		
	</script>
</body>
</html>