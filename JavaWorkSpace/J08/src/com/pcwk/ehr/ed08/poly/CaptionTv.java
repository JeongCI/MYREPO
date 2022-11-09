package com.pcwk.ehr.ed08.poly;

public class CaptionTv extends Tv {
	boolean caption; // 캡션(on / off)
	
	void displayCaption(String text) {
		if(caption == true)System.out.println(text);
	}
	
}
