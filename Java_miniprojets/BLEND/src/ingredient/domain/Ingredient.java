package ingredient.domain;

import cmn.DTO;

public class Ingredient extends DTO {

	private String name ;				//재료 이름 : name			String
	private int amount ;				//재료 수량: amount			int(단위 ml)
	
	public Ingredient() {}
	public Ingredient(String name) {
		this.name = name;
		this.amount = 0;
	}
	public Ingredient(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "재료 " + name + "/" + amount;
	}
	
	
}
