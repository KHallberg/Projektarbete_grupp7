package se.mah.k3;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Test1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 frame = new Test1();
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
	public Test1() 
	{
		setBackground(Color.GRAY);Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, (int)width, (int)height);
		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Futura LT", Font.PLAIN, 54));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(862, 67, 262, 50);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("TIME");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Futura LT", Font.PLAIN, 54));
		lblTime.setBounds(862, 130, 262, 50);
		contentPane.add(lblTime);
		
		JLabel lblHeadline = new JLabel("HEADLINE");
		lblHeadline.setFont(new Font("Futura LT", Font.PLAIN, 39));
		lblHeadline.setForeground(Color.BLACK);
		lblHeadline.setBounds(85, 342, 271, 50);
		contentPane.add(lblHeadline);
		
		JLabel lblTime_1 = new JLabel("TIME");
		lblTime_1.setFont(new Font("Futura LT", Font.PLAIN, 13));
		lblTime_1.setForeground(Color.BLACK);
		lblTime_1.setBounds(85, 422, 56, 16);
		contentPane.add(lblTime_1);
		
		JLabel lblPlace = new JLabel("PLACE");
		lblPlace.setFont(new Font("Futura LT", Font.PLAIN, 13));
		lblPlace.setBounds(85, 451, 56, 16);
		contentPane.add(lblPlace);
		
		JTextPane txtpnDetails = new JTextPane();
		txtpnDetails.setEditable(false);
		txtpnDetails.setFont(new Font("Futura LT", Font.PLAIN, 13));
		txtpnDetails.setText("DETAILS");
		txtpnDetails.setBounds(85, 526, 484, 329);
		contentPane.add(txtpnDetails);
		
		JLabel lblHeadline_1 = new JLabel("HEADLINE");
		lblHeadline_1.setFont(new Font("Futura LT", Font.PLAIN, 13));
		lblHeadline_1.setBounds(1273, 300, 89, 16);
		contentPane.add(lblHeadline_1);
		
		JLabel lblTime_2 = new JLabel("TIME");
		lblTime_2.setFont(new Font("Futura LT", Font.PLAIN, 13));
		lblTime_2.setBounds(1273, 320, 56, 16);
		contentPane.add(lblTime_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Futura LT", Font.PLAIN, 13));
		lblNewLabel.setIcon(new ImageIcon(Test1.class.getResource("/GUIBackground/Kalendersk\u00E4rm_clean.png")));
		lblNewLabel.setBounds(0, 0, (int)width, (int)height);
		contentPane.add(lblNewLabel);
		
		
	}
}
