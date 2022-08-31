<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판목록</title>
<!--  <style type="text/css">
tr.colored:hover td{
  background-color:#F7FE3E !important;
  color:#303f39 !important;
}
table{
	border-collapse : collapse;
}
</style> -->
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

<script src="resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- vo객체 만들지않고 MAP 타입을 받아서 표현할때는 테이블 컬럼명을 대문자로 작성해준다!!! LIST MAP으로 만들면 몸체가 JSON객체로 날아와서 만들기쉬움 -->
	<div align="center">
		<div><h1>공지사항 목록</h1></div>
		<div>
			<table>
				<tr>
					<td width="70">
						<select id="key" name="key">
							<option value="1">제목</option>		
							<option value="2">내용</option>		
							<option value="3">작성자</option>			
						</select>
					</td>
					<td width="100">
						<input type="text" id="val" name="val">
					</td>
					<td width="100" align="left"></td>
					<td><button type="button" onclick="searchCall()">검색</button></td>
				</tr>
			</table>
		</div><br>

<table border="1" id="list">
	<thead>
	 <tr>
		<th width="70">순번</th>
		<th width="130">작성자</th>
		<th width="200">제목</th>
		<th width="70">조회수</th>
	 </tr>
	</thead>
	<tbody id="tbody">
	<c:choose>
		<c:when test="${not empty notices }">
			<c:forEach items="${notices }" var="N">
			<tr class="colored" onclick="noticeCall(${N.NOTICE_ID})">
				<td>${N.NOTICE_ID } </td>
				<td> ${N.NOTICE_WRITER } </td>
				<td> ${N.NOTICE_TITLE }</td>
				<td> ${N.NOTICE_HIT }</td>
			</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
					<tr>
						<td colspan="6" align="center">
							게시글이 존재하지 않습니다.
						</td>
					</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
</div>	
<div>
<!-- list처럼 form 이 없는 상태에서는 id가 있는 히든폼을 만들어서 post방식으로 보낸다. -->
	<form id="frm" method="post">
		<input type="hidden" id="noticeId" name="noticeId">
	</form>
</div>
<script type="text/javascript">

	function noticeCall(id) {
		frm.noticeId.value=id;
		frm.action="noticeSelect.do";
		frm.submit();		
	}
	
/* 	function searchCall() {
		let key = document.getElementById('key').value;
	    let val = document.getElementById('val').value;
	   // alert(key);
	    $.ajax({
	    	url : "ajaxSearch.do",
	    	type : "post",
	    	data : {"key" : key, "val" : val},
	    	dataType : "json",
	    	success : function(data){
	    		console.log(data);
	    		htmlView(data);
	    	},
	    	error : function(){
	    		alert("실패!!!!!!!!!!!!!!!!!!!!");
	    	}
	    });
	} */
	
	   function searchCall() {
		      //ajax 검색 처리
		      let key = document.getElementById('key').value;
		      let val = document.getElementById('val').value;
		      console.log(key, val); // 값 넘어오나 확인
		      let payMent = {'key' : key, 'val' : val};
		      console.log("payMent = " + payMent); // 값 넘어오나 확인
		      fetch("ajaxSearch.do", {
		         method : 'post',
		         headers : {
		            //'Content-Type' : 'application/x-www-form-urlencoded',
		              'Content-Type' : 'application/json',
		         },
		         // body : "key="+key+"&val="+val
		         body : JSON.stringify(payMent)
		      }).then(response => response.json())
		        .then((data)=> htmlView(data));
		   } 
		   
/* 			   //json형태로 값을 전달할때 헤더와 바디를 변경해야함
			   	headers :{
			   		'Content-Type' : 'application/json',
			   	},
			   	body : JSON.stringify(payMent) */
				
	   	function htmlView(data) {
			 $("#tbody").remove();
			 let tbody = $("<tbody />").attr('id',"tbody")
			 $.each(data, function(index, item){
				 alert(index);
				 alert(item);
			 let tr = $("<tr />").attr("onclick","noticeCall("+item.noticeId+")").append($("<td />").text(item.noticeId),
			 				  		   $("<td />").text(item.noticeWriter),
			 				           $("<td />").text(item.noticeTitle),
			 				           $("<td />").text(item.noticeHit)
			 				           );
			 	tbody.append(tr);
			 });
			 $("#list").append(tbody);
			 
			// html로 변환해서 원하는 위치에 출력하도록 구현한다.
		}
				

		   
		  

</script>
</body>
</html>