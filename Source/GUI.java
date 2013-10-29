
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

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
	private AutoDropBox _autoDropBox = new AutoDropBox();
	private SockList _sockList;
	private NameGenerator _nameGenerator = new NameGenerator("prefix.txt");
	private EmailGenerator _emailGenerator = new EmailGenerator();
	private String _password = "passasd!@#123"; // or your desired password
	private boolean _isFirstTime = true;
	private int _accountNumber = 0; // how many accounts to create
	private String [] _fullInfo = new String[4]; // this hold the full info of the current account
	// aelninluedul347@yahoo.com : this is for thesting this account
	
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
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new BtnSaveActionListener());
		btnSave.setBounds(536, 34, 117, 25);
		contentPane.add(btnSave);
		
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
		fldReferral.setText("https://db.tt/K8IR2AXm");
		fldAccounts.setText("1");
		textArea.setText("***** AutoDropBox Version 1.0 | Please see Readme file for more details ******\n"
				+ "***** Contact me: nguyenph88@gmail.com | http://www.nguyenphuoc.net *****\n");
	}
	
	/**
	 * Get the current account number from the account number field
	 */
	public int getAccountNumber(){
		int currentAccount = Integer.parseInt(fldAccounts.getText());
		
		if (currentAccount == 0){
			messageBox("Done! There is no more request to create!");
			return 0;
		} else if (currentAccount < 0 ){
			messageBox("Invalid number of accounts!");
			return 0;
		} else {
			_accountNumber = currentAccount;
			return _accountNumber;
		}
	}
	
	/**
	 * Update current account number from field
	 * @param number: new number
	 */
	public void setAccountNumber(int number){
		_accountNumber = number;
		fldAccounts.setText(Integer.toString(_accountNumber));
	}
	
	/**
	 * Pop out the warning message
	 * @param s: String to pop out
	 */
	public void messageBox(String s){
		   JOptionPane.showMessageDialog(null, s);
	}
	
	/**
	 * Return the referral link
	 * @return referral link
	 */
	public String getReferralLink(){
		return fldReferral.getText();
	}
	
	/**
	 * Generating information and save into an array
	 */
	public void generateInfo(){
		_fullInfo[0] = _nameGenerator.compose(2);
		_fullInfo[1] = _nameGenerator.compose(2);
		_fullInfo[2] = _emailGenerator.generate(_fullInfo[0], _fullInfo[1]);
		_fullInfo[3] = _password;
	}
	
	/**
	 * Start creating account based on the info saved in the array
	 */
	public void startCreateAccount(){
		_autoDropBox.Start(getReferralLink(), _fullInfo[0], _fullInfo[1], _fullInfo[2], _fullInfo[3]);
	}
	
	/**
	 * Generating the content of the file before saving
	 */
	public String generateSaveContent(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String text = "Created by AutoDropBox - (C)2013 Peter Nguyen - nguyenph88@gmail.com \n" 
				     + "Saved at:" + dateFormat.format(date) 
				     + "Referral URL:" + fldReferral.getText()
				     + "\n===============================================\n"
				     + textArea.getText();
		return text;
	}
	
	/**
	 * Take care of Save Button Click
	 * @author kiddo
	 *
	 */
	private class BtnSaveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(null);
            File saveFile = fileChooser.getSelectedFile();
            PrintStream out = null;
            
            try {
                try {
					out = new PrintStream(new FileOutputStream(saveFile.getPath()));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                out.print(generateSaveContent());
            }
            finally {
                if (out != null) out.close();
            }
            
            messageBox("Sucessfully saved!");
            textArea.append("\nSaved to:" + saveFile.getPath() + "\n");
		}
	}
	
	/**
	 * Take care of Start Button Click
	 * @author kiddo
	 *
	 */
	private class BtnStartActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int i, currentAccount;
			
			// clear the intro
			if (_isFirstTime){
				textArea.setText("Starting ...");
				_isFirstTime = false;
			}
			
			currentAccount = getAccountNumber();
			
			// main loop
			for (i = 0; i < currentAccount; i++){
				generateInfo();
				String fullWriteOut = _fullInfo[0] + " | " + _fullInfo[1] + " | " + _fullInfo[2];
				textArea.setText(textArea.getText() + "\n" + fullWriteOut);
				startCreateAccount();
				setAccountNumber(getAccountNumber() - 1);
			}
			
			textArea.setText(textArea.getText() + "\n*** Done!!!");
		}
	}
	
	
	/**
	 * Take care of Sock Button Click
	 * @author kiddo
	 *
	 */
	private class BtnSockActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			messageBox("Not working with this version");
		}
	}
}
