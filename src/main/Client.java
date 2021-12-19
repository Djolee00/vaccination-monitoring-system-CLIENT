package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client implements Runnable {

	private static BufferedReader serverInput = null;
	private static BufferedReader in = null;
	private static PrintStream serverOutput = null;


	public static void main(String[] args) {

	
		
		try {
			Socket clientSocket = new Socket("localhost", 3333);

			serverInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			serverOutput = new PrintStream(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(System.in));

			new Thread(new Client()).start();;
			String messageFromServer;

			while (true) {
				messageFromServer = serverInput.readLine();
				System.out.println(messageFromServer);

				if (messageFromServer.startsWith(">> Goodbye")) {
					break;
				}
			}
			
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Server is down");
			System.exit(0);    // da onemogucim korisniku unos sa tastature, jer ta nit nastavlja da se izvrsava, ovo zaustavlja JVM 
		}  
	}

	@Override
	public void run() {
		try {
			String messageToServer;
			while (true) {
				messageToServer = in.readLine();
				serverOutput.println(messageToServer);

				if (messageToServer.startsWith("***exit")) {
					break;
				}
			}

		} catch (IOException ex) {
			System.out.println("Error with keyboard input stream");
		} catch (Exception e) {
			System.out.println("\nClient has been terminated!");
		}
	}

}
