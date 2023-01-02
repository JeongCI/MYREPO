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
<%-- <link rel="stylesheet" href="${CP_RES}/css/bootstrap.min.css"> --%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<!-- jQuery -->
<script src="${CP_RES}/js/jquery-1.12.4.js"></script>
<!-- callAjax -->
<script src="${CP_RES}/js/callAjax.js"></script>

<!-- bootstrap js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<%-- <script src="${CP_RES}/js/bootstrap.min.js"></script> --%>
<meta charset="UTF-8">
<title>회원관리</title>
<script >

  $(document).ready(function(){
     console.log("document.ready");
    
    //textinput에 숫자만 입력 처리
    $(".numberOnly").on("keyup",function(e){
    	console.log(""+$(this).val());
    	
    	$(this).val(   $(this).val().replace(/[^0-9]/g,"")   );
    });     
     
    //검색어 enter 
    $("#searchWord").on("keypress",function(e){
    	console.log(e.type + ": " +  e.which );
    	if(13 ==e.which ){
    		e.preventDefault();
    		doRetrieve(1);
    	}
    //searchWord    	
    });
     
    

    
    //조회
    $("#doRetrive").on("click",function(e){
    	console.log("doRetrive");
    	
    	let method ="GET";
    	let url    ="/user/doRetrive.do";
    	let async  = true;
    	let params = {
    			searchDiv : $("#searchDiv").val(),
    			searchWord: $("#searchWord").val(),
    			pageSize : $("#pageSize").val(),
    			pageNo: 1
    	};     
    	
    	PClass.callAjax(method,url,async,params,function(data){
            console.log("data:"+data);
            //JSON.parse() 메서드는 JSON 문자열의 구문을 분석하고, 그 결과에서 JavaScript 값이나 객체를 생성합니다.
            let parsedJson = JSON.parse(data);
            
            let htmlData = "";
            //table 데이터 삭제  
            $("#userTable>tbody").empty();
            
            if(null !=parsedJson && parsedJson.length > 0 ){
              $.each(parsedJson,function(index,value){
                  console.log(index+","+value.uId);
                  htmlData +=" <tr>";                                                                  
                  htmlData +="   <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+value.num  +"</td>";
                  htmlData +="   <td class='text-left   col-sm-2 col-md-2 col-lg-2'>"+value.uId  +"</td>";
                  htmlData +="   <td class='text-left   col-sm-2 col-md-2 col-lg-2'>"+value.name +"</td>";
                  htmlData +="   <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.level+"</td>";
                  htmlData +="   <td class='text-left   col-sm-3 col-md-3 col-lg-3'>"+value.email+"</td>";
                  htmlData +="   <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.regDt+"</td>";
                  htmlData +=" </tr>";                  
              });
            //데이터가 없는 경우    
            }else{
              htmlData +=" <tr>"; 
              htmlData +="   <td colspan='99' class='text-center  col-sm-12 col-md-12 col-lg-12'>no data found</td>";
              htmlData +=" </tr>";
            }
              
            //table 데이터 출력
            $("#userTable>tbody").append(htmlData);
            
        //PClass.callAjax  
        });
    	
    //doRetrive	
    });
  
  //document  
  });
  
  
  function doRetrieve(page){
      console.log("doRetrive");
        //location.pathname
        let method ="GET";
        let url    ="/user/doRetrive.do";
        let async  = true;
        let params = {
            searchDiv : $("#searchDiv").val(),
            searchWord: $("#searchWord").val(),
            pageSize : $("#pageSize").val(),
            pageNo: page
        };     
        
        PClass.callAjax(method,url,async,params,function(data){
        	  console.log("data:"+data);
            //JSON.parse() 메서드는 JSON 문자열의 구문을 분석하고, 그 결과에서 JavaScript 값이나 객체를 생성합니다.
            let parsedJson = JSON.parse(data);
            
            let htmlData = "";
            //table 데이터 삭제  
            $("#userTable>tbody").empty();
            
            if(null !=parsedJson && parsedJson.length > 0 ){
              $.each(parsedJson,function(index,value){
                  console.log(index+","+value.uId);
                  htmlData +=" <tr>";                                                                  
                  htmlData +="   <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+value.num  +"</td>";
                  htmlData +="   <td class='text-left   col-sm-2 col-md-2 col-lg-2'>"+value.uId  +"</td>";
                  htmlData +="   <td class='text-left   col-sm-2 col-md-2 col-lg-2'>"+value.name +"</td>";
                  htmlData +="   <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.level+"</td>";
                  htmlData +="   <td class='text-left   col-sm-3 col-md-3 col-lg-3'>"+value.email+"</td>";
                  htmlData +="   <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.regDt+"</td>";
                  htmlData +=" </tr>";                  
              });
            //데이터가 없는 경우    
            }else{
              htmlData +=" <tr>"; 
              htmlData +="   <td colspan='99' class='text-center  col-sm-12 col-md-12 col-lg-12'>no data found</td>";
              htmlData +=" </tr>";
            }
              
            //table 데이터 출력
            $("#userTable>tbody").append(htmlData);
        	
        });
      
    }
    
  
    
  
</script>

</head>
<body>
  <!-- div container -->     
  <div class="container text-center border">   
  <div class="row align-items-start border">
    <div class="col">
         제목
    </div>  
  </div>
  <div class=" d-flex justify-content-between border">
    <!-- 검색 : 검색구분(select) 검색어(input) 페이지 사이즈(select)--> 
    <form action="#" class="row col-10 border">
      <div class="col-3">
        <select class="form-control input-sm" name="searchDiv" id="searchDiv">
          <option value="">전체</option>
          <option value="10">아이디</option>
          <option value="20">이름</option>
          <option value="30">이메일</option>
        </select>
      </div>
      <div class="col-6">  
        <input type="text" class="form-control input-sm" name="searchWord" id="searchWord" placeholder="검색어를 입력하세요">
      </div> 
      <div class="col-3">   
        <select class="form-control input-sm" name="pageSize" id="pageSize">
          <option value="10">10</option>
          <option value="20">20</option>
          <option value="30">30</option>   
          <option value="50">50</option>
          <option value="100">100</option>  
        </select>        
      </div>   
    </form> 
    <!-- 검색 ------------------------------------------------------------------->
    <div class="d-flex justify-content-end col-2   border">
        <input type="button" class="btn btn-primary btn-md" value="조회" id="doRetrive">  
    </div>
  </div>
  <div class="row align-items-start border ">
    <table class="table table-striped table-bordered table-hover" id="userTable">
      <thead class="bg-primary text-white">
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
      </tbody>  
    </table>
    <!-- 테이블 목록 -------------------------------------------------------------->
  </div>
    
  
  </div>    
  <!-- div container ---------------------------------------------------------->
       
</body>
</html>


















