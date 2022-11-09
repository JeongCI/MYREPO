package com.pcwk.ehr.ed01;

public class Ex04SystemArraycopy {
    //API를 이용한 배열 복사
	public static void main(String[] args) {
		//System.arraycopy(args, 0, args, 0, 0);
		char alpha[]  = {'A','B','C','D','F'};
		char number[] = {'0','1','2','3','4','5','6','7','8','9'};

		System.out.println(alpha);
		System.out.println(number);
		
		char[] result = new char[alpha.length+number.length];
		//alpha[0]에서 , result[0], alpha.length만큰 copy
		System.arraycopy(alpha, 0, result, 0, alpha.length);
		
		System.out.println(result);
		//number[0],result[alpha.length]부터 number.length까지 copy
		System.arraycopy(number,0,result,alpha.length,number.length);
		System.out.println(result);
		
	}

}





