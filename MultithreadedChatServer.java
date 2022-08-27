package sockets;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MultithreadedChatServer implements Runnable {

	private Socket client;

	public MultithreadedChatServer(Socket client) {
		this.client = client;

	}

	@Override
	public void run() {
		try {
			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			InputStream in = client.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String s = null;
			while ((s = reader.readLine()) != null) {
				writer.write(s + "\n");
				writer.flush();
				System.out.println("Recieved from Client:" + s);
			}

			writer.close();
			reader.close();

			client.close();

		} catch (Exception e) {
		}

	}

}
