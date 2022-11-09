package com.pcwk.ehr.ed02;

import java.util.Arrays;

public class Ex04Frequency {
    //4.빈도수 구하기
	//1. 난수(0~9) 발생해서 score에 할당
    //2. 빈도수 출력					

	public static void main(String[] args) {
		int score[]=new int[10];
		int counter[]=new int[10];
		
		for(int i=0;i<score.length;i++) {
			score[i] = (int)(Math.random()*10);
			System.out.print(score[i]+",");
		}
		
		System.out.println();
		//6,2,1,9,7,8,7,2,8,8,
		for(int i=0;i<score.length;i++) {
			counter[score[i]]++;//score[i]저장된 값과 일치하는 인덱스의 요소에 값을 1증가
		}
		
		
		//빈도수 출력
		for(int i=0;i<score.length;i++) {
			System.out.println(i+"의 개수 :"+counter[i]);
		}
		
	}

}
//2,1,9,4,1,5,4,9,7,5,
//0의 개수 :0
//1의 개수 :2
//2의 개수 :1
//3의 개수 :0
//4의 개수 :2
//5의 개수 :2
//6의 개수 :0
//7의 개수 :1
//8의 개수 :0
//9의 개수 :2