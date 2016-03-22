package se.mah.k3;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

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
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Kalender_v2 extends JFrame {

	private JPanel contentPane;
	public TimeAndDate myTimeAndDate;
	private static JLabel lblTime;
	private static JLabel lblDate;
	private JLabel lblPlace;
	private JLabel lblTime_1;
	private RSS_new a;
	private int testNbr = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kalender_v2 frame = new Kalender_v2();
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
	public Kalender_v2() {

		setBackground(Color.GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		a = new RSS_new(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, (int) width, (int) height);
		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDate = new JLabel("DATE");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Futura LT", Font.PLAIN, 38));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(677, 121, 461, 67);
		contentPane.add(lblDate);

		lblTime = new JLabel("TIME");
		lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Futura LT", Font.PLAIN, 48));
		lblTime.setBounds(677, 65, 461, 50);
		contentPane.add(lblTime);

		JLabel lblHeadline = new JLabel("");
		lblHeadline.setFont(new Font("Futura LT", Font.PLAIN, 39));
		lblHeadline.setForeground(Color.BLACK);
		lblHeadline.setBounds(116, 334, 968, 50);
		contentPane.add(lblHeadline);
		lblHeadline.setText(a.getInfo().get(1).getTitle().toString());
		// lblHeadline.setText("hejhej");

		lblTime_1 = new JLabel("");
		lblTime_1.setFont(new Font("Futura LT", Font.PLAIN, 24));
		lblTime_1.setForeground(Color.BLACK);
		lblTime_1.setBounds(196, 414, 921, 28);
		contentPane.add(lblTime_1);
		lblTime_1.setText(a.getInfo().get(0).getTimeStart().toString() + " - " + a.getInfo().get(0).getTimeEnd().toString());
		
		/*
		  try { //if (a.getInfo().size()>=0){ String s1 =
		  a.getInfo().get(0).getTitle().toString(); //String s2 =
		  a.getInfo().get(1).getTimeEnd().toString(); String s2 ="S2";
		  printError("noError"); lblTime_1.setText(s1+"-"+s2);
		  printError("noError"+ a.getInfo().size()); //} } catch (Exception e)
		  { // TODO Auto-generated catch block printError("fel"+e.getMessage()
		  + e.toString()); }
		  */
		 

		lblPlace = new JLabel("PLACE");
		lblPlace.setFont(new Font("Futura LT", Font.PLAIN, 24));
		lblPlace.setBounds(196, 446, 901, 34);
		contentPane.add(lblPlace);
		lblPlace.setText(a.getInfo().get(0).getPlace().toString());
		// lblPlace.setText("hejhej");

		JTextPane txtpnDetails = new JTextPane();
		txtpnDetails.setEditable(false);
		txtpnDetails.setBackground(new Color(240, 241, 241));
		txtpnDetails.setFont(new Font("Futura LT", Font.PLAIN, 28));
		txtpnDetails.setBounds(116, 536, 968, 422);
		contentPane.add(txtpnDetails);
		txtpnDetails.setText(a.getInfo().get(0).getDescription().toString());
		// txtpnDetails.setText("hejhej");

		
		for (int i = 0; i < 6; i ++){
			int distance = i * 100;
			
			JLabel lblHeadline_1 = new JLabel("");
			lblHeadline_1.setFont(new Font("Futura LT", Font.BOLD, 24));
			lblHeadline_1.setBounds(1273, 314 +  distance, 550, 35);
			contentPane.add(lblHeadline_1);
			lblHeadline_1.setText(a.getInfo().get(i).getTitle().toString());

			JLabel lblTime_2 = new JLabel("TIME");
			lblTime_2.setFont(new Font("Futura LT", Font.PLAIN, 24));
			lblTime_2.setBounds(1273, 350 + distance, 550, 35);
			contentPane.add(lblTime_2);
			lblTime_2.setText(a.getInfo().get(i).getTimeExact().toString()
					+ "      " +  a.getInfo().get(i).getTimeStart().toString()+" - "+a.getInfo().get(i).getTimeEnd().toString());

		}

		JLabel lblTid = new JLabel("Tid:");
		lblTid.setFont(new Font("Futura LT", Font.BOLD, 24));
		lblTid.setBounds(116, 414, 53, 30);
		contentPane.add(lblTid);

		JLabel lblPlats = new JLabel("Plats:");
		lblPlats.setFont(new Font("Futura LT", Font.BOLD, 24));
		lblPlats.setBounds(116, 446, 71, 34);
		contentPane.add(lblPlats);
		// lblTimeNextDate_2.setText("hejhej");

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Futura LT", Font.PLAIN, 13));
		lblNewLabel
				.setIcon(new ImageIcon(Kalender_v2.class.getResource("/GUIBackground/Kalenderskärm_clean_new2.png")));
		lblNewLabel.setBounds(0, 0, (int) width, (int) height);
		contentPane.add(lblNewLabel);
		//printError("Version 14");
		myTimeAndDate = new TimeAndDate(this);

	}

	public static void setTimeOnLabel(String time) {
		lblTime.setText(time);
	}

	public static void setDateOnLabel(String date) {
		lblDate.setText(date);
	}
}
