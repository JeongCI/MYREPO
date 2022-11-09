package com.pcwk.ehr.ed01;

public class KoreaTour implements Providable {

	@Override
	public void leisureSports() {
		System.out.println("한강에서 수상스키 투어");
	}
	
	@Override
	public void sightseeing() {
		System.out.println("올림픽 대교 야경");
	}
	
	@Override
	public void food() {
		System.out.println("치맥");
	}
	
}
