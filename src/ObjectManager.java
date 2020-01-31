import java.awt.Graphics;

public class ObjectManager {
	Player player;
	
	ObjectManager(Player player){
		
	}
	
	void update() {
		player.update();
	}
	
	void draw(Graphics g) {
		player.draw(g);
	}
}
