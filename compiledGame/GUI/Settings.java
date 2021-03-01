package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Choice;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSettings = new JLabel("SETTINGS");
		lblSettings.setBounds(10, 11, 194, 38);
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		
		JButton beginGameButton = new JButton("Save");
		beginGameButton.setBounds(48, 231, 214, 29);
		beginGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Your settings have been saved :)"); 
			}
		});
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Voice Chat");
		rdbtnNewRadioButton.setBounds(102, 99, 160, 23);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton rdbtnTextChat = new JRadioButton("Text Chat");
		rdbtnTextChat.setBackground(SystemColor.control);
		rdbtnTextChat.setBounds(102, 136, 160, 23);
		rdbtnTextChat.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTextChat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		Choice iconColour = new Choice();
		iconColour.setBounds(121, 177, 141, 20);
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.setBounds(316, 11, 112, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				mainScreen nw = new mainScreen();
				nw.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblSettings);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(rdbtnNewRadioButton);
		frame.getContentPane().add(rdbtnTextChat);
		frame.getContentPane().add(beginGameButton);
		frame.getContentPane().add(iconColour);
		
		JLabel lblNewLabel = new JLabel("Opt. in or out for:");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 72, 204, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Icon Colour:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 177, 118, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Settings.class.getResource("/pictures/picture 2.jpg")));
		lblNewLabel_2.setBounds(0, 0, 444, 271);
		frame.getContentPane().add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
}
