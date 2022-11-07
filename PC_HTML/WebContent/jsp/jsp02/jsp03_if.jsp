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
  <h2>core if</h2>
  <hr>
  <c:if test="true">
    <p>무조건 수행</p>
  </c:if>
  <!-- http://localhost:8089/PC_HTML/jsp/jsp02/jsp03_if.jsp?name=c -->
  <c:if test="${param.name eq'c'}">
    <p>name 파라메터의 값은:${param.name }</p>
  </c:if>
  
  <!-- == : eq -->
  <!-- != : ne -->
  <c:if test="${param.name ne'c'}">
    <p>name 파라메터의 값은:${param.name }</p>
  </c:if>
  
  <!-- http://localhost:8089/PC_HTML/jsp/jsp02/jsp03_if.jsp?age=27 -->
  <!-- var: 조건문 계산 결과(true / flase) -->
  <c:if test="${param.age > 18 }" var="result">
    <p>당신의 나이는 : ${param.age }</p>
  </c:if>
  
  <p>result:${result }</p>
  
  <!-- null -->
  <c:if test="${empty param.age}">
    <p>null 나이를 입력하세요</p>
  </c:if>
  
  <!-- null -->
  <c:if test="${not empty param.age}">
    <p>not null당신의 나이는 : ${param.age }</p>
  </c:if>
</body>
</html>