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
<style>       
   /* style초기화 */
   body, div,h1,table,tr,td,thead,tbody,input,select,button{
     margin: 0;
     padding: 0;
     box-sizing: border-box;
   }
   
   input, select{
    height: 30px;
   }
   
   button{
    height: 31px;
    cursor:pointer
   }
      

      
  @font-face {
    font-family: 'NGB';
    src: url("/PC_HTML/assets/fonts/NanumGothicExtraBold.woff") format('woff');
  }
  
  @font-face {
    font-family: 'NG';
    src: url("/PC_HTML/assets/fonts/NanumGothic.woff") format('woff');
  }
    
  @font-face {
    font-family: 'NGBE';
    src: url("/PC_HTML/assets/fonts/NanumGothicBold.woff") format('woff');
  }

  .regular {
    font-family: 'NG';
  } 
  
  .medium {
    font-family: 'NGB';
  }   
  
  .bold {
    font-family: 'NGBE';
  } 

  a {
     text-decoration: none; /* underline 지우기 */
     color: #222;
  }
  
      
   .content_area {
     width: 1010px;
     margin: 0 auto;
   
   }
   
   .search_area {
     /* 위 | 오른쪽 | 아래 | 왼쪽 */     
     margin: 30px 1px 2px 1px;
     text-align: right;
     display: inline-block;
     width: 100%;
     height:40px;
     line-height: 40px;
   }
   
   
   #search_frm{
    display: inline-block;
   }
   
   .button_area{
     margin: 1px 0px 0px 20px;
     display: inline-block;
     text-align: right;
     vertical-align:bottom;
   }
   
   .table_area {
     width: 100%;
     margin: 0 auto;
   }
   
   .normal_btn {
    background:linear-gradient(to bottom, #007dc1 5%, #0061a7 100%);
    background-color:#004ba0;
    border-radius:5px;
    border:1px solid #124d77;
    display:inline-block;  
    cursor:pointer;
    color:#ffffff;
    font-size:13px;  
    padding:6px 12px;
    text-decoration:none;
    text-shadow:0px 1px 0px #154682;
   }
   
   /* paging */
   .page_area {
     display: inline-block;
     width: 100%;
    
     /* 위 | 오른쪽 | 아래 | 왼쪽 */     
     margin-top: 30px;     
   }
      
   .page_table{
     border-collapse: collapse;
     margin: 0 auto;
     width: 40%;  
   }
   
   .page_table td {
     height: 20px;
     font-family: 'NG';   
   }
      
    .page_table li{
      display: inline-block;
    }

      
   .table_list{
     border-collapse: collapse;
     margin: 0 auto;
     width: 100%;
   }
   
   .table_list th{
     border: 1px solid #555;
     height: 23px;
     padding: 10px;
     font-family: 'NGB';
     font-size: 16px;
   }
   
   .table_list td {
     border: 1px solid #ccc;
     height: 20x;
     padding: 10px;
     font-family: 'NG';
     font-size: 14px;     
   }
   
   .header {
     background-color: #004ba0;
     color: #fff;
     font-family: 'NGB';
   }
   
   .txt_center {
     text-align: center;
   }
   
   .txt_left {
     text-align: left;
   }
   
   .txt_right {
     text-align: right;
   }      
   
   .txt_hidden{
     display: none;
   }
   /* link 비활성화 */
    .disable {
        color: gray;
    }
       
</style>
<title>제목</title>
<script src="/PC_HTML/assets/js/jquery-3.6.1.min.js"></script>
<script src="/PC_HTML/assets/js/jquery-ui.js"></script>
</head>
<body>
  <h2>Layout</h2>
  <br/>
  <table class="table_list">
    <tr>
    <td>&nbsp;</td>
      <td>
        <jsp:include page="/jsp/jsp04/jsp09_login.jsp">
          <jsp:param value="value1" name="param1"/>
        </jsp:include>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <jsp:include page="/jsp/jsp04/top.jsp">
          <jsp:param value="value1" name="param1"/>
        </jsp:include>
      </td>
    </tr>
    
    <tr>
      <td width="30%">
          <jsp:include page="/jsp/jsp04/left.jsp" />
      </td>
      
      <td width="70%">
        <jsp:include page="/board/board_list.jsp" />
      </td>
    </tr>
    
    <tr>
      <td colspan="2">
        <jsp:include page="/jsp/jsp04/bottom.jsp" />
      </td>
    </tr>
  </table>
</body>
</html>
</fmt:bundle>