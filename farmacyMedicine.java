  
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JButton;



import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.print.*;
import javax.swing.JSeparator;


public class farmacyMedicine extends JFrame {
	

	private JTextField textField_Name;
	
	private JTextField textField_code;
	
	private JTextField textField_Price;
	
	private JTable table_3;
	private JTextField textField_Quantity;
	private JTextField textField_Total;
	private JTextField textField_Pay;
	private JTextField textField_Balance;
	private JTextField textField_Date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					farmacyMedicine frame = new farmacyMedicine();
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
	public farmacyMedicine() {
		
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 792);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(12, 106, 324, 626);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(28, 132, 56, 16);
		panel.add(lblNewLabel);
		
		textField_code = new JTextField();
		textField_code.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				
				if (evt.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya" ,"root" ,"aditya");
					 		PreparedStatement ps= con.prepareStatement("select*from onlinebill where code=?");
					 		
					 		ps.setString(01, textField_code.getText());
					 		ResultSet rs=ps.executeQuery();
					 		
					 		if(rs.next()==false) {
					 			JOptionPane.showMessageDialog( null, "Record Updated Successfully...");
					 		}
					 		else
					 		{
					 			String pName=rs.getString("name");
					 			String pPrice=rs.getString("price");
					 			
					 			textField_Name.setText(pName.trim());
					 			textField_Price.setText(pPrice.trim());
					 			
					 		}
							
						} catch (ClassNotFoundException e) {
							System.out.println(e);
							e.printStackTrace();
						} catch (SQLException sql) {
							// TODO Auto-generated catch block
							System.out.println(sql);
						}
					
				}
			}
		});
		textField_code.setBounds(28, 161, 177, 22);
		panel.add(textField_code);
		textField_code.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(28, 196, 56, 16);
		panel.add(lblNewLabel_1);
		
		textField_Date = new JTextField();
		textField_Date.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				Calendar timer =Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tDate =new SimpleDateFormat("dd-MMM-YYYY");
				tDate.format(timer.getTime());
				textField_Date.setText(String.valueOf(tDate.format(timer.getTime())));
			}
		});
		
		textField_Date.setBounds(28, 97, 177, 22);
		panel.add(textField_Date);
		textField_Date.setColumns(10);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(28, 225, 177, 22);
		panel.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2.setBounds(28, 260, 67, 26);
		panel.add(lblNewLabel_2);
		
	
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_3.setBounds(28, 334, 56, 16);
		panel.add(lblNewLabel_3);
		
		textField_Price = new JTextField();
		textField_Price.setText("");
		textField_Price.setBounds(28, 363, 177, 22);
		panel.add(textField_Price);
		textField_Price.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Amount");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_4.setBounds(28, 398, 67, 16);
		panel.add(lblNewLabel_4);
		
		JTextField textField_amount = new JTextField();
		textField_amount.setText("");
		textField_amount.setBounds(28, 427, 177, 22);
		panel.add(textField_amount);
		textField_amount.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
			 		System.out.println("Connecting to database");
			 		System.out.println("Connected sussfully");
			 		
			 		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya" ,"root" ,"aditya");
			 		PreparedStatement ps1=conn.prepareStatement("insert into data values(?,?,?,?,?,?)");
			 		
			 		 ps1.setString(1, textField_Date.getText());
			 	    ps1.setString(2, textField_code.getText());
			 	    ps1.setString(3, textField_Name.getText());
			 	    ps1.setString(4, textField_Quantity.getText());
			 	   ps1.setString(5, textField_Price.getText());
			 	  ps1.setString(6, textField_amount.getText());
			 		
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
				DefaultTableModel model=new DefaultTableModel();
				model=(DefaultTableModel)table_3.getModel();
				model.addRow(new Object[]
						{
								textField_code.getText(),
								textField_Name.getText(),
								textField_Quantity.getText(),
								textField_Price.getText(),
								textField_amount.getText(),
								
								
								
								
						});
				int sum = 0;
				
				for(int i=0;i<table_3.getRowCount();i++) {
					sum=sum+Integer.parseInt(table_3.getValueAt(i, 4).toString());
				}
				textField_Total.setText(Integer.toString(sum));

				
				textField_code.setText("");
				textField_Name.setText("");
				textField_Quantity.setText("");
				textField_Price.setText("");
				textField_amount.setText("");
				textField_code.requestFocus();
				
			}
		});
		btnNewButton.setBounds(28, 493, 129, 42);
		panel.add(btnNewButton);
		
		textField_Quantity = new JTextField();
		textField_Quantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int qut=Integer.parseInt(textField_Quantity.getText().toString());
				int prec=Integer.parseInt(textField_Price.getText());
				
				int tot=qut*prec;
				textField_amount.setText(String.valueOf(tot));
			}
		});
		textField_Quantity.setBounds(28, 299, 177, 22);
		panel.add(textField_Quantity);
		textField_Quantity.setColumns(10);
		
		textField_Date = new JTextField();
		textField_Date.setBounds(28, 97, 177, 22);
		panel.add(textField_Date);
		textField_Date.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Date");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(28, 57, 67, 27);
		panel.add(lblNewLabel_10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 106, 801, 232);
		getContentPane().add(scrollPane);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code", "Name", "Quantity", "Price", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(348, 351, 352, 381);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(12, 13, 85, 28);
		panel_1.add(lblNewLabel_5);
		
		textField_Total = new JTextField();
		textField_Total.setBounds(109, 13, 164, 28);
		panel_1.add(textField_Total);
		textField_Total.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(712, 351, 337, 381);
		getContentPane().add(scrollPane_1);
		
		JTextArea Bill = new JTextArea();
		Bill.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		scrollPane_1.setViewportView(Bill);
		
		
		JLabel lblNewLabel_6 = new JLabel("Pay");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(12, 71, 85, 28);
		panel_1.add(lblNewLabel_6);
		
		textField_Pay = new JTextField();
		textField_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Pay=Integer.parseInt(textField_Pay.getText().toString());
				int Total=Integer.parseInt(textField_Total.getText());
				
				int bal=Pay-Total;
				textField_Balance.setText(String.valueOf(bal));
			}
		});
		textField_Pay.setText("");
		textField_Pay.setBounds(109, 71, 164, 28);
		panel_1.add(textField_Pay);
		textField_Pay.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Balance");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(12, 124, 85, 28);
		panel_1.add(lblNewLabel_7);
		
		textField_Balance = new JTextField();
		
		textField_Balance.setBounds(109, 124, 164, 28);
		panel_1.add(textField_Balance);
		textField_Balance.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Recipt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String total= textField_Total.getText();
				String pay= textField_Pay.getText();
				String balance= textField_Balance.getText();
				
				DefaultTableModel model=new DefaultTableModel();
				
				model=(DefaultTableModel)table_3.getModel();
				//==================================================================================
				Calendar timer =Calendar.getInstance();
				timer.getTime();
				
				SimpleDateFormat tTime =new SimpleDateFormat("HH:mm:ss");
				tTime.format(timer.getTime());
				
				SimpleDateFormat tDate =new SimpleDateFormat("dd-MMM-YYYY");
				tDate.format(timer.getTime());
				//====================================================================================
				
				
				
				Bill.setText(Bill.getText()+"************************************************\n");
				Bill.setText(Bill.getText()+"*******************Medical Bill*****************\n");
				Bill.setText(Bill.getText()+"************************************************\n");
				
				Bill.setText(Bill.getText()+"\t" + "\t" + "Date:" +tDate.format(timer.getTime())+  "\n" );
				Bill.setText(Bill.getText()+"\t" + "\t" + "Time:" +tTime.format(timer.getTime())+  "\n" );
				
				
				Bill.setText(Bill.getText()+"Product" + "\t" + "Price" + "\t" + "Amount" + "\n" );
				
				for(int i=0;i<table_3.getRowCount();i++) {
					String Pname =(String)model.getValueAt(i, 1);
					String Price =(String)model.getValueAt(i, 3);
					String amount =(String)model.getValueAt(i, 4);
				
				Bill.setText(Bill.getText()+ Pname  + "\t" + Price + "\t" + amount + "\n" );
				}
				Bill.setText(Bill.getText()+"\n");
				Bill.setText(Bill.getText()+"\n");
				Bill.setText(Bill.getText()+"\n");
				
				Bill.setText(Bill.getText()+"\t" + "\t" + "SubTotal" + total+  "\n" );
				Bill.setText(Bill.getText()+"\t" + "\t" + "Pay" + pay+  "\n" );
				Bill.setText(Bill.getText()+"\t" + "\t" + "Balance" + balance+  "\n" );
				
			
				
				
				Bill.setText(Bill.getText()+"************************************************\n");
				Bill.setText(Bill.getText()+"********************ThankYou********************\n");
				Bill.setText(Bill.getText()+"************************************************\n");
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.setBounds(109, 184, 164, 50);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(50, 13, 1051, 63);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("pharmacy Bill");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(296, 13, 400, 37);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Online Bill");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(962, 34, 77, 16);
		panel_2.add(lblNewLabel_9);
		
		JButton btnNewButton_2 = new JButton("Main ");
		btnNewButton_2.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmacyTh th=new farmacyTh();
				th.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(1052, 452, 97, 25);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Bill.print();
				}
				catch(PrinterException e1){
					System.err.format("no printer found", e1.getMessage());
					
				}
			}
		});
		btnNewButton_3.setBounds(1052, 387, 97, 25);
		getContentPane().add(btnNewButton_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1052, 431, 97, 8);
		getContentPane().add(separator);
		
		
		
		
	}
}
