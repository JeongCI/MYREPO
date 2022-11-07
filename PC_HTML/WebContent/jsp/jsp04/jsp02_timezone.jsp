<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
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
  <h2>timezone</h2>
  <hr>
  <c:set var="now" value="<%=new Date() %>"/>
  서울: <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/> <br/>
  홍콩: <fmt:timeZone value="HongKong">
        <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/> <br/>
      </fmt:timeZone>
  뉴욕: <fmt:timeZone value="New_York">
        <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/> <br/>
      </fmt:timeZone>
      
      <hr>
      <h2>timezone list</h2>
      <c:forEach var="zone" items="<%=TimeZone.getAvailableIDs() %>">
        ${zone }</br>
      </c:forEach>
      
</body>
</html>
</fmt:bundle>