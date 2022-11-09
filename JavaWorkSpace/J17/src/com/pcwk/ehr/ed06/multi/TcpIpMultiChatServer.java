package com.pcwk.ehr.ed06.multi;

import java.io.*;
import java.net.*;
import java.util.*;

public class TcpIpMultiChatServer {
	HashMap clients;

	public TcpIpMultiChatServer() {
		clients = new HashMap(); // thread unsafe
		Collections.synchronizedMap(clients); // thread safe
	}

	public static void main(String args[]) {
		new TcpIpMultiChatServer().start();
	}

	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		int port = 8888;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("서버 start~~");
			while (true) {
				socket = serverSocket.accept();
				String clientInfo = "[" + socket.getInetAddress() + "]에서 접속하였습니다.";
				System.out.println(clientInfo);
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (IOException e) {
		}
	}

	// 접속된 모든 사용자에게 메세지 전달
	void sendToAll(String msg) {
		Iterator iter = clients.keySet().iterator();

		while (iter.hasNext() == true) {
			String name = (String) iter.next(); // 접속자 이름
			DataOutputStream out = (DataOutputStream) clients.get(name);

			// client로 msg전송
			try {
				out.writeUTF(msg);
			} catch (IOException e) {
			}
		}
	}

	// clients 요청을 받는다.
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream()); // inputstream
				out = new DataOutputStream(socket.getOutputStream()); // outputstream
			} catch (IOException e) {
			}

		}

		@Override
		public void run() {
			String name = ""; // client 이름

			try {
				name = in.readUTF();

				sendToAll("#" + name + "님이 입장 하셨습니다.");

				// client에 접속 정보 저장 : 사용자 이름, DataOutputStream
				clients.put(name, out);

				// 현재 접속자 수
				System.out.println("현재 접속자 수는 " + clients.size() + "입니다.");
				while (null != in) {
					sendToAll(in.readUTF()); // client가 보낸 메시지를 모든 사람에게 전송.
				}
			} catch (IOException e) {
			} finally {
				sendToAll("#" + name + "님이 퇴장 하셨습니다.");
				clients.remove(name);
				System.out.println("현재 접속자 수는 " + clients.size() + "입니다.");
			}
		}
	}
}
