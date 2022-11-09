package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerSend extends Thread {

	private final Socket socket;
	private Scanner scanner = new Scanner(System.in);

	public ServerSend(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
			String sendString;
			// 채팅 보내기
			while (true) {
				sendString = scanner.nextLine();
				sendWriter.writeUTF(sendString);
				sendWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}