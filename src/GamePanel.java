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
	Player player;
	ObjectManager object;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	GamePanel() {
		tim = new Timer(1000/60, this);
		titleFont = new Font("Comic Sans MS",Font.PLAIN,48);
		player = new Player(200, 200, 50, 50);
		object = new ObjectManager(player);
	}
	
	void updateMenuState(){
		
	}
	
	void updateGameState() {
		object.update();
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("TREASURE HUNT", 200, 100);
		g.drawString("Press ENTER to start", 150, 600);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
		object.draw(g);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 250, 100);
		g.drawString("Press ENTER to try again", 100, 600);
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState ++;
			if(currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.x -= player.speed;
			if (player.x > TreasureHunt._width) {
				player.x = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.x += player.speed;
			if (player.x < 0) {
				player.x = TreasureHunt._width;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player.y += player.speed;
			if (player.y < 0) {
				player.y = TreasureHunt._height;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.y -= player.speed;
			if (player.y > TreasureHunt._height) {
				player.y = 0;
			}
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
