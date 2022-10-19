package com.Riyaan.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.Riyaan.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker worker;
	JTextArea textArea;
	
	public void sendMessage(String message) throws IOException {
		message = message+"\n";
		out.write(message.getBytes());
		
	}
	public void readMessage() {
		worker  = new ClientWorker(in,textArea); // calling a read thread
		worker.start();
	}
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int PORT =Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		out = socket.getOutputStream();
		in = socket.getInputStream();
		this.textArea = textArea;
		//internally calling readMessage
		readMessage();
		
//		single thread for reference
//		System.out.println("Client Comes ");
//		System.out.println("Enter the Message Send to the Server....");
//		Scanner scanner = new Scanner(System.in);
//		String message = scanner.nextLine();
//		OutputStream out = socket.getOutputStream();// Writes bytes on Network
//		out.write(message.getBytes());
//		System.out.println("message send to the server");
//		out.close();
//		scanner.close();
//		socket.close();
	}
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		Client client = new Client();
//	}
}
