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
import javax.swing.SwingConstants;

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
		hostf.setResizable(false);
		hostf.getContentPane().setBackground(new Color(173, 216, 230));
		hostf.setBounds(100, 100, 554, 331);
		hostf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblHostAGame = new JLabel("HOST  A  GAME");
		lblHostAGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblHostAGame.setBounds(10, 0, 335, 49);
		lblHostAGame.setForeground(Color.WHITE);
		lblHostAGame.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.setBounds(452, 11, 86, 26);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hostf.setVisible(false);
				mainScreen nw = new mainScreen();
				nw.setVisible(true);
				hostf.dispose();
			}
		});
		
		nametxt = new JTextField();
		nametxt.setBounds(114, 157, 137, 20);
		nametxt.setColumns(10);
		
		
		codetxt = new JTextField();
		codetxt.setHorizontalAlignment(SwingConstants.CENTER);
		codetxt.setBounds(114, 124, 137, 20);
		codetxt.setText("auto generated code");
		codetxt.setEditable(false);
		codetxt.setColumns(10);
		
		PlayersTxtfield = new JTextField();
		PlayersTxtfield.setBounds(114, 197, 137, 20);
		PlayersTxtfield.setEditable(false);
		PlayersTxtfield.setColumns(10);
		
		JButton beginGameButton = new JButton("Begin");
		beginGameButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		beginGameButton.setBounds(82, 265, 119, 26);
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
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(28, 155, 279, 20);
		
		JLabel lblOfPlayers = new JLabel("# of Players:");
		lblOfPlayers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOfPlayers.setBounds(28, 196, 279, 20);
		
		JLabel lblGameCode = new JLabel("Game Code:");
		lblGameCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGameCode.setForeground(Color.BLACK);
		lblGameCode.setBounds(25, 124, 95, 20);
		hostf.getContentPane().setLayout(null);
		hostf.getContentPane().add(lblNewLabel);
		hostf.getContentPane().add(nametxt);
		hostf.getContentPane().add(lblOfPlayers);
		hostf.getContentPane().add(PlayersTxtfield);
		hostf.getContentPane().add(lblHostAGame);
		hostf.getContentPane().add(btnNewButton);
		hostf.getContentPane().add(lblGameCode);
		hostf.getContentPane().add(codetxt);
		hostf.getContentPane().add(beginGameButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(hostGame.class.getResource("/pictures/picture 5.jpg")));
		lblNewLabel_1.setBounds(0, 0, 548, 415);
		hostf.getContentPane().add(lblNewLabel_1);
	}

	public void setVisible(boolean b) {
		hostf.setVisible(b);
		
	}
	
	}

