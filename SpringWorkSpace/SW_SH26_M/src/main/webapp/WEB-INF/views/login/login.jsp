<%--
/**
  Class Name:login.jsp
  Description: 로그인
  
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
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<title>로그인</title>
<script >
  $(document).ready(function(){
	  console.log("document.ready");
	  
	  $("#changeEn").on("click",function(e){
		    let method = "GET";
	      let url    = "/login/doLogin.do";
	      let async  = true;
	      let params = {
	          "lang" : "en"
	      };
	      
	      PClass.callAjax(method,url,async,params,function(data){		  
	    	  //console.log(data);
	    	  let parsedJson = JSON.parse(data);
	    	  if(null != parsedJson){
	    		  alert(parsedJson.msgContents);
	    		  //화면 refresh
	    		  window.location.reload();
	    	  } 
	      });  
	  });
	  
	    $("#changeKo").on("click",function(e){
	        let method = "GET";
	        let url    = "/login/doLogin.do";
	        let async  = true;
	        let params = {
	            "lang" : "ko"
	        };
	        
	        PClass.callAjax(method,url,async,params,function(data){     
	          //console.log(data);
	          let parsedJson = JSON.parse(data);
	          if(null != parsedJson){
	            alert(parsedJson.msgContents);
	            //화면 refresh
	            window.location.reload();	            
	          } 
	        });  
	    });
	    
	  $("#passwd").on("keypress",function(e){
	      
	      if(13==e.which){
	        e.preventDefault();
	        //event trigger발생
	        $('#doLogin').trigger('click');
	      }
	      
	    });
	  
	  
	  $("#doLogin").on("click",function(){
		  console.log("doLogin");
		  
		  if(confirm('로그인 하시겠습니까?')==false)return;
		  
		  let method = "POST";
		  let url    = "/login/doLogin.do";
		  let async  = true;
		  let params = {
				  "uId" : $("#uId").val(),
				  "passwd": $("#passwd").val()
		  };
		  
		  PClass.callAjax(method,url,async,params,function(data){
			  console.log("data:"+data);
			  let parsedJson = JSON.parse(data);
			  //id입력 확인
			  if("40" == parsedJson.msgId){
				  alert(parsedJson.msgContents);
				  $("#uId").focus();
				  return;
			  }
			  
			  //비번입력 확인
        if("50" == parsedJson.msgId){
            alert(parsedJson.msgContents);
            $("#passwd").focus();
            return;
        }
			  
			  //------------------------------------------
			  //id존재 체크
			  if("10" == parsedJson.msgId){
				  alert(parsedJson.msgContents);
				  $("#uId").focus();
				  return;
			  }
			  
			  //비번 체크
			  if("20" == parsedJson.msgId){
				  alert(parsedJson.msgContents);
				  $("#passwd").focus();
		      return;
			  }
			  
			  //로그인 성공
		    if("30" == parsedJson.msgId){			  
		    	alert(parsedJson.msgContents);
		    	
		    	//TODO: main.jsp
		    	window.location.href = "${CP}/user/view.do";
		    }
        
		  });
		  
		  
		//doLogin  
	  });
	  
	//document  
  });
</script>

</head>
<body>
  <!-- div container -->   
  <div class="container">
    <!-- 제목 -->
    <div class="page-header">
       <h2><spring:message code="message.user.login.title"/></h2>
    </div>
    <!-- 제목 ------------------------------------------------------------------->
    
    <!--버튼  -->

    <!--버튼 -------------------------------------------------------------------->
    <!-- 영어, 한글 -->
    <h3>
	    <a href="#" id="changeEn">
	      <spring:message code="message.cmn.language.en"/>
	    </a>
	    <a href="#" id="changeKo">
	      <spring:message code="message.cmn.language.ko"/>
	    </a>
    </h3>     
    <!-- 폼 -->
    <form action="#" class="form-inline ">   
	    <div class="form-group">
		    <input type="text" class="form-control" id="uId" name="uId" placeholder="<spring:message code='message.user.login.id'/>" maxlength="20">
	    </div>
      <div class="form-group">
        <input type="password" class="form-control" id="passwd" name="passwd" placeholder="<spring:message code='message.user.login.password'/>" maxlength="50">
      </div>
      <div class="form-group">
        <input type="button" class="btn btn-primary btn-sm" value="<spring:message code='message.user.login.title'/>" id="doLogin">
      </div>     	    
    </form>
    <!--폼   -------------------------------------------------------------------->
  </div>   
  <!-- div container ---------------------------------------------------------->
     
     
     
</body>
</html>





















