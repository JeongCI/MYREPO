package begin.doc.chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("사용자 이름을 입력하세요.");
			System.exit(0);
		}

		String name = args[0]; // 사용자 이름 저장
		String serverIP = "192.168.3.5";
//		String serverIP = "192.168.219.103";
		int port = 7777;

		try {
			// Socket 객체를 생성하는 순간
			// TcpIpMultiChatServer클래스의 serverSocket=new ServerSocket(port)를 호출한다?
			Socket socket = new Socket(serverIP, port);
			System.out.println("서버에 연결 되었습니다.");

			Thread sender = new Thread(new ClientSender(socket, name));
			Thread receiver = new Thread(new ClientReceiver(socket));

			sender.start(); // ClientSender의 run() 메서드 호출
			receiver.start(); // ClientReceiver의 run() 메서드 호출

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;
		String name;

		ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {}
		}

		@Override
		public void run() {
			Scanner scan = new Scanner(System.in);

			try {
				if (out != null) {
					out.writeUTF(name); // 이름 전송
				}

				// 사용자 입력 메시지
				while (out != null) {
					String sendMsg = "[" + name + "]" + scan.nextLine();
					out.writeUTF(sendMsg);
				}

			} catch (IOException e) {
			}
		}

	}

	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;

		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (in != null) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {
					// e.printStackTrace();
				}
			}
		}

	}

}
