<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board detail Page</h1>

	<table border="1">
		<tr>
			<th>bno</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>title</th>
			<td>${bvo.title}</td>
		</tr>
		<tr>
			<th>writer</th>
			<td>${bvo.writer}</td>
		</tr>
		<tr>
			<th>regdate</th>
			<td>${bvo.regdate}</td>
		</tr>
		<tr>
			<th>moddate</th>
			<td>${bvo.moddate}</td>
		</tr>
		<tr>
			<th>content</th>
			<td>${bvo.content}</td>
		</tr>
	</table>
	
	<a href="/brd/list"><button>list</button></a>
	
	<c:if test="${bvo.writer eq ses.id }">
	<a href="brd/modify?bno=${bvo.bno }">modify</a>
	<a href="brd/remove?bno=${bvo.bno }">remove</a>
	</c:if>
	<script type="text/javascript">
	const brd_modify = `<c:out value="${brd_modify }"></c:out>`;
	console.log(brd_modify);
	if(brd_modify =="fail"){
		alert("게시물 수정을 실패하였습니다. 다시 시도해주세요.");
	}
	
	
	</script>
</body>
</html>