package com.pcwk.ehr.ed10.oop2;

public class CaptionTvMain {

	public static void main(String[] args) {
		CaptionTv cTv = new CaptionTv();
		
		cTv.channel = 11;
		cTv.channelUp();
		
		System.out.println("channel : " + cTv.channel);
		
		cTv.displayCaption("Hello, World!");
		cTv.caption = true;
		cTv.displayCaption("Hello, pcwk!");
		
	}

}
