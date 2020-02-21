import java.awt.Graphics;

public class ObjectManager {
	Player player;
	Walls walls;
	FinishLine finish;
	
	ObjectManager(Player player){
		this.player = player;
		this.walls = new Walls(0, 0, TreasureHunt._width, TreasureHunt._height);
		this.finish = new FinishLine(TreasureHunt._width-50, 50, 50,50);
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
