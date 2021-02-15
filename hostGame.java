package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class hostGame {

	private JFrame frame;
	private JTextField gameCodeTxtfield;
	private JTextField nameTxtfield;
	private JTextField noPlayersTxtfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hostGame window = new hostGame();
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
	public hostGame() {
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
		
		JLabel lblHostAGame = new JLabel("HOST A GAME");
		lblHostAGame.setForeground(Color.WHITE);
		lblHostAGame.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblHostAGame.setBounds(10, 11, 196, 38);
		frame.getContentPane().add(lblHostAGame);
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.setBounds(338, 11, 86, 26);
		frame.getContentPane().add(btnNewButton);
		
		gameCodeTxtfield = new JTextField();
		gameCodeTxtfield.setText("name");
		gameCodeTxtfield.setBounds(104, 104, 86, 20);
		frame.getContentPane().add(gameCodeTxtfield);
		gameCodeTxtfield.setColumns(10);
		
		nameTxtfield = new JTextField();
		nameTxtfield.setText("code");
		nameTxtfield.setEditable(false);
		nameTxtfield.setBounds(104, 60, 86, 20);
		frame.getContentPane().add(nameTxtfield);
		nameTxtfield.setColumns(10);
		
		noPlayersTxtfield = new JTextField();
		noPlayersTxtfield.setText("# of players");
		noPlayersTxtfield.setEditable(false);
		noPlayersTxtfield.setBounds(104, 150, 86, 20);
		frame.getContentPane().add(noPlayersTxtfield);
		noPlayersTxtfield.setColumns(10);
		
		JButton beginGameButton = new JButton("Begin");
		beginGameButton.setBounds(63, 227, 89, 23);
		frame.getContentPane().add(beginGameButton);
	}
}
