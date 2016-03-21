package staxRSS;

import staxRSS.Feed;
import staxRSS.FeedMessage;
import staxRSS.RSSFeedParser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class staxTestGUI extends JFrame {

	private JPanel contentPane;
	public static JTextArea txtrStaxtestgui;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staxTestGUI frame = new staxTestGUI();
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
	public staxTestGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txtrStaxtestgui = new JTextArea();
		scrollPane.setViewportView(txtrStaxtestgui);

		RSSFeedParser parser = new RSSFeedParser("https://mah.se/Nyheter/RSS/Kalender-fran-Malmo-hogskola/");
		Feed feed = parser.readFeed();
		//System.out.println(feed);
		
		for (int i = 0; i < feed.getMessages().size(); i++) {
			System.out.println(feed.getMessages().get(i));
			txtrStaxtestgui.append(feed.getMessages().get(i) + "\n");

		}

	}
}
