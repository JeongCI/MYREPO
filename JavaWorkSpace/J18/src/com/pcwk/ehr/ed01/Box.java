package com.pcwk.ehr.ed01;

public class Box<T> { // 지네릭 타입 T선언
	T item;

	public void setItem(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

}
