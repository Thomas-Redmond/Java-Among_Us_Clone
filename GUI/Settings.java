package compiled;

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
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setBounds(46, 11, 150, 38);
		lblSettings.setForeground(Color.DARK_GRAY);
		lblSettings.setFont(new Font("Tw Cen MT", Font.BOLD, 27));

		JButton beginGameButton = new JButton("Save");
		beginGameButton.setBounds(122, 206, 214, 29);
		beginGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Your settings have been saved :)");
			}
		});

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Voice Chat");
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setBounds(234, 108, 141, 23);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JRadioButton rdbtnTextChat = new JRadioButton("Text Chat");
		rdbtnTextChat.setBackground(Color.LIGHT_GRAY);
		rdbtnTextChat.setBounds(234, 134, 141, 23);
		rdbtnTextChat.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTextChat.setFont(new Font("Tahoma", Font.PLAIN, 16));

		Choice iconColour = new Choice();
		iconColour.setBounds(234, 175, 141, 20);

		JButton btnNewButton = new JButton("Back ");
		btnNewButton.setBounds(336, 11, 92, 23);
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
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(90, 112, 235, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Icon Colour:");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(90, 175, 118, 20);
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
