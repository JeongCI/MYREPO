package com.pcwk.ehr.ed03.serialization;

import java.io.Serializable;

// 객체 직렬화 : 객체를 기록, 기록한 객체 다시 읽어 들일 수 있다.
// 마샬링(marshalling) : 객체를 byte단위로 변환
// 언마샬링(unmarshalling) : byte단위의 데이터를 원래의 객체로 복구하는 작업.
public class Person implements Serializable {

	/**
	 * 클래스의 동일성 확인
	 */
	private static final long serialVersionUID = -481543365182240387L;
	
	String name;
	
	// 직렬화 대상에서 제거
	transient String job;
	
	public Person() {}

	public Person(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", job=" + job + "]";
	}
	
	
	
	
}
