<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    int sum = 0;
    for(int i = 1; i <= 100; i++) {
    	sum+=i;
    }
%>

<%!
    String []str = {"jsp는","재미 ","있다."};

    public int multiply(int a, int b) {
    	int c = a*b;
    	return c;
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
  <h2>jsp 스크립트 요소</h2>
  <hr>
  <div>
    <p>1 ~100까지 합계: <%=sum %>
  </div>
  
  <div>
    <%
      for(String s : str) {
    	  out.print("<p>"+s+"</p>");
      }
    %>
  </div>
  
  <div>
    11*13=<%= multiply(11, 13) %>
  </div>
</body>
</html>