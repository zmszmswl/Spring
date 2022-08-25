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
	<!-- vo객체 만들지않고 MAP 타입을 받아서 표현할때는 테이블 컬럼명을 대문자로 작성해준다!!! LIST MAP으로 만들면 몸체가 JSON객체로 날아와서 만들기쉬움 -->
	<c:forEach items="${notices }" var="N">
	${N.NOTICE_ID } : ${N.NOTICE_WRITER } : ${N.NOTICE_TITLE } <br/>
	</c:forEach>
</body>
</html>