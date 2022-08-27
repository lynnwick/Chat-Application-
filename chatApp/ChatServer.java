package sockets;

import java.net.*;
import java.io.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

	private Socket socket;
	private ServerSocket server;
	private DataInputStream in;

	public ChatServer() {
		try (ServerSocket server = new ServerSocket(13)){
			System.out.println("Server started");
			System.out.println("Waiting a client ...");
			socket = server.accept();
			
			System.out.println("Client accepted");
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			String writer = "";
			
			//
			while (!writer.equals("q")) {  //"q" to stop and terminate chat
			try {
			writer = in.readUTF();
			System.out.println(writer);

			} catch (IOException i) {
			System.out.println(i);
			}
			}
			System.out.println("Exit: connection");
			
		} catch (IOException i) {
			System.out.println(i);
		}
	          }

	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		ExecutorService excutor = Executors.newFixedThreadPool(30);
	}
}
