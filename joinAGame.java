package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class joinAGame {

	private JFrame frame;
	private JTextField nameTxtfield;
	private JTextField gameCodeTxtfield;
	private JLabel lblNewLabel;
	private JLabel lblGameCode;

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
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblJoinAGame = new JLabel("JOIN A GAME");
		lblJoinAGame.setForeground(Color.WHITE);
		lblJoinAGame.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblJoinAGame.setBounds(10, 11, 196, 38);
		frame.getContentPane().add(lblJoinAGame);
		
		nameTxtfield = new JTextField();
		nameTxtfield.setColumns(10);
		nameTxtfield.setBounds(168, 83, 86, 20);
		frame.getContentPane().add(nameTxtfield);
		
		gameCodeTxtfield = new JTextField();
		gameCodeTxtfield.setColumns(10);
		gameCodeTxtfield.setBounds(168, 126, 86, 20);
		frame.getContentPane().add(gameCodeTxtfield);
		
		JButton beginGameButton = new JButton("Begin");
		beginGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameTxtfield.getText().isEmpty() && gameCodeTxtfield.getText().isEmpty() ){
					JOptionPane.showMessageDialog(null, "Please fill in your name and the game code, thank you!");
				}
				else {
				frame.setVisible(false);
				gameContext nw = new gameContext();
				nw.setVisible(true);
				frame.dispose();
			}
			}});
		beginGameButton.setBounds(165, 227, 89, 23);
		frame.getContentPane().add(beginGameButton);
		
		JButton btnNewButton_1 = new JButton("Back ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				mainScreen nw = new mainScreen();
				nw.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(338, 11, 86, 26);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(78, 83, 56, 20);
		frame.getContentPane().add(lblNewLabel);
		
		lblGameCode = new JLabel("Game Code:");
		lblGameCode.setBounds(78, 129, 80, 20);
		frame.getContentPane().add(lblGameCode);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}

}
