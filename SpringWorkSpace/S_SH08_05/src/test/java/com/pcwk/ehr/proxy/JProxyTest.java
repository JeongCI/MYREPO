package com.pcwk.ehr.proxy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JProxyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
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
