<%--
/**
  Class Name: user_mng.jsp
  Description: 회원관리
  
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
<title>회원관리</title>
<script >

  //ID중복체크:)
  //다건처리: 화면에서 회원ID를 전달,List<String>회원ID,Service. upDeleteAll(List<String>)
  //등업:
  //예외처리:)
  
  
  $(document).ready(function(){
     console.log("document.ready");
     doRetrieve(1);
     
     //다건삭제
     $("#upDeleteAll").on("click",function(){
    	 let uIdArray = [];
    	 
    	 $("input:checkbox[name=chk]").each(function(i,element){
    		 
    		 //체크된것들은 uIdArray추가
    		 if($(this).is(":checked")==true){
    			 console.log($(this).val());
    			 uIdArray.push($(this).val());
    		 }
    	 });
    	 
    	 
       let uIdString = "";
       if(uIdArray.length>0){
    	   uIdString = uIdArray.toString();
    	   console.log("uIdString:"+uIdString);
       }else{
    	   alert("삭제할 자료를 선택 하세요.");
    	   return;
    	   
       }  
        
       if(false==confirm("삭제 하시겠습니까?\n("+uIdString+")" ) )return;
         
       let method =  "POST";
       let url    =  "/user/upDeleteAll.do";
       let async  =  true;
       let params = { "userId":uIdString};
    	 
       PClass.callAjax(method,url,async,params,function(data){
           console.log("data:"+data);
           let parsedJson = JSON.parse(data);
           //다건삭제 성공
           if("0" != parsedJson.msgId){
        	     alert(parsedJson.msgContents);
               doRetrieve(1);
               //입력 항목 초기화
               //아이디: enabled
               //등록버튼:enabled
               initControll();                 	 
        	 //실패  
           }else{
        	   alert(parsedJson.msgId+","+parsedJson.msgContents);
        	   
           }
    	   
       });
     //다건삭제	 
     });
     
     //전체 선택/해제
     $("#checkAll").on("click",function(){
    	 console.log("#checkAll");
    	 //chk
    	 //전체 체크
    	 if( $("#checkAll").is(":checked") == true ){
    		 $("input[name=chk]").prop("checked",true);
    	 //체크 해제	 
    	 }else{
    		 $("input[name=chk]").prop("checked",false);
    	 }
    	 
     });
     
     //id중복체크   
     $("#idCheck").on("click",function(){
    	  console.log("#idCheck");
     
    	  //id값 
    	  if(eUtil.ISEmpty( $("#uId").val() ) == true){
    		  alert("아이디를 입력하세요.");
    		  $("#uId").focus();
    		  return;
    	  }
    	  
    	  let method = "GET";
    	  let url    = "/user/idCheck.do";
    	  let async  = true;
    	  let params = {"uId": $("#uId").val()};
    	  
    	  PClass.callAjax(method,url,async,params,function(data){
    		  console.log("data:"+data);
    		  
    		  let parsedJson = JSON.parse(data);
    		  //id사용 가능
    		  if("0" == parsedJson.msgId){
    			  alert(parsedJson.msgContents);
    			  $("#idCheckYN").val("1");
    			  
    			  //아이디는 PK로 활성화
    		    $("#uId").prop("disabled",true);
    			//id중복  
    		  }else{
    			  alert(parsedJson.msgContents);
    			  $("#idCheckYN").val("0");
    		  }
    		  
    		  
    	  });
    	  
     //id중복체크	 
     });
     
     
     //등록
     $("#add").on("click",function(){
    	    console.log("#add");
          if(eUtil.ISEmpty( $("#uId").val() ) == true){
             alert("아이디를 입력 하세요.");
             $("#uId").focus();
             return;
           }
           
          //$("#idCheckYN").val("0");          
          if(eUtil.ISEmpty( $("#idCheckYN").val() ) == true){
        	  alert("아이디중복 체크 해주세요.");
        	  $("#idCheck").focus();
        	  return;
          }
          
          if($("#idCheckYN").val() == "0"){
              alert("아이디중복 체크  해주세요.");
              $("#idCheck").focus();
              return;
          }
          
          
          if(eUtil.ISEmpty( $("#name").val() ) == true){
               alert("이름을 입력 하세요.");
               $("#name").focus();
               return;
          }       

           if(eUtil.ISEmpty( $("#passwd").val() ) == true){
               alert("비번을 입력 하세요.");
               $("#passwd").focus();
               return;
           }
           
           if(eUtil.ISEmpty( $("#login").val() ) == true){
               alert("로그인을 입력 하세요.");
               $("#login").focus();
               return;
           } 
           
           if(eUtil.ISEmpty( $("#recommend").val() ) == true){
               alert("추천을 입력 하세요.");
               $("#recommend").focus();
               return;
           }
           
           if(eUtil.ISEmpty( $("#email").val() ) == true){
               alert("이메일을 입력 하세요.");
               $("#email").focus();
               return;
           }       
           
           if(confirm("등록 하시겠습니까?")==false)return;
           
           let method = "POST";
           let url    = "/user/add.do";
           let async  = true;
           let params = {
               "uId"      : $("#uId").val(),
               "name"     : $("#name").val(),
               "passwd"   : $("#passwd").val(),
               "intLevel" : $("#intLevel").val(),
               "login"    : $("#login").val(),
               "recommend": $("#recommend").val(),
               "email"    : $("#email").val()
           };
           
           PClass.callAjax(method,url,async,params,function(data){
        	   console.log("data:"+data);
        	   let parsedJson = JSON.parse(data);
        	   
        	   if("1" == parsedJson.msgId){
       	          alert(parsedJson.msgContents);
       	          doRetrieve(1);
       	          //입력 항목 초기화
       	          //아이디: enabled
       	          //등록버튼:enabled
       	          initControll();          		   
        	   }else{
        		   alert(parsedJson.msgId+","+parsedJson.msgContents);
        	   }
        	   
           });           
     //등록	 
     });
     
     //수정
     $("#doUpdate").on("click",function(){
    	 console.log("#doUpdate");
    	 
    	 
    	 if(eUtil.ISEmpty( $("#uId").val() ) == true){
    		 alert("아이디를 입력 하세요.");
    		 $("#uId").focus();
    		 return;
    	 }
    	 
       if(eUtil.ISEmpty( $("#name").val() ) == true){
           alert("이름을 입력 하세요.");
           $("#name").focus();
           return;
       }    	 

       if(eUtil.ISEmpty( $("#passwd").val() ) == true){
           alert("비번을 입력 하세요.");
           $("#passwd").focus();
           return;
       }
       
       if(eUtil.ISEmpty( $("#login").val() ) == true){
           alert("로그인을 입력 하세요.");
           $("#login").focus();
           return;
       } 
       
       if(eUtil.ISEmpty( $("#recommend").val() ) == true){
           alert("추천을 입력 하세요.");
           $("#recommend").focus();
           return;
       }
       
       if(eUtil.ISEmpty( $("#email").val() ) == true){
           alert("이메일을 입력 하세요.");
           $("#email").focus();
           return;
       }       
       
       if(confirm("수정 하시겠습니까?")==false)return;
       
       let method = "POST";
       let url    = "/user/doUpdate.do";
       let async  = true;
       let params = {
    		   "uId"      : $("#uId").val(),
    		   "name"     : $("#name").val(),
    		   "passwd"   : $("#passwd").val(),
    		   "intLevel" : $("#intLevel").val(),
    		   "login"    : $("#login").val(),
    		   "recommend": $("#recommend").val(),
    		   "email"    : $("#email").val()
       };
       
       PClass.callAjax(method,url,async,params,function(data){
    	   console.log("data:"+data);
    	   //JSON.parse() 메서드는 JSON 문자열의 구문을 분석하고, 그 결과에서 JavaScript 값이나 객체를 생성합니다.
    	   let parsedJson = JSON.parse(data);
    	   
    	   if("1" == parsedJson.msgId){
    		   alert(parsedJson.msgContents);
    		   doRetrieve(1);
    		   initControll();
    		   $("#searchWord").focus();
    	   }else{
    		   
    		   alert(parsedJson.msgId+","+parsedJson.msgContents);
    	   }
    	   
       });
       
       
       
     //수정	 
     });
     
    //초기화: 최초화면 로딩 상태로 컨트롤 상태로 처리
    //button모두 enable,uId enable
    //데이터 초기화
     $("#initBtn").on("click",function(){
    	 console.log("#initBtn");
       //초기화	 
       initControll(); 
         
     }); 
    
    //삭제
    $("#doDelete").on("click",function(){
    	console.log("#doDelete");
    	
    	if(eUtil.ISEmpty($("#uId").val()) == true){
	    		alert("아이디를 입력 하세요.");
	    		$("#uId").focus();
	    		return;
    	}
    	
    	let method = "GET";
    	let url    = "/user/doDelete.do";
    	let async  = true;
    	let params = {"uId":$("#uId").val()};
    	
    	if(confirm("삭제 하시겠습니까?")==false)return;
    	
    	PClass.callAjax(method,url,async,params,function(data){
    		console.log("data:"+data);
    		let parsedJson = JSON.parse(data);
    		
    		if("1" == parsedJson.msgId){
    			alert(parsedJson.msgContents);
    			doRetrieve(1);
    			//입력 항목 초기화
    			//아이디: enabled
    			//등록버튼:enabled
    			initControll();    			
    			
    		}else{
    			alert(parsedJson.msgId+","+parsedJson.msgContents);
    		}
    		
    		
    	});
    //삭제	
    });
     
    //테이블 데이터 click
    $("#userTable>tbody").on("click","tr",function(e){
    	//console.log("#userTable>tbody"+$(this).html());
    	let tdArray = $(this).children();
    	let uId = tdArray.eq(2).text();
    	
    	console.log("uId:"+uId);
    	
    	let method = "GET";
    	let url    = "/user/doSelectOne.do";
    	let async  = true;
    	let params = {"uId":uId}
    	PClass.callAjax(method,url,async,params,function(data){
    		console.log("data:"+data);
    		let parsedJson = JSON.parse(data);
    		console.log("parsedJson.uId:"+parsedJson.uId);
    		
    		$("#uId").val(parsedJson.uId);
    		$("#name").val(parsedJson.name);
    		$("#passwd").val(parsedJson.passwd);
    		$("#intLevel").val(parsedJson.intLevel);
    		
    		$("#login").val(parsedJson.login);
    		$("#recommend").val(parsedJson.recommend);
    		$("#email").val(parsedJson.email);
    		$("#regDt").val(parsedJson.regDt);
    		
    		//아이디는 PK로 수정 불가
    		//$( "input" ).prop( "disabled", false )
    		//$("#uId").prop("disabled",true);
    		$("#uId").prop("disabled","disabled");
    		
    		//버튼 비활성화
    		$("#add").prop("disabled",true);
    	});
    	
    });
     
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
    	doRetrieve(1);
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
            
           
            let totalCnt = 0; //총글수
            let pageTotal = 0;//총 페이지수
            
            if(null !=parsedJson && parsedJson.length > 0 ){
            	//총페이지수 
            	//총글수/페이수-나머지가 있으면 1증가
            	totalCnt=parsedJson[0].totalCnt;
            	pageTotal = Math.ceil( totalCnt/$("#pageSize").val() );
            	console.log("================");
            	console.log("=totalCnt="+totalCnt);
            	console.log("=pageSize="+$("#pageSize").val());
            	console.log("=pageTotal="+pageTotal);
            	console.log("=page="+page);
            	console.log("================");
            	
              $.each(parsedJson,function(index,value){
                  htmlData +=" <tr>";
                  htmlData +="   <td class='text-center col-sm-1 col-md-1 col-lg-1'><input type='checkbox' name='chk' value='"+value.uId+"' /></td>";
                  htmlData +="   <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+value.num  +"</td>";
                  htmlData +="   <td class='text-left   col-sm-2 col-md-2 col-lg-2'>"+value.uId  +"</td>";
                  htmlData +="   <td class='text-left   col-sm-2 col-md-2 col-lg-2'>"+value.name +"</td>";
                  htmlData +="   <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.level+"</td>";
                  htmlData +="   <td class='text-left   col-sm-3 col-md-3 col-lg-3'>"+value.email+"</td>";
                  htmlData +="   <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+value.regDt+"</td>";
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
            
            //paging 데이터 삭제
            $("#page-selection").empty();
            renderingPage(pageTotal,page);
            
        });
      
    }
    
    //버튼, 등록 컨트롤 초기화
    function initControll(){
        const initValue = "";
        //id중복체크 초기화
        $("#idCheckYN").val(initValue);
        
        $("#uId").val(initValue);
        $("#name").val(initValue);
        $("#passwd").val(initValue);
        $("#intLevel").val(1);
        
        $("#login").val(initValue);
        $("#recommend").val(initValue);
        $("#email").val(initValue);
        $("#regDt").val(initValue);
        
        //아이디는 PK로 활성화
        $("#uId").prop("disabled",false);
        //버튼 활성화
        $("#add").prop("disabled",false);        	
    }
    
    //paging
    function renderingPage(pageTotal, page){
    	console.log("pageTotal:"+pageTotal);
    	console.log("page:"+page);
    	
    	pageTotal=parseInt(pageTotal);
    	
    	//연결된 EventHandler제거
    	$('#page-selection').unbind('page');
    	
    	$('#page-selection').bootpag({
    	    total: pageTotal,
    	    page: page,
    	    maxVisible: 10,
    	    leaps: true,
    	    firstLastUse: true,
    	    first: '←',
    	    last: '→',
    	    wrapClass: 'pagination',
    	    activeClass: 'active',
    	    disabledClass: 'disabled',
    	    nextClass: 'next',
    	    prevClass: 'prev',
    	    lastClass: 'last',
    	    firstClass: 'first'
    	}).on("page", function(event, num){
    	    console.log("num:"+num);
    	    doRetrieve(num);
    	});    	
    	
    	
    	
    }
    
  
</script>

</head>
<body>
  <!-- div container -->     
  <div class="container">   
    <!-- 제목 -->
    <div class="page-header">
       <h2>회원관리</h2>
    </div>
    <!-- 제목 ------------------------------------------------------------------->
    
    <!-- 검색 : 검색구분(select) 검색어(input) 페이지 사이즈(select)--> 
    <form action="#" class="form-inline text-right">
      <div class="form-group">
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
        <input type="button" class="btn btn-primary btn-sm" value="조회" id="doRetrive">          
        <input type="button" class="btn btn-primary btn-sm" value="삭제" id="upDeleteAll">
      </div>
    </form> 
    <!-- 검색 ------------------------------------------------------------------->
    
    <!-- 테이블 목록 -->
    <table class="table table-striped table-bordered table-hover" id="userTable">
      <thead class="bg-primary">
        <tr>
          <th class="text-center col-sm-1 col-md-1 col-lg-1"><input type="checkbox" id="checkAll"></th>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-2">아이디</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-2">이름</th>
          <th class="text-center col-sm-2 col-md-2 col-lg-2">등급</th>
          <th class="text-center col-sm-3 col-md-3 col-lg-3">이메일</th>
          <th class="text-center col-sm-1 col-md-1 col-lg-1">등록일</th>
        </tr>
      </thead>
      <tbody>                   
      </tbody>
    </table>
    <!-- 테이블 목록 -------------------------------------------------------------->
    
    <!-- 페이징 -->
    <div class="text-center col-sm-12 col-md-12 col-lg-12">
      <div id="page-selection" class="text-center page"></div>    
    </div>
    <!-- 페이징--- -------------------------------------------------------------->
    <div class="container">  
    <!-- 관리:등록,수정,삭제 --> 
    <!--버튼  -->
    <div class="row text-right ">
        <label for="inputEmail3" class="col-sm-2 col-md-2 col-lg-2 control-label"></label>
        <div class="col-sm-10 col-md-10 col-lg-10">
		      <input type="button" class="btn btn-primary btn-sm" value="초기화" id="initBtn" >
		      <input type="button" class="btn btn-primary btn-sm" value="등록"  id="add" >
		      <input type="button" class="btn btn-primary btn-sm" value="삭제"  id="doDelete">
		      <input type="button" class="btn btn-primary btn-sm" value="수정"  id="doUpdate">
        </div>
    </div>
    <!--버튼 -------------------------------------------------------------------->
    
    <!-- 폼 -->
    <form action="#" class="form-horizontal"> 
      <input type="hidden" name="idCheckYN" id="idCheckYN">
	    <div class="form-group">
		    <label for="uId" class="col-sm-2 col-md-2 col-lg-2 control-label">아이디</label>
		    <div class="col-sm-8 col-md-8 col-lg-8">
			      <input type="text" 
			        maxlength="20"
			        class="form-control" id="uId" name="uId" placeholder="아이디를 입력하세요">
		    </div>
		    <div class="col-sm-2 col-md-2 col-lg-2 text-right">
		         <input type="button" class="btn btn-primary btn-sm" 
               value="아이디 중복" id="idCheck">
        </div>    
	    </div>      
         
      <div class="form-group">
        <label for="name" class="col-sm-2 col-md-2 col-lg-2 control-label">이름</label>
        <div class="col-sm-10 col-md-10 col-lg-10">
          <input type="text" 
          maxlength="20"
          class="form-control" id="name" name="name" placeholder="이름을 입력하세요">
        </div>
      </div>
             
      <div class="form-group">
        <label for="passwd" class="col-sm-2 col-md-2 col-lg-2 control-label">비밀번호</label>
        <div class="col-sm-10 col-md-10 col-lg-10">
          <input type="password" 
          maxlength="50"
          class="form-control" id="passwd" name="passwd" placeholder="비밀번호를 입력하세요">
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
          <input type="text" 
          maxlength="8"
          class="form-control numberOnly" id="login" name="login" placeholder="로그인을 입력하세요">
        </div>
      </div>
                  
      <div class="form-group">
        <label for="recommend" class="col-sm-2 col-md-2 col-lg-2 control-label">추천</label>
        <div class="col-sm-10 col-md-10 col-lg-10">
          <input type="text" 
          maxlength="8"
          class="form-control numberOnly" id="recommend" name="recommend" placeholder="추천을 입력하세요">
        </div>
      </div>
                   
      <div class="form-group">
        <label for="email" class="col-sm-2 col-md-2 col-lg-2 control-label">이메일</label>
        <div class="col-sm-10 col-md-10 col-lg-10">
          <input type="text"
          maxlength="320"
           class="form-control" id="email" name="email" placeholder="이메일을 입력하세요">
        </div>
      </div>
      
      <div class="form-group">
        <label for="regDt" class="col-sm-2 col-md-2 col-lg-2 control-label">등록일</label>
        <div class="col-sm-10 col-md-10 col-lg-10">
          <input type="text" class="form-control" id="regDt" name="regDt" 
          readonly="readonly"
          placeholder="등록일을 입력하세요">
        </div>
      </div>
                                               
    </form>
    <!--폼   -------------------------------------------------------------------->
   </div>   
   <!-- div container ----------------------------------------------------------> 
        
  </div>   
  <!-- div container ---------------------------------------------------------->
       
</body>
</html>


















