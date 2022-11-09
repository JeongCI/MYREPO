package com.pcwk.ehr.ed02;

public class Ex01Quiz {

	public static void main(String[] args) {
		int scoreArray[]= {100,77,88,100,91};
		
		//총점과 평균을 구하세요.
		int sum = 0;
		float avg = 0.0f;
		
		for(int i=0;i<scoreArray.length;i++) {
			sum += scoreArray[i];
		}

		avg = sum/(float)scoreArray.length;
		
		System.out.println("sum:"+sum);
		System.out.println("avg:"+avg);
	}

}
//sum:456
//avg:91.2
