package compiledGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;


public class gameScreen {
	
	private JFrame frame;
	public JLabel timelabel;
	
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
		frame.getContentPane().add(new TimerCountD());
		
		JButton btnNewButton = new JButton("HELP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HowToPlay nw = new HowToPlay();
				nw.setVisible(true);
				HowToPlay.changeButtonStatus(false);
			}
		});
		btnNewButton.setBounds(271, 11, 73, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Leave");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the game?", null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null);
					       if(result == JOptionPane.YES_OPTION){
					    	   mainScreen nw = new mainScreen();
								nw.setVisible(true);
								frame.setVisible(false);
								frame.dispose();
					       }else{
					               //Do nothing
					       }
			}
		});
		btnNewButton_1.setBounds(354, 11, 73, 23);
		frame.getContentPane().add(btnNewButton_1);
		
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
		
		JLabel timelabel = new JLabel("");
		timelabel.setBounds(329, 227, 98, 23);
		frame.getContentPane().add(timelabel);
		
		JLabel lblNewLabel = new JLabel("Time\r\n left:");
		lblNewLabel.setBounds(271, 224, 73, 33);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
}

@SuppressWarnings("serial")
class TimerCountD extends JPanel {
	JLabel label;
	Timer timer;
	int count;
	public TimerCountD() {
		label = new JLabel("...");
		label.setBounds(329, 227, 98, 23);
		add(label);
		timer = new Timer(9000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				if (count < 100000) {
					label.setText(Integer.toString(count));
				} else {
					((Timer) (e.getSource())).stop();
				}
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}
}
