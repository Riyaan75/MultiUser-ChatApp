package com.Riyaan.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//
//					DashBoard frame = new DashBoard();
//					frame.setVisible(true);
//		 
//	}

	/**
	 * Create the frame.
	 */
	public DashBoard(String message) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 880);
		
		JMenuBar chatMenu = new JMenuBar();
		setJMenuBar(chatMenu);
		
		JMenu mnNewMenu = new JMenu("Chat");
		chatMenu.add(mnNewMenu);
		
		JMenuItem startChat = new JMenuItem("startChat");
		startChat.setIcon(new ImageIcon(DashBoard.class.getResource("/images/chat.png")));
		startChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ClientChatScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(startChat);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle(message);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(DashBoard.class.getResource("/images/chit-chat.png")));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
