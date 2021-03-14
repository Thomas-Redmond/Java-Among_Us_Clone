package Source;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class player extends entity{

	
	int velx=0,vely=0;
	public player(int x, int y) {
		super(x, y);
		
	}
	
	public void update()
	{
		y+=vely;
		x+=velx;
		
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(),x,y,null);
	}
	
	public Image getPlayerImg() {
		ImageIcon ic = new ImageIcon("blobby.jpg");
		Image i = ic.getImage();
		Image si= i.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ic= new ImageIcon(si);
		return si;
	}
	
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			vely = -2;
		}else if (key == KeyEvent.VK_S) {
			vely = 2;
		}else if(key == KeyEvent.VK_A) {
			velx = -2;
		}else if(key == KeyEvent.VK_D) {
			velx= 2;
		}
		
	}
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			vely = 0;
		}else if (key == KeyEvent.VK_S) {
			vely = 0;
		}else if(key == KeyEvent.VK_A) {
			velx = 0;
		}else if(key == KeyEvent.VK_D) {
			velx= 0;
		}
	}

}

