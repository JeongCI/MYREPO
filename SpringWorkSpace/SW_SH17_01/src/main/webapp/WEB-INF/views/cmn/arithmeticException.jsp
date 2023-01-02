<%--
/**
  Class Name:
  Description:
  
  Modification information
  
    수정일     수정자      수정내용
  -----   -----  -------------------------------------------
    2022. 11. 29        최초작성 
    
    author eclass 개발팀 :ITSC
    since 2022.11.24
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
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
<title>예외처리</title>
<script >
  $(document).ready(function(){
	  console.log("document.ready");
	  
  });
</script>

</head>
<body>
     <!-- div container -->
     <div class="container">
     <!-- 제목 -->
      <div class="page--header">
       <h2>NullPointerException</h2>
      </div>
     
    <table class="table table-striped table-bordered table-hover">
      <thead class="bg-primary">
	        <tr>
	          <th class="text-center col-sm-3 col-md-3 col-lg-3">구분</th>
	          <th class="text-left col-sm-5 col-md-5 col-lg-5">설명</th>
	        </tr>
        <tbody>
	        <tr>
	          <td class="text-center col-sm-3 col-md-3 col-lg-3">상태코드</td>
	          <td class="text-left col-sm-5 col-md-5 col-lg-5"><c:out value="${requestScope['javax.servlet.error.status_code']}"> </c:out>   </td>
	        </tr>        
	        <tr>
	          <td class="text-center col-sm-3 col-md-3 col-lg-3">예외유형</td>
	          <td class="text-left col-sm-5 col-md-5 col-lg-5"><c:out value="${requestScope['javax.servlet.error.exception_type']}"> </c:out></td>
	        </tr>        
	        <tr>
	          <td class="text-center col-sm-3 col-md-3 col-lg-3">메세지</td>
	          <td class="text-left col-sm-5 col-md-5 col-lg-5"><c:out value="${requestScope['javax.servlet.error.message']}"> </c:out></td>
	        </tr>        
	        <tr>
	          <td class="text-center col-sm-3 col-md-3 col-lg-3">요청URI</td>
	          <td class="text-left col-sm-5 col-md-5 col-lg-5"><c:out value="${requestScope['javax.servlet.error.request_uri']}"> </c:out>   </td>
	        </tr>        
	        <tr>
	        <tr>
	          <td class="text-center col-sm-3 col-md-3 col-lg-3">HOME</td>
	          <td class="text-left col-sm-5 col-md-5 col-lg-5"><a href=' <c:url value="/user/view.do" />'>[회원관리]</a></td>
	        </tr>        
	        <tr>
	          <td class="text-center col-sm-3 col-md-3 col-lg-3">발생한 예외처리 내용</td>
	          <td class="text-left col-sm-5 col-md-5 col-lg-5"><c:out value="${requestScope['javax.servlet.error.exception']}"> </c:out></td>
	        </tr>        
	        <tr>
	          <td class="text-center col-sm-3 col-md-3 col-lg-3">오류가 발생한 서블릿</td>
	          <td class="text-left col-sm-5 col-md-5 col-lg-5"><c:out value="${requestScope['javax.servlet.error.servlet_name']}"> </c:out>  </td>
	        </tr>        
        </tbody>        
      </thead>
     </table>
     
     </div>
     <!-- div container end --------------------------------------------------->
</body>
</html>