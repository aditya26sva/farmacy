import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class farmacyAbout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					farmacyAbout frame = new farmacyAbout();
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
	public farmacyAbout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(farmacyAbout.class.getResource("/image/makingmedicines784.jpg")));
		lblNewLabel.setBounds(12, 13, 389, 365);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("About");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(610, 13, 69, 22);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(423, 44, 444, 13);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Pharmacy is online organisation that aim making healthcare  delivery");
		lblNewLabel_2.setBounds(468, 70, 399, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("very simple,accessible and afordable.");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(433, 99, 434, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CEO");
		lblNewLabel_4.setBounds(468, 150, 36, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Aditya Sharma");
		lblNewLabel_5.setBounds(468, 179, 84, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Contact");
		lblNewLabel_6.setBounds(699, 150, 56, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("aditya.sva26@gmail.com");
		lblNewLabel_7.setBounds(699, 179, 152, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("9413731807");
		lblNewLabel_8.setBounds(699, 208, 106, 16);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd=e.getActionCommand();
				if(cmd.equals("Go Back")) {
				farmacySignup fp=new farmacySignup();
				fp.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(699, 303, 97, 25);
		contentPane.add(btnNewButton);
	}

}
