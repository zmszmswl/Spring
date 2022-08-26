<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>

</head>
<body>
<div align="center">
<h1>게시글 단건조회</h1>
<table border="1">
				<tr>
						<th width="150">작성자</th>
							<td width="200">
								<input type="text" id="noticeWriter" name="noticeWriter" value="${n.noticeWriter}">  <!-- name은 vo객체이름과 똑같이! id= 자바스크립트, neme=자바 -->
							</td>
						<th width="150">작성일자</th>
							<td width="200">
								<input type="date" id="noticeDate" name="noticeDate" value="${n.noticeDate }">
							</td>
						</tr>
						<tr>
						<th>제목</th>
							<td colspan="3">
								<input type="text" id="noticeTitle" name="noticeTitle" value="${n.noticeTitle }"size="84"> 
							</td>
						</tr>
						<tr>
						<th>내용</th>
							<td colspan="3">
								<textarea rows="10" cols="80" id="noticeSubject" name="noticeSubject"> ${n.noticeSubject }</textarea>
	 						</td>
 						</tr>
						<tr>
						<th>첨부파일</th>
							<td colspan="3">
								<input type="file" id="file" name="file">
							</td>
						</tr>
					</table><br>
	
	<button type="button" onclick="location.href='noticeSelectList.do'">NOTICE 목록 바로가기</button>
</div>	

</body>
</html>