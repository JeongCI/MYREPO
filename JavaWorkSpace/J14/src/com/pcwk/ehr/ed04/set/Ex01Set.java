package com.pcwk.ehr.ed04.set;
import java.util.*;
public class Ex01Set {

	public static void main(String[] args) {
//		List 를 implements 받는다.			
//		순서가 유지 되지 않음.			
//		중복을 허용하지 않는다.			
//		null값을 허용			
		
		Object [] objArr = {"1", new Integer(1),"2","2","3","5","5","5"};
		
		Set set = new HashSet();
		
		for(int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]);
		}
		
		System.out.println("set : " + set);
				
	}

}
