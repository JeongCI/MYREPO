package com.pcwk.ehr.ed06.properties;
import java.util.*;
public class Ex01Properties {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		// prop에 있는 내용 출력
		Enumeration e = prop.propertyNames();
		
		while(e.hasMoreElements()) {
			String key = (String) e.nextElement(); // key값 출력
			System.out.println(key + ", " + prop.getProperty(key));			
		}
		
		prop.setProperty("size", "16");
		
		System.out.println("size : " + prop.getProperty("size"));
		
	}

}
