package compiledGame;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


class mainScreen {

	private JFrame frmSuperSpreader;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainScreen window = new mainScreen();
					window.frmSuperSpreader.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainScreen() {
	
		frmSuperSpreader = new JFrame();
		frmSuperSpreader.getContentPane().setBackground(new Color(255, 160, 122));
		frmSuperSpreader.getContentPane().setEnabled(false);
		frmSuperSpreader.getContentPane().setForeground(Color.PINK);
		frmSuperSpreader.setTitle("Super Spreader");
		frmSuperSpreader.setBounds(100, 100, 450, 300);
		frmSuperSpreader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSuperSpreader.getContentPane().setLayout(null);
		
		JButton hostbtn = new JButton("Host a game");
		hostbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSuperSpreader.setVisible(false);
				hostGame nw = new hostGame();
				nw.setVisible(true);
				frmSuperSpreader.dispose();
			}
		});
		hostbtn.setBounds(38, 133, 135, 23);
		frmSuperSpreader.getContentPane().add(hostbtn);
		JButton joinbtn = new JButton("Join a game");
		joinbtn.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				frmSuperSpreader.setVisible(false);
				joinAGame nw = new joinAGame();
				nw.setVisible(true);
				frmSuperSpreader.dispose();
				
			}
		});
		joinbtn.setBounds(38, 162, 135, 23);
		frmSuperSpreader.getContentPane().add(joinbtn);
		
		JButton insbtn = new JButton("How to play");
		insbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmSuperSpreader.setVisible(false);
				HowToPlay nw = new HowToPlay();
				nw.setVisible(true);
				frmSuperSpreader.dispose();
			}
		});
		insbtn.setBounds(38, 189, 135, 23);
		frmSuperSpreader.getContentPane().add(insbtn);
		
		JButton settingbtn = new JButton("Settings");
		settingbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmSuperSpreader.setVisible(false);
				Settings nw = new Settings();
				nw.setVisible(true);
				frmSuperSpreader.dispose();
			}
		});
		settingbtn.setBounds(38, 215, 135, 23);
		frmSuperSpreader.getContentPane().add(settingbtn);
		
		JLabel lblNewLabel = new JLabel("SUPER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblNewLabel.setBounds(10, 11, 145, 38);
		frmSuperSpreader.getContentPane().add(lblNewLabel);
		
		JLabel lblSpreader = new JLabel("SPREADER");
		lblSpreader.setForeground(Color.WHITE);
		lblSpreader.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblSpreader.setBounds(10, 51, 145, 38);
		frmSuperSpreader.getContentPane().add(lblSpreader);
	}


	public void setVisible(boolean b) {
		frmSuperSpreader.setVisible(b);
		
	}

}
