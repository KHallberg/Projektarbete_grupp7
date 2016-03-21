package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;
	private JTextArea searchResults;
	private JTextField departField;
	private JTextField destinationField;
	private JTextArea travelResults;
	private String searchURL;
	private Journeys journeys;
	private DecimalFormat correctTime;
	private ArrayList<Station> stringToDepartStation;
	private ArrayList<Station> stringToDestinationStation;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		searchField = new JTextField();
		searchField.setText("");
		searchField.setBounds(12, 278, 153, 22);
		panel.add(searchField);
		searchField.setColumns(10);

		JLabel lblHllplatsnamn = new JLabel("H\u00E5llplatsnamn:");
		lblHllplatsnamn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblHllplatsnamn.setBounds(12, 249, 153, 30);
		panel.add(lblHllplatsnamn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 249, 363, 93);
		panel.add(scrollPane);

		searchResults = new JTextArea();
		scrollPane.setViewportView(searchResults);

		JButton searchButton = new JButton("S\u00F6k h\u00E5llplats");
		searchButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchResults.setText("Hämtar stationer...");

				new stationThread().start();
			}
		});
		searchButton.setBounds(12, 313, 153, 25);
		panel.add(searchButton);

		departField = new JTextField();
		departField.setText("");
		departField.setBounds(12, 117, 153, 22);
		panel.add(departField);
		departField.setColumns(10);

		destinationField = new JTextField();
		destinationField.setText("");
		destinationField.setBounds(12, 168, 153, 22);
		panel.add(destinationField);
		destinationField.setColumns(10);

		JLabel lblFrn = new JLabel("Fr\u00E5n:");
		lblFrn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblFrn.setBounds(12, 95, 153, 22);
		panel.add(lblFrn);

		JLabel lblTill = new JLabel("Till:");
		lblTill.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblTill.setBounds(12, 146, 153, 22);
		panel.add(lblTill);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(177, 117, 363, 108);
		panel.add(scrollPane_1);

		travelResults = new JTextArea();
		travelResults.setText("");
		scrollPane_1.setViewportView(travelResults);

		correctTime = new DecimalFormat("00");

		JButton btnSkResa = new JButton("S\u00F6k resa");
		btnSkResa.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnSkResa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				travelResults.setText("Hämtar resor...");

				new travelThread().start();
			}
		});
		btnSkResa.setBounds(12, 203, 153, 22);
		panel.add(btnSkResa);

		JLabel lblShittyResplanerare = new JLabel("Shitty resplanerare");
		lblShittyResplanerare.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		lblShittyResplanerare.setForeground(Color.RED);
		lblShittyResplanerare.setHorizontalAlignment(SwingConstants.CENTER);
		lblShittyResplanerare.setBounds(12, 16, 528, 66);
		panel.add(lblShittyResplanerare);
	}

	private class stationThread extends Thread {
		
		@Override
		public void run() {
			
			ArrayList<Station> searchStations = new ArrayList<Station>();
			searchStations.addAll(Parser.getStationsFromURL(searchField.getText()));
			searchResults.setText("");
			
			for (Station s : searchStations) {
				searchResults.append(s.getStationName() + " number: " + s.getStationNbr() + "\n");
			}
		}
	}

	private class travelThread extends Thread {
		
		@Override
		public void run() {
			stringToDepartStation = new ArrayList<>();
			stringToDestinationStation = new ArrayList<>();
			
			/* Då XSDn (adressen) till Skånetrafikens API inte kan ta emot mellanrum måste man byta ut dessa mot 
			 * "%20" för att kunna söka på stationer vars namn innehåller flera ord */
			String departFormat = departField.getText().replaceAll(" ", "%20");
			String destinationFormat = destinationField.getText().replaceAll(" ", "%20");
			
			stringToDepartStation.addAll(Parser.getStationsFromURL(departFormat));
			stringToDestinationStation.addAll(Parser.getStationsFromURL(destinationFormat));
			
			searchURL = Constants.getURL(stringToDepartStation.get(0).getStationNbr(), stringToDestinationStation.get(0).getStationNbr(), 20);
			journeys = Parser.getJourneys(searchURL);
			travelResults.setText("");

			for (Journey journey : journeys.getJourneys()) {
				travelResults.append(" " + journey.getStartStation() + " - " + journey.getEndStation());
				String time = correctTime.format(journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)) + ":"
						+ correctTime.format(journey.getDepDateTime().get(Calendar.MINUTE));
				travelResults.append("\n Avgår " + time + ", alltså om " + journey.getTimeToDeparture()
						+ " minuter och är " + journey.getDepTimeDeviation() + " minuter sen.\n\n");
			}
		}
	}
}
