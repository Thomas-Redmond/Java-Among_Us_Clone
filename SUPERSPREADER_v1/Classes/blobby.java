import java.util.math;

public class blobby extends entity{
  int velx = 0, vely = 0;

  public blobby(int x, int y){
    super(x, y);
  }

  public void chase(int player_x, int player_y){
    int move_x = player_x - x;
    int move_y = player_y - y;

    // move in x direction this much
    if (move_x > 0){velx = 2;}
    elif (move_x < 0){velx = -2;}

    // move in y direction
    if (move_y > 0){vely = 2;}
    elif (move_y < 0){vely = -2;}

  }

}
