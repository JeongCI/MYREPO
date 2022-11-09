package com.pcwk.ehr.ed01.bytearrayinputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex01ByteArrayInputStream {

	public static void main(String[] args) {
		byte[] inSrc = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		byte[] outSrc = null;

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		int data = 0;
		while ((data = input.read()) != -1) { // -1이 들어오면 더이상 읽을 데이터가 없다.
			output.write(data);
		}

		// stream에 있는 데이터를 byte[] return
		outSrc = output.toByteArray();

		System.out.println("Input source : " + Arrays.toString(inSrc));
		System.out.println("Output source : " + Arrays.toString(outSrc));
	}

}
//Input source : [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
//Output source : [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]