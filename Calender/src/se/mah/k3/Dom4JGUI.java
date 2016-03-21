package se.mah.k3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

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
		setBounds(100, 100, 925, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtrTesting = new JTextArea();
		txtrTesting.setText("");
		scrollPane.setViewportView(txtrTesting);
		
        File inputFile = new File("rss/rss.xml");
        SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(inputFile);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Node> nodes = document.selectNodes("//item" );
		
		for (Node node : nodes) {
			txtrTesting.append("Title : " + node.selectSingleNode("title").getText());
          

           //System.out.println("Title : " + node.selectSingleNode("title").getText());
	}

	}
}
