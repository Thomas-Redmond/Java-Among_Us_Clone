package Source;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener{
	
	Timer mainTimer;
	player Player;
	public GameFrame() {
		setFocusable(true);
		
		
		Player = new player(100,100);
		addKeyListener(new keyadapt(Player));
		mainTimer = new Timer(10,this);
		mainTimer.start();
		
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d= (Graphics2D) g;
		Player.draw(g2d);
	
	
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		Player.update();
	}

}
