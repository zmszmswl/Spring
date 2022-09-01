<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html>
<html>
<head>
<style>
body {
  color: #666;
  font: 14px/24px "Open Sans", "HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", Sans-Serif;
}
table {
  border-collapse: separate;
  border-spacing: 0;
  width: 100%;
}
th,
td {
  padding: 6px 15px;
}
th {
  background: #42444e;
  color: #fff;
  text-align: left;
}
tr:first-child th:first-child {
  border-top-left-radius: 6px;
}
tr:first-child th:last-child {
  border-top-right-radius: 6px;
}
td {
  border-right: 1px solid #c6c9cc;
  border-bottom: 1px solid #c6c9cc;
}
td:first-child {
  border-left: 1px solid #c6c9cc;
}
tr:nth-child(even) td {
  background: #eaeaed;
}
tr:last-child td:first-child {
  border-bottom-left-radius: 6px;
}
tr:last-child td:last-child {
  border-bottom-right-radius: 6px;
}
</style>
<meta charset="UTF-8">
<title>맴버 목록</title>
</head>
<body>
<div align="center"><h1>맴버 목록</h1></div>
<table border="1" id="list">
	<thead>
	 <tr>
		<th width="70">아이디</th>
		<th width="130">비밀번호</th>
		<th width="200">이름</th>
		<th width="70">권한</th>
	 </tr>
	</thead>
	<tbody id="tbody">
	<c:choose>
		<c:when test="${not empty members }">
			<c:forEach items = "${members }" var="m">
			<tr>
				<td>${m.memberId } </td>
				<td> ${m.memberPassword } </td>
				<td> ${m.memberName }</td>
				<td> ${m.memberAuthor }</td> 
			</tr>	
			</c:forEach>
		</c:when>
		<c:otherwise>
					<tr>
						<td colspan="6" align="center">
							목록이 존재하지 않습니다.
						</td>
					</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
	<br>
	<div align="center">
		<button type="button" onclick="location.href='memberForm.do'">Member 등록</button>
		<button type="button" onclick="location.href='home.do'">홈으로</button>
	</div>

</body>
</html>