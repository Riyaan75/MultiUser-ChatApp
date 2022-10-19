package com.Riyaan.chatapp.network;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
// client data read
public class ClientWorker extends Thread {
	// it will be reading data therefore inputStream\
	private InputStream in;
	private JTextArea textArea;
	public ClientWorker(InputStream in, JTextArea textArea) {
		this.in = in;
		this.textArea = textArea;
	}
	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
		while(true) {
			line = br.readLine()+"\n";
			// reading old + new messages
//			System.out.println(line);
			textArea.setText(textArea.getText()+ line);
			
		}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(in!=null) {
				try {
					in.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
