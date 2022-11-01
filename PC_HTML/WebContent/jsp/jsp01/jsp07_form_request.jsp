<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   //한글깨짐처리
   request.setCharacterEncoding("utf-8");
   String userNm = request.getParameter("userNm");
   String cellPhone = request.getParameter("cellPhone");
   String lang = request.getParameter("lang");
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
  <p>이름: <%= userNm %></p>
  <p>핸펀: <%= cellPhone %></p>
  <p>좋아하는 프로그램: <%= lang %></p>
  <%
     String[] langArray = request.getParameterValues("lang");
     for(String str : langArray) {
    	 out.print(str+"<br>");
     }
  %>
  
  <div>
    client ip : <%= request.getRemoteAddr() %> <br>
      서버 이름: <%= request.getServerName() %> <br>
      서버 포트: <%= request.getServerPort() %> <br>
      프로토콜: <%= request.getProtocol() %> <br>
      컨텍스트: <%= request.getContextPath() %><br>
      요청정보의 크기: <%= request.getContentLength() %>  
  </div>
  
  <%
     Enumeration<String> names = request.getParameterNames();
     while(names.hasMoreElements()) {
    	 String name= names.nextElement();
    	 System.out.println("name:"+name);
    	 
    	 out.println(name+","+request.getParameter(name)+"<br>");
     }
  %>
  
</body>
</html>