package com.Riyaan.chatapp.views;
//import com.Riyaan.chatapp.utils.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.Riyaan.chatapp.dao.UserDAO;
import com.Riyaan.chatapp.dto.UserDTO;
import com.Riyaan.chatapp.utils.UserInfo;

public class UserScreen extends JFrame{
	private JTextField useridtxt;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public static void main(String[] args) {
		
		UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO = new UserDAO();
	private void doLogin() {
		String userid = useridtxt.getText();
		//getText method f0r string is now old there character array getPassword is used
				char[] password = passwordField.getPassword();
				String email = textField_1.getText();
				String phoneno = textField_2.getText();
				String city = textField_3.getText();
				//UserDAO userDAO = new UserDAO();
				UserDTO userDTO = new UserDTO(userid , password,email,phoneno,city);
				try {
					String message  = "";
					if(userDAO.isLogin(userDTO)) {
							message = "Welcome "+userid;
							UserInfo.USER_NAME = userid;
							JOptionPane.showMessageDialog(this, message);
							setVisible(false);
							//dispose will finish the function from memory
							dispose();
							DashBoard dashBoard = new DashBoard(message);
							dashBoard.setVisible(true);
					}
					else {
						message = "Invalid Userid or Password";
						JOptionPane.showMessageDialog(this, message);
					}
					
					//JOptionPane.showMessageDialog(this, message);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
	}
	//function that will  acquire userid and password
	private void register()     {
		String userid = useridtxt.getText();
		//getText method f0r string is now old there character array getPassword is used
		char[] password = passwordField.getPassword();
		String email = textField_1.getText();
//		if(!isvalidEmail(email)) {
//			System.out.println("wrong email");
//		}
		String phoneno = textField_2.getText();
		String city = textField_3.getText();
		//UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid , password,email,phoneno,city);//crete object of DTO which contains user info from the dao
		try {
		int result = userDAO.add(userDTO);
		if(result>0) {
			
			JOptionPane.showMessageDialog(this, "Register  Successfully");
			//System.out.println("Record added");
		}
		else {
			JOptionPane.showMessageDialog(this, "Register Fail");
		}
		}
		//Exception is parent of all exception therefore you have to write something before that
		catch(ClassNotFoundException | SQLException ex) {
			System.out.println("DB Issue ...");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("Some Generic exception Raised... ");
			ex.printStackTrace();
		}
		System.out.println("userid " + userid +" password " +password);//classname@hashcode
	}

	
	//  Create the application.
	 
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(Color.WHITE);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(303, 11, 175, 75);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(405, 100, 315, 33);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		pwdlbl.setBounds(196, 294, 107, 33);
		getContentPane().add(pwdlbl);
		
		JLabel useridlbl = new JLabel("Userid");
		useridlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		useridlbl.setBounds(196, 97, 107, 33);
		getContentPane().add(useridlbl);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(405, 297, 311, 33);
		getContentPane().add(passwordField);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//function that will collect input fields
				register();
			}
		});
		registerbt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		registerbt.setBounds(437, 359, 132, 41);
		getContentPane().add(registerbt);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		loginbt.setBounds(276, 359, 132, 41);
		getContentPane().add(loginbt);
		setBackground(Color.WHITE);
		setSize(1027,711);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(196, 165, 88, 12);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(406, 158, 314, 33);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone NO.");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(196, 203, 100, 24);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(405, 202, 315, 33);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("City");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(196, 244, 64, 30);
		getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(405, 246, 315, 33);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		setBackground(Color.WHITE);
		setSize( 933, 540);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
