package com.pcwk.ehr.ed01;

import java.util.Arrays;

public class Ex03Copy {
    //배열의 크기를 *2배로 증가 시키기
	public static void main(String[] args) {
		int arr[]=new int[5];
		//int defulat 값인 '0' 으로 초기화 되어 있음.
		//System.out.println(Arrays.toString(arr));

		
		for(int i=0;i<arr.length;i++) {
			arr[i] = i+1;//1,2,3,4,5
		}
		
		System.out.println("변경전");
		System.out.println(Arrays.toString(arr));
		
		int tmp[] = new int[arr.length*2];//크기가 2배 증가한 배열 만들기
		
		//데이터 옮기기
		for(int i=0;i<arr.length;i++) {
			tmp[i] = arr[i];
		}
		
		arr = tmp;//주소값 변경
		System.out.println("변경후");
		System.out.println(Arrays.toString(arr));		

	}

}
//변경전
//[1, 2, 3, 4, 5]
//변경후
//[1, 2, 3, 4, 5, 0, 0, 0, 0, 0]





