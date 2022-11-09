package com.pcwk.ehr.ed06.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class TcpIpClient {

	public static void main(String[] args) {
		// Client
		// 192.168.3.14
		
		String serverIp = "192.168.3.14"; // 서버 IP적기
		int port = 5555; // server port
		
		try {
			Socket socket = new Socket(serverIp, port);
			InputStream in = socket.getInputStream();
			
			DataInputStream dis = new DataInputStream(in);
			
			// 서버로 부터 메시지 수신
			System.out.println("서버 수신 메시지 : " + dis.readUTF());
			System.out.println("연결을 종료 합니다.");
			
			dis.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
