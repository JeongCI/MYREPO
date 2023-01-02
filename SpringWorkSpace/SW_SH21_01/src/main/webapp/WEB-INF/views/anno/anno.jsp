<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>anno</title>
</head>
<body>
    <h2>로그인</h2>
    <hr>
    <form action="/ehr/anno/doSelectOne.do" method="post">
      <label>아이디</label>
      <input type="text" name="userId" id="userId">
      <label>비번</label>
      <input type="password" name="passwd" id="passwd">   
      <input type="submit" value="전송"  />  
    </form>
    
    vo:${vo}
</body>
</html>