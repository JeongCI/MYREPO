package com.pcwk.ehr.cmn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PcwkInterceptor implements HandlerInterceptor {

	final Logger  LOG = LogManager.getLogger(getClass());
	
	//controller로 보내기 전에 요청과 응답을 인터셉트
	//return이 false이면 controller로 요청을 않함
	//Object 핸들러 정보를 의미(RequestMapping, DefaultServletHandler)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		LOG.debug("===========================");
		LOG.debug("=preHandle=");
		LOG.debug("===========================");
		
		return true;
	}

	//controller의 handler가 끝나면 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		LOG.debug("===========================");
		LOG.debug("=postHandle=");
		LOG.debug("===========================");		
	}

	//view까지 처리가 끝난 이후 처리
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		LOG.debug("===========================");
		LOG.debug("=afterCompletion=");
		LOG.debug("===========================");			
	}

}
