<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board List Page</h1>
	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>writer</th>
			<th>regdate</th>
		</tr>
		<c:forEach items="${list }" var="bvo">
			<tr>
				<td>${bvo.bno }</td>
				<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
				<td>${bvo.writer }</td>
				<td>${bvo.regdate }</td>

			</tr>
		</c:forEach>

	</table>
	<a href="../index.jsp"> <button type="button">index</button> </a>

	<script type="text/javascript">
	const brd_modify = `<c:out value="${brd_modify }"></c:out>`;
	console.log(brd_modify);
	if(brd_modify =="ok"){
		alert("게시물 수정을 완료하였습니다.");
	}
	
	
	</script>
</body>
</html>