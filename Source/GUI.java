import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JSeparator;
import javax.swing.JTextArea;


public class GUI extends JFrame {

	/**
	 * Instances
	 */
	private JPanel contentPane;
	private JTextField fldSocks;
	private JTextField fldReferral;
	private JTextField fldAccounts;
	private JTextArea textArea;
	private AutoDropBox _autoDropBox;
	private SockList _sockList;
	private NameGenerator _nameGenerator = new NameGenerator("prefix.txt");
	private EmailGenerator _emailGenerator = new EmailGenerator();
	
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
		setBounds(100, 100, 676, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSocks = new JLabel("Socks");
		lblSocks.setBounds(39, 13, 99, 15);
		contentPane.add(lblSocks);
		
		fldSocks = new JTextField();
		fldSocks.setBounds(105, 10, 416, 22);
		contentPane.add(fldSocks);
		fldSocks.setColumns(10);
		
		JButton btnLoadSocks = new JButton("Load Socks");
		btnLoadSocks.addActionListener(new BtnSockActionListener());
		btnLoadSocks.setBounds(536, 7, 117, 25);
		contentPane.add(btnLoadSocks);
		
		JLabel lblReferralURL = new JLabel("Referral URL");
		lblReferralURL.setBounds(12, 40, 117, 21);
		contentPane.add(lblReferralURL);
		
		fldReferral = new JTextField();
		fldReferral.setBounds(105, 39, 416, 22);
		contentPane.add(fldReferral);
		fldReferral.setColumns(10);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new BtnStopActionListener());
		btnStop.setBounds(536, 34, 117, 25);
		contentPane.add(btnStop);
		
		JLabel lblAccount = new JLabel("# Account");
		lblAccount.setBounds(12, 75, 70, 15);
		contentPane.add(lblAccount);
		
		fldAccounts = new JTextField();
		fldAccounts.setBounds(105, 68, 62, 22);
		contentPane.add(fldAccounts);
		fldAccounts.setColumns(10);
		
		JLabel lblHowManyAccount = new JLabel("How many account you want to create");
		lblHowManyAccount.setBounds(185, 73, 336, 17);
		contentPane.add(lblHowManyAccount);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 102, 537, 22);
		contentPane.add(separator);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new BtnStartActionListener());
		btnStart.setBounds(536, 60, 117, 25);
		contentPane.add(btnStart);
		
		textArea = new JTextArea();
		textArea.setBounds(22, 114, 612, 267);
		textArea.setEditable ( false );
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(22, 114, 612, 267);
		scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		contentPane.add(scrollPane);
		
		initializeMessage();
	}
	
	/**
	 * Initialize message when the GUI first created
	 */
	public void initializeMessage(){
		fldSocks.setText("Set sock or leave to use local IP");
		fldReferral.setText("https://db.tt/nkcXZIYj");
		fldAccounts.setText("5");
		textArea.setText("*****AutoDropBox Version 1.0*****\n"
				+ "- Please see Readme file for more details\n"
				+ "- Contact me: nguyenph88@gmail.com");
	}
	
	/**
	 * Take care of Stop Button Click
	 * @author kiddo
	 *
	 */
	private class BtnStopActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	/**
	 * Take care of Start Button Click
	 * @author kiddo
	 *
	 */
	private class BtnStartActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String firstName = _nameGenerator.compose(2);
			String lastName = _nameGenerator.compose(2);
			String password = "asd123!@#";
			String email = _emailGenerator.generate(firstName, lastName);
			String fullWriteOut = firstName + " | " + lastName + " | " + email;
		    

		    // nextInt is normally exclusive of the top value,
		    // so add 1 to make it inclusive
		   // int randomNum = rand.nextInt((999 - 100) + 1) + 100;
			textArea.setText(textArea.getText() + "\n" + fullWriteOut);
		}
	}
	
	
	/**
	 * Take care of Sock Button Click
	 * @author kiddo
	 *
	 */
	private class BtnSockActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
}
