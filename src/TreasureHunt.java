import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TreasureHunt {
	JFrame frame;
	final int _width = 800;
	final int _height = 800;
	GamePanel gamePanel;
	
	public static void main(String[] args) {
		new TreasureHunt().setup();
		
	}
	
	 TreasureHunt() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}
	
	void setup() {
		frame.addKeyListener(gamePanel);
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setSize(_width, _height);
		frame.getContentPane().setPreferredSize(new Dimension(_width, _height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		gamePanel.startGame();
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
}
//YOU ARE ON PART 5 STEP TEN!
