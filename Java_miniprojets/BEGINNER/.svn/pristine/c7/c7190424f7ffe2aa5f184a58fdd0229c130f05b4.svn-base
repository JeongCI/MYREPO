package begin.doc.chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class ChatServer {

	HashMap clients;

	// defualt 생성자
	public ChatServer() {
		clients = new HashMap(); // HashMap() -> thread-unsafe

		// synchronizedMap()은 HashMap을 thread-safe하게 해준다.
		Collections.synchronizedMap(clients);
	}

	// main() 메서드
	public static void main(String[] args) {
		new ChatServer().start();
	}

	// 서버 start 메서드
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		int port = 7777;

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("서버 START.");

			while (true) { // 서버는 계속 떠있어야 하기때문에 무한 루프
				socket = serverSocket.accept();

				String clientInfo = "[" + socket.getInetAddress() + "] 에서 접속하였습니다.";
				System.out.println(clientInfo);

				ServerReceiver thread = new ServerReceiver(socket);
				thread.start(); // 내부적으로 run() 호출

			}

		} catch (IOException e) {

		}

	}

	// 접속된 모든 사용자에게 메시지 전달
	void sendToAll(String msg) {

		Iterator iter = clients.keySet().iterator();

		// 사용자 하나 하나에 메시지 전송
		while (iter.hasNext()) { // 데이터가 있으면 true
			String name = (String) iter.next(); // iter.next()로 name을 꺼냄
			DataOutputStream out = (DataOutputStream) clients.get(name); // name으로 client의 내용을 꺼냄

			// client로 msg 전송
			try {
				out.writeUTF(msg);
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}

	}

	// inner class, client 요청을 받는다.
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		// 생성자
		ServerReceiver(Socket socket) {
			this.socket = socket;

			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String name = ""; // client 이름

			try {
				name = in.readUTF();

				sendToAll("#" + name + "님이 입장 하였습니다.");

				// clinets에 접속자 정보 저장 : 사용자 이름, DataOutputStream
				clients.put(name, out);

				// 현재 접속자 수
				System.out.println("현재 서버 접속자 수는 " + clients.size() + "명 입니다.");

				while (in != null) {
					// 읽어 들인 내용을 계속 전송
					sendToAll(in.readUTF());
				}

			} catch (IOException e) {

			} finally {
				sendToAll("#" + name + "님이 퇴장하였습니다.");
				clients.remove(name);
				System.out.println("현재 서버 접속자 수는 " + clients.size() + "명 입니다.");
			}
		}

	}

}
