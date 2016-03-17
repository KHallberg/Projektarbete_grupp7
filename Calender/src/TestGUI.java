import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class TestGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI frame = new TestGUI();
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
	public TestGUI() {
		RSS_new a = new RSS_new();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setBounds(6, 6, 438, 36);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("Titel:   "+a.getInfo().get(0).getTitle().toString());
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(6, 54, 324, 50);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText("Start:   "+a.getInfo().get(0).getTimeStart().toString());
		
	}
}
