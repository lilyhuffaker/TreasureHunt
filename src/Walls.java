import java.awt.Color;
import java.awt.Graphics;

public class Walls extends GameObject{
	
	Walls(int x, int y, int width, int height){
		super(x, y, width, height);
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLACK);
	    g.fillRect(x, y, width, height);
	}
	
	void update() {
		
	}
}
/*
XXXXXXXXXXXXXXXX
X         X
X     X   X XXXX
X XXX XXX X X  X
X X X   X X XX X
X X XXX X X X  X
X X X X X X X XX
X X X X  X  X  X
X X   XX   XXX X
X XXX   XXX    X
X              X
XXX XXXXXX X X X
X X X    X X X X
X X X XXXX X X X
X   X      X X X
XXXXXXXXXXXXXX X
*/
