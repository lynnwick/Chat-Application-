package sockets;

import java.net.*;
import java.io.*;

	//referenceMaterial:Java Coding Community - Programming Tutorials

public class ChatClient {
	
	private Socket socket;
	private BufferedReader input;
	private DataOutputStream out;

	
	public ChatClient(String address, int port) {

		try (Socket socket= new Socket(address, port)){
			System.out.println("Connected");
			input = new BufferedReader(new InputStreamReader(System.in));
			out = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException u) {
			System.out.println(u);
		} catch (IOException i) {
			System.out.println(i);
		}
		 String writer = "";
		 while (!writer.equals("q")) {
		 try {
		 writer = input.readLine();
		 out.writeUTF(writer);
		} catch (IOException i) {
		   System.out.println(i);
		   }
		}
		
	}

	public static void main(String args[]) {
		ChatClient client = new ChatClient("", 13);
	}
}
