package Source;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyadapt extends KeyAdapter {
	
	player p;
	
	public keyadapt(player Player) {
		p=Player;
	}
	
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}

}
