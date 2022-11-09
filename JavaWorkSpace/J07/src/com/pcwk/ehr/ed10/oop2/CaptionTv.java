package com.pcwk.ehr.ed10.oop2;

public class CaptionTv extends Tv {
	boolean caption; // 캡션(on / off)
	
	void displayCaption(String text) {
		if(caption == true)System.out.println(text);
	}
	
}
