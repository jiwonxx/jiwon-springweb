<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>편지</title>
</head>
<body>
	<h2>글 보기</h2>
	<p>
		<a href="./app/letter/listOfReceiver">받은 편지 목록</a>
	</p>
	<hr />
	<p>
		<span>${letter.receiverId }</span> | <span style="font-weight: bold;">${letter.title }</span>
	</p>
	<p>
		<span>${letter.cdate }</span> | <span>${letter.name }</span>
	</p>
	<hr />
	<p>${letter.contentHtml }</p>
	<hr />
</body>
</html>