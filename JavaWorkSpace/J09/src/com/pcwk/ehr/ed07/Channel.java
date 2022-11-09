package com.pcwk.ehr.ed07;

import java.util.ArrayList;
import java.util.List;

public class Channel {
	List<Item> items = new ArrayList<Item>();
	
	public Channel() {
		
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
