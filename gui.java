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
  Label titleLabel;

  // constructor method
  private gui(){
    // modify starting values
    this.setTitle("Hello World");
    this.setSize(500, 500);

    mainPage Main = new mainPage();
    this.add(Main);
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

  }

public class mainPage extends Container{
  // declare variables here - values assigned elsewhere unless they're like pi
  Button nav1, nav2, nav3, nav4;
  private mainPage(){
    // constructor

    // instansiate widgets
    nav1 = new Button("Join a game");
    nav2 = new Button("Host a game");
    nav3 = new Button("How to play");
    nav4 = new Button("Settings");
    // add widgets to this
    this.add(nav1);
    this.add(nav2);
    this.add(nav3);
    this.add(nav4);
    this.setVisible(true);
  }



  }
}
