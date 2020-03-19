import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	  int x;
      int y;
      int width;
      int height;
      int lives;
      boolean isAlive = true;
      boolean hasWon = false;
      Rectangle collisionBox;
      
	GameObject(int x, int y, int width, int height){
		this.x = x;
		this.height = height;
		this.y = y;
		this.width = width;
		lives = 2;
		collisionBox = new Rectangle(x, y, width, height);

	}
	
	void update(){
		collisionBox.setBounds(x, y, width, height);
	}
	
	void draw(Graphics g) {
		
	}
	
	void checkCollision() {
		
	}
}
