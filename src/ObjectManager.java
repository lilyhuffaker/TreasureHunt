import java.awt.Graphics;

public class ObjectManager {
	Player player;
	Walls walls;
	FinishLine finish;

	
	ObjectManager(Player player, FinishLine finish){
		this.player = player;
		this.walls = new Walls(0, 0, TreasureHunt._width, TreasureHunt._height);
		this.finish = finish;
	}
	
	void update() {
		player.update();
		walls.update();
		finish.update();
	}
	
	void draw(Graphics g) {
		walls.draw(g);
		player.draw(g);
		finish.draw(g);
	}
}
