import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	public static BufferedImage heartimg;
	public static BufferedImage failedimg;
	public static BufferedImage finishedimg;
	public static BufferedImage titleimg;
	public static BufferedImage instructionsimg;
	
	GamePanel() {
		tim = new Timer(1000/60, this);
		lifeFont = new Font ("Comic Sans MS",Font.PLAIN,24);
		titleFont = new Font("Comic Sans MS",Font.PLAIN,35);
		otherFont = new Font("Comic Sans MS",Font.PLAIN,48);
		player = new Player(710, 740, 35, 35);
		finish = new FinishLine(TreasureHunt._width-50, 50, 50,50);
		object = new ObjectManager(player, finish);
		start = System.currentTimeMillis();
		try {
            heartimg = ImageIO.read(this.getClass().getResourceAsStream("HEART.png"));
            failedimg = ImageIO.read(this.getClass().getResourceAsStream("ESCAPE_FAILED.png"));
            finishedimg = ImageIO.read(this.getClass().getResourceAsStream("ESCAPE_FINISHED.png"));
            titleimg = ImageIO.read(this.getClass().getResourceAsStream("ESCAPE_TITLE.png"));
            instructionsimg = ImageIO.read(this.getClass().getResourceAsStream("ESCAPE_INSTRUCTIONS.png"));
    } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
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
		g.drawImage(GamePanel.titleimg, 0, 0, TreasureHunt._width, TreasureHunt._height, null);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0, TreasureHunt._width, TreasureHunt._height);
		object.draw(g);
		g.setFont(lifeFont);
		g.setColor(Color.black);
		g.drawString("Lives:", 10, 40);
		g.drawImage(GamePanel.heartimg, 70, 5, 50, 50, null);
		g.drawImage(GamePanel.heartimg, 110, 5, 50, 50, null);
		g.drawImage(GamePanel.heartimg, 150, 5, 50, 50, null);
		if(player.lives == 1) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(150, 0, 50, 50);
		}
		if(player.lives == 0) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(150, 0, 50, 50);
			g.fillRect(110, 0, 50, 50);
		}
	}
	
	void drawEndState(Graphics g) {
		g.drawImage(GamePanel.finishedimg, 0, 0, TreasureHunt._width, TreasureHunt._height, null);
		g.setFont(titleFont);
		g.drawString(""+finishTime, 340, 225);
	}
	
	void drawFailState(Graphics g) {
		g.drawImage(GamePanel.failedimg, 0, 0, TreasureHunt._width, TreasureHunt._height, null);
	}
	
	void drawRulesState(Graphics g) {
		g.drawImage(GamePanel.instructionsimg, 0, 0, TreasureHunt._width, TreasureHunt._height, null);
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
