<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/cmn/cache.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initail-scale=1.0">
<meta name="description" content="pcwk html" />
<!-- 키워드 -->
<meta name="keyword" content="html5, css3, javascript6, jQuery">
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="/PC_HTML/favicon.ico">
<!-- jquery ui -->
<link rel="stylesheet" href="/PC_HTML/assets/css/jquery-ui.css">
<style>
  table {
    border-collapse: collapse;
  }
  
  td, th, tr {
    widht: 100%;
    letter-spacing: 1px;
    border: 1px solid;
  }
</style>
<title>제목</title>
<script src="/PC_HTML/assets/js/jquery-3.6.1.min.js"></script>
<script src="/PC_HTML/assets/js/jquery-ui.js"></script>
<!-- javascript -->
<script type="text/javascript">
  $(document).ready(function(){
	  
  });
  
  function send(){
	  //console.log("send()");
	  $.ajax({ 
		   type: "GET",
		   url: "/PC_HTML/board/board.do",
		   asyn: "true",
		   dataType: "html",
		   data:{
		       work_div: $("#work_div").val(),
		       seq: $("#seq").val()
		   },
		   success:function(data){ //통신 성공
			   //console.log('data:'+data);
			   let resData = JSON.parse(data);
			   let tableData = '';
			   
				 $("#result").val(resData.title+"\r\n"+resData.contents);
			   
				   console.log('test');
				   //검색에 맞는 데이터 출력
				   tableData += "<tr>";
				   tableData += "<td>"+resData.no+"</td>";
				   tableData += "<td>"+resData.title+"</td>";
				   tableData += "<td>"+resData.modDt+"</td>";
				   tableData += "<td>"+resData.modId+"</td>";
				   tableData += "<td>"+resData.totalCnt+"</td>";
				   tableData += "<td>"+resData.seq+"</td>";
				   tableData += "</tr>";

			   
			   $('table #table1').append(tableData); 
			   
		   },
		   error:function(data){//실패
		   
		   },
		   complete:function(data){//성공, 실패 관계 없이 출력
		   
		   }

		});
  }
</script>
</head>
<body>
  <!-- /board/board.do -->
  <!-- work_div -->
  <!-- seq -->
  
  <button onclick="javascript:send();">전송</button>
  <form action="/PC_HTML/board/board.do" method="get">
    <div>
      <label>작업 구분</label>
      <input value="doSelectOne" type="text" name="work_div" id="work_div" required="required" maxlength="12">
    </div>
    
    <div>
      <label>SEQ</label>
      <input value="173" type="text" name="seq" id="seq">
    </div>
    
    
  </form>
  
  <textarea rows="10" cols="60" id="result"></textarea>
  
  <table>
  <thead>
    <th>no</th>
    <th>제목</th>
    <th>게시일</th>
    <th>작성자</th>
    <th>조회수</th>
    <th>seq</th>
  </thead>
    <tbody id="table1">
    </tbody>
  </table>
</body>
</html>