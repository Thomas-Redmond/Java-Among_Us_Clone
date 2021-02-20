package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class gameContext {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameContext window = new gameContext();
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
	public gameContext() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(106, 90, 205));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton beginGameButton = new JButton("Continue");
		beginGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				gameScreen nw = new gameScreen();
				nw.setVisible(true);
				frame.dispose();
			}
		});
		beginGameButton.setBounds(173, 227, 89, 23);
		frame.getContentPane().add(beginGameButton);
		
		JTextPane txtpnItsYouAnd = new JTextPane();
		txtpnItsYouAnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnItsYouAnd.setForeground(new Color(255, 255, 255));
		txtpnItsYouAnd.setBackground(new Color(106, 90, 205));
		txtpnItsYouAnd.setEditable(false);
		txtpnItsYouAnd.setText("It's you and your teams responsability to not get blobbified!  \r\n\r\n....\r\n");
		txtpnItsYouAnd.setBounds(54, 39, 327, 124);
		frame.getContentPane().add(txtpnItsYouAnd);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
}
