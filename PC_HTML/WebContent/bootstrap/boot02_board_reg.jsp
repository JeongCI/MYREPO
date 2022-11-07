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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
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
  <div class="container">
  <!-- 제목 -->
  <div class="page-header">
    <h2>게시등록</h2>
  </div>
  <!-- 버튼 -->
   <div class="row text-right">
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
	    <input type="button" class="btn btn-primary btn-sm" value="목록">
	    <input type="button" class="btn btn-primary btn-sm" value="등록">
    </div>
   </div>
   
  <!-- 폼 -->
  <form action="#" class="form-horizontal">
  <!-- 제목 -->
    <div class="row">
      <label for="title" class="col-sm-3 col-md-2 col-lg-2 col-form-label">제목</label>
      <div class="col-sm-9 col-md-10 col-lg-10">
        <input type="text" name="title" id="title" placeholder="제목" class="form-control"> 
      </div>
    </div>
  <!-- 등록자 -->
    <div class="row">
      <label for="reg_id" class="col-sm-3 col-md-2 col-lg-2 col-form-label">등록자</label>
      <div class="col-sm-9 col-md-10 col-lg-10">
        <input type="text" readonly name="reg_id" id="reg_id" placeholder="등록자" class="form-control-plaintext"> 
      </div>
    </div>
  <!-- 내용 -->
    <div class="row">
      <label for="contents" class="col-sm-3 col-md-2 col-lg-2 col-form-label">내용</label>
      <div class="col-sm-9 col-md-10 col-lg-10">
        <textarea rows="5" cols="20" class="form-control" name="contents" id="contents"></textarea>
      </div>
    </div>
  </form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
</fmt:bundle>