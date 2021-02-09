package compiledGame; // compiled files stored in seperate file for neatness
// requires using different compilation command: javac -d . gui.java
// run on cmd: java compiledGame.gui for testing purposes

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class gui extends Frame implements WindowListener{

  private void constructor(String newTitle){
    Frame window = new Frame("New Window");

    setTitle(newTitle);
    setVisible(true);
    setSize(700,700);
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
    gui master = new gui();
    master.constructor("Generic Page");
  }

}
