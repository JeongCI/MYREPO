package com.pcwk.ehr.ed01.arraylist;

import java.util.*;

public class Ex04ArrayListDel {

	public static void main(String[] args) {
		ArrayList list01 = new ArrayList<Integer>(11);

		list01.add(new Integer(5));
		list01.add(new Integer(4));
		list01.add(new Integer(2));
		list01.add(new Integer(0));
		list01.add(new Integer(1));
		list01.add(new Integer(3));

		System.out.println("list01 : " + list01.toString());

		ArrayList list02 = new ArrayList<Integer>(list01.subList(1, 4));
		System.out.println("list02 : " + list02.toString());
		System.out.println("=============================");

		// sort asc
		Collections.sort(list01);
		Collections.sort(list02);
		System.out.println("list01 : " + list01.toString());
		System.out.println("list02 : " + list02.toString());
		System.out.println("=============================");
		
		// list02 에서 list01 에 포함된 객체 삭제
		// 뒤에서부터 삭제해야함
		for(int i = list02.size()-1; i>= 0; i--) {
			if(list01.contains(list02.get(i))) {
				
			}
		}
	}

}
