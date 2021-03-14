package Source;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class HowToPlay {

	private JFrame frmSuperSpreader;
	private static JButton backbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HowToPlay window = new HowToPlay();
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
	public HowToPlay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSuperSpreader = new JFrame();
		frmSuperSpreader.setResizable(false);
		frmSuperSpreader.setTitle("Super Spreader");
		frmSuperSpreader.getContentPane().setBackground(new Color(245, 222, 179));
		frmSuperSpreader.setBounds(100, 100, 560, 340);
		frmSuperSpreader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblHowToPlay = new JLabel("HOW TO PLAY");
		lblHowToPlay.setBounds(10, 11, 196, 38);
		lblHowToPlay.setForeground(Color.WHITE);
		lblHowToPlay.setFont(new Font("Tw Cen MT", Font.BOLD, 27));

		JTextPane txtpnInstructions = new JTextPane();
		txtpnInstructions.setBounds(50, 57, 429, 213);
		txtpnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnInstructions.setText("Instructions");

		JButton backbtn = new JButton("Back ");
		backbtn.setBounds(338, 11, 196, 28);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSuperSpreader.setVisible(false);
				mainScreen nw = new mainScreen();
				nw.setVisible(true);
				frmSuperSpreader.dispose();
			}
		});
		frmSuperSpreader.getContentPane().setLayout(null);
		frmSuperSpreader.getContentPane().add(lblHowToPlay);
		frmSuperSpreader.getContentPane().add(backbtn);
		frmSuperSpreader.getContentPane().add(txtpnInstructions);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(HowToPlay.class.getResource("/Objects/picture 3.png")));
		lblNewLabel.setBounds(-26, 0, 619, 395);
		frmSuperSpreader.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		frmSuperSpreader.setVisible(b);

	}

	public static void changeButtonStatus(boolean b) {
		backbtn.setEnabled(b);

	}

	public static void setEnabled(boolean b) {
		backbtn.setEnabled(b);

	}
}
