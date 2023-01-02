<%--
/**
  Class Name: naver_search_list.jsp
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
<meta charset="UTF-8">
<title>게시목록</title>
<script >
  $(document).ready(function(){
	  console.log("document.ready");
	  //tableView제어
	  initTableView();
	  
	  $("#doRetrive").on("click",function(){
		  console.log("doRetrive");
		  doRetrive(1);
	  });
	  
    //검색어 enter event
    $("#searchWord").on("keypress",function(e){
      
      if(13==e.which){
        e.preventDefault();
        doRetrive(1);
      }
      
    });	  
  });
  
  //table view제어
  function initTableView(){
	  if("10" == $('#searchDiv').val()){
		  $("#blogTable").css("display","");
		  $("#newsTable").css("display","none");
		  $("#bookTable").css("display","none");
	  }else if("20" == $('#searchDiv').val()){
      $("#blogTable").css("display","none");
      $("#newsTable").css("display","");		
      $("#bookTable").css("display","none");
	  }else if("30" == $('#searchDiv').val()){
      $("#blogTable").css("display","none");
      $("#newsTable").css("display","none");    
      $("#bookTable").css("display","");		  
	  }
  }
  
  //기존 데이터 삭제
  function initTable(){
      $("#blogTable>tbody").empty();        
      $("#newsTable>tbody").empty();	 
      $("#bookTable>tbody").empty();
  }
  
  function setTableData(htmlData){
      //데이터 출력
      if("10" == $('#searchDiv').val()){
        $("#blogTable>tbody").append(htmlData);
      }else if("20" == $('#searchDiv').val()){
        $("#newsTable>tbody").append(htmlData);
      }else if("30" == $('#searchDiv').val()){
        $("#bookTable>tbody").append(htmlData);
      }	  
  }
  
  function doRetrive(page){
	    let method  ="GET";
	    let url     ="/naver/doNaverSearch.do";
	    let async   =true;
	    
	    let params  = {
	            searchDiv  : $('#searchDiv').val(),
	            searchWord : $('#searchWord').val(),
	            pageSize : $('#pageSize').val(),
	            pageNo:page       
	        };	 
	    
	    PClass.callAjax(method,url,async,params,function(data){
	    	console.log(data);
	    	//javascript Object변환
	    	let parsedJson = JSON.parse(data);
	    	
	    	let htmlData = "";
	    	
	    	//기존 데이터 삭제
	    	initTable();
	    	
	      //검색 조건에 따라 table view 제어
	      initTableView();
	      
	      
	      if(null != parsedJson && parsedJson.items.length  > 0){
	    	    //blog
	    	    if("10" == $('#searchDiv').val()){
		          $.each(parsedJson.items,function(index,value){
		        	    index = index+1;
		        	    //console.log("index:"+index);
		        	    let formatDate=eUtil.toFormatDateString(value.postdate,'.');
		              htmlData += "<tr>";       
		              htmlData += "    <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+<c:out value='index'/>+"</td>";    
		              htmlData += "    <td class='text-left   col-sm-6 col-md-6 col-lg-8'>"+<c:out value='value.title'/>+"</td>";
		              htmlData += "    <td class='text-center col-sm-2 col-md-2 col-lg-1'>"+<c:out value='value.bloggername'/>+"</td>";
		              htmlData += "    <td class='text-center col-sm-2 col-md-2 col-lg-1'>"+<c:out value='formatDate'/>+"</td>";
		              htmlData += "    <td class='text-center col-sm-1 col-md-1 col-lg-1'><a href='"+<c:out value='value.link'/>+"'>Link</a></td>";           
		              htmlData += "</tr>";
		              
		          });
		        //news  
	    	    }else if("20" == $('#searchDiv').val()){
	                $.each(parsedJson.items,function(index,value){
	                    index = index+1;
	                    //console.log("index:"+index);
	                    //let formatDate=eUtil.toFormatDateString(value.pubDate,'/');
	                    htmlData += "<tr>";       
	                    htmlData += "    <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+<c:out value='index'/>+"</td>";    
	                    htmlData += "    <td class='text-left   col-sm-6 col-md-6 col-lg-8'>"+<c:out value='value.title'/>+"</td>";
	                    htmlData += "    <td class='text-center col-sm-2 col-md-2 col-lg-1'>"+<c:out value='value.description'/>+"</td>";
	                    htmlData += "    <td class='text-center col-sm-2 col-md-2 col-lg-1'>"+<c:out value='value.pubDate'/>+"</td>";
	                    htmlData += "    <td class='text-center col-sm-1 col-md-1 col-lg-1'><a href='"+<c:out value='value.link'/>+"'>Link</a></td>";           
	                    htmlData += "</tr>";
	                    
	                });	    	    	
	    	    	
	    	    //book	
	    	    }else if("30" == $('#searchDiv').val()){
	                  $.each(parsedJson.items,function(index,value){
	                      index = index+1;
	                      //console.log("index:"+index);
	                      //let formatDate=eUtil.toFormatDateString(value.pubDate,'/');
	                      htmlData += "<tr>";       
	                      htmlData += "    <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+<c:out value='index'/>+"</td>";    
	                      htmlData += "    <td class='text-left   col-sm-6 col-md-6 col-lg-8'>"+<c:out value='value.title'/>+"</td>";
	                      htmlData += "    <td class='text-center col-sm-2 col-md-2 col-lg-1'>"+<c:out value='value.author'/>+"</td>";
	                      htmlData += "    <td class='text-center col-sm-2 col-md-2 col-lg-1'><img alt='도서' src='"+<c:out value='value.image'/>+"'/></td>";
	                      htmlData += "    <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+<c:out value='value.publisher'/>+"</td>"; 
	                      htmlData += "</tr>";
	                      
	                  }); 	    	    	
	    	    }
	            
	      }else{
	          htmlData += "<tr>";
	          htmlData += "  <td class='text-center col-sm-12 col-md-12 col-lg-12' colspan='99'>";
	          htmlData += "   No data found ";
	          htmlData += "  </td>";
	          htmlData += "</tr>";
	      }          
	      
	      setTableData(htmlData);
	      
	    });
	    
  }
  
  

  
</script>

</head>
<body>
  <!-- div container -->   
  <div class="container">   
    <!-- 제목 -->
    <div class="page-header">
       <h2>네이버 검색</h2>
    </div>
    <!-- 제목 ------------------------------------------------------------------->
    
    <!-- 검색 : 검색구분(select) 검색어(input) 페이지 사이즈(select)--> 
    <form action="#" class="form-inline text-right">
      <div class="form-group">
				<select class="form-control input-sm" name="searchDiv" id="searchDiv">
				  <option value="10">블로그</option>
				  <option value="20">뉴스</option>
				  <option value="30">책</option>
				  <option value="40">카페</option>
				  <option value="50">쇼핑</option>
				</select>
				<input type="text" class="form-control input-sm" name="searchWord" id="searchWord"
				placeholder="검색어를 입력하세요">
        <select class="form-control input-sm" name="pageSize" id="pageSize">
          <option value="10">10</option>
          <option value="20">20</option>
          <option value="30">30</option>
          <option value="50">50</option>
          <option value="100">100</option>
        </select>
        <input type="button" class="btn btn-primary btn-sm" 
        value="조회" id="doRetrive">		      
      </div>
    </form> 
    <!-- 검색 ------------------------------------------------------------------->
    
    <!-- 테이블 목록 -->
    <div class="table-responsive">
    <!-- blog table -->
    <table id="blogTable" class="table table-striped table-bordered table-hover">
      <thead class="bg-primary">
        <tr>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
          <th class="text-center col-sm-6 col-md-6 col-lg-8">제목</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">작성자</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">등록일</th>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">URL</th>
        </tr>
      </thead>
      <tbody>
             
      </tbody>
    </table>
    <!-- blog table ----------------------------------------------------------->
    
    <!-- news table -->
    <table id="newsTable" class="table table-striped table-bordered table-hover">
      <thead class="bg-primary">
        <tr>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
          <th class="text-center col-sm-6 col-md-6 col-lg-8">제목</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">요약</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">등록일</th>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">URL</th>
        </tr>
      </thead>
      <tbody>
             
      </tbody>
    </table>
    <!-- news table ----------------------------------------------------------->
        
    <!-- book table -->
    <table id="bookTable" class="table table-striped table-bordered table-hover">
      <thead class="bg-primary">
        <tr>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
          <th class="text-center col-sm-6 col-md-6 col-lg-8">책제목</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">저자</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-1">이미지</th>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">출판사</th>
        </tr>
      </thead>
      <tbody>
             
      </tbody>
    </table>
    <!-- news table ----------------------------------------------------------->
             
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


















