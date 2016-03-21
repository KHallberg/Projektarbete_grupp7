package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class screenTest extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrHej;
	private String searchURL;
	private Journeys journeys;
	private String travelResults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					screenTest frame = new screenTest();
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
	public screenTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txtrHej = new JTextArea();
		//txtrHej.setText(journeys.toString());
		scrollPane.setViewportView(txtrHej);
		
		searchURL = Constants.getURL("80100","93070",20);
		journeys = Parser.getJourneys(searchURL);
		
		for (Journey journey : journeys.getJourneys()) {
			txtrHej.append(journey.getStartStation() + " - " + journey.getEndStation() +"\n");
		}
	}

}
