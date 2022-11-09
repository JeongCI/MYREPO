package com.pcwk.ehr.ed09.object.equals;

public class Person extends Object {

	long id;

	public Person() {
		this(0);
	}

	public Person(long id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}

//	@Override
//	public boolean equals(Object obj) {
//		// Person의 ID값으로 데이터 비교
//		
//		if(null != obj && obj instanceof Person) {
//			return this.id == ((Person)obj).id;
//		} else {
//			return false;
//		}
//	}

}
