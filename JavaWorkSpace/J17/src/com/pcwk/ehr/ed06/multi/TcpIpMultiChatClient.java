package com.pcwk.ehr.ed06.multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpMultiChatClient {

	public static void main(String[] args) {
		
		// 사용자 이름 입력 (arguments에서 입력)
		if(args.length != 1) {
			System.out.println("대화명을 입력 하세요.");
			System.exit(0);
		}
		
		String name = args[0];
		String serverIp = "192.168.3.14";
		int port = 9500;
		
		try {
			Socket socket = new Socket(serverIp, port);
			System.out.println("서버에 연결 되었습니다.");
			Thread sender = new Thread(new ClientSender(socket, name));
			Thread receiver = new Thread(new ClientReceiver(socket));
			
			sender.start();
			receiver.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class ClientSender extends Thread{
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
		
		
		public void run() {
			Scanner sc = new Scanner(System.in);
			
			try {
			if(null != out) {
				out.writeUTF(name); // 이름 전송
			}
			
			// 사용자 입력 메세지
			while(null != out) {
				String sendMsg = "[" +name+"] "+sc.nextLine();
				out.writeUTF(sendMsg);
			}
			
			} catch(IOException e) {}
		}
	}
	
	static class ClientReceiver extends Thread{
		Socket socket;
		DataInputStream in;
		
		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {}
		}
		
		public void run() {
			while(null != in) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {}
			}
		}
	}
}
