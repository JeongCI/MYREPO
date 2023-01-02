<%--
/**
  Class Name:
  Description:
  
  Modification information
  
    수정일     수정자      수정내용
  -----   -----  -------------------------------------------
    2022. 11. 28        최초작성 
    
    author eclass 개발팀 :ITSC
    since 2022.11.24
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
   //공지사항(10)/자유게시판 구분(20)
   String divValue = request.getParameter("div");
   request.setAttribute("divValue", divValue);
%>   
<c:set var="CP" value="${pageContext.request.contextPath }"></c:set>
<c:set var="RES" value="/resources" ></c:set>
<c:set var="CP_RES" value="${CP}${RES}" ></c:set>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="${CP}/favicon.ico">   
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="${CP_RES}/css/bootstrap.min.css">

<!-- jQuery -->
<script src="${CP_RES}/js/jquery-1.12.4.js"></script>
<!-- callAjax -->
<script src="${CP_RES}/js/callAjax.js"></script>
<!-- String, Number, Date Util -->
<script src="${CP_RES}/js/eUtil.js"></script>

<!-- paging -->
<script src="${CP_RES}/js/jquery.bootpag.js"></script>

<!-- bootstrap js -->
<script src="${CP_RES}/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>브트스트랩_등록</title>
<script >
  $(document).ready(function(){
	  console.log("document.ready");
	  
	  $("#contents").on("keyup",function(){
	      let content = $(this).val();
	      $("#num_text").html("("+content.length + "/2000)");
	      if(content.length > 2000) {
	        alert("최대 2000자 까지만 입력 가능합니다.");
	        $(this).val(content.subString(0,2000));
	        return false;
	      }
	    });
	     
	  $("#doSave").on("click",function(){
		  
		  if(eUtil.ISEmpty($("#title").val()) == true) {
			  alert("제목을 입력하세요");
			  $("#title").focus();
			  return;
		  }
		  if(eUtil.ISEmpty($("#regId").val()) == true) {
			  alert("등록자를 입력하세요");
			  $("#regId").focus();
			  return;
		  }
		  if(eUtil.ISEmpty($("#contents").val()) == true) {
			  alert("내용을 입력하세요");
			  $("#contents").focus();
			  return;
		  }
		  
		  if(confirm("등록 하시겠습니까?") == false) return;
		  let method = "POST";
		  let url    = "/board/doSave.do";
		  let async  = true;
		  let params = {
				  title: $("#title").val(),
		      regId: $("#regId").val(),
		      contents: $("#contents").val(),
		      div: $("#div").val(),
		  };
		  PClass.callAjax(method,url,async,params,function(data){
	            console.log("data:"+data);
	             let parsedJson = JSON.parse(data);
	             
	             if("1" == parsedJson.msgId){
	                  alert(parsedJson.msgContents);
	                  moveToList(1);
	             }else{
	               alert(parsedJson.msgId+","+parsedJson.msgContents);
	             }
		  });
	  });
		  //doSave End -------------------------------------------------------------
	  
	  $("#boardView").on("click",function(){
		  moveToList(1);
	  });
	  
  });
	  // document End ------------------------------------------------------------
	  
	  function moveToList() {
		  window.location.href = "${CP}/board/boardView.do?div="+$("#div").val();
	  }
</script>

</head>
<body>
  <!-- div container -->   
  <div class="container">
    <!-- 제목 -->
    <div class="page-header">
       <h2>게시등록</h2>
    </div>
    <!-- 제목 ------------------------------------------------------------------->
    <!--버튼  -->
    <div class="row text-right">
      <input type="button" class="btn btn-primary btn-sm" value="등록" id="doSave">
      <input type="button" class="btn btn-primary btn-sm" value="목록" id="boardView">
    </div>
    <!--버튼 -------------------------------------------------------------------->
    
    <!-- 폼 -->
    <form action="#" class="form-horizontal">
    <input type="hidden" name="div" id="div" value="${requestScope.divValue}">   
	    <div class="form-group">
		    <label for="title" >제목</label>
		    <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요" maxlength="100">
	    </div>
      <div class="form-group">
        <label for="regId" >등록자</label>
        <input type="text" class="form-control" id="regId" name="regId" placeholder="등록자를 입력하세요" maxlength="100">
      </div>
      <div class="form-group">
        <label for="contents" >내용</label>
        <textarea class="form-control" rows="10" id="contents" name="contents" maxlength="2000"></textarea>
        <span id="num_text">(0/2000)</span>
      </div>      	    
    </form>
    <!--폼   -------------------------------------------------------------------->
  </div>   
  <!-- div container ---------------------------------------------------------->
     
     
     
</body>
</html>





















