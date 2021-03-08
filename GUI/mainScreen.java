package compiled;

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
		frmSuperSpreader.setResizable(false);
		frmSuperSpreader.setTitle("Super Spreader");
		frmSuperSpreader.setBounds(100, 100, 444, 302);
		frmSuperSpreader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSuperSpreader.getContentPane().setLayout(null);

		JButton hostbtn = new JButton("Host a game");
		hostbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hostbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSuperSpreader.setVisible(false);
				hostGame nw = new hostGame();
				nw.setVisible(true);
				frmSuperSpreader.dispose();
			}
		});

		JLabel lblSpeader = new JLabel("SPEADER");
		lblSpeader.setBackground(SystemColor.textHighlight);
		lblSpeader.setForeground(SystemColor.menu);
		lblSpeader.setFont(new Font("Verdana", Font.BOLD, 29));
		lblSpeader.setBounds(39, 49, 174, 38);
		frmSuperSpreader.getContentPane().add(lblSpeader);
		hostbtn.setBounds(30, 98, 154, 32);
		frmSuperSpreader.getContentPane().add(hostbtn);
		JButton joinbtn = new JButton("Join a game");
		joinbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		joinbtn.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				frmSuperSpreader.setVisible(false);
				joinAGame nw = new joinAGame();
				nw.setVisible(true);
				frmSuperSpreader.dispose();

			}
		});
		joinbtn.setBounds(30, 141, 154, 32);
		frmSuperSpreader.getContentPane().add(joinbtn);

		JButton insbtn = new JButton("How to play");
		insbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		insbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmSuperSpreader.setVisible(false);
				HowToPlay nw = new HowToPlay();
				nw.setVisible(true);
				frmSuperSpreader.dispose();
			}
		});
		insbtn.setBounds(30, 184, 154, 32);
		frmSuperSpreader.getContentPane().add(insbtn);

		JButton settingbtn = new JButton("Settings");
		settingbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		settingbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmSuperSpreader.setVisible(false);
				Settings nw = new Settings();
				nw.setVisible(true);
				frmSuperSpreader.dispose();
			}
		});
		settingbtn.setBounds(30, 227, 154, 32);
		frmSuperSpreader.getContentPane().add(settingbtn);

		JLabel lblNewLabel = new JLabel("SUPER");
		lblNewLabel.setBackground(SystemColor.text);
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 29));
		lblNewLabel.setBounds(10, 11, 174, 38);
		frmSuperSpreader.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(mainScreen.class.getResource("/pictures/picture 4.png")));
		lblNewLabel_1.setBounds(-57, 0, 506, 299);
		frmSuperSpreader.getContentPane().add(lblNewLabel_1);
	}


	public void setVisible(boolean b) {
		frmSuperSpreader.setVisible(b);

	}

}
