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
	<c:forEach items="${notices }" var="n">
		${n.noticeId } : ${n.noticeWriter} : ${n.noticeTitle} <!-- vo로 받았으니 vo객체와 이름이 같게 써줘야함 -->
	</c:forEach>
</body>
</html>