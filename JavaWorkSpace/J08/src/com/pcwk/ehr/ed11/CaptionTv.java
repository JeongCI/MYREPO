package com.pcwk.ehr.ed11;

public class CaptionTv extends Tv {

	private boolean chaption;

	public CaptionTv() {
		this(false); // CaptionTv(boolean chaption)call
	}

	public CaptionTv(boolean chaption) {
		super(); // Tv() 생성자 호출
		this.chaption = chaption;

	}

	public void disp() {
		setChannel(58);
		System.out.println(getChannel());
	}

}
