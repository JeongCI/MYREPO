package project.quack.chat01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSendThread extends Thread {

	private final Socket socket;
	Scanner scanner = new Scanner(System.in);

	public ClientSendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
			String sendString;
			while (true) {
				System.out.print("손님 : ");
				sendString = scanner.nextLine();
				sendWriter.writeUTF(sendString);
				if (sendString == "/q") {
					System.out.println("채팅이 종료 되었습니다.");
					sendWriter.close();
				} else {
					sendWriter.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}