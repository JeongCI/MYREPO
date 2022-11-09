package project.quack.chat01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerSendThread extends Thread {

	private final Socket socket;
	private Scanner scanner = new Scanner(System.in);

	public ServerSendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
			String sendString;
			while (true) {
				System.out.print("카운터 : ");
				sendString = scanner.nextLine();
				sendWriter.writeUTF(sendString);
				sendWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}