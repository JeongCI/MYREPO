package com.pcwk.ehr.ed03.classz;
import com.pcwk.ehr.ed02.classz.Tv;

public class TvEx03Main {

	public static void main(String[] args) {
		Tv[] tvArr=new Tv[3];
		
		//Tv객체를 생성
		for(int i=0;i<tvArr.length;i++) {
			tvArr[i]=new Tv();
			tvArr[i].channel = 58;
			
		}
		
		//배열에 들어 있는 값 출력
		for(int i=0;i<tvArr.length;i++) {
		
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel=%d\n",i,tvArr[i].channel);
			
		}
		

	}

}

