<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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

</style>
<title>제목</title>
<script src="/PC_HTML/assets/js/jquery-3.6.1.min.js"></script>
<script src="/PC_HTML/assets/js/jquery-ui.js"></script>
<!-- javascript -->
<script type="text/javascript">
  $(document).ready(function(){
	  
  });
</script>
</head>
<body>
  <h2>jstl choose ~ when ~ otherwise</h2>
  <hr>
  <c:choose>
  
    <c:when test="${param.name == 'html' }">
      <p>프로그램은: ${param.name}</p>
    </c:when>
    <c:when test="${param.name == 'css' }">
      <p>프로그램은: ${param.name}</p>
    </c:when>
    <c:when test="${param.name == 'jsp' }">
      <p>프로그램은: ${param.name}</p>
    </c:when>
    <c:otherwise>
      <p>없습니다.</p>
      ${param.name}
    </c:otherwise>
  
  </c:choose>
</body>
</html>