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
<h1>Member Modify Page</h1>
<form action="/memb/update" method="post">
	id : <input type="text" name="id" value="${ses.id }" readonly="readonly"> <br>
	pwd : <input type="password" name="pwd" value="${ses.pwd }" > <br>
	email : <input type="text" name="email" value="${ses.email }" > <br>
	age : <input type="number" name="age" value="${ses.age }" > <br>
	phone : <input type="text" name="phone" value="${ses.phone }" > <br>
	regdate : <input type="text" name="regdate" value="${ses.regdate }" disabled="disabled" > <br>
	lastLogin : <input type="text" name="lastlogin" value="${ses.lastlogin }" disabled="disabled" > <br>
	<button type="submit">Modify</button>
</form>
<a href="/memb/delete"> <button type="button">회원탈퇴</button> </a>
<a href="../index.jsp"> <button type="button">index</button> </a>

<script type="text/javascript">
const msg_update = `<c:out value="${msg_update}"></c:out>`;
console.log(msg_update);
if(msg_update ==="fail"){
	alert("회원정보 수정이 실패했습니다.");
}


</script>

</body>
</html>