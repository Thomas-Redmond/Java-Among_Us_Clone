package Classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class gameContext {

	private JFrame frmSuperSpreader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameContext window = new gameContext();
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
	public gameContext() {
		initialize();
	}

	public static int initvariable() {
		var=0;
		return var;
	}



	/**
	 * Initialize the contents of the frame.
	 */
	static int var=0;
	static int flagend=0;
	private void initialize() {
		frmSuperSpreader = new JFrame();
		frmSuperSpreader.setResizable(false);
		frmSuperSpreader.setTitle("Super Spreader");
		frmSuperSpreader.getContentPane().setBackground(new Color(106, 90, 205));
		frmSuperSpreader.setBounds(100, 100, 594, 356);
		frmSuperSpreader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton beginGameButton = new JButton("Continue");
		beginGameButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		beginGameButton.setBounds(173, 271, 243, 29);
		beginGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initflag();
				frmSuperSpreader.setVisible(false);
				gameScreen nw = new gameScreen();
				nw.setVisible(true);
				frmSuperSpreader.dispose();
				initvariable();
				System.out.println(flagend);
			}
		});
		frmSuperSpreader.getContentPane().setLayout(null);

		JTextPane txtpnItsYouAnd = new JTextPane();
		txtpnItsYouAnd.setBounds(54, 39, 481, 124);
		txtpnItsYouAnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnItsYouAnd.setForeground(new Color(255, 255, 255));
		txtpnItsYouAnd.setBackground(new Color(106, 90, 205));
		txtpnItsYouAnd.setEditable(false);
		txtpnItsYouAnd.setText("It's your responsability to not get blobbified!  \r\n\r\nMove around the game board with the arrow keys. Try to collect all the gold coins before the time runs out or before Mr Blobby catches you !!\r\n\r\nGOOD LUCK! (you'll need it)");
		frmSuperSpreader.getContentPane().add(txtpnItsYouAnd);
		frmSuperSpreader.getContentPane().add(beginGameButton);
	}

	public static int variable(int v) {
		if (var!=0)
		{
			return 1;
		}
		else if (var==v) {
			return 0;
		}
		return (Integer) null;
	}

	public static void updvariable(int i) {
		var=i;
		variable(var);
	}

	public static int flagend(int v) {
		flagend=1;
		return flagend;
	}
	public static int initflag() {
		flagend=0;
		return flagend;
	}



	public void setVisible(boolean b) {
		frmSuperSpreader.setVisible(b);

	}
}
