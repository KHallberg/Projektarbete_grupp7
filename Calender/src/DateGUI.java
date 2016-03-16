import java.awt.BorderLayout;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class DateGUI extends JFrame {

	private JPanel contentPane;
	private JTextField DayMonth;
	private JTextField time;
	
	int day, month, year;
    int second, minute, hour;
    GregorianCalendar date = new GregorianCalendar();
    
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
	 
	     
	      
	      
		/*Calendar now = Calendar.getInstance();*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateGUI frame = new DateGUI();
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
	public DateGUI() {
		Calendar now = Calendar.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 13, 420, 227);
		contentPane.add(label);
		
		second = date.get(Calendar.SECOND);
	      minute = date.get(Calendar.MINUTE);
	      hour = date.get(Calendar.HOUR_OF_DAY);
		
		DayMonth = new JTextField();
		DayMonth.setBounds(232, 0, 173, 22);
		contentPane.add(DayMonth);
		DayMonth.setColumns(10);
		DayMonth.setText("" + GetCurrentDateTime.strDays[now.get(Calendar.DAY_OF_WEEK) - 1] +" " + now.get(Calendar.DATE) + " " + GetCurrentDateTime.strMonths[now.get(Calendar.MONTH)]);
		
		
		time = new JTextField();
		time.setColumns(10);
		time.setBounds(232, 48, 173, 22);
		contentPane.add(time);
		time.setText(" "+hour+" : "+minute+"");
	}
}
