package Classes;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class task extends entity {


	public task(int x, int y) {
		super(x, y);
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getCoinImg(),x,y,null);
	}
	
	public Image getCoinImg() {
		ImageIcon ic = new ImageIcon("Objects/goldcoin.jpg");
		Image i = ic.getImage();
		Image si= i.getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
		ic= new ImageIcon(si);
		return si;
	}
	

	public Object getXBounds() {
		return x;
	}
	
	public Object getYBounds() {
		return y;
	}

		
}
