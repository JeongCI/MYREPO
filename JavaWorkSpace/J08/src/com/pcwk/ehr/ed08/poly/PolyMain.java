package com.pcwk.ehr.ed08.poly;

public class PolyMain {

	public static void main(String[] args) {
		CaptionTv cTv = new CaptionTv();
		
		// 부모 타입의 참조 변수로 자식 타입의 인스턴스를 참조할 수 있다.
		// 반대로 자식타입의 참조변수로 부모타입의 인스턴스를 참조할 수 없다.
		//CaptionTv cTv02 = new CaptionTv();
		
		Tv t = new CaptionTv();
		
		
		
	}

}
