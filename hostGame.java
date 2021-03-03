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

public class hostGame {

	private JFrame hostf = new JFrame("Host");
	private JTextField nametxt;
	private JTextField codetxt;
	private JTextField PlayersTxtfield;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hostGame window = new hostGame();
					window.hostf.setVisible(true);
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

		hostf = new JFrame();
		hostf.getContentPane().setBackground(new Color(173, 216, 230));
		hostf.setBounds(100, 100, 450, 300);
		hostf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hostf.getContentPane().setLayout(null);
		
		JLabel lblHostAGame = new JLabel("HOST A GAME");
		lblHostAGame.setForeground(Color.WHITE);
		lblHostAGame.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblHostAGame.setBounds(10, 11, 196, 38);
		hostf.getContentPane().add(lblHostAGame);
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hostf.setVisible(false);
				mainScreen nw = new mainScreen();
				nw.setVisible(true);
				hostf.dispose();
			}
		});
		btnNewButton.setBounds(338, 11, 86, 26);
		hostf.getContentPane().add(btnNewButton);
		
		nametxt = new JTextField();
		nametxt.setBounds(104, 104, 125, 20);
		hostf.getContentPane().add(nametxt);
		nametxt.setColumns(10);
		
		
		codetxt = new JTextField();
		codetxt.setText("auto generated code");
		codetxt.setEditable(false);
		codetxt.setBounds(104, 60, 125, 20);
		hostf.getContentPane().add(codetxt);
		codetxt.setColumns(10);
		
		PlayersTxtfield = new JTextField();
		PlayersTxtfield.setEditable(false);
		PlayersTxtfield.setBounds(104, 150, 125, 20);
		hostf.getContentPane().add(PlayersTxtfield);
		PlayersTxtfield.setColumns(10);
		
		JButton beginGameButton = new JButton("Begin");
		beginGameButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(nametxt.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please fill in your name");
					
				}
				else {
					beginGameButton.setEnabled(true);
					hostf.setVisible(false);
					gameContext nw = new gameContext();
					nw.setVisible(true);
					hostf.dispose();
				
				}
			}
		});
		beginGameButton.setBounds(63, 227, 89, 23);
		hostf.getContentPane().add(beginGameButton);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(28, 104, 84, 20);
		hostf.getContentPane().add(lblNewLabel);
		
		JLabel lblOfPlayers = new JLabel("# of Players:");
		lblOfPlayers.setBounds(28, 150, 84, 20);
		hostf.getContentPane().add(lblOfPlayers);
		
		JLabel lblGameCode = new JLabel("Game Code:");
		lblGameCode.setBounds(28, 60, 84, 20);
		hostf.getContentPane().add(lblGameCode);
	}

	public void setVisible(boolean b) {
		hostf.setVisible(b);
		
	}
	
	}

