package com.Riyaan.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Riyaan.chatapp.network.Client;
import com.Riyaan.chatapp.utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					try {
						ClientChatScreen frame = new ClientChatScreen();
						//frame.setVisible(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
	
	private void sendIt() {
		String message = textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME+"-"+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea = new JTextArea();
		 client = new Client(textArea);
		setForeground(Color.BLACK);
		setTitle("Chit Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 742, 311);
		contentPane.add(scrollPane);
		
//		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textArea.setBounds(10, 25, 712, 280);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(23, 351, 556, 85);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton send = new JButton("Send Message");
		send.setFont(new Font("Tahoma", Font.PLAIN, 16));
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		send.setBounds(599, 371, 153, 29);
		contentPane.add(send);
		setVisible(true);
	}
	
}
