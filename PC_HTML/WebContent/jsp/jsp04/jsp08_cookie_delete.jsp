<%@page import="java.net.URLEncoder"%>
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

</head>
<body>
  <h2>쿠키 삭제</h2>
  <hr/>
  <%
    //기존 쿠키 조회
    Cookie[] cookies = request.getCookies();
    if(null != cookies && cookies.length>0) {
      
      for(Cookie cookie : cookies) {
        if(cookie.getName().equals("pcwk")) {
            Cookie newCookie = new Cookie("pcwk",URLEncoder.encode("", "UTF-8"));
            newCookie.setMaxAge(0);
            //쿠키를 브라우저에 전송
            response.addCookie(newCookie);
        }
      }
    }
  %>
</body>
</html>
</fmt:bundle>