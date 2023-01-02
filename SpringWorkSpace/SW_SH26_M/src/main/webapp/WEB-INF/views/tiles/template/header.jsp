<%--
/**
  Class Name: header.jsp
  Description:
  
  Modification information
  
    수정일     수정자      수정내용
  -----   -----  -------------------------------------------
    2022. 12. 13        최초작성 
    
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

   <!-- nav -->
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
        </button>
        <a class="navbar-brand" href="#">PCWK</a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="${CP}/user/view.do" class="navbar-link">회원관리</a></li>
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">템플릿<span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="${CP}/boot/bootList.do" class="navbar-link">템플릿 리스트</a></li>
              <li><a href="${CP}/boot/bootReg.do" class="navbar-link">템플릿 등록</a></li>
              <li class="divider"></li>
              <li><a href="${CP}/chart/pie.do" class="navbar-link">Pie</a></li>
              <li><a href="${CP}/chart/line.do" class="navbar-link">Line</a></li>
              <li class="divider"></li>
              <li><a href="${CP}/file/viewFile.do" class="navbar-link">파일</a></li>
            </ul>
          </li>
            <li><a href="${CP}/user/pieChartView.do" class="navbar-link">레벨별회원</a></li>
            <li><a href="${CP}/board/boardView.do?div=10" class="navbar-link">공지사항</a></li>
            <li><a href="${CP}/board/boardView.do?div=20" class="navbar-link">자유게시판</a></li>
            <li><a href="${CP}/naver/view.do" class="navbar-link">naver-search</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <!-- login/logout -->
            <c:choose>
             <c:when test="${null !=sessionScope.userInfo && not empty sessionScope.userInfo}">
               <li class="text-right">
                 <a href="#" class="navbar-link">  
                   <span class="label label-default">${sessionScope.userInfo.name}</span>
                 </a>
               </li>
               <li class="text-right">
                 <a href="javascript:doLogout();" class="navbar-link">  
                   <span class="glyphicon glyphicon-log-out" id="doLogin">로그아웃</span>
                 </a>
               </li>                
             </c:when>
             <c:otherwise>   
               <li class="text-right">  
                 <a href="javascript:doLogin();" class="navbar-link">
                   <span class="glyphicon glyphicon-log-in" id="doLogin">로그인</span>
                 </a>
               </li>
             </c:otherwise>
               
            </c:choose>
        </ul>
      </div>
    </div>
  </nav>  
   <!-- nav ------------------------------------------------------------------->
   <script >
      function doLogout() {
        if(confirm('로그아웃 하시겠습니까?')==false)return;
        window.location.href= "${CP}/login/doLogout.do";
      }
   
      function doLogin(){
        window.location.href = "${CP}/login/loginView.do";
      }
   </script>