import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
	int speed;
	public static int startX = 710;
	public static int startY = 740;
	
	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}
	
	void update(){
		super.update();
	}
	
	void draw(Graphics g) {
		 g.setColor(Color.DARK_GRAY);
	     g.fillRect(x, y, width, height);
	}
}
