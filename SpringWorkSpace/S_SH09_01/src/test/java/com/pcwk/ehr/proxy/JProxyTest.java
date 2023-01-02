package com.pcwk.ehr.proxy;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JProxyTest {
	
	@Test
	public void dynamicProxy() {
	   //프록시 생성
	   Hello proxiedHello = (Hello) Proxy.newProxyInstance(getClass().getClassLoader(), //동적으로 생성되는 다이내믹 프록시 클래스 로딩
	         new Class[] {Hello.class},//구현 클래스
	         new UppercaseHandler(new HelloTarget()));
	   
	   System.out.println("proxiedHello.sayHello(Pcwk): "+proxiedHello.sayHello("Pcwk"));
	   System.out.println("proxiedHello.sayHi(Pcwk): "+proxiedHello.sayHi("Pcwk"));
	   System.out.println("proxiedHello.sayThankYou(Pcwk): "+proxiedHello.sayThankYou("Pcwk"));
	   
	   assertEquals(proxiedHello.sayHello("Pcwk"), "HELLO PCWK");
	   assertEquals(proxiedHello.sayHi("Pcwk"), "HI PCWK");
	   assertEquals(proxiedHello.sayThankYou("Pcwk"), "Thank you Pcwk");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	@Ignore
	public void proxyTest() {
		Hello proxiedHello = new HelloUppercase(new HelloTarget());
		assertEquals(proxiedHello.sayHello("Pcwk"), "HELLO PCWK");
		
		assertEquals(proxiedHello.sayHi("Pcwk"), "HI PCWK");
		
		assertEquals(proxiedHello.sayThankYou("Pcwk"), "THANK YOU PCWK");
	}

	@Test
	@Ignore
	public void simpleProxy() {
		Hello hello = new HelloTarget();
		assertEquals(hello.sayHello("Pcwk"), "Hello Pcwk");
		
		assertEquals(hello.sayHi("Pcwk"), "Hi Pcwk");
		
		assertEquals(hello.sayThankYou("Pcwk"), "Thank you Pcwk");
	}

}
