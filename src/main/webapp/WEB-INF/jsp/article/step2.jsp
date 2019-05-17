<!doctype html>
<!-- 
p.277 [리스트 11.9] 회원가입 화면
 -->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 등록</title>
</head>
<body>
	<h2>글 정보 입력</h2>
	<form action="./app/article/step3" method="post">
			<p>
			제목:<br> <input type="text" name="title" value="${article.title }">
		</p>
		<p>
			내용:<br>  <textarea rows="5" cols="30" name="content" value="${article.content }"></textarea>
		</p>

		<button type="submit">글 등록 완료</button>
	</form>
</body>
</html>