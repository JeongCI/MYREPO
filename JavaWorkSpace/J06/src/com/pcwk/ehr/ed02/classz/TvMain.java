package com.pcwk.ehr.ed02.classz;

public class TvMain {

	public static void main(String[] args) {
		Tv tv;//Tv 클래스를 참조하기 위한 변수 tv;
		tv = new Tv();//인스턴스를 생성
		
		System.out.println("전원:"+tv.power);
		
		//전원 켜기
		tv.power();
		System.out.println("전원:"+tv.power);
		
		//채널 up
		tv.channelUp();
		System.out.println("채널:"+tv.channel);
		
		//전원 끄기
		tv.power();		
		System.out.println("전원:"+tv.power);
	}

}
