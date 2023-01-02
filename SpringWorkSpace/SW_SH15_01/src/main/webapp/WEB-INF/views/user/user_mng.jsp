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

<!-- ajax -->
<script src="${CP_RES}/js/callAjax.js"}></script>

<!-- bootstrap js -->
<script src="${CP_RES}/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>회원 관리</title>
<script>

  $(document).ready(function(){
    //console.log("document.ready");
    $(".numberOnly").on("keydown",function(e){
    	$(this).val($(this).val().replace(/[^0-9]/g,""));
    });
    
    //검색어 enter
    $("#searchWord").on("keydown",function(e){
    	//console.log(e.type + ": " + e.which);
    	if(13 == e.which) {
    	  e.preventDefault();
    	  doRetrieve(1);
    	}
    });

  //조회
  $("#doRetrieve").on("click",function(e){
    //console.log("click");
    let method = "GET";
    let url    = "/user/doRetrieve.do";
    let async  = true;
    let params  = {
        pageSize : $("#pageSize").val(),
        searchDiv: $("#searchDiv").val(),
        searchWord: $("#searchWord").val(),
        pageNo   : 1
    };
    PClass.callAjax(method,url,async,params,function(data){
        //console.log(data);
        let parsedJson = JSON.parse(data);
        
        let htmlData ="";
        //table 데이터 삭제
        $("#userTable>tbody").empty();
        
        if(null != parsedJson && parsedJson.length > 0) {
          $.each(parsedJson,function(index, value){
            //console.log(index+", "+value.uId);
            htmlData +="<tr>                                                                   ";
            htmlData +="  <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+value.num+"</td>  ";
            htmlData +="  <td class='text-left col-sm-2 col-md-2 col-lg-2'>"+value.uId+"</td>    ";
            htmlData +="  <td class='text-left col-sm-2 col-md-2 col-lg-2'>"+value.name+"</td>   ";
            htmlData +="  <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.level+"</td>";
            htmlData +="  <td class='text-left col-sm-3 col-md-3 col-lg-3'>"+value.email+"</td>  ";
            htmlData +="  <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.regDt+"</td>";
            htmlData +="</tr>                                                                  ";
          });
        } else {
            htmlData +="<tr>                                                                   ";
            htmlData +="  <td  colspan = '99' class='text-center col-sm-12 col-md-12 col-lg-12'>Have No Data</td>  ";
            htmlData +="</tr>                                                                  ";
        }
         $("#userTable>tbody").append(htmlData);
      //PClass.callAjax End
      });
    
    //doRetrieve End
    });
  
  //document End
  });
  
  function doRetrieve(page){
      console.log("doRetrieve");
      let method = "GET";
      let url    = "/user/doRetrieve.do";
      let async  = true;
      let params  = {
          pageSize : $("#pageSize").val(),
          searchDiv: $("#searchDiv").val(),
          searchWord: $("#searchWord").val(),
          pageNo   : page
      };
      PClass.callAjax(method,url,async,params,function(data){
        //console.log(data);
        let parsedJson = JSON.parse(data);
        
        let htmlData ="";
        //table 데이터 삭제
        $("#userTable>tbody").empty();
        
        if(null != parsedJson && parsedJson.length > 0) {
          $.each(parsedJson,function(index, value){
            //console.log(index+", "+value.uId);
            htmlData +="<tr>                                                                   ";
            htmlData +="  <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+value.num+"</td>  ";
            htmlData +="  <td class='text-left col-sm-2 col-md-2 col-lg-2'>"+value.uId+"</td>    ";
            htmlData +="  <td class='text-left col-sm-2 col-md-2 col-lg-2'>"+value.name+"</td>   ";
            htmlData +="  <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.level+"</td>";
            htmlData +="  <td class='text-left col-sm-3 col-md-3 col-lg-3'>"+value.email+"</td>  ";
            htmlData +="  <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.regDt+"</td>";
            htmlData +="</tr>                                                                  ";
          });
        } else {
            htmlData +="<tr>                                                                   ";
            htmlData +="  <td  colspan = '99' class='text-center col-sm-12 col-md-12 col-lg-12'>Have No Data</td>  ";
            htmlData +="</tr>                                                                  ";
        }
         $("#userTable>tbody").append(htmlData);        
      });
  }
  
</script>

</head>
<body>
     <!-- div container -->
     <div class="container">
     <!-- 제목 -->
      <div class="page--header">
       <h2>회원 관리</h2>
      </div> 
     <!-- 제목 end --------------------------------------------------------------> 
              
     <!-- 검색: 검색 구분(select), 검색어(input), 페이지 사이즈(select),  -->
     <form action="#" class="form-inline text-right">
     <div class="from-group">
      <select class="form-control input-sm" name="searchDiv" id="searchDiv">
        <option value="">전체</option>
        <option value="10">아이디</option>
        <option value="20">이름</option>
        <option value="30">이메일</option>
      </select>
      <input type="text" class="form-control input-sm" name="searchWord" id="searchWord" placeholder="검색어를 입력하세요">
      <select class="form-control input-sm" name="pageSize" id="pageSize">
        <option value="10">10</option>
        <option value="20">20</option>
        <option value="30">30</option>
        <option value="50">50</option>
        <option value="100">100</option>
      </select>    
      <input type="button" class="btn btn-primary btn-sm" value ="조회" id="doRetrieve">  
     </div>
     </form>
     <!-- 검색 영역  end ---------------------------------------------------------->
     
     <!-- 테이블 목록 -->
     <div class="table-responsive">
     <table class="table table-striped table-bordered table-hover" id="userTable">
      <thead class="bg-primary">
        <tr>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-2">아이디</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-2">이름</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-2">등급</th>
          <th class="text-center col-sm-3 col-md-3 col-lg-3">이메일</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-2">등록일</th>
        </tr>
      </thead>
        <tbody>
        <tr>
          <td class="text-center col-sm-1 col-md-1 col-lg-1"></td>
          <td class="text-left col-sm-2 col-md-2 col-lg-2"></td>
          <td class="text-left col-sm-2 col-md-2 col-lg-2"></td>
          <td class="text-center col-sm-2 col-md-2 col-lg-2"></td>
          <td class="text-left col-sm-3 col-md-3 col-lg-3"></td>
          <td class="text-center col-sm-2 col-md-2 col-lg-2"></td>
        </tr>     
        </tbody>        
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
     
     <!-- 관리: 등록, 수정, 삭제 -->
     <div class="container">
     <!-- 버튼 -->
     <div class="row text-right">
	      <label for="inputEmail3" class="col-sm-2 col-md-2 col-lg-2 control-label"></label>
	      <div class="col-sm-10 col-md-10 col-lg-10">
		      <input type="button" class="btn btn-primary btn-sm" value ="초기화">
		      <input type="button" class="btn btn-primary btn-sm" value ="등록">
		      <input type="button" class="btn btn-primary btn-sm" value ="삭제">
		      <input type="button" class="btn btn-primary btn-sm" value ="수정">
        </div>
     </div>
     <!-- 버튼 end -------------------------------------------------------------->
     
     <!-- 폼 -->
     <form action="#" class="form-horizontal">
     <div class="form-group">
       <label for="uId" class="col-sm-2 col-md-2 col-lg-2 control-label">아이디</label>
       <div class="col-sm-10 col-md-10 col-lg-10">
         <input type="text" class="form-control" id="uId" name="uId" maxlength="20" placeholder="아이디를 입력하세요.">
       </div>
       
     </div>
     <div class="form-group">
       <label for="name" class="col-sm-2 col-md-2 col-lg-2 control-label">이름</label>
       <div class="col-sm-10 col-md-10 col-lg-10">
         <input type="text" class="form-control" id="name" name="name" maxlength="20" placeholder="이름을 입력하세요.">
       </div>
     </div>
     
     <div class="form-group">
       <label for="passwd" class="col-sm-2 col-md-2 col-lg-2 control-label">비밀번호</label>
       <div class="col-sm-10 col-md-10 col-lg-10">
         <input type="password" class="form-control" id="passwd" name="passwd" maxlength="50" placeholder="비밀번호를 입력하세요.">
       </div>
     </div>
     
     <div class="form-group">
       <label for="intLevel" class="col-sm-2 col-md-2 col-lg-2 control-label">등급</label>
       <div class="col-sm-10 col-md-10 col-lg-10">
         <select class="form-control" id="intLevel" name="intLevel">
            <option value="1">BASIC</option>
            <option value="2">SILVER</option>
            <option value="3">GOLD</option>
         </select>
        </div>
       </div>
     
     <div class="form-group">
       <label for="login" class="col-sm-2 col-md-2 col-lg-2 control-label">로그인</label>
       <div class="col-sm-10 col-md-10 col-lg-10">
         <input type="text" class="form-control numberOnly" id="login" name="login" maxlength="8" placeholder="로그인을 입력하세요.">
       </div>
     </div>
     
     <div class="form-group">
       <label for="recommend" class="col-sm-2 col-md-2 col-lg-2 control-label">추천</label>
       <div class="col-sm-10 col-md-10 col-lg-10">
         <input type="text" class="form-control numberOnly" id="recommend" name="recommend" maxlength="8" placeholder="추천을 입력하세요.">
       </div>
     </div>
     
     <div class="form-group">
       <label for="email" class="col-sm-2 col-md-2 col-lg-2 control-label">이메일</label>
       <div class="col-sm-10 col-md-10 col-lg-10">
         <input type="email" class="form-control" id="email" name="email" maxlength="320" placeholder="이메일을 입력하세요.">
       </div>
     </div>
     
     <div class="form-group">
       <label for="regDt" class="col-sm-2 col-md-2 col-lg-2 control-label">등록일</label>
       <div class="col-sm-10 col-md-10 col-lg-10">
         <input type="text" class="form-control" id="regDt" name="regDt" readonly="readonly" placeholder="등록일을 입력하세요.">
       </div>
     </div>
            
     </div>
           
     </form>
     <!-- 폼 End --------------------------------------------------------------->
     </div>
     <!-- div container end --------------------------------------------------->
     </div>
</body>
</html>