package com.pcwk.ehr.ed02;

public class Ex03Shuffle {

	public static void main(String[] args) {
		// 섞기(shuffle)				
		int num[] =new int[10];			

		for(int i=0;i<num.length;i++) {
			num[i]=i;
		}
		
		//shuffle전 값 출력
		for(int i=0;i<num.length;i++) {
			System.out.print(num[i]+",");
		}
		
		for(int i=0;i<num.length;i++) {
			
			int rNum=(int)(Math.random()*10) ;//0.0포함 ~ 1.0미 포함
			
			//자비 바꿈:num[0]와num[rNum]과 자리바꿈
			int tmp = num[0];
			num[0]  = num[rNum];
			num[rNum] = tmp;
		}
		System.out.println();
		for(int i=0;i<num.length;i++) {
			System.out.print(num[i]+",");
		}	
		
		
		
	}

}
