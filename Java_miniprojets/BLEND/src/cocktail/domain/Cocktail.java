package cocktail.domain;

import java.util.ArrayList;
import java.util.List;

import cmn.DTO;
import ingredient.domain.Ingredient;

public class Cocktail extends DTO {

	private String name;
	private ArrayList<Ingredient> ingredArr = new ArrayList<Ingredient>();
	
	public Cocktail() {}
	public Cocktail(String name) {
		this.name = name;
	}
	public Cocktail(String name, ArrayList<Ingredient> ingredArr){
		this.name = name;
		this.ingredArr = ingredArr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Ingredient> getIngredArr() {
		return ingredArr;
	}
	public void setIngredArr(ArrayList<Ingredient> ingredArr) {
		this.ingredArr = ingredArr;
	}
	
	@Override
	public String toString() {
		return "칵테일 이름: " + name + ", 각 재료별 이름/양=" + ingredArr;
	}
	
	
}
