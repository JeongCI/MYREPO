<%--
/**
  Class Name: bootList.jsp
  Description: 목록
  
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
<!-- callAjax -->
<script src="${CP_RES}/js/callAjax.js"></script>
<!-- String, Number, Date Util -->
<script src="${CP_RES}/js/eUtil.js"></script>

<!-- paging -->
<script src="${CP_RES}/js/jquery.bootpag.js"></script>

<!-- bootstrap js -->
<script src="${CP_RES}/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>게시목록</title>
<script >
  $(document).ready(function(){
	  $("#doRetrive").on("click",function(){
		  doRetrive(1);
	  });
	//document End --------------------------------------------------------------  
  });
  
  function doRetrive(page) {
	  console.log("doRetrive page: "+page);
	  
	  let method = "GET";
	  let url    = "/board/doRetrive.do";
	  let async  = true;
	  let param  = {
	      searchDiv : $("#searchDiv").val(),
	      searchWord: $("#searchWord").val(),
	      pageSize : $("#pageSize").val(),
	      pageNo: page
	  };
	  PClass.callAjax(method,url,async,param,function(data){
          console.log("data:"+data);
          //JSON.parse() 메서드는 JSON 문자열의 구문을 분석하고, 그 결과에서 JavaScript 값이나 객체를 생성합니다.
          let parsedJson = JSON.parse(data);
          
          let htmlData = "";
	  });
  }
</script>

</head>
<body>
  <!-- div container -->   
  <div class="container">   
    <!-- 제목 -->
    <div class="page-header">
       <h2>게시목록</h2>
    </div>
    <!-- 제목 ------------------------------------------------------------------->
    <!-- 검색 : 검색구분(select) 검색어(input) 페이지 사이즈(select)--> 
    <form action="#" class="form-inline text-right">
      <div class="form-group">
				<select class="form-control input-sm" name="searchDiv" id="searchDiv">
					<c:forEach items="${BOARD_SEARCH}" var="code">
					    <option value='<c:out value="${code.detCode}"/>'>
					    <c:out value="${code.detName}"/>
					  </option>
					</c:forEach>
				</select>
				<input type="text" class="form-control input-sm" name="searchWord" id="searchWord" placeholder="검색어를 입력하세요">
        <select class="form-control input-sm" name="pageSize" id="pageSize">
          <c:forEach items="${PAGE_SIZE}" var="size">
            <option value='<c:out value="${size.detCode}"/>'>
            <c:out value="${size.detName}"/>
            </option>
          </c:forEach>
        </select>
        <input type="button" class="btn btn-primary btn-sm" value="조회" id="doRetrive">
        <input type="button" class="btn btn-primary btn-sm" value="등록">				      
      </div>
    </form> 
    <!-- 검색 ------------------------------------------------------------------->
    
    <!-- 테이블 목록 -->
    <div class="table-responsive">
    <table class="table table-striped table-bordered table-hover">
      <thead class="bg-primary">
        <tr>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
          <th class="text-center col-sm-6 col-md-6 col-lg-8">제목</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">작성자</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">등록일</th>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">조회수</th>
        </tr>
      </thead>
      <tbody>
        <c:choose>
          <c:when test="${list.size()>0}">
            <c:forEach var="vo" items="${list}">
                      <tr>
          <td class="text-center col-sm-1 col-md-1 col-lg-1"><c:out value="${vo.num }"></c:out></td>
          <td class="text-left col-sm-6 col-md-6 col-lg-8"><c:out value="${vo.title }"></c:out></td>
          <td class="text-center col-sm-2 col-md-2 col-lg-1"><c:out value="${vo.modId }"></c:out></td>
          <td class="text-center col-sm-2 col-md-2 col-lg-1"><c:out value="${vo.modDt }"></c:out></td>
          <td class="text-right col-sm-1 col-md-1 col-lg-1"><c:out value="${vo.readCnt }"></c:out></td>
        </tr>  
            </c:forEach>
          </c:when>
          <c:otherwise>
            <tr>
              <td class="text-center col-sm-12 col-md-12 col-lg-12" colspan="99">
                No data found
              </td>
            </tr>
          </c:otherwise>
        </c:choose>
      </tbody>
    </table>
    </div>
    <!-- 테이블 목록 -------------------------------------------------------------->
    <!-- 페이징 -->
    <div class="text-center">
			<nav>
			  <ul class="pagination">
			    <li>
			      <a href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li>
			      <a href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>    
    </div>
    <!-- 페이징--- -------------------------------------------------------------->    
  </div>   
  <!-- div container ---------------------------------------------------------->
       
</body>
</html>


















