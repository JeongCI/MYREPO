package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		int port = 8888;
		ServerSocket socketServer = new ServerSocket(port);
		while (true) {
			Socket sock = socketServer.accept();
			System.out.println("ip : " + sock.getInetAddress() + " 와 연결되었습니다.");
			ServerReceiveThread receiveThread = new ServerReceiveThread(sock);
			receiveThread.start();
			ServerSend sendThead = new ServerSend(sock);
			sendThead.start();
		}
	}
}
