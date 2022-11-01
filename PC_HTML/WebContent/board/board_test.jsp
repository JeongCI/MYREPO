<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <!-- /board/board.do -->
  <!-- work_div -->
  <!-- seq -->
  
  <form action="/PC_HTML/board/board.do" method="get">
    <div>
      <label>작업 구분</label>
      <input value="doSelectOne" type="text" name="work_div" required="required" maxlength="12">
    </div>
    
    <div>
      <label>SEQ</label>
      <input value="173" type="text" name="seq">
    </div>
    
    <input type="submit" value="전송">
    
  </form>
  
</body>
</html>