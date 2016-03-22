package se.mah.k3;

import java.awt.BorderLayout;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class Test1 extends JFrame {

	private JPanel contentPane;
	private String url="http://www.nasa.gov/rss/dyn/image_of_the_day.rss";
	private JTextArea textArea;
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
	public Test1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane tfldOut = new JScrollPane();
		tfldOut.setBounds(5, 5, 607, 326);
		contentPane.add(tfldOut);
		
		textArea = new JTextArea();
		tfldOut.setViewportView(textArea);
		
		
        try {
        	URL feedSource = new URL("http://mah.se/Nyheter/RSS/Kalender-fran-Malmo-hogskola/");
            SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedSource));
			List entries = feed.getEntries();
			for(Object entryAsObject :entries){
				SyndEntry entry = (SyndEntry)entryAsObject;
				textArea.append("Title: "+entry.getTitle() + " Author: " + entry.getAuthor()+ "\n");
			}
		} catch (IllegalArgumentException | FeedException | IOException e) {
			textArea.append(e.getMessage());
			//e.printStackTrace();
		}
		
	}

}
