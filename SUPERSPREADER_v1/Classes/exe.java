package Classes;
import java.awt.EventQueue;

public class exe{

  public static void main(String[] args){
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {

          // create new instance of gui
          // create new instance of network
          mainScreen window = new mainScreen();

          System.out.println("GUI initiated");

          MulticastSocketClient network = new MulticastSocketClient();

          System.out.println("Socket created: INACTIVE");


        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
