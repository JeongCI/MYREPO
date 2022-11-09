package com.pcwk.ehr.ed02.classz;

public class TvEx02Main {

	public static void main(String[] args) {
		Tv tv01=new Tv();
		Tv tv02=new Tv();
		
		
		System.out.println("tv01의 channel값은 "+tv01.channel+" 입니다.");
		System.out.println("tv02의 channel값은 "+tv02.channel+" 입니다.");
		
		tv01.channel = 58;
		System.out.println("tv01의 channel값은 "+tv01.channel+" 입니다.");
		System.out.println("tv02의 channel값은 "+tv02.channel+" 입니다.");		
	}

}
