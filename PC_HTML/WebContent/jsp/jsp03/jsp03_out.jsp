<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@include file="/jsp/cmn/cache.jsp" %>

<%
  String path = request.getParameter("path");
  out.print("path: "+path); /// /board/board_list.jsp
  // http://localhost:8089/PC_HTML/jsp/jsp03/jsp03_out.jsp?path=/board/board_list.jsp
  
  String realPath = getServletContext().getRealPath(path);
  out.print("realPathL " + realPath);
  FileReader reader = null;
  try {
	  reader = new FileReader(realPath);
	  
  } catch(IOException e) {
	  System.out.println("==============================");
	  System.out.println("IOException: " + e.getMessage());
	  System.out.println("==============================");
  }
  
%>
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
  <pre>
  <c:out value="<%= reader %>" escapeXml="true" />
  </pre>
</body>
</html>