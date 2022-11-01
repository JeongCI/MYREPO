<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     String userId = request.getParameter("userId");
     String userPw = request.getParameter("userPw");
     

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <p>
    <label>이름:</label><%=userId %>
  </p>
  <p>
    <label>비번:</label><%=userPw %>
  </p>
</body>
</html>