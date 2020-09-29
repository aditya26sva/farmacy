import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class farmacySignup extends JFrame {

	private JPanel contentPane;
	private JTextField id_field;
	private JTextField name_field;
	private JTextField username_field;
	private JTextField password_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					farmacySignup frame = new farmacySignup();
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
	public farmacySignup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(farmacySignup.class.getResource("/image/makingmedicines784.jpg")));
		lblNewLabel.setBounds(12, 13, 389, 365);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Signup");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_1.setBounds(607, 13, 69, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(413, 56, 29, 16);
		contentPane.add(lblNewLabel_2);
		
		id_field = new JTextField();
		id_field.setBounds(542, 51, 154, 22);
		contentPane.add(id_field);
		id_field.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(413, 87, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		name_field = new JTextField();
		name_field.setBounds(542, 86, 154, 22);
		contentPane.add(name_field);
		name_field.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(413, 122, 87, 16);
		contentPane.add(lblNewLabel_4);
		
		username_field = new JTextField();
		username_field.setBounds(542, 121, 154, 22);
		contentPane.add(username_field);
		username_field.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(413, 161, 87, 16);
		contentPane.add(lblNewLabel_5);
		
		password_field = new JTextField();
		password_field.setBounds(542, 156, 154, 22);
		contentPane.add(password_field);
		password_field.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(414, 210, 453, 10);
		contentPane.add(separator);
		
		JButton submit_btn = new JButton("Submit");
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
			 	{
			 		Class.forName("com.mysql.cj.jdbc.Driver");
			 		System.out.println("Connecting to database");
			 		System.out.println("Connected sussfully");
				
			 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya" ,"root" ,"aditya");
			 		PreparedStatement ps= con.prepareStatement("insert into pharmacy values(?,?,?,?)");
			 		ps.setString(1, id_field.getText());
			 		ps.setString(2, name_field.getText());
			 		ps.setString(3, username_field.getText());
			 		ps.setString(4, password_field.getText());
			 		
			 		
			 	
			 		 int x = ps.executeUpdate();
			 		 if(x>0)
			 		 {
			 			 System.out.println("Registration submitted successfully..");
			 		 }
			 		 else
			 		 {
			 			 System.out.println("Registration Failed...");
			 		 }
			 		
			 		
				}
			 	
				
				catch(SQLException sql)
				{
					System.out.println(sql);
				}


					catch(Exception ae)
					{
						 
						System.out.println(ae);
					}
			}
		});
		submit_btn.setBounds(424, 233, 97, 25);
		contentPane.add(submit_btn);
		
		JButton clear_btn = new JButton("Clear");
		clear_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id_field.setText("");
				name_field.setText("");
			 	username_field.setText("");
				password_field.setText("");
			}
		});
		clear_btn.setBounds(542, 233, 97, 25);
		contentPane.add(clear_btn);
		
		JButton update_btn = new JButton("Update");
		update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
			 	{
					
					
			 		Class.forName("com.mysql.cj.jdbc.Driver");
			 		System.out.println("Connecting to database");
			 		System.out.println("Connected sussfully");
			 		
			 		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya" ,"root" ,"aditya");
			 		PreparedStatement ps1=conn.prepareStatement("Update pharmacy set name=?, usenmae=?,  password=? where id=?");
			 		
			 	
			 	    ps1.setString(1, id_field.getText());
			 	    ps1.setString(2, name_field.getText());
			 	    ps1.setString(3, username_field.getText());
			 		ps1.setString(4, password_field.getText());
			 	   int x=ps1.executeUpdate();
			 	   
			 	 if(x>0)
			 		 {
			 			 JOptionPane.showMessageDialog(null, "Record Updated Successfully...");
			 			
			 		 }
			 		 else
			 		 {
			 			JOptionPane.showMessageDialog(null, "Invalid Record...");
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
		update_btn.setBounds(651, 233, 97, 25);
		contentPane.add(update_btn);
		
		JButton goback_btn = new JButton("GoBack");
		goback_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmacySP sy=new farmacySP();
				sy.setVisible(true);
			}
		});
		goback_btn.setBounds(760, 233, 97, 25);
		contentPane.add(goback_btn);
	}

}
