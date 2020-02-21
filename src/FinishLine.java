import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FinishLine extends GameObject{
	
	FinishLine(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	
	void update() {
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
	
}
