package project.quack.chat01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerReceiveThread extends Thread {

	private final Socket socket;
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("(HH:mm:ss) ");

	public ServerReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
			String receiveString;
			while (true) {
				receiveString = tmpbuf.readUTF();
				System.out.printf("\n" + formatter.format(date) + "손님 : " + receiveString + "\n");
				if(receiveString == "/q") {
					System.out.println("채팅이 종료 되었습니다");
					tmpbuf.close();
				}
			}
		} catch (SocketException e1) {
			System.out.println("상대방 연결이 종료되었습니다.");
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
