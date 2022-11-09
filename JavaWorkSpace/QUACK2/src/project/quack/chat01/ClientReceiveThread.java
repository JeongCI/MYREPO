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
				if(receiveString.equalsIgnoreCase("/q")) {
					System.out.println("테이블이 연결을 종료하였습니다.");  //받은 메시지 출력
					break;  //"q"를 받으면 연결 종료
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
