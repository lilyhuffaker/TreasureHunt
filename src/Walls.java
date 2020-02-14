import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Walls extends GameObject{
	int cellsX = 16;
	int cellsY = 16;
	char array [][] = new char[cellsX][cellsY];
	
	Walls(int x, int y, int width, int height){
		super(x, y, width, height);
		loadWalls("src/Maze1.txt");
	}
	
	void draw(Graphics g) {
		int cellWidth = this.width/cellsX;
		int cellHeight = this.height/cellsY;
		g.setColor(Color.black);
	    g.fillRect(x, y, width, height);
	    for (int col = 0;col<cellsX;col++) {
	    	for(int row = 0;row<cellsY;row++) {
	    		if (array[col][row] == 'X') {
	    			g.setColor(Color.LIGHT_GRAY);
	    			g.fillRect(col*cellWidth, row*cellHeight, cellWidth, cellHeight);
	    		}
	    	}
	    }
	}
	
	void update() {
		
	}
	
	void loadWalls(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int row = 0;
			while (line != null) {
				for (int col = 0;col<line.length();col++) {
					array[col][row]=line.charAt(col);
				}
				row++;
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
