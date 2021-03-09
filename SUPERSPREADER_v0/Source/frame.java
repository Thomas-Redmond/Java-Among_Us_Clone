package movement.test;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Player Navigation");
        setSize(800,800);
        setResizable(false);

        init();
    }
    public void init(){
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,1,0,0));

        Screen s = new Screen();

        add(s);

        setVisible(true);


    }
    public static void main(String[] args){
        Frame f = new Frame();
    }
}