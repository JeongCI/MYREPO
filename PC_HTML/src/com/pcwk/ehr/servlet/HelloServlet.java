package com.pcwk.ehr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends HttpServlet {
	Logger LOG = Logger.getLogger(getClass());
	
	
	public HelloServlet() {
		LOG.debug("================");
		LOG.debug("=HelloServlet()=");
		LOG.debug("================");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		//out객체
		PrintWriter out = resp.getWriter();
		out.println(" <!DOCTYPE html>                    ");
		out.println(" <html>                             ");
		out.println(" <head>                             ");
		out.println(" <meta charset='UTF-8'>             ");
		out.println(" <title>Insert title here</title>   ");
		out.println(" </head>                            ");
		out.println(" <body>                             ");
		out.println("   <h2>Hello,world!</h2>            ");
		out.println("   <hr>                             ");
		out.println(new Date()						 	  );
		out.println(" </body>                            ");
		out.println(" </html>                            ");
	}
	
}
