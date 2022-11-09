package com.pcwk.ehr.ed01;

public class TourGuide {
	
//	private Providable tour = new KoreaTour();
	private Providable tour = new JapanTour();
	
	public void leisureSprots() {
		tour.leisureSports();
	}
	
	public void sightseeing() {
		tour.sightseeing();
	}
	
	public void food() {
		tour.food();
	}

}
