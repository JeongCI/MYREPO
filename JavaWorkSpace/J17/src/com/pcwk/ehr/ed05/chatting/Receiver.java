package com.pcwk.ehr.ed05.chatting;

import java.io.*;
import java.net.*;

public class Receiver extends Thread {

	Socket socket;
	DataInputStream dis;

	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		if (dis != null) {
			try {
				System.out.println(dis.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
