<%@page import="com.pcwk.ehr.login.domain.UserVO"%>
<%@page import="com.pcwk.ehr.cmn.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/jsp/cmn/cache.jsp" %>

<%
  //String userId = StringUtil.nvl(request.getParameter("uesr_id"));
  //String userPw = StringUtil.nvl(request.getParameter("user_pw"));
  //out.print("userId: "+userId+"<br/>");
  //out.print("userPw: "+userPw);
  
  UserVO user = (UserVO)session.getAttribute("user");
  if(null != user) {
	  out.print("로그인 성공:user" + user);
  } else {
	  out.print("로그인 실패");
  }

%>

  <html>
    <head>
      <title>로그인</title>
      <script>
        function doLogout() {
        	//alert("logout");
        	if(false == confirm("로그아웃 하시겠습니까?")) {
        		return false;
        	}
        	let frm = document.Logout_frm;
        	frm.work_div.value = "doLogout";
        	frm.action = "<%=conPath%>/login/logout.do";
        	frm.submit();
        }
      </script>
    </head>
      <body>
        <button onclick="doLogout();">로그아웃</button>
        
        <form action="#" method="get" name="Logout_frm">
          <input type="hidden" name="work_div" id="work_div">
        </form>
      </body>
  </html>
