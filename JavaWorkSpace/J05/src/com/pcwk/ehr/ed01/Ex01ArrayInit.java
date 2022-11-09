package com.pcwk.ehr.ed01;

public class Ex01ArrayInit {

	public static void main(String[] args) {
		//배열 초기화시 배열의 개수를 명시하지 않음:  error
		//int []studentId =new int[3] {101,102,103};

		int studentId[] =  {101,102,103};
		
		System.out.println("studentId[0]:"+studentId[0]);
		System.out.println("studentId[1]:"+studentId[1]);
		
		int add = studentId[0] + studentId[1];
		System.out.println("add:"+add);
		
		System.out.println("배열의 길이:"+studentId.length);
		
		System.out.println("===========================");
		for(int i=0;i<studentId.length;i++) {
			System.out.printf("studentId[%d]=%d\n",i,studentId[i]);
		}
		
	}

}
//studentId[0]:101
//studentId[1]:102
//add:203
//배열의 길이:3
//===========================
//studentId[0]=101
//studentId[1]=102
//studentId[2]=103