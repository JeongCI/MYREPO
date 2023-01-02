package com.pcwk.ehr.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//리플렉션: 자바코드를 추상화 해서 접근
		//모든 자바 클래스는 Class 타입의 오브젝트를 하나씩 가지고 있다.
		
		//기존 객체 접근 vs 리플렉션
		
		String name = "Spring";
		
		System.out.println("name의 length: "+name.length());
		
		//리플렉션
		Method lengthMethod = String.class.getMethod("length");
		
		int nameLength = (int)lengthMethod.invoke(name, args);
		System.out.println("nameLength: "+nameLength);
		
		//기존 객체 접근 vs 리프렉션(param 있는 메서드)
		//기존 객체 접근
		System.out.println("name의 length(0): "+name.charAt(0));
		
		//리플렉션
		Class rClass = String.class;
		
		Method charMethod = rClass.getMethod("charAt", int.class);
		
		System.out.println("charMethod.invoke(name, 0): "+charMethod.invoke(name, 0));
		
	}

}
