package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 30000);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line = br.readLine();
			System.out.println("the date from server: " + line);
			
			br.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
