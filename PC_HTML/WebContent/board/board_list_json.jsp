<%@page import="com.pcwk.ehr.board.domain.BoardVO"%>
<%@page import="java.util.List"%>
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
  /* style 초기화*/
  body, div, h1, table, tr, td, thead ,tobody, select,input{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  input, select, button{
    height: 30px;
  }
  .content_area{
    width: 1010px;
    margin: 0 auto;
  }
  .search_area{
    margin-top: 30px;
    margin-bottom: 5px;
    text-align: right;
  }
  .table_area{
    width: 100%;
    margin: 0 auto;
  }
  .nomal_btn{
    background-color:#004ba0; 
    color: white;
    border-radius: 5px;
    min-width: 50px;
  }
  .table_list{
    border-collapse: collapse;
    margin: 0 auto;
    width: 100%;
  }
  .table_list th,td{
    border: 1px solid #ccc;
    height: 20px;
    padding: 10px;
  }
  .header{
    background-color: #004ba0;
    color: white;
  }
  .txt_center{
    text-align: center;
  }
  .txt_left{
    text-align: left;
  }
  .txt_right{
    text-align: right;
  }
  .txt_hidden{
    display: none;
  }
  
</style>
<title>게시 목록</title>
<script src="/PC_HTML/assets/js/jquery-3.6.1.min.js"></script>
<script src="/PC_HTML/assets/js/jquery-ui.js"></script>
<!-- javascript -->
<script type="text/javascript">
  $(document).ready(function(){
	  
  });
  
  function doRetrieve(pageNo){
	    //console.log("send()");
	    $.ajax({ 
	       type: "GET",
	       url: "/PC_HTML/board/board.do",
	       asyn: "true",
	       dataType: "html",
	       data:{
	           //page_no: $("#page_no").val(),
	           search_div: $("#search_div").val(),
	           //search_word: $("#search_word").val(),
	           //page_size: $("#page_size").val()
	       },
	       success:function(data){ //통신 성공
	         console.log('data:'+data);
	         let resData = JSON.parse(data);
	         let tableData = '';
	         
	         console.log('test');
	         //검색에 맞는 데이터 출력
	         tableData += "<tr>";
	         tableData += "<td>"+resData.no+"</td>";
	         tableData += "<td>"+resData.title+"</td>";
	         tableData += "<td>"+resData.modId+"</td>";
	         tableData += "<td>"+resData.modDt+"</td>";
	         tableData += "<td>"+resData.totalCnt+"</td>";
	         tableData += "<td>"+resData.seq+"</td>";
	         tableData += "</tr>";

	         
	         $('.table_list #table1').append(tableData); 
	         
	       },
	       error:function(data){//실패
	    	   console.log('오류');
	       },
	       complete:function(data){//성공, 실패 관계 없이 출력
	       
	       }

	    });
	  };
	  
</script>
</head>
<body>
  <div class="content_area">
    <h1>게시판</h1>
    <div class="search_area">
      <button class="nomal_btn" onclick="javascript:doRetrieve('1');">조회</button>
      <button class="nomal_btn">등록</button>
<!-- http://localhost:8089/PC_HTML/board/board.do?work_div=doRetrieve&page_no=1&search_div=&search_word=&page_size=10 -->
    <form action="/PC_HTML/board/board.do" method="get" name="search_frm" id="search_frm">
    <input type="hidden" name="work_div" id="work_div"> <!-- 작업 구분 -->
    <input type="hidden" name="page_no" id="page_no"> <!-- 페이지 번호 -->
    
      <label for="search_div">검색조건</label>
      <select id="search_div" name="search_div">
        <option value="">전체</option>
        <option value="10">제목</option>
        <option value="20">내용</option>
        <option value="30">제목+내용</option>
      </select>
        <input type="text" name="search_word" id="search_word" maxlength="50">
      <select id="page_size" name="page_size">
        <option value="10">10</option>
        <option value="20">20</option>
        <option value="30">30</option>
        <option value="50">50</option>
        <option value="100">100</option>
      </select>

    </form>
    </div>
    <div class="table_area">
      <table class="table_list">
        <thead>
	        <tr>
	          <th class="header" width="10%">No.</th>
	          <th class="header" width="60%">제목</th>
	          <th class="header" width="10%">등록일</th>
	          <th class="header" width="10%">등록자</th>
	          <th class="header" width="10%">조회수</th>
	          <th class="header txt_hidden">seq</th>
	        </tr>
        </thead>
        <tbody id="table1">
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>