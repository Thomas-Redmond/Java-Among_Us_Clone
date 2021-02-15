package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class gameScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameScreen window = new gameScreen();
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
	public gameScreen() {
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
		
		JButton btnNewButton = new JButton("HELP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(271, 11, 73, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Leave");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(354, 11, 73, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(15);
		progressBar.setBounds(270, 227, 157, 23);
		frame.getContentPane().add(progressBar);
		
		JTextPane txtpnChatLog = new JTextPane();
		txtpnChatLog.setText("chat log");
		txtpnChatLog.setBounds(271, 45, 156, 171);
		frame.getContentPane().add(txtpnChatLog);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 251, 205);
		frame.getContentPane().add(panel);
		
		JLabel taskLabel = new JLabel("Task's left:");
		taskLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		taskLabel.setBounds(10, 227, 91, 23);
		frame.getContentPane().add(taskLabel);
	}
}
