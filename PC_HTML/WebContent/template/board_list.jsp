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
    color: #fff;
  }
  
  .txt_center {
    text-align: center;
  }
  .txt_left {
    text-align: left;
  }
  .txt_right {
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
</script>
</head>
<body>
  <div class="content_area">
    <h1>게시판</h1>
    <div class="search_area">
    <form>
      <label>검색조건</label>
      <select id="search_div">
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
      <button class="normal_btn">조회</button>
      <button class="normal_btn">등록</button>
    </form>
    </div>
    <div class="table_area">
      <table class="table_list">
        <thead>
	        <tr>
	          <th class="header">No.</th>
	          <th class="header">제목</th>
	          <th class="header">등록일</th>
	          <th class="header">등록자</th>
	          <th class="header">조회수</th>
	          <th class="header txt_hidden">seq</th>
	        </tr>
        </thead>
        <tbody>
          <tr>
            <td class="txt_center">1</td>
            <td class="txt_left">제목1..........</td>
            <td class="txt_center">11:06</td>
            <td class="txt_center">이상무</td>
            <td class="txt_right">1</td>
            <td class="txt_left txt_hidden">240</td>
          </tr>
          <tr>
            <td class="txt_center">2</td>
            <td class="txt_left">제목2..........</td>
            <td class="txt_center">2022.10.31</td>
            <td class="txt_center">이상무</td>
            <td class="txt_right">1</td>
            <td class="txt_left txt_hidden">241</td>
          </tr>
          <tr>
            <td class="txt_center">3</td>
            <td class="txt_left">제목3..........</td>
            <td class="txt_center">2022.10.31</td>
            <td class="txt_center">이상무</td>
            <td class="txt_right">1</td>
            <td class="txt_left txt_hidden">242</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>