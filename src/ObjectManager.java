import java.awt.Graphics;

public class ObjectManager {
	Player player;
	Walls walls;
	
	ObjectManager(Player player){
		this.player = player;
		this.walls = new Walls(0, 0, TreasureHunt._width, TreasureHunt._height);
	}
	
	void update() {
		player.update();
		walls.update();
	}
	
	void draw(Graphics g) {
		walls.draw(g);
		player.draw(g);
	}
}
