<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
  String type = request.getParameter("type");
  if(null == type) return;
  
  out.print("type: "+type+"<br/>");
  
  if(type.equals("good")) {
	  out.print("good type");
  } else if(type.equals("very good")) {
	  out.print("very good");
  } else {
	  out.print("else");
  }
  
%>
