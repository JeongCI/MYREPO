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
  <h2>jstl url</h2>
  <hr>
  
  <c:url var="searchURL" value="https://search.daum.net/search">
    <c:param name="w" value="blog"/>
    <c:param name="q" value="하늘공원"/>
  </c:url>
  
  <c:url var="board_list" value="http://localhost:8089/PC_HTML/board/board.do">
    <c:param name="work_div" value="doRetrieve"></c:param>
    <c:param name="page_no" value="1"></c:param>
  </c:url>
  
  <ul>
    <li><a href="${board_list}">게시판</a></li>
    <li><a href="${page_no}">페이지</a></li>
    <li>${searchURL }</li>
    <li><c:url value="/jsp/jsp03/jstl01_forTokens.jsp"></c:url></li> <!-- 절대 경로 -->
    <li><c:url value=".jstl01_forTokens.jsp"></c:url></li> <!-- 상대경로 -->
  </ul>
  
</body>
</html>