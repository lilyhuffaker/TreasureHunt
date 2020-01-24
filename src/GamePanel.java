import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer tim;
	Font titleFont;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	GamePanel() {
		tim = new Timer(1000/60, this);
		//titleFont = new Font();
		//YOU ARE ON PART 7 STEP 1
	}
	
	void updateMenuState(){
		
	}
	
	void updateGameState() {
		
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
	}
	
	void startGame() {
		tim.start();
	}
	
	  @Override

	  public void paintComponent(Graphics g){	
		  if(currentState == MENU_STATE){
	             drawMenuState(g);
	     }
			 else if(currentState == GAME_STATE){
	             drawGameState(g);
	     }
			 else if(currentState == END_STATE){
	             drawEndState(g);
	     }
	     }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		 if(currentState == MENU_STATE){
             updateMenuState();
     }
		 else if(currentState == GAME_STATE){
             updateGameState();
     }
		 else if(currentState == END_STATE){
             updateEndState();
     }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key has been smooshed");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState ++;
			if(currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key has been relased from federal prison");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("type");
	}
}
