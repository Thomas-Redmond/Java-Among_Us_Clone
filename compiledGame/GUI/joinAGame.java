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
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class joinAGame {

	private JFrame frame;
	private JTextField nameTxtfield;
	private JTextField gameCodeTxtfield;
	private JLabel lblNewLabel;
	private JLabel lblGameCode;
	private JLabel lblNewLabel_1;

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
		
		JLabel lblJoinAGame = new JLabel("JOIN A GAME");
		lblJoinAGame.setBackground(SystemColor.textInactiveText);
		lblJoinAGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinAGame.setBounds(32, 11, 163, 70);
		lblJoinAGame.setForeground(Color.DARK_GRAY);
		lblJoinAGame.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		
		nameTxtfield = new JTextField();
		nameTxtfield.setBounds(242, 124, 161, 22);
		nameTxtfield.setColumns(10);
		
		gameCodeTxtfield = new JTextField();
		gameCodeTxtfield.setBounds(242, 162, 161, 22);
		gameCodeTxtfield.setColumns(10);
		
		JButton beginGameButton = new JButton("Begin");
		beginGameButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		beginGameButton.setBounds(149, 198, 131, 23);
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
		
		JButton btnNewButton_1 = new JButton("Back ");
		btnNewButton_1.setBounds(336, 11, 86, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				mainScreen nw = new mainScreen();
				nw.setVisible(true);
				frame.dispose();
			}
		});
		
		lblGameCode = new JLabel("Game Code:");
		lblGameCode.setForeground(Color.DARK_GRAY);
		lblGameCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGameCode.setBounds(59, 160, 141, 20);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBackground(SystemColor.scrollbar);
		lblNewLabel.setBounds(59, 121, 115, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblJoinAGame);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(nameTxtfield);
		frame.getContentPane().add(lblGameCode);
		frame.getContentPane().add(gameCodeTxtfield);
		frame.getContentPane().add(beginGameButton);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(joinAGame.class.getResource("/pictures/picture 1.png")));
		lblNewLabel_1.setBounds(0, 0, 444, 271);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}

}
