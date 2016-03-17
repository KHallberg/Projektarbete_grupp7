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
import javax.swing.UIManager;

public class KalenderGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KalenderGUI frame = new KalenderGUI();
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
	public KalenderGUI() {
		RSS_new a = new RSS_new();
		
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
		
		JLabel lblHeadline = new JLabel("");
		lblHeadline.setFont(new Font("Futura LT", Font.PLAIN, 39));
		lblHeadline.setForeground(Color.BLACK);
		lblHeadline.setBounds(85, 321, 800, 50);
		contentPane.add(lblHeadline);
		lblHeadline.setText(a.getInfo().get(0).getTitle().toString());
		
		JLabel lblTime_1 = new JLabel("");
		lblTime_1.setFont(new Font("Futura LT", Font.PLAIN, 20));
		lblTime_1.setForeground(Color.BLACK);
		lblTime_1.setBounds(85, 409, 200, 16);
		contentPane.add(lblTime_1);
		lblTime_1.setText(a.getInfo().get(0).getTimeStart().toString()+"-"+a.getInfo().get(0).getTimeEnd().toString());
		
		JLabel lblPlace = new JLabel("PLACE");
		lblPlace.setFont(new Font("Futura LT", Font.PLAIN, 20));
		lblPlace.setBounds(85, 438, 650, 20);
		contentPane.add(lblPlace);
		lblPlace.setText(a.getInfo().get(0).getPlace().toString());
		
		JTextPane txtpnDetails = new JTextPane();
		txtpnDetails.setEditable(false);
		txtpnDetails.setBackground(new Color(240, 241, 241));
		txtpnDetails.setFont(new Font("Futura LT", Font.PLAIN, 22));
		txtpnDetails.setBounds(105, 518, 484, 340);
		contentPane.add(txtpnDetails);
		txtpnDetails.setText(a.getInfo().get(0).getDescription().toString());
		
		JLabel lblHeadline_1 = new JLabel("");
		lblHeadline_1.setFont(new Font("Futura LT", Font.PLAIN, 20));
		lblHeadline_1.setBounds(1273, 300, 550, 20);
		contentPane.add(lblHeadline_1);
		lblHeadline_1.setText(a.getInfo().get(0).getTitle().toString());
		
		JLabel lblTime_2 = new JLabel("TIME");
		lblTime_2.setFont(new Font("Futura LT", Font.PLAIN, 20));
		lblTime_2.setBounds(1273, 335, 174, 20);
		contentPane.add(lblTime_2);
		lblTime_2.setText(a.getInfo().get(0).getTimeStart().toString()+"-"+a.getInfo().get(0).getTimeEnd().toString());
		
		JLabel lblHeadline_2 = new JLabel("");
		lblHeadline_2.setFont(new Font("Futura LT", Font.PLAIN, 20));
		lblHeadline_2.setBounds(1273, 385, 550, 20);
		contentPane.add(lblHeadline_2);
		lblHeadline_2.setText(a.getInfo().get(1).getTitle().toString());
		
		JLabel lblTime_3 = new JLabel("");
		lblTime_3.setFont(new Font("Futura LT", Font.PLAIN, 20));
		lblTime_3.setBounds(1273, 415, 174, 20);
		contentPane.add(lblTime_3);
		lblTime_3.setText(a.getInfo().get(1).getTimeStart().toString()+"-"+a.getInfo().get(1).getTimeEnd().toString());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Futura LT", Font.PLAIN, 13));
		lblNewLabel.setIcon(new ImageIcon(KalenderGUI.class.getResource("/GUIBackground/Kalendersk\u00E4rm_clean.png")));
		lblNewLabel.setBounds(0, 0, (int)width, (int)height);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
}
