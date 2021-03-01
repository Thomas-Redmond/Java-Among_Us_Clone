package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HowToPlay {

	private JFrame frame;
	private static JButton backbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HowToPlay window = new HowToPlay();
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
	public HowToPlay() {
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
		
		JLabel lblHowToPlay = new JLabel("HOW TO PLAY");
		lblHowToPlay.setForeground(Color.WHITE);
		lblHowToPlay.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblHowToPlay.setBounds(10, 11, 196, 38);
		frame.getContentPane().add(lblHowToPlay);
		
		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setText("Instructions");
		txtpnInstructions.setBounds(104, 82, 231, 123);
		frame.getContentPane().add(txtpnInstructions);
		
		JButton backbtn = new JButton("Back ");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				mainScreen nw = new mainScreen();
				nw.setVisible(true);
				frame.dispose();
			}
		});
		backbtn.setBounds(338, 11, 86, 26);
		frame.getContentPane().add(backbtn);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}

	public static void changeButtonStatus(boolean b) {
		backbtn.setEnabled(b);
		
	}
}
