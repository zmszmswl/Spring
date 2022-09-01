<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>맴버등록</title>
</head>
<body>
	<div align="center">
		<div><h1>맴버 등록</h1></div>
		<div>
			<form id="frm" action="memberInsert.do" method="post" >
				<div>
					<table border="1">
						<tr>
						<th >아이디</th>
							<td >
								<input type="text" id="memberId" name="memberId"> <!-- name은 vo객체이름과 똑같이! id= 자바스크립트, neme=자바 -->
							</td>
						<th >패스워드</th>
							<td >
								<input type="text" id="memberPassword" name="memberPassword">
							</td>

						<th>이름</th>
							<td>
								<input type="text" id="memberName" name="memberName" >
							</td>
						<td>
							<select id="memberAuthor" name="memberAuthor">
								<option value="USER">USER</option>	
								<option value="ADMIN">ADMIN</option>		
							</select>
							<!-- <input type="hidden" id="memberAuthor" name="memberAuthor" value="USER"> -->
						</td>
						</tr>
						
					</table>
				</div><br>
				<input type="submit" value="등록">&nbsp;
				<input type="reset" value="초기화">&nbsp; 
				<button type="button" onclick="location.href='home.do'">홈으로</button>
			</form>
		</div>
	</div>
</body>
</html>