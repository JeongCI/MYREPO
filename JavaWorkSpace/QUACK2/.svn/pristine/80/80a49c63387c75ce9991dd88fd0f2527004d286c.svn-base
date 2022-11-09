package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread {

	private final Socket socket;
	Scanner scanner = new Scanner(System.in);

	public ClientSend(Socket socket) {
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