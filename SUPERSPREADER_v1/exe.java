import Classes.*;
import java.awt.EventQueue;

public class exe{
  public static void main(String[] args){
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Classes.mainScreen window = new Classes.mainScreen();

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
