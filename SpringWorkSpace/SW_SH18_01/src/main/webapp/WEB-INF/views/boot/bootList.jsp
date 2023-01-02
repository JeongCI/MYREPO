<%--
/**
  Class Name: bootList
  Description: 목록조회
  
  Modification information
  
    수정일     수정자      수정내용
  -----   -----  -------------------------------------------
    2022. 11. 28        최초작성 
    
    author eclass 개발팀 :ITSC
    since 2022.11.24
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="CP" value="${pageContext.request.contextPath }"></c:set>
<c:set var="RES" value="/resources" ></c:set>
<c:set var="CP_RES" value="${CP}${RES}" ></c:set>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="${CP}/favicon.ico">   
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="${CP_RES}/css/bootstrap.min.css">

<!-- jQuery -->
<script src="${CP_RES}/js/jquery-1.12.4.js"></script>

<!-- bootstrap js -->
<script src="${CP_RES}/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>목록</title>
<script >
  $(document).ready(function(){
	  console.log("document.ready");
	  
  });
</script>

</head>
<body>
     <!-- div container -->
     <div class="container">
     <!-- 제목 -->
      <div class="page--header">
       <h2>게시 목록</h2>
      </div> 
     <!-- 제목 end --------------------------------------------------------------> 
              
     <!-- 검색: 검색 구분(select), 검색어(input), 페이지 사이즈(select),  -->
     <form action="#" class="form-inline text-right">
     <div class="from-group">
      <select class="form-control input-sm">
        <option value="">전체</option>
        <option value="10">제목</option>
        <option value="20">내용</option>
      </select>
      <input type="text" class="form-control input-sm" placeholder="검색어를 입력하세요">
      <select class="form-control input-sm">
        <option value="10">10</option>
        <option value="20">20</option>
        <option value="30">30</option>
        <option value="50">50</option>
        <option value="100">100</option>
      </select>    
      <input type="button" class="btn btn-primary btn-sm" value ="조회">  
      <input type="button" class="btn btn-primary btn-sm" value ="등록">
     </div>
     </form>
     <!-- 검색 영역  end ---------------------------------------------------------->
     
     <!-- 테이블 목록 -->
     <div class="table-responsive">
     <table class="table table-striped table-bordered table-hover">
      <thead class="bg-primary">
        <tr>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
          <th class="text-center col-sm-6 col-md-6 col-lg-8">제목</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">작성자</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">작성일</th>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">조회수</th>
        </tr>
        <tbody>
        <tr>
          <td class="text-center col-sm-1 col-md-1 col-lg-1">1</td>
          <td class="text-left col-sm-6 col-md-6 col-lg-8">디자인 작업</td>
          <td class="text-center col-sm-2 col-md-2 col-lg-1">이상무</td>
          <td class="text-center col-sm-2 col-md-2 col-lg-1">2022/11/28</td>
          <td class="text-right col-sm-1 col-md-1 col-lg-1">100</td>
        </tr>        
        <tr>
          <td class="text-center col-sm-1 col-md-1 col-lg-1">2</td>
          <td class="text-left col-sm-6 col-md-6 col-lg-8">디자인 작업</td>
          <td class="text-center col-sm-2 col-md-2 col-lg-1">이상무</td>
          <td class="text-center col-sm-2 col-md-2 col-lg-1">2022/11/28</td>
          <td class="text-right col-sm-1 col-md-1 col-lg-1">100</td>
        </tr>        
        <tr>
          <td class="text-center col-sm-1 col-md-1 col-lg-1">3</td>
          <td class="text-left col-sm-6 col-md-6 col-lg-8">디자인 작업</td>
          <td class="text-center col-sm-2 col-md-2 col-lg-1">이상무</td>
          <td class="text-center col-sm-2 col-md-2 col-lg-1">2022/11/28</td>
          <td class="text-right col-sm-1 col-md-1 col-lg-1">100</td>
        </tr>        
        </tbody>        
      </thead>
     </table>
     </div>
     <!-- 테이블 목록  end -------------------------------------------------------->
     
     <!-- 페이징 -->
		 <nav aria-label="Page navigation example" class="text-center">
		   <ul class="pagination">
		     <li class="page-item"><a class="page-link" href="#">Previous</a></li>
		     <li class="page-item"><a class="page-link" href="#">1</a></li>
		     <li class="page-item"><a class="page-link" href="#">2</a></li>
		     <li class="page-item"><a class="page-link" href="#">3</a></li>
		     <li class="page-item"><a class="page-link" href="#">Next</a></li>
		   </ul>
	 	</nav>     
     <!-- 페이징  end ------------------------------------------------------------>
     </div>
</body>
</html>