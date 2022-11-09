package com.pcwk.ehr.ed02.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonUnmarshalling {

	public static void main(String[] args) {
		
		try (FileInputStream fis = new FileInputStream("pcwk_serial.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			Person person01 = (Person)ois.readObject();
			Person person02 = (Person)ois.readObject();
			
			System.out.println("person01 : " + person01);
			System.out.println("person02 : " + person02);
			
		}catch (IOException e) {
			System.out.println("IOExceptio : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("완료");
	}

}
