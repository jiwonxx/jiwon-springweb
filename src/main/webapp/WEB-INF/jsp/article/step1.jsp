<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 내용</title>
</head>
<body>
	<table>
			<tr><td>글번호</td><td>${article.articleId }</td></tr>
			<tr><td>학번</td><td>${article.userId }</td></tr>
			<tr><td>제목</td><td>${article.title }</td></tr>
			<tr><td>이름</td><td>${article.name }</td></tr>
			<tr><td>내용</td><td>${article.contentHtml }</td></tr>
			<tr><td>등록일시</td><td>${article.udate }</td></tr>

	</table>
			<form action="./app/main" method="post">
		<button  type="submit">닫기</button>
		</form>
</body>
</head>
</html>