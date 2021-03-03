package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Choice;

public class Settings {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Settings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSettings = new JLabel("SETTINGS");
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblSettings.setBounds(10, 11, 196, 38);
		frame.getContentPane().add(lblSettings);
		
		JButton beginGameButton = new JButton("Save");
		beginGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		beginGameButton.setBounds(171, 227, 89, 23);
		frame.getContentPane().add(beginGameButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Voice Chat");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(134, 92, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTextChat = new JRadioButton("Text Chat");
		rdbtnTextChat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnTextChat.setBounds(134, 124, 126, 23);
		frame.getContentPane().add(rdbtnTextChat);
		
		Choice iconColour = new Choice();
		iconColour.setBounds(144, 152, 99, 23);
		frame.getContentPane().add(iconColour);
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				mainScreen nw = new mainScreen();
				nw.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(338, 11, 86, 26);
		frame.getContentPane().add(btnNewButton);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}

	
}
