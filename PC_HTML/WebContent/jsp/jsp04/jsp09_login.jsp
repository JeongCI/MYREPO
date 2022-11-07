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
  function doLogin() {
	  //alert("login");
	  let frm = document.login_frm;
	  frm.work_div.value = "doLogin";
	  frm.action = "<%=conPath%>/login/login.do";
	  
	  frm.submit();
  }
</script>
</head>
<body>
  <h2>로그인</h2>
  <hr>
  
  <button onclick="javascript:doLogin();">로그인</button>
  <form action="#" method="post" name="login_frm">
    <input type="hidden" name="work_div" id="work_div">
    <label for="user_id">ID</label>
    <input type="text" name="user_id" id="user_id" required="required">
    <label for="user_pw">비밀번호</label>
    <input type="password" name="user_pw" id="user_pw" required="required">
    
  </form>
</body>
</html>
</fmt:bundle>