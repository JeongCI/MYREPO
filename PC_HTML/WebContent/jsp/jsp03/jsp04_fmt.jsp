<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- 국제화 --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<%@include file="/jsp/cmn/cache.jsp" %>
<fmt:message var="title" key="TITLE" scope="page"></fmt:message>
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
  <!-- message 출력 -->
  <h2>${title}</h2>
  <hr>
  <!-- message 출력 -->
  <fmt:message key="GREETING"></fmt:message><br/>
  <!-- parameter 받기 -->
  <c:if test="${not empty param.user_id }">
    <fmt:message key="VISITOR">
      <fmt:param value="${param.user_id }"></fmt:param>
    </fmt:message>
  </c:if>
</body>
</html>
</fmt:bundle>