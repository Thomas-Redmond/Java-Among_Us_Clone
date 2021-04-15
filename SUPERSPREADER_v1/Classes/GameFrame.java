package Classes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Classes.SuppressWarnings;
import Classes.task;

@SuppressWarnings("serial")
public class GameFrame extends JPanel implements ActionListener{

	Timer mainTimer;
	player Player;
	blobby monster;
	task Task1;
	task Task2;
	task Task3;
	task Task4;
	task Task5;
	static int taskCounter;

	public GameFrame() {
		setFocusable(true);
		// create new player, and new blobby monster
		Player = new player(100,100);
		monster = new blobby(0,0);
		taskCounter=5;
		addKeyListener(new keyadapt(Player));
		Task1 = new task(xcoord(),ycoord());
		Task2 = new task(xcoord(),ycoord());
		Task3 = new task(xcoord(),ycoord());
		Task4 = new task(xcoord(),ycoord());
		Task5 = new task(xcoord(),ycoord());
		mainTimer = new Timer(15,this);
		mainTimer.start();


	}
	public int tasksRemaining() {
		return taskCounter;
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d= (Graphics2D) g;
		Player.draw(g2d);
		monster.draw(g2d);
		Task1.draw(g2d);
		Task2.draw(g2d);
		Task3.draw(g2d);
		Task4.draw(g2d);
		Task5.draw(g2d);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		Player.update();
		monster.chase(Player.x, Player.y);
		monster.update();

		if (sameCoords(Player, Task1)==true){			
			if (task(Task1)==true) {
					taskCounter --;
					Task1.dispose();
					repaint();
			}
			else {
				Task1 = new task(xcoord(),ycoord());
				repaint();
				Player.update();
			}
		}
		if (sameCoords(Player, Task2)==true) {
			if (task(Task2)==true) {
				taskCounter --;
				Task2.dispose();
				repaint();
		}
			else {
				Task2 = new task(xcoord(),ycoord());
				repaint();
				Player.update();
			}
		}

		if (sameCoords(Player, Task3)==true) {
			if (task(Task3)==true) {
				taskCounter --;
				Task3.dispose();
				repaint();
		}
			else {
				Task3 = new task(xcoord(),ycoord());
				repaint();
				Player.update();
			}
		}
		if (sameCoords(Player, Task4)==true) {
			if (task(Task4)==true) {
				taskCounter --;
				Task4.dispose();
				repaint();
		}
			else {
				Task4 = new task(xcoord(),ycoord());
				repaint();
				Player.update();
			}
		}
		if (sameCoords(Player, Task5)==true) {
			if (task(Task5)==true) {
				taskCounter --;
				Task5.dispose();
				repaint();
		}
			else {
				Task5 = new task(xcoord(),ycoord());
				repaint();
				Player.update();
			}
		}
	}

	

	public String randomMiniGame() {
		File taskfile = new File("Objects/minigames");
		int totalLines = 0;

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(taskfile));

			while ((br.readLine()) != null) {
				totalLines++;
			}
			br.close();

			br = new BufferedReader(new FileReader(taskfile));

			Random random = new Random();
			int randomInt = random.nextInt(totalLines);
			int count=0;
			String icaocode;
			while ( (icaocode = br.readLine()) != null) {
				if (count == randomInt) {
					br.close();
					return icaocode;
				}
				count++;
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + taskfile.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file: " + taskfile.toString());
		}
		return null;
	}

	private boolean sameCoords(player player1, task task) {

		if( (player1.x >= ((task.x)-5) && player1.x <= ((task.x)+5)) && (player1.y >= ((task.y)-5) && player1.y <= ((task.y)+5)) ) {
			return true;
		}
		else {
			return false;
		}

	}

	public int xcoord() {
		Random r = new Random();
		int low = 0;
		int high = 399;
		int randxcoord = r.nextInt(high-low) + low;
		return randxcoord;
	}

	public int ycoord() {
		Random r = new Random();
		int low = 0;
		int high = 299;
		int randycoord = r.nextInt(high-low) + low;
		return randycoord;
	}

	public boolean task(Classes.task task22taskIcon){

		String minigame = randomMiniGame();
		String[] result = minigame.split(",");

		String userAnswer = JOptionPane.showInputDialog(result[0], JOptionPane.QUESTION_MESSAGE);

		if (userAnswer.equals(result[1])){
			JOptionPane.showMessageDialog(null, "Correct, you recieved a coin!! :) ");
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Oh Noooo :(( you didnt get that right, better luck next time");
			return false;
		}

	}

}
