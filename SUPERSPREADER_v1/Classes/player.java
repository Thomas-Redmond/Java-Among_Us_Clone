package Classes;

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
		ImageIcon ic = new ImageIcon("Objects/blobby.jpg");
		Image i = ic.getImage();
		Image si= i.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ic= new ImageIcon(si);
		return si;
	}

	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		if (x<400 && x>0 && y<300 && y>0)	{
			if (key == KeyEvent.VK_UP) {
				vely = -2;
			}else if (key == KeyEvent.VK_DOWN) {
				vely = 2;
			}else if(key == KeyEvent.VK_LEFT) {
				velx = -2;
			}else if(key == KeyEvent.VK_RIGHT) {
				velx= 2;
			}
		}
		else {
			if(x>398) {
				x=399;
			}
			if(x<=1) {
				x=1;
			}
			if(y>298) {
				y=299;
			}
			if(y<=1) {
				y=1;
			}
		}
		

	}
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			vely = 0;
		}else if (key == KeyEvent.VK_DOWN) {
			vely = 0;
		}else if(key == KeyEvent.VK_LEFT) {
			velx = 0;
		}else if(key == KeyEvent.VK_RIGHT) {
			velx= 0;
		}
	}

}

