package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("localhost", 8888);
		System.out.println("서버와 접속되었습니다.");
		ClientReceiveThread receiveThread = new ClientReceiveThread(sock);
		receiveThread.start();
		ClientSend sendThead = new ClientSend(sock);
		sendThead.start();
	}

}