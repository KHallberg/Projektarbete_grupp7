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
	public TestGUI() 
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
		
		JTextPane txtpnVadVillDu = new JTextPane();
		txtpnVadVillDu.setEditable(false);
		txtpnVadVillDu.setFont(new Font("Calibri", Font.PLAIN, 68));
		txtpnVadVillDu.setText("\r\n\r\n\r\n\r\n\r\nVad vill du se p\u00E5 den h\u00E4r sk\u00E4rmen?\r\nMaila niagaramonitors@gmail.com");
		txtpnVadVillDu.setBackground(Color.WHITE);
		txtpnVadVillDu.setBounds(400, 50, (int)width, (int)height);
		contentPane.add(txtpnVadVillDu);
	}
}
