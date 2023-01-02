package com.pcwk.ehr.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UppercaseHandler implements InvocationHandler {
	   final Logger LOG = LogManager.getLogger(getClass());
	   Object target;
	   
	   //다이내믹 프록시로부터 전달받은 요청을 다시 타깃 오브젝트에 위임해야 
	   //하기 때문에 타깃 오브젝트를 주입 받는다.
	   
	   //어떤 종류의 인터페이스를 구현한 타깃에도 적용가능
	   public UppercaseHandler(Object target) {
	      this.target = target;
	   }
	   
	   @Override
	   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		   Object ret = (String) method.invoke(target, args);
	      LOG.debug("┌─────────────────────────────────────┐");
	      LOG.debug("│invoke() : "+method.getName()+"      │");
	      LOG.debug("└─────────────────────────────────────┘");
	      
	      //호출한 메서드의 리턴 타입이 String인 경우만
	      //대문자로 변경
	      if(ret instanceof String && method.getName().startsWith("sayH")) {
	    	  return ((String)ret).toUpperCase();
	      } else {
	    	  return ret;
	      }
	   }
	}
