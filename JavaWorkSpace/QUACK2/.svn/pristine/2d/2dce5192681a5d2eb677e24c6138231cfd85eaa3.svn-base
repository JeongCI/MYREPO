package project.quack.domain;

public class Menu {
	
	private String menuNum;			//음식번호
	private String menuName;		//음식이름
	private String price;			//가격
	private boolean available;		//주문가능/불가능
	
	public Menu() {
		
	}

	public Menu(String menuNum, String menuName, String price, boolean available) {
		super();
		this.menuNum = menuNum;
		this.menuName = menuName;
		this.price = price;
		this.available = available;
	}

	public String getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Menu [menuNum=" + menuNum + ", menuName=" + menuName + ", price=" + price + ", available=" + available
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuNum == null) ? 0 : menuNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (menuNum == null) {
			if (other.menuNum != null)
				return false;
		} else if (!menuNum.equals(other.menuNum))
			return false;
		return true;
	}
		
	
}
