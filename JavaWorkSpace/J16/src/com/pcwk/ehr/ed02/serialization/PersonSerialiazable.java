package com.pcwk.ehr.ed02.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonSerialiazable {

	public static void main(String[] args) {
		Person person01 = new Person("홍","의적");
		Person person02 = new Person("이상무","개발자");
		
		// ObjectInputStream / ObjectOutputStream
		// 객체 직렬화

		try(	FileOutputStream fos = new FileOutputStream("pcwk_serial.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			
			oos.writeObject(person01);
			oos.writeObject(person02);
			
		} catch(IOException e) {
			System.out.println("IOException : " + e.getMessage());
		}
		System.out.println("파일 직렬화 성공");
	}

}
