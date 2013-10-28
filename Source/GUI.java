import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		JLabel lblUserAgent = new JLabel("User Agent");
		lblUserAgent.setBounds(12, 12, 99, 15);
		contentPane.add(lblUserAgent);
		
		textField = new JTextField();
		textField.setBounds(105, 10, 416, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(536, 7, 117, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblSocks = new JLabel("Socks");
		lblSocks.setBounds(22, 43, 70, 15);
		contentPane.add(lblSocks);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 39, 416, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(536, 34, 117, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblAccount = new JLabel("# Account");
		lblAccount.setBounds(12, 75, 70, 15);
		contentPane.add(lblAccount);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 68, 62, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblHowManyAccount = new JLabel("How many account you want to create");
		lblHowManyAccount.setBounds(185, 73, 336, 17);
		contentPane.add(lblHowManyAccount);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 102, 537, 22);
		contentPane.add(separator);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStart.setBounds(536, 60, 117, 25);
		contentPane.add(btnStart);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 114, 612, 267);
		contentPane.add(textArea);
	}
}
