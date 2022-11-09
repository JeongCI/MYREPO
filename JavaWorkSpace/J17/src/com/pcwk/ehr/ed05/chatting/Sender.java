package com.pcwk.ehr.ed05.chatting;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class Sender extends Thread {

	Socket socket;
	DataOutputStream out;
	String name; // 사용자 이름
	
	public Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		name = "["+socket.getInetAddress()+":"+socket.getPort()+"]";
		
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		while(null != out) {
			String msg = name+" "+sc.nextLine();
			try {
				out.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	
}
