package com.pcwk.ehr.ed05.chatting;

import java.io.IOException;
import java.net.Socket;

public class TcpIpClient {

	public static void main(String[] args) {
		String serverIp = "192.168.3.14";
		int port = 9612;

		try {
			Socket socket = new Socket(serverIp, port);

			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
