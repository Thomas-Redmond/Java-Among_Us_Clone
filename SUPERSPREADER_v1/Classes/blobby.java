package Classes;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class blobby extends entity{
  int velx = 0, vely = 0;

  public blobby(int x, int y){
    super(x, y);
  }

  public void update()
	{
		y+=vely;
		x+=velx;

	}

  public void draw(Graphics2D g2d) {
		g2d.drawImage(getBlobbyImg(),x,y,null);
	}

	public Image getBlobbyImg() {
		ImageIcon ic = new ImageIcon("Objects/blobby.jpg");
		Image i = ic.getImage();
		Image si= i.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ic= new ImageIcon(si);
		return si;
	}


  public void chase(int player_x, int player_y){
    int move_x = player_x - x;
    int move_y = player_y - y;

    // move in x direction this much
    if (move_x > 0)
    {
    	velx = 1;

    }
    else if (move_x < 0)
    {
    	velx = -1;
    }

    // move in y direction
    if (move_y > 0)
    {
    	vely = 1;

    }
    else if (move_y < 0)
    {
    	vely = -1;


    }
    if (  move_y<=3 && move_y>=0 && move_x>=0 && move_x<=3 )
    {
    	velx=0;
    	vely=0;
    	Classes.gameContext.flagend(1);

    }


  }
  public static int infected() {
	return Classes.gameContext.flagend;
  }


}
