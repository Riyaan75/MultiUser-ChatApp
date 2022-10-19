package com.Riyaan.chatapp.network;
import com.Riyaan.chatapp.network.ServerWorker;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.Riyaan.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers = new ArrayList<>();//contains all the client sockets
	//multiple client
	public Server() throws IOException {
		int PORT =Integer.parseInt(ConfigReader.getValue("PORTNO"));
   	    serverSocket = new ServerSocket(PORT);
   	    System.out.println("Server start and waiting for the clients to join...");
   	    handleClientRequest();
	}
	//multiple client handshaking
	public void handleClientRequest() throws IOException {
		while(true) {
	    	 Socket clientSocket = serverSocket.accept();//handshaking
	    	 //per client per thread
	    	 ServerWorker serverWorker = new ServerWorker(clientSocket,this);//creating a new thread
	    	 workers.add(serverWorker);
	    	 serverWorker.start();
	   	    }
	}
	
	/*Single client logic
     public Server() throws IOException {
    	 int PORT =Integer.parseInt(ConfigReader.getValue("PORTNO"));
    	 serverSocket = new ServerSocket(PORT);
    	 System.out.println("Server Started and waiting for the Client Connection...");
    	 Socket socket = serverSocket.accept();//handshaking
    	 System.out.print("Client joins the server");
    	 InputStream in = socket.getInputStream();//read bytes from the network
    	 byte arr[] = in.readAllBytes();
    	 String str = new String(arr);// bytes convert into String
    	 System.out.println("Message Rec From the Client "+ str);
    	 in.close();
    	 socket.close();
	}*/
     public static void main(String[] args) throws IOException {
		Server server = new Server();
	}
}
