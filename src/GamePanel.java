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
	Player player;
	FinishLine finish;
	ObjectManager object;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	long start;
	long end;
	long finishTime;
	GamePanel() {
		tim = new Timer(1000/60, this);
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
			currentState = END_STATE;
			player.hasWon = false;
			player.x = Player.startX;
			player.y = Player.startY;
		}
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
		g.drawString("YOU COMPLETED THE MAZE IN " + finishTime + " SECONDS!", 10, 100);
		g.setFont(otherFont);
		g.drawString("Press ENTER to play again", 100, 600);
	}
	
	void startGame() {
		System.out.println("speak");
		player.hasWon = false;
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
			player.isAlive = false;
			player.x = Player.startX;
			player.y = Player.startY;
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
