
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class addmedicin extends JFrame {

	private JPanel contentPane;
	private JTextField TextField_Code;
	private JTextField textField_Name;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addmedicin frame = new addmedicin();
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
	public addmedicin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Code");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(42, 266, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		TextField_Code = new JTextField();
		TextField_Code.setBounds(146, 260, 116, 22);
		contentPane.add(TextField_Code);
		TextField_Code.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(42, 308, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(146, 302, 116, 22);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(42, 350, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 347, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(354, 171, 575, 414);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
				Class.forName("com.mysql.cj.jdbc.Driver");
		 		System.out.println("Connecting to database");
		 		System.out.println("Connected sussfully");
		 		
		 		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya" ,"root" ,"aditya");
		 		PreparedStatement ps1=conn.prepareStatement("insert into onlinebill values(?,?,?)");
		 		
		 	
		 	    ps1.setString(1, TextField_Code.getText());
		 	    ps1.setString(2, textField_Name.getText());
		 	    ps1.setString(3, textField_2.getText());
		 		
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


				catch(Exception ae)
				{
					 
					System.out.println(ae);
				}
				
				
				TextField_Code.setText("");
		 	    textField_Name.setText("");
		 	   textField_2.setText("");
		}
        
		 	
			
			
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(54, 404, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
			 		System.out.println("Connecting to database");
			 		System.out.println("Connected sussfully");
			 		
			 		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya" ,"root" ,"aditya");
			 		PreparedStatement ps1=conn.prepareStatement("select* from onlinebill");
			 		ResultSet rs=ps1.executeQuery();
			 		
			 		table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ae)
				{
					 
					System.out.println(ae);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(198, 405, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setForeground(Color.WHITE);
		panel.setBounds(42, 23, 962, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Medicine Update");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(257, 13, 459, 56);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(578, 118, 126, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tabel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(12, 0, 83, 25);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Go Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmacyTh th=new farmacyTh();
				th.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_2.setBounds(129, 472, 97, 25);
		contentPane.add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 453, 306, 6);
		contentPane.add(separator);
	}

}
