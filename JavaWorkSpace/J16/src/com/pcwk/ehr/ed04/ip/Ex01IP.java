package com.pcwk.ehr.ed04.ip;

import java.io.IOException;
import java.net.*;

public class Ex01IP {

	public static void main(String[] args) {
		InetAddress ip = null;

		try {
			ip = InetAddress.getLocalHost();

			// 컴퓨터 이름 출력
			System.out.println("getHostName : " + ip.getHostName());

			// ip
			System.out.println("getHostAddress : " + ip.getHostAddress());

			// getLoopbackAddress
			System.out.println("getLoopbackAddress : " + ip.getLoopbackAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//getHostName : DESKTOP-ONE4R81
//getHostAddress : 192.168.3.14
//getLoopbackAddress : localhost/127.0.0.1