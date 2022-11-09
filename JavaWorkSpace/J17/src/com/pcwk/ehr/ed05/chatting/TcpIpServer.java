package com.pcwk.ehr.ed05.chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("[hh:mm:ss]");
		return df.format(new Date());
	}

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 9612;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println(getTime() + " 서버가 준비 되었습니다.");

			socket = serverSocket.accept();

			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
