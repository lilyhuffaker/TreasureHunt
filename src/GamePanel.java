import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer tim;
	Font titleFont;
	Font otherFont;
	Font lifeFont;
	Player player;
	FinishLine finish;
	ObjectManager object;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int FAIL_STATE = 3;
	final int RULES_STATE = 4;
	int currentState = MENU_STATE;
	long start;
	long end;
	long finishTime;
	GamePanel() {
		tim = new Timer(1000/60, this);
		lifeFont = new Font ("Comic Sans MS",Font.PLAIN,24);
		titleFont = new Font("Comic Sans MS",Font.PLAIN,35);
		otherFont = new Font("Comic Sans MS",Font.PLAIN,48);
		player = new Player(710, 740, 35, 35);
		finish = new FinishLine(TreasureHunt._width-50, 50, 50,50);
		object = new ObjectManager(player, finish);
		start = System.currentTimeMillis();
	}
	
	void updateMenuState(){
		
	}
	
	void updateGameState() {
		object.update();
		if(player.hasWon == true) {
			player.lives = 2;
			currentState = END_STATE;
			player.hasWon = false;
			player.x = Player.startX;
			player.y = Player.startY;
		}
	}
	
	void updateEndState() {
		
	}
	
	void updateFailState() {
		
	}
	
	void updateRulesState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("TREASURE HUNT", 200, 100);
		g.drawString("Press ENTER to start", 150, 600);
		g.drawString("Press 'I' for help", 150, 700);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
		object.draw(g);
		g.setFont(lifeFont);
		g.setColor(Color.black);
		g.drawString("Lives:", 10, 40);
	    g.setColor(Color.red);
		g.fillRect(90, 12, 30, 30);
		g.fillRect(130, 12, 30, 30);
		g.fillRect(170, 12, 30, 30);
		if(player.lives == 1) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(170, 12, 30, 30);
		}
		if(player.lives == 0) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(170, 12, 30, 30);
			g.fillRect(130, 12, 30, 30);
		}
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("YOU COMPLETED THE MAZE IN " + finishTime + " SECONDS!", 10, 100);
		g.setFont(otherFont);
		g.drawString("Press ENTER to play again", 100, 600);
	}
	
	void drawFailState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("You failed to complete the maze...", 10, 100);
		g.setFont(otherFont);
		g.drawString("Press ENTER to play again", 100, 600);
	}
	
	void drawRulesState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("How to Play", 10, 100);
	}
	
	void startGame() {
		System.out.println("speak");
		player.hasWon = false;
		player.isAlive = true;
		player.lives = 2;
		player.x = Player.startX;
		player.y = Player.startY;
		tim.start();
		start = System.currentTimeMillis();
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
			 else if(currentState == FAIL_STATE) {
				 drawFailState(g);
		 }
			 else if(currentState == RULES_STATE) {
				 drawRulesState(g);
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
		 else if(currentState == RULES_STATE) {
			 updateRulesState();
	 }
		 else if(currentState == FAIL_STATE) {
			 updateFailState();
		 }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = player.x;
		int y = player.y;
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState ++;
			if(currentState > END_STATE) {
				currentState = MENU_STATE;
			}
			if(currentState == GAME_STATE) {
				 startGame();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
			currentState = RULES_STATE;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			x -= player.speed;
			if (x > TreasureHunt._width) {
				x = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			x += player.speed;
			if (x < 0) {
				x = TreasureHunt._width;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			y += player.speed;
			if (y < 0) {
				y = TreasureHunt._height;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			y -= player.speed;
			if (y > TreasureHunt._height) {
				y = 0;
			}
		}
		if(object.walls.intersects(new Rectangle(x,y,player.width,player.height)) == false) {
			player.x = x;
			player.y = y;
		}
		else {
			System.out.println("nah");
			if (player.lives >= 1) {
				player.lives--;
				player.x = Player.startX;
				player.y = Player.startY;
			}
			else {
				player.isAlive = false;
				currentState = FAIL_STATE;
			}
			
		}
		
		if(player.collisionBox.intersects(finish.collisionBox) == true) {
			System.out.println("free");
			end = System.currentTimeMillis();
			finishTime = (end - start)/1000;
			player.hasWon = true;
			player.x = Player.startX;
			player.y = Player.startY;
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
