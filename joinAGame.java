package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class joinAGame {

	private JFrame frame;
	private JTextField nameTxtfield;
	private JTextField gameCodeTxtfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					joinAGame window = new joinAGame();
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
	public joinAGame() {
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
		
		JLabel lblJoinAGame = new JLabel("JOIN A GAME");
		lblJoinAGame.setForeground(Color.WHITE);
		lblJoinAGame.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblJoinAGame.setBounds(10, 11, 196, 38);
		frame.getContentPane().add(lblJoinAGame);
		
		nameTxtfield = new JTextField();
		nameTxtfield.setText("name");
		nameTxtfield.setColumns(10);
		nameTxtfield.setBounds(168, 83, 86, 20);
		frame.getContentPane().add(nameTxtfield);
		
		gameCodeTxtfield = new JTextField();
		gameCodeTxtfield.setText("code");
		gameCodeTxtfield.setColumns(10);
		gameCodeTxtfield.setBounds(168, 126, 86, 20);
		frame.getContentPane().add(gameCodeTxtfield);
		
		JButton beginGameButton = new JButton("Begin");
		beginGameButton.setBounds(165, 227, 89, 23);
		frame.getContentPane().add(beginGameButton);
		
		JButton btnNewButton_1 = new JButton("Back ");
		btnNewButton_1.setBounds(338, 11, 86, 26);
		frame.getContentPane().add(btnNewButton_1);
	}

}
