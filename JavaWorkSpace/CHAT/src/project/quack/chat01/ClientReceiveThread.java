package project.quack.chat01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.internal.StringUtil;

public class ClientReceiveThread extends Thread {

	private final Socket socket;
	private String receiveString;
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("(HH:mm:ss) ");
	

	public ClientReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
			while (true) {
				receiveString = tmpbuf.readUTF();
				System.out.printf("\n" + formatter.format(date) + "카운터 : " + receiveString + "\n");
				if (receiveString == null) {
					System.out.println("상대방 연결이 종료되었습니다.");
				} else if(receiveString.equals("/q")) {
						System.out.println("채팅을 종료 합니다.");
						tmpbuf.close();
				} else {
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
