package compiledGame;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.*;
import javax.swing.*;
import java.awt.*;


public class gameScreen {

	private JFrame frmSuperSpreader;
	public JLabel timelabel;
	private JTextField timerfield;
	private LocalDateTime startTime;
    private Timer timer;
    private Duration duration = Duration.ofMinutes(15);
    private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameScreen window = new gameScreen();
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
	public gameScreen() {
		initialize();

	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frmSuperSpreader = new JFrame();
		frmSuperSpreader.setBackground(SystemColor.inactiveCaption);
		frmSuperSpreader.setResizable(false);
		frmSuperSpreader.setTitle("SUPER SPREADER");
		frmSuperSpreader.setBounds(100, 100, 766, 469);
		frmSuperSpreader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSuperSpreader.setLocationRelativeTo(null);


		JButton btnNewButton = new JButton("HELP");
		btnNewButton.setBounds(473, 11, 126, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HowToPlay nw = new HowToPlay();
				nw.setVisible(true);
				HowToPlay.changeButtonStatus(false);
			}
		});
		frmSuperSpreader.getContentPane().setLayout(null);
		frmSuperSpreader.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Leave");
		btnNewButton_1.setBounds(609, 11, 126, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the game?", null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null);
				if(result == JOptionPane.YES_OPTION){
					mainScreen nw = new mainScreen();
					nw.setVisible(true);
					frmSuperSpreader.setVisible(false);
					frmSuperSpreader.dispose();
				}else{
					//Do nothing
				}
			}
		});
		frmSuperSpreader.getContentPane().add(btnNewButton_1);

		JTextPane txtpnChatLog = new JTextPane();
		txtpnChatLog.setEditable(false);
		txtpnChatLog.setBounds(473, 55, 233, 306);
		txtpnChatLog.setText("chat log");
		frmSuperSpreader.getContentPane().add(txtpnChatLog);

		JPanel panel = new JPanel();
		panel.setBounds(20, 55, 428, 339);
		frmSuperSpreader.getContentPane().add(panel);

		JLabel taskLabel = new JLabel("Task's left:");
		taskLabel.setForeground(Color.WHITE);
		taskLabel.setBounds(10, 14, 91, 23);
		taskLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmSuperSpreader.getContentPane().add(taskLabel);

		JLabel lblNewLabel = new JLabel("Time\r\n left:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(263, 9, 73, 33);
		frmSuperSpreader.getContentPane().add(lblNewLabel);

		timerfield = new JTextField();
		timerfield.setHorizontalAlignment(SwingConstants.CENTER);
		timerfield.setBounds(336, 11, 100, 33);
		timerfield.setEditable(false);
		frmSuperSpreader.getContentPane().add(timerfield);
		timerfield.setColumns(10);

	     JButton btn = new JButton("Start");
	     btn.setBounds(144, 15, 89, 25);
 		frmSuperSpreader.getContentPane().add(btn);
 		
 		textField = new JTextField();
 		textField.setBounds(473, 374, 233, 20);
 		frmSuperSpreader.getContentPane().add(textField);
 		textField.setColumns(10);
 		
 		JLabel lblNewLabel_1 = new JLabel("New label");
 		lblNewLabel_1.setIcon(new ImageIcon(gameScreen.class.getResource("/pictures/picture 8.1.png")));
 		lblNewLabel_1.setBounds(0, 0, 760, 443);
 		frmSuperSpreader.getContentPane().add(lblNewLabel_1);
         btn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if (timer.isRunning()) {
                     timer.stop();
                     startTime = null;
                     btn.setText("Start");
                 } else {
                     startTime = LocalDateTime.now();
                     timer.start();
                     btn.setText("Stop");
                 }
             }
         });
         
// https://stackoverflow.com/questions/48046501/create-a-java-gui-countdown-timer-that-starts-with-user-input
         timer = new Timer(500, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 LocalDateTime now = LocalDateTime.now();
                 Duration runningTime = Duration.between(startTime, now);
                 Duration timeLeft = duration.minus(runningTime);
                 if (timeLeft.isZero() || timeLeft.isNegative()) {
                     timeLeft = Duration.ZERO;
                     btn.doClick(); // Cheat
                 }

                 timerfield.setText(format(timeLeft));
             }
         });
     }

     protected String format(Duration duration) {
         long mins = duration.toMinutes();
         long seconds = duration.minusMinutes(mins).toMillis() / 1000;
         return String.format("%02dm %02ds", mins, seconds);
     }


	public void setVisible(boolean b) {
		frmSuperSpreader.setVisible(b);
	}
}



