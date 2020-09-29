import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import java.awt.print.*;

public class farmacyEquipment extends JFrame {

	private JPanel contentPane;
	private JTextField textField_serialno;
	private JTextField textField_Name;
	private JTextField textField_Quantity;
	private JTextField textField_Price;
	private JTextField textField_Amount;
	private JTextField textField_Total;
	private JTextField textField_Pay;
	private JTextField textField_Balance;
	private JTable table;
	private JTextField textField_Date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					farmacyEquipment frame = new farmacyEquipment();
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
	public farmacyEquipment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1208, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(25, 13, 1153, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EquipmentBill");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(269, 13, 484, 49);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(368, 101, 810, 244);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serialno", "Name", "Quantity", "Price", "Amount"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(25, 101, 331, 508);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Serial no");
		lblNewLabel_1.setBounds(12, 80, 56, 16);
		panel_1.add(lblNewLabel_1);
		
		textField_serialno = new JTextField();
		textField_serialno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya" ,"root" ,"aditya");
			 		PreparedStatement ps= con.prepareStatement("select*from equipment where serialno=?");
			 		
			 		ps.setString(01, textField_serialno.getText());
			 		ResultSet rs=ps.executeQuery();
			 		
			 		if(rs.next()==false) {
			 			JOptionPane.showMessageDialog( null, "Record Updated Successfully...");
			 		}
			 		else
			 		{
			 			String pName=rs.getString("name");
			 			String pPrice=rs.getString("code");
			 			
			 			textField_Name.setText(pName.trim());
			 			textField_Price.setText(pPrice.trim());
			 			
			 		}
					
				} catch (ClassNotFoundException e1) {
					System.out.println(e1);
					e1.printStackTrace();
				} catch (SQLException sql) {
					// TODO Auto-generated catch block
					System.out.println(sql);
				}
			
		
			}
		});
		textField_serialno.setBounds(116, 77, 158, 22);
		panel_1.add(textField_serialno);
		textField_serialno.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(12, 133, 56, 16);
		panel_1.add(lblNewLabel_2);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(116, 130, 158, 22);
		panel_1.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setBounds(12, 187, 56, 16);
		panel_1.add(lblNewLabel_3);
		
		textField_Quantity = new JTextField();
		textField_Quantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qut=Integer.parseInt(textField_Quantity.getText().toString());
				int prec=Integer.parseInt(textField_Price.getText());
				
				int tot=qut*prec;
				textField_Amount.setText(String.valueOf(tot));
			}
			
		});
		textField_Quantity.setBounds(116, 184, 158, 22);
		panel_1.add(textField_Quantity);
		textField_Quantity.setColumns(10);
		
		textField_Price = new JTextField();
		textField_Price.setBounds(116, 243, 158, 22);
		panel_1.add(textField_Price);
		textField_Price.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(12, 246, 56, 16);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setBounds(12, 299, 56, 16);
		panel_1.add(lblNewLabel_5);
		
		textField_Amount = new JTextField();
		textField_Amount.setBounds(116, 296, 158, 22);
		panel_1.add(textField_Amount);
		textField_Amount.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=new DefaultTableModel();
				model=(DefaultTableModel)table.getModel();
				model.addRow(new Object[]
						{
								textField_serialno.getText(),
								textField_Name.getText(),
								textField_Quantity.getText(),
								textField_Price.getText(),
								textField_Amount.getText(),
								
								
								
								
						});
				int sum = 0;
				
				for(int i=0;i<table.getRowCount();i++) {
					sum=sum+Integer.parseInt(table.getValueAt(i, 4).toString());
				}
				textField_Total.setText(Integer.toString(sum));
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
			 		System.out.println("Connecting to database");
			 		System.out.println("Connected sussfully");
			 		
			 		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya" ,"root" ,"aditya");
			 		PreparedStatement ps1=conn.prepareStatement("insert into data values(?,?,?,?,?,?)");
			 		
			 		 ps1.setString(1, textField_Date.getText());
			 	    ps1.setString(2, textField_serialno.getText());
			 	    ps1.setString(3, textField_Name.getText());
			 	    ps1.setString(4, textField_Quantity.getText());
			 	   ps1.setString(5, textField_Price.getText());
			 	  ps1.setString(6, textField_Amount.getText());
			 		
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
				
				textField_serialno.setText("");
				textField_Name.setText("");
				textField_Quantity.setText("");
				textField_Price.setText("");
				textField_Amount.setText("");
				textField_serialno.requestFocus();
				
			}
			
		});
		btnNewButton.setBounds(116, 352, 158, 44);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("Date");
		lblNewLabel_9.setBounds(12, 36, 56, 16);
		panel_1.add(lblNewLabel_9);
		
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
		
		textField_Date.setBounds(116, 33, 158, 22);
		panel_1.add(textField_Date);
		textField_Date.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(368, 358, 313, 253);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Total");
		lblNewLabel_6.setBounds(22, 13, 56, 16);
		panel_2.add(lblNewLabel_6);
		
		textField_Total = new JTextField();
		textField_Total.setBounds(112, 10, 170, 22);
		panel_2.add(textField_Total);
		textField_Total.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Pay");
		lblNewLabel_7.setBounds(22, 70, 56, 16);
		panel_2.add(lblNewLabel_7);
		
		textField_Pay = new JTextField();
		textField_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Pay=Integer.parseInt(textField_Pay.getText().toString());
				int Total=Integer.parseInt(textField_Total.getText());
				
				int bal=Pay-Total;
				textField_Balance.setText(String.valueOf(bal));
			}
		});
		textField_Pay.setBounds(112, 67, 170, 22);
		panel_2.add(textField_Pay);
		textField_Pay.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Balance");
		lblNewLabel_8.setBounds(22, 134, 56, 16);
		panel_2.add(lblNewLabel_8);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(693, 358, 348, 253);
		contentPane.add(scrollPane_1);
		
		JTextArea Bill = new JTextArea();
		scrollPane_1.setViewportView(Bill);
	
		
		textField_Balance = new JTextField();
		textField_Balance.setBounds(112, 131, 170, 22);
		panel_2.add(textField_Balance);
		textField_Balance.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Recipt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String total= textField_Total.getText();
				String pay= textField_Pay.getText();
				String balance= textField_Balance.getText();
				
				DefaultTableModel model=new DefaultTableModel();
				
				model=(DefaultTableModel)table.getModel();
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
				
				for(int i=0;i<table.getRowCount();i++) {
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
		btnNewButton_1.setBounds(141, 182, 97, 25);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Bill.print();
				}
				catch(PrinterException e1){
					System.err.format("no printer found", e1.getMessage());
					
				}
			}
		});
		btnNewButton_2.setBounds(1066, 369, 97, 25);
		contentPane.add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1053, 416, 125, 9);
		contentPane.add(separator);
		
		JButton btnNewButton_3 = new JButton("Main");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmacyTh th=new farmacyTh();
				th.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(1066, 438, 97, 25);
		contentPane.add(btnNewButton_3);
		
	
	}
}
