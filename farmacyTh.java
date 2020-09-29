import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class farmacyTh extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					farmacyTh frame = new farmacyTh();
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
	public farmacyTh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(farmacyTh.class.getResource("/image/makingmedicines784.jpg")));
		lblNewLabel.setBounds(12, 13, 389, 365);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type of product");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(569, 13, 140, 40);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Medicine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmacyMedicine fm= new farmacyMedicine();
				fm.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(457, 87, 108, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Equipment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmacyEquipment fE=new farmacyEquipment();
				fE.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(457, 174, 108, 25);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(440, 138, 414, 7);
		contentPane.add(separator);
		
		JButton btnNewButton_3 = new JButton("Add Medicin");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addmedicin ad =new addmedicin();
				ad.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(675, 87, 140, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add Equipment");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipment eq=new equipment();
				eq.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(675, 174, 140, 25);
		contentPane.add(btnNewButton_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(440, 236, 414, 12);
		contentPane.add(separator_1);
		
		JButton btnNewButton_2 = new JButton("Record");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				record rd=new record();
				rd.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(590, 261, 97, 25);
		contentPane.add(btnNewButton_2);
		
		
	}
}
