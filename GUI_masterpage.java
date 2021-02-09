// game
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class GUI_masterpage extends Frame implements WindowListener{
  // page title variable
  // page size fixed
  // array of children ?
  // page parent pointer


  private void constructor(String newTitle){
    Frame newWindow = new Frame("New Window");

    setTitle(newTitle);
    setVisible(true);
    setSize(300,300);
    setLayout(null);
    addWindowListener(this); // required to close the window

    // declaring generic elements

    // adding elements to frame
  }

  // following methods are all required to close the window
  // don't ask AWT is a bit dim
  public void windowActivated(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
  public void windowClosing(WindowEvent e) {
      dispose();
  }
  public void windowDeactivated(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowOpened(WindowEvent arg0) {}
  // end of window methods

  public static void main(String[] args){
    GUI_masterpage master = new GUI_masterpage();
    master.constructor("Master Page");
  }

}
