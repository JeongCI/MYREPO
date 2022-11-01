<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<style>
  /* 초기화 */
  body, div, h1, table, tr, td, thead ,tobody, select,input{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  input, select{
    height: 30px;
  }
  
  button{
    height: 31px;
    cursor:pointer;
  }
  
  .content_area {
    width: 800px;
    margin: 0 auto;
    padding-top: 30px;
  }
  
  .search_area {
    /*       위 |오른쪽|아래|왼쪽 */
    margin: 30px 1px 2px 1px;
    text-align: right;
    display: inline-block;
    width: 100%;
    height: 40px;
    line-height: 40px;
  }
  
  .buttoen_area {
    margin: 1px 0px 0px 20px;
    display: inline-block;
    text-align: right;
    vertical-align: bottom;
  }
  
  .nomal_btn{
    background:linear-gradient(to bottom, #007dc1 5%, #0061a7 100%);
    background-color: #004ba0;
    border-radius: 5px;
    border: 1px solid #124d77;
    display: inline-block;
    cursor: pointer;
    color: #fff;
    font-size: 13px;
    padding: 6px 12px;
    text-decoration: none;
    text-shadow: 0px 1px 0px #154682;
  }
  
  .table_list{
    width:100%;
    margin: 0 auto;
  }  
  
  td {
    width: 100%;
  }
  
  input {
    width: 745px;
  }
  
  #contents {
    height:500px;
    width: 740px;
    resize: none;
  }
  
  
</style>
<title>제목</title>
<script src="/PC_HTML/assets/js/jquery-3.6.1.min.js"></script>
<script src="/PC_HTML/assets/js/jquery-ui.js"></script>
<!-- javascript -->
<script type="text/javascript">
  $(document).ready(function(){
  });
  
	  function moveList() {
		  //console.log("moveList");
	    let frm = document.getElementById("reg_frm");
	    frm.work_div.value = "moveList";
	    
		  console.log('work_div'+$('#work_div').val());
		  frm.submit();
	  }
	  
	  function doSave() {
		  //console.log("doSave");
		  let frm = document.getElementById("reg_frm");
		  
		  $("#work_div").val("doSave");
		  
		  let title = $("#title").val();
		  if(title === null || title.trim().length == 0) {
			  $("#title").val(""); // 데이터 삭제
			  $("#title").focus();
			  alert("제목을 입력 하세요.");
			  return false;
		  }
		  
		  let reg_id = $("#reg_id").val();
		  if(reg_id === null || reg_id.trim().length == 0) {
			  $("#reg_id").val(""); // 데이터 삭제
			  $("#reg_id").focus();
			  alert("등록자를 입력 하세요.");
			  return false;
		  }
		  
		  let contents = $("#contents").val();
		  if(contents === null || contents.trim().length == 0) {
			  $("#contents").val(""); // 데이터 삭제
			  $("#contents").focus();
			  alert("내용을 입력 하세요.");
			  return false;
		  }
		  
		  // 데이터 변경 전 confirm
		  if(false == confirm("저장 하시겠습니까?")) {
			  return;
		  }
		  
		  //frm.submit();
		  
		  $.ajax({ 
			   type: "POST",
			   url: "<%=conPath%>/board/board.do",
			   asyn: "true",
			   dataType: "html",
			   data:{
				     work_div: $("#work_div").val(),
			       title: $("#title").val(),
			       reg_id: $("#reg_id").val(),
			       contents: $("#contents").val()
			   },
			   success:function(data){ //통신 성공
				   //console.log('data: '+data);
			     const jsonObj = JSON.parse(data);
			     console.log('jsonObj.messageId: ' + jsonObj.messageId);
			     console.log('jsonObj.msgContents: ' + jsonObj.msgContents);
			     if(null != jsonObj && jsonObj.messageId == "1") {
			    	 alert(jsonObj.msgContents);
			    	 
			    	 //화면 이동
			    	 const listUrl = "<%=conPath%>/board/board.do?work_div=doRetrieve";
			    	 window.location.href = listUrl;
			     } else {
			    	 alert(msgContents + " : " + jsonObj.messageId);
			     }
			     
			   },
			   error:function(data){//실패
				   console.log(data);
			   },
			   complete:function(data){//성공, 실패 관계 없이 출력
			   
			   }

			});
	  }
</script>
</head>
<body>
  <div class="content_area">
    <h1>게시판 등록</h1>
    <div class="search_area">
	    <div class="button_area">
	      <button class="nomal_btn" onclick="javascript:doSave();">등록</button> 
	      <button class="nomal_btn" onclick="javascript:moveList();">목록</button> 
	    </div>
    </div>
    <div class="reg_area">
      <form action="<%=conPath %>/board/board.do" method="post" name="reg_frm" id="reg_frm">
	    <input type="hidden" name="work_div" id="work_div"> <!-- 작업 구분 -->
	    
        <table class="table_list">
          <tr>
            <td><label for="title">제목</label></td>
            <td><input type="text" name="title" id="title" required="required" maxlength="65"></td>
          </tr>
          
          <tr>
            <td><label for="reg_id">등록자</label></td>
            <td><input type="text" name="reg_id" id="reg_id" required="required" maxlength="20"></td>
          </tr>
          
          <tr>
            <td><label for="contents">내용</label></td>
            <td><textarea rows="30" cols="60" id="contents" name="contents" required="required"></textarea></td>
          </tr>
        </table>
      </form>
    </div>
    
  </div>
</body>
</html>