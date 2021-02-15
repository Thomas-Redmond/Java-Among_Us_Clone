package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class mainScreen {

	private JFrame frmSuperSpreader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainScreen window = new mainScreen();
					window.frmSuperSpreader.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSuperSpreader = new JFrame();
		frmSuperSpreader.getContentPane().setForeground(Color.PINK);
		//frmSuperSpreader.getContentPane().setForeground("c:\\compiledGame.Images\blobby backround.png");
		frmSuperSpreader.setTitle("Super Spreader");
		frmSuperSpreader.setBounds(100, 100, 450, 300);
		frmSuperSpreader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSuperSpreader.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Host a game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(38, 133, 135, 23);
		frmSuperSpreader.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Join a game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(38, 162, 135, 23);
		frmSuperSpreader.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("How to play");
		btnNewButton_2.setBounds(38, 189, 135, 23);
		frmSuperSpreader.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Settings");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(38, 215, 135, 23);
		frmSuperSpreader.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("SUPER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 11, 145, 38);
		frmSuperSpreader.getContentPane().add(lblNewLabel);
		
		JLabel lblSpreader = new JLabel("SPREADER");
		lblSpreader.setForeground(Color.WHITE);
		lblSpreader.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblSpreader.setBounds(10, 51, 145, 38);
		frmSuperSpreader.getContentPane().add(lblSpreader);
	}
}
