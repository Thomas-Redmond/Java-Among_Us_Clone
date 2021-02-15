package compiledGame; // compiled files stored in seperate file for neatness
// requires using different compilation command: javac -d . gui.java
// run on cmd: java compiledGame.gui for testing purposes

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
This function is the framework class. Think of it as the bucket which contains GUI soup. If the bucket isn't there it would make a very big mess
It is not supposed to be visible, and works in the background. It will not have widgets.
*/
public class gui extends Frame implements WindowListener{
  // declare variables before implementation to avoid ERROR: not found

  // constructor method
  private void gui(){
    page1 newPage = new page1();
    newPage.setVisible(true);
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
  // end of MANDATORY window methods

  public static void main(String[] args){
    gui master = new gui();
    master.setVisible(true);
    master.addWindowListener(master);
    // instansiate child classes

  }

private class page1 extends gui{
  // declare variables here - values assigned elsewhere unless they're like pi
  Label title;

  // constructor !
  private void page1(){
    setTitle("FRAME");
    addWindowListener(this);
    // instansiate variables here
    title = new Label();

    // declare text for Labels
    title.setText("New String");

    // give position data
    title.setAlignment(Label.CENTER);
    // add to page

  }

  }
}
