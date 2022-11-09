package com.pcwk.ehr.ed06.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TcpIpServer {

	public static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("[hh:mm:ss]");

		return df.format(new Date());
	}

	public static void main(String[] args) {
		// ServerSocket (Client와 연결 담당)
		ServerSocket serverSocket = null;
		int port = 5555; // 0 ~ 65535 (0 ~ 1024 시스템에 예약) 1024 이후로 사용

		try {
			System.out.println(getTime() + "서버 ready");
			serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept(); // 서버가 Client가 들어올때까지 대기...

			System.out.println(getTime() + socket.getInetAddress() + " 로 부터 연결요청이 들어 왔습니다.");
//			System.out.println("서버가 Client가 들어올 때까지 대기...");

			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeUTF("[PCWK Notice] Test Message from Pcwk Server!");
			System.out.println(getTime() + "데이터를 전송 했습니다.");

			// 스트림과 소켓을 닫는다.
			dos.close();
			socket.close();
			serverSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
