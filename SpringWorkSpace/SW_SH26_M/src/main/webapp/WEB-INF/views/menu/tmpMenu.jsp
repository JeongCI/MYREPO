<%--
/**
  Class Name: tmpMenu.jsp
  Description: 임시메뉴
  
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

<!-- bootstrap js -->
<script src="${CP_RES}/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>임시메뉴</title>
<script >
  $(document).ready(function(){
	  console.log("document.ready");
	  
    $('#top_menu .sub_1').hide();

    $('.menu_1').on("click",function(){
    	$('.sub_1').toggle("slow", function(){
    		console.log("doLogout");
      });
    });  
    
	    
	  //로그인
	  $("#doLogin").on("click", function() {
	  	window.location.href = "${CP}/login/loginView.do";
		//doLogin  
	  });
	  
	  //로그아웃
	  $("#doLogout").on("click",function(){
		  console.log("doLogout");
		  
		  if(confirm("로그 아웃 하시겠습니까?")==false)return;
		  
		  window.location.href = "${CP}/login/doLogout.do";
		//doLogout
	  });
	
	//document  
  });
</script>

</head>
<body>
  <!-- div container -->   
  <div class="container">   
    <!-- 제목 -->
    <div class="page-header">
       <h2>임시메뉴</h2>
    </div>    
    <!-- 제목 ------------------------------------------------------------------->
		<ul id="top_menu">
		  <li>
		    <h4 class="menu_1">과일</h4>
		    <ul class="sub_1">
		      <li>사과</li>  
		      <li>배</li>
		    </ul>
        <h4 class="menu_1">나무</h4>
        <ul class="sub_1">
          <li>사과</li>
          <li>배</li>
        </ul>		      
		  </li>
		</ul>
    
    <!-- 검색 : 검색구분(select) 검색어(input) 페이지 사이즈(select)--> 
    <div class="row text-right">
      <c:choose>
        <c:when test="${null !=sessionScope.userInfo || not empty sessionScope.userInfo }">
         <span class="label label-default">${sessionScope.userInfo.name}</span>
         <span class="glyphicon glyphicon-log-out" id="doLogout">로그아웃</span> 
         &nbsp;&nbsp;&nbsp;    
        </c:when> 
        <c:otherwise> 
          <span class="glyphicon glyphicon-log-in" id="doLogin">로그인</span>
          &nbsp;&nbsp;&nbsp;
        </c:otherwise>
      </c:choose> 
      
      
    </div>
    <!-- 검색 ------------------------------------------------------------------->
    
    <!-- 테이블 목록 -->
    <div class="table-responsive">
    <table class="table table-striped table-bordered table-hover">
      <thead class="bg-primary">
        <tr>
          <th class="text-center col-sm-2 col-md-2 col-lg-2">번호</th>
          <th class="text-center col-sm-10 col-md-10 col-lg-10">메뉴</th>
        </tr>
      </thead>
      <tbody>
      
        <tr>
          <td class="text-center col-sm-2 col-md-2 col-lg-2">1</td>
          <td class="text-left col-sm-10 col-md-10 col-lg-10">
             <a href="${CP}/user/view.do">회원관리</a>
          </td>
        </tr>      
        <tr>
          <td class="text-center col-sm-2 col-md-2 col-lg-2">2</td>
          <td class="text-left col-sm-10 col-md-10 col-lg-10">
             <a href="${CP}/board/boardView.do?div=10">공지사항</a>
          </td>
        </tr> 
        
        <tr>
          <td class="text-center col-sm-2 col-md-2 col-lg-2">3</td>
          <td class="text-left col-sm-10 col-md-10 col-lg-10">
             <a href="${CP}/board/boardView.do?div=20">자유게시판</a>
          </td>
        </tr>
        
        <tr>
          <td class="text-center col-sm-2 col-md-2 col-lg-2">4</td>
          <td class="text-left col-sm-10 col-md-10 col-lg-10">
             <a href="${CP}/boot/bootList.do">템플릿 리스트</a>
          </td>
        </tr> 
        
        <tr>
          <td class="text-center col-sm-2 col-md-2 col-lg-2">5</td>
          <td class="text-left col-sm-10 col-md-10 col-lg-10">
             <a href="${CP}/boot/bootReg.do">템플릿 등록</a>
          </td>
        </tr>
        <tr>
          <td class="text-center col-sm-2 col-md-2 col-lg-2">6</td>
          <td class="text-left col-sm-10 col-md-10 col-lg-10">
             <a href="${CP}/login/loginView.do">로그인</a>
          </td>
        </tr>
        <tr>
          <td class="text-center col-sm-2 col-md-2 col-lg-2">7</td>
          <td class="text-left col-sm-10 col-md-10 col-lg-10">
             <a href="${CP}/file/viewFile.do">파일업로드</a>
          </td>
        </tr>                                                      
      </tbody>
    </table>
    </div>
    <!-- 테이블 목록 -------------------------------------------------------------->
    
    <!-- 페이징 -->

    <!-- 페이징--- -------------------------------------------------------------->    
  </div>   
  <!-- div container ---------------------------------------------------------->
       
</body>
</html>


















