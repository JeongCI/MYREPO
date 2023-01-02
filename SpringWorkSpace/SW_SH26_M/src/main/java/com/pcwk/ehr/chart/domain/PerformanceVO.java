package com.pcwk.ehr.chart.domain;

import com.pcwk.ehr.cmn.DTO;

public class PerformanceVO extends DTO {

	
	private String year;
	private int sales;
	private int expenses;
	
	public PerformanceVO() {}

	public PerformanceVO(String year, int sales, int expenses) {
		super();
		this.year = year;
		this.sales = sales;
		this.expenses = expenses;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getExpenses() {
		return expenses;
	}

	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "PerformanceVO [year=" + year + ", sales=" + sales + ", expenses=" + expenses + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
