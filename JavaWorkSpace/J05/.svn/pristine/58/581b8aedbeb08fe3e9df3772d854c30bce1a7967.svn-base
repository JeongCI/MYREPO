package com.pcwk.ehr.ed03;

public class Ex02HexToBinary {

	public static void main(String[] args) {
		char[] hex = {'1','C','A','F','E'};			
        String binary[] = {  "0000"
			        		,"0001"
			        		,"0010"
			        		,"0011"
			        		,"0100"
			        		,"0101"
			        		,"0110"
			        		,"0111"
			        		,"1000"
			        		,"1001"
			        		,"1010"
			        		,"1011"
			        		,"1100"
			        		,"1101"
			        		,"1110"
			        		,"1111"};
        String result = "";
        for(int i=0;i<hex.length;i++) {
        	//System.out.printf("hex[%d]=%c\n",i,hex[i]);
        	//System.out.println(hex[i]-'A'+10);
        	//숫자일 경우
        	if(hex[i]>='0' && hex[i]<='9') {
        		result += binary[hex[i]-'0'];
        	}else {
        		result += binary[hex[i]-'A'+10];
        	}
        	//A~F
        	
        	
        }
        System.out.println("result:"+result);
		
	}

}
