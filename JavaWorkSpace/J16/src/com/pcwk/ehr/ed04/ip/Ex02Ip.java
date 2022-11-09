package com.pcwk.ehr.ed04.ip;

import java.net.*;

public class Ex02Ip {

	public static void main(String[] args) {
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		try {
			String hostName = "www.daum.net";
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName : " + ip.getHostName());
			System.out.println("getHostAddress : " + ip.getHostAddress());
			ipArr = InetAddress.getAllByName(hostName);
			for (int i = 0; i < ipArr.length; i++) {
				System.out.println(i + ". " + ipArr[i]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}