package com.pcwk.ehr.ed01.string.encoding;

import java.io.UnsupportedEncodingException;
import java.util.StringJoiner;

public class Ex01StringGetBytesMain {

	static String joinByteArr(byte[] bArr) {
		StringJoiner sj = new StringJoiner(":", "[", "]");

		for (byte b : bArr) {
			sj.add(String.format("%02X", b)); // 2자리 확보하고 남는 자리는 0으로 채우고, 16진수로 출력
		}

		return sj.toString();
	}

	public static void main(String[] args) {
		// java.lang.String
		// import 필요없음

		String str = "가";
		try {
			byte[] bArrUTF8 = str.getBytes("UTF-8");
			byte[] bArrCP949 = str.getBytes("CP949");

			// 해당 코드 페이지로 인코딩
			System.out.println("UTF-8 : " + joinByteArr(bArrUTF8)); // UTF-8 은 3byte로 표현
			System.out.println("CP949 : " + joinByteArr(bArrCP949)); // 2byte로 한글 표현

			// 한글 형태로 변환 디코딩
			System.out.println("UTF-8 : " + new String(bArrUTF8, "UTF-8"));
			System.out.println("CP949 : " + new String(bArrCP949, "CP949"));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}