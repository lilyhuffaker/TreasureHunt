import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	  int x;
      int y;
      int width;
      int height;
      boolean isAlive;
      Rectangle collisionBox;
      
	GameObject(int x, int y, int width, int height){
		this.x = x;
		this.height = height;
		this.y = y;
		this.width = width;
		collisionBox = new Rectangle();
	}
	
	void update(){
		
	}
	
	void draw(Graphics g) {
		
	}
}
//YOU ARE ON PART 12 STEP 3!