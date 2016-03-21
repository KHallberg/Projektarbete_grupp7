package se.mah.k3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.Node;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Dom4JGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dom4JGUI frame = new Dom4JGUI();
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
	public Dom4JGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtrTesting = new JTextArea();
		txtrTesting.setText("testing");
		scrollPane.setViewportView(txtrTesting);
		for (Node node : XMLParserDom4J.nodes) {
			txtrTesting.append("Title : " + node.selectSingleNode("title").getText());
          

           //System.out.println("Title : " + node.selectSingleNode("title").getText());
	}

	}
}
