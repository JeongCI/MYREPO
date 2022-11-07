package com.pcwk.ehr.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.pcwk.ehr.cmn.StringUtil;
import com.pcwk.ehr.login.domain.UserVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(
		description = "로그인", 
		urlPatterns = { 
				"/login/login.do", 
				"/login/logout.do"
		})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger LOG = Logger.getLogger(getClass());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("============================");         
		LOG.debug("==doLogout()==");
		LOG.debug("============================");	
    	
		HttpSession session = request.getSession();
		//session 삭제
		if(null != session.getAttribute("user")) {
			session.removeAttribute("user"); //삭제
			session.invalidate(); //세션 종료
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
    }
    
    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("============================");         
		LOG.debug("==doLogin()==");
		LOG.debug("============================");
		
		String userId = StringUtil.nvl(request.getParameter("user_id"));
		String userPw = StringUtil.nvl(request.getParameter("user_pw"));
		
		UserVO inVO = new UserVO();
		inVO.setUserId(userId);
		inVO.setUserPw(userPw);
		inVO.setDevType("full stack developer");
		LOG.debug("==inVO()=="+inVO);
		//DAO : UserDao에 id/비번 값 일치하면 session 처리하면 됨.
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user", inVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/jsp04/login_result.jsp");
		dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //work_div읽어서 분기
        //request encoding을 UTF-8설정
        request.setCharacterEncoding("UTF-8");
        String workDiv = request.getParameter("work_div") == null ? "":request.getParameter("work_div");
        LOG.debug("workdiv = "+workDiv);
        
        switch(workDiv) {
        case "doLogin":
        	doLogin(request, response);
        	break;
        case "doLogout":
        	doLogout(request, response);
        	break;
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
