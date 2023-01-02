package com.pcwk.ehr.chart.domain;

import com.pcwk.ehr.cmn.DTO;

public class PizzaVO extends DTO {
	private String topping;//토핑
	private int slices;//조각
	
	public PizzaVO() {}

	public PizzaVO(String topping, int slices) {
		super();
		this.topping = topping;
		this.slices = slices;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public int getSlices() {
		return slices;
	}

	public void setSlices(int slices) {
		this.slices = slices;
	}

	@Override
	public String toString() {
		return "PizzaVO [topping=" + topping + ", slices=" + slices + ", toString()=" + super.toString() + "]";
	}
	
	
}
