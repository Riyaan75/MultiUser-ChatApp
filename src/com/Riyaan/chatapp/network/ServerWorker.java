package com.Riyaan.chatapp.network;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

//we want to handshake with multiple workers and we create per client per thread
public class ServerWorker extends Thread{
	private Socket clientSocket;
	// ek worker ko ek thread to input stream kholaga  aur out put bhi
	private InputStream in;
	private OutputStream out;
	private Server server;
	public ServerWorker(Socket clientSocket ,Server server) throws IOException {
		this.server = server;
		this.clientSocket = clientSocket;
		in = clientSocket.getInputStream();// client data read
	
		out = clientSocket.getOutputStream();//client data write
		System.out.println("New Client comes");
	}
	@Override
	public void run() {
		//read data from the cliient and Broadcast the data to all
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		// bufferedReader read data line by line
		String line;
		try {
		while(true) {
			
				line = br.readLine();//\n is required
				System.out.println("line read...." +line);
				
				if(line.equalsIgnoreCase("quit")) {
					break;//client chat end
				}
				//getting and printing data
				// this code will only get data of one client
				//out.write(line.getBytes());
				// Broad cast to all client and data 
				for(ServerWorker serverWorker : server.workers) {
					line = line+"\n";
					serverWorker.out.write(line.getBytes());
				
				}
			
		
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		finally {
			try {
			if(br!=null) {
				br.close();
			}
			if(in!=null) {
				in.close();
			}
			if(out!=null) {
				out.close();
			}
			if(clientSocket!=null) {
				clientSocket.close();
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
/*
 Thread  == Worker
 Worker need a job to perform 
 For job u give runnable
runnable is an interface
 once job is created via Runnable so write the job logic inside a run function
 Assign a job to thread/worker
 main is itself a thread but when you write Thread worker = new Thread(job)
new threads get created
every thread has its on stack

public class ServerWorker implements Runnable {
another approach useing Thread class(which already using runnable
we use runnable when we are already extending other class

public class ServerWorker extends Thread{
	@Override
	public void run() {
		// Job to perform
		//logic
		for(int i=1;i<=5;i++) {
			System.out.println("Run I is"+i+" "+Thread.currentThread());
			// trying to slow or stop a thread
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	public static void main(String[] args) {
		ServerWorker worker = new ServerWorker();
		worker.start();
		
//		ServerWorker job = new ServerWorker();
		//Assign the job to a thread/ Worker
		// below two lines are to be used with runnable
//		Thread worker = new Thread(job,"worker1");
//		worker.start();//internally it call run()
		for(int j=1;j<=5;j++) {
			System.out.println("Main "+j+" "+Thread.currentThread());
		}
	}
}
*/
