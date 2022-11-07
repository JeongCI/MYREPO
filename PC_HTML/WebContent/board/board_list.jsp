<%@page import="com.pcwk.ehr.cmn.StringUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pcwk.ehr.cmn.SearchVO"%>
<%@page import="com.pcwk.ehr.board.domain.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
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
    margin-top: 5px;
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
    margin-top: 10px;
    margin-bottom: 20px;
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
	  
	    $("#check_all").on("click",function(){
	    	if($("#check_all").is(":checked") == true) {
	    		$("input[name=chk]").prop("checked",true);
	    	} else {
	    		$("input[name=chk]").prop("checked",false);
	    	}
	    });
	  
     $("#list_table>tbody").on("mouseenter","tr",function(){
    	 //console.log("click\n"+$(this));
    	 let tdArray = $(this).children();
    	 //console.log("tdArray.last().text(): "+tdArray.last().text());
    	 let seq = tdArray.last().text();
    	 //console.log("seq: " + seq);
    	 
    	 $("#list_table>tbody>tr>#cursor_title").on("click",function(){
    		 
	    	 //상세 화면으로 이동: form submit으로
	    	 let frm = document.getElementById("search_frm");
	    	 frm.work_div.value = "doSelectOne";
	    	 frm.seq.value = seq;
	    	 
	    	 //console.log("seq"+seq);
	    	 frm.submit();
    	 });
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
  
  function doDelete(){
      //alert('doDelete');
      let seqArray = [];
      $("input:checkbox[name=chk]").each(function(i, element) {
         //console.log($(this).val());
         if($(this).is(":checked")==true){
            //console.log($(this).val());
            seqArray.push($(this).val());
         }
         
      });
      
      let seqString = '';
      //선택된 값이 있는 지 validation
      if(seqArray.length>0){
         seqString = seqArray.toString();
         console.log("seqString:"+seqString);
      }else{
         alert("삭제할 자료를 선택하세요.");
         return;
      }
      
      if(false==confirm("삭제 하시겠습니까?"))return;
      /* data의 seq_arr form과 연관 관계가 없다.(사용자 정의 명칭) */
      $.ajax({ 
           type: "POST",
           url: "<%=conPath%>/board/board.do",
           asyn: "true",
           dataType: "html",
           data:{
               work_div: 'doDeleteAll',
               seq_arr: seqString
           },
           success:function(data){ //통신 성공
            //alert(data);
             const jsonObj = JSON.parse(data);
             console.log('jsonObj.messageId:'+jsonObj.messageId);
             console.log('jsonObj.msgContents:'+jsonObj.msgContents);
           
           if(null != jsonObj && jsonObj.messageId != "0"){
              alert(jsonObj.msgContents);
              const listUrl = "<%=conPath%>/board/board.do?work_div=doRetrieve";
              window.location.href = listUrl;
           }else{
              alert(jsonObj.msgContents+":"+jsonObj.messageId);
           }
           },
           error:function(data){//실패
             console.log('error:'+data);
           },
           complete:function(data){//성공, 실패 관계 없이 출력
           
           }

        });
      
   }
  
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
    <input type="hidden" name="seq" id="seq"> <!-- seq 번호 -->
    
      <label for="search_div">검색조건</label>
      <select id="search_div" name="search_div">
        <option value="">전체</option>
        <option value="10" <c:if test="${'10' == vo.searchDiv }">selected</c:if> > 제목</option>
        <option value="20" <c:if test="${'20' == vo.searchDiv }">selected</c:if> > 내용</option>
        <option value="30" <c:if test="${'30' == vo.searchDiv }">selected</c:if> > 제목+내용</option>
      </select>
        <input type="text" name="search_word" id="search_word" maxlength="50" value="${vo.searchWord }">
      <select id="page_size" name="page_size">
        <option value="10"  <c:if test="${10 == vo.pageSize}">selected</c:if>>10</option>
        <option value="20"  <c:if test="${20 == vo.pageSize}">selected</c:if>>20</option>
        <option value="30"  <c:if test="${30 == vo.pageSize}">selected</c:if>>30</option>
        <option value="50"  <c:if test="${50 == vo.pageSize}">selected</c:if>>50</option>
        <option value="100" <c:if test="${100 == vo.pageSize}">selected</c:if>>100</option>
      </select>
      </form>
      
      <div class="button_area">
	      <button class="nomal_btn" onclick="javascript:doRetrieve('1');">조회</button>
	      <button class="nomal_btn" onclick="javascript:moveReg();">등록</button>
	      <button class="nomal_btn" onclick="javascript:doDelete();">삭제</button>
      </div>
    </div>
    <div class="table_area">
      <table class="table_list" id="list_table">
        <thead>
          <tr>
            <th class="header" width="5%"><input type="checkbox" id="check_all"></th>
            <th class="header" width="10%">No.</th>
            <th class="header" width="55%">제목</th>
            <th class="header" width="10%">등록일</th>
            <th class="header" width="10%">등록자</th>
            <th class="header" width="10%">조회수</th>
            <th class="header txt_hidden">seq</th>
          </tr>
        </thead>
        <tbody>
        <c:choose>
          <c:when test="${not empty list && list.size() > 0}">
            <c:forEach var="vo" items="${list}">
			          <tr>
			            <td class="txt_center"><input type="checkbox" name="chk" value="${vo.getSeq() }"></td>
			            <td class="txt_center">${vo.getNo()}</td>
			            <td class="txt_left cursor_title" id="cursor_title"><c:out value="${vo.getTitle()}" escapeXml="true"></c:out></td>
			            <td class="txt_center">${vo.getModDt()}</td>
			            <td class="txt_center"><c:out value="${vo.getModId()}" escapeXml="true"></c:out></td>
			            <td class="txt_right">${vo.getReadCnt()}</td>
			            <td class="txt_left txt_hidden">${vo.getSeq()}</td>
			          </tr>
            </c:forEach>
          </c:when>
          <c:otherwise>
            <tr>
              <td class="txt_center" colspan="99">No Data found</td>
            </tr>
          </c:otherwise>
        </c:choose>
<%--           <%
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
          %> --%>
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