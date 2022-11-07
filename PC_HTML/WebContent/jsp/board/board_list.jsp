<%@page import="com.pcwk.ehr.cmn.StringUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pcwk.ehr.cmn.SearchVO"%>
<%@page import="com.pcwk.ehr.board.domain.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/cmn/cache.jsp" %>

<%
  //조회목록
  List<BoardVO> list = (request.getAttribute("list")==null) ? new ArrayList():(List<BoardVO>)request.getAttribute("list");

  //총글수
  int totalCnt = (request.getAttribute("totalCnt")==null? 0:(Integer)request.getAttribute("totalCnt"));
  //out.println("totalCnt : " + totalCnt);

  //검색 조건
  SearchVO paranVO = (request.getAttribute("vo")==null) ? new SearchVO():(SearchVO)request.getAttribute("vo");
  /**
   * 
   * @param maxNum: 총글수
   * @param currPageNo: 현재페이지
   * @param rowPerPage: 10/ 20/ 30/ 50/ 100
   * @param buttomCount: 10
   * @param url: http://localhost:8089/PC_HTML/board/board.do?work_div=doRetrieve&page_no=1&search_div=&search_word=&page_size=10
   * @param scriptName: javascript function name
   * @return
   */
  //public static String renderPaging(int maxNum, int currPageNo, int rowPerPage, int bottomCount, String url, String scriptName)
  int currPageNo = 1;   // 현재 페이지
  int rowPerPage = 10;  // 페이지당 보여줄 글 수
  int bottomCount = 10; // 바닥에 보여줄 번호 ( 1 2 3 4 5 6 7 8 9 10)
  String goPageUrl = conPath+"/board/board.do"; // 호출 URL
  String scriptName = "doSearchPage"; // 호출 자바스크립트 이름
  if(10 != paranVO.getPageSize() || 1 != paranVO.getPageNo()) {
	  currPageNo = paranVO.getPageNo();
	  rowPerPage = paranVO.getPageSize();
  }
  
%>

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
  input, select{
    height: 30px;
  }
  
  @font-face {
    font-family: 'NGB';
    src: url("/PC_HTML/assets/fonts/NanumGothicExtraBold.woff") format('woff');
  }
  
  @font-face {
    font-family: 'NG';
    src: url("/PC_HTML/assets/fonts/NanumGothic.woff") format('woff');
  }
    
  @font-face {
    font-family: 'NGBE';
    src: url("/PC_HTML/assets/fonts/NanumGothicBold.woff") format('woff');
  }

  .regular {
    font-family: 'NG';
  } 
  
  .medium {
    font-family: 'NGB';
  }   
  
  .bold {
    font-family: 'NGBE';
  } 
  
  button{
    height: 31px;
    cursor:pointer;
  }
  
  .content_area{
    width: 1010px;
    margin: 0 auto;
    padding-top: 30px;
  }
  
  .search_area{
    margin-top: 30px;
    margin-bottom: 5px;
    text-align: right;
  }
  
  .page_area {
    width: 40%;
    margin: 0 auto;
    margin-top: 10px;
  }
  
/* paging */
 .page_area {
   display: inline-block;
   width: 100%;
  
   /* 위 | 오른쪽 | 아래 | 왼쪽 */     
   margin-top: 30px;     
 }
    
 .page_table{
   border-collapse: collapse;
   margin: 0 auto;
   width: 100%; 
   background-color: rgba(200,200,200,0.2); 
 }
 
 .page_table td {
   height: 20px;
   font-size: 18px;
   font-family: 'NG';   
 }
    
  .page_table li{
    display: inline-block;
  }
  
  .page_table td a {
   text-decoration: none;
   color: black; 
   padding: 2px;
 }
  
  .page_table td a:hover {
    text-decoration: underline;
  }
  
  .page_table .now_page {
    background-color: rgba(222,222,222,0.5);
    text-decoration: underline;
    font-weight: bold;
  }
  
  /* 게시판 */    
  .table_area{
    width: 100%;
    margin: 0 auto;
  }

  .table_list{
    border-collapse: collapse;
    margin: 0 auto;
    width: 100%;
  }
  
  .table_list td,th{
    border: 1px solid #ccc;
    height: 20px;
    padding: 10px;
  }
  
  .nomal_btn{
    background-color:#004ba0; 
    color: white;
    border-radius: 5px;
    min-width: 50px;
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
  .type_text{
    display: none;
  }
   .buttoen_area {
    margin: 1px 0px 0px 20px;
    display: inline-block;
    text-align: right;
    vertical-align: bottom;
  }
  
  .table_list .cursor_title:hover {
    text-decoration: underline;
    cursor: pointer;
  }
  
</style>
<title>게시 목록</title>
<script src="/PC_HTML/assets/js/jquery-3.6.1.min.js"></script>
<script src="/PC_HTML/assets/js/jquery-ui.js"></script>
<!-- javascript -->
<script type="text/javascript">
  $(document).ready(function(){

/* 	  $("#list_table>tbody>tr>#cursor_title").on("click",function(){
		  //console.log("click");
		  
		  let tdArray = $("#list_table>tbody").children();
		  let seq = tdArray.last().text();
		  
		  let frm = document.getElementById("search_frm");
		  frm.work_div.value = "doSelectOne";
		  frm.seq.value = seq;
		  
		  console.log("tdArray: " + tdArray);
		  console.log("seq : " + seq);
		  //frm.submit();
	  }); */
	  
     $("#list_table>tbody").on("click","tr",function(){
    	 //console.log("click\n"+$(this));
    	 let tdArray = $(this).children();
    	 //console.log("tdArray.last().text(): "+tdArray.last().text());
    	 let seq = tdArray.last().text();
    	 
    	 //상세 화면으로 이동: form submit으로
    	 let frm = document.getElementById("search_frm");
    	 frm.work_div.value = "doSelectOne";
    	 frm.seq.value = seq;
    	 
    	 //console.log("seq"+seq);
    	 //frm.submit();
    	 
    }); 
    
    $("#search_word").on("keypress", function(event){
    	//alert("keypress"+event.type+": "+ event.which);
    	if(13 == event.which) {
    		doRetrieve(1);
    		return false;
    	alert("********");
    	}
    });
    
  });
  
    /* 목록 조회 */
    function doRetrieve(pageNo) {
      let frm = document.search_frm;
      frm.work_div.value = "doRetrieve";
      frm.page_no.value = pageNo;
      
      /* alert(frm.search_word.value); */
      console.log('frm.work_div.value :'+$("#work_div").val());
      console.log('frm.page_no.value : '+$("#page_no").val());
      console.log('frm.search_div.value :'+$("#search_div").val());
      console.log('frm.search_word.value :'+$("#search_word").val());
      
      frm.submit();
    }
    
    /* 게시물 등록화면 이동 */
    function moveReg() {
    	//console.log('이동완료');
    	//let frm = document.search_frm;
    	let frm = document.getElementById("search_frm");
    	frm.work_div.value = 'moveReg';
    	
    	//console.log('frm.work_div.value :'+$("#work_div").val());
    	
    	frm.submit();
    }
    
    function doSearchPage(url, pageNo) {
    	console.log('url'+url);
    	console.log('pageNo'+pageNo);
    	let frm = document.search_frm;
    	frm.work_div.value = 'doRetrieve';
    	frm.page_no.value = pageNo;
    	
    	frm.action = url;
    	frm.submit();
    }
    
</script>
</head>
<body>
  <div class="content_area">
    <h1>게시판</h1>
    <div class="search_area">
    <%-- <%= paranVO %> --%>
<!-- http://localhost:8089/PC_HTML/board/board.do?work_div=doRetrieve&page_no=1&search_div=&search_word=&page_size=10 -->
    <form action="<%=conPath %>/board/board.do" method="get" name="search_frm" id="search_frm">
    <input type="hidden" name="work_div" id="work_div"> <!-- 작업 구분 -->
    <input type="hidden" name="page_no" id="page_no"> <!-- 페이지 번호 -->
    <input type="text" name="seq" id="seq"> <!-- seq 번호 -->
    
      <div class="button_area">
      <label for="search_div">검색조건</label>
      <select id="search_div" name="search_div">
        <option value="">전체</option>
        <option value="10" <% if(paranVO != null && paranVO.getSearchDiv().equals("10")) {out.print("selected");} %>>제목</option>
        <option value="20" <% if(paranVO != null && paranVO.getSearchDiv().equals("20")) {out.print("selected");} %>>내용</option>
        <option value="30" <% if(paranVO != null && paranVO.getSearchDiv().equals("30")) {out.print("selected");} %>>제목+내용</option>
      </select>
        <input type="text" name="search_word" id="search_word" maxlength="50" value="<% if(paranVO != null) {out.print(paranVO.getSearchWord());}%>">
      <select id="page_size" name="page_size">
        <option value="10"  <% if(paranVO != null && paranVO.getPageSize() == 10){out.print("selected");}%>>10</option>
        <option value="20"  <% if(paranVO != null && paranVO.getPageSize() == 20){out.print("selected");}%>>20</option>
        <option value="30"  <% if(paranVO != null && paranVO.getPageSize() == 30){out.print("selected");}%>>30</option>
        <option value="50"  <% if(paranVO != null && paranVO.getPageSize() == 50){out.print("selected");}%>>50</option>
        <option value="100" <% if(paranVO != null && paranVO.getPageSize() == 100){out.print("selected");}%>>100</option>
      </select>
      </form>
	      <button class="nomal_btn" onclick="javascript:doRetrieve('1');">조회</button>
	      <button class="nomal_btn" onclick="javascript:moveReg();">등록</button>
      </div>
    </div>
    <div class="table_area">
      <table class="table_list" id="list_table">
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
        <tbody>
          <%
            if(null != list && list.size()>0) {
              for(BoardVO vo : list) {
          %>
          <tr>
            <td class="txt_center"><%= vo.getNo() %></td>
            <td class="txt_left cursor_title" id="cursor_title"><%= vo.getTitle() %></td>
            <td class="txt_center"><%= vo.getModDt() %></td>
            <td class="txt_center"><%= vo.getModId() %></td>
            <td class="txt_right"><%= vo.getReadCnt() %></td>
            <td class="txt_left txt_hidden"><%= vo.getSeq() %></td>
          </tr>
          <%
              }// for
            }else {//if
          %>
            <tr>
              <td class="txt_center" colspan="99">No Data found</td>
            </tr>
          <%
            }
          %>
        </tbody>
      </table>
    </div>
    
    <!-- paging -->
    <div class="page_area">
      <%=StringUtil.renederPaging(totalCnt, currPageNo, rowPerPage, bottomCount, goPageUrl, scriptName) %>
    </div>
    
  </div>
</body>
</html>