package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(30000);
			
			while (true) {
				Socket s = ss.accept();
				System.out.println("IP:" + s.getInetAddress() + " connect this server!!");
				
				PrintStream ps = new PrintStream(s.getOutputStream());
				
				ps.println("Hello Client, I'm server.");
				ps.close();
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
