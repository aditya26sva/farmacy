import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class farmacySP extends JFrame {

	private JPanel contentPane;
	private JTextField UsernameField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					farmacySP frame = new farmacySP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public farmacySP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(602, 106, 176, 32);
		contentPane.add(UsernameField);
		UsernameField.setColumns(10);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 22));
		UsernameLabel.setBounds(626, 61, 110, 32);
		contentPane.add(UsernameLabel);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 22));
		lblNewLabel.setBounds(626, 151, 110, 32);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(602, 196, 176, 32);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("signin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
			 	{
					if (UsernameField != null && passwordField != null)
					{
			 		Class.forName("com.mysql.cj.jdbc.Driver");
			 		System.out.println("Connecting to database");
			 		System.out.println("Connected sussfully");
				
			 		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya" ,"root" ,"aditya");

                   PreparedStatement ps1=conn.prepareStatement(  "select * from pharmacy where usernmae=? and password=?");  
                   ps1.setString(1,UsernameField.getText());  
                   ps1.setString(2,passwordField.getText());  
                   ResultSet rs=ps1.executeQuery();
                   
			 		
			 	    if(rs.next())
			 		 {
			 			 JOptionPane.showMessageDialog(null, "Login successfully...");
			 			 new farmacyTh().setVisible(true);
			 			
			 		 }
			 		 else
			 		 {
			 			JOptionPane.showMessageDialog(null, "Login Failed...");
			 		 }
			 		
					}
				
			}
				
				catch(SQLException sql)
				{
					System.out.println(sql);
				}


					catch(Exception e1)
					{
						 
						System.out.println(e1);
					}
			}
		});
		btnNewButton.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18));
		
	
		btnNewButton.setBounds(626, 254, 136, 32);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setIcon(new ImageIcon(farmacySP.class.getResource("/image/makingmedicines784.jpg")));
		lblNewLabel_1.setBounds(12, 13, 413, 373);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(602, 309, 176, 2);
		contentPane.add(separator);
		
		JButton btnNewButton_1 = new JButton("Signup");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmacySignup fys=new farmacySignup();
				fys.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18));
		btnNewButton_1.setBounds(626, 335, 136, 32);
		contentPane.add(btnNewButton_1);
	}
}
