
import processing.core.PApplet;

public class Main extends PApplet {

	Maze theMaze;
	Guy theGuy;
	Square theSquare;
	boolean prize;
	boolean collide = true;
	
	int currentRow=0;
	int currentCol=0;
	
	float widthOfSquare = 30;
	float heightOfSquare = 30;
	
	int numRows = 10;
	int numCols = 20;
	
	public void settings() {
		size(1000,800);
	} // end settings
	
	public void setup() {
	
			theMaze = new Maze(0, 0, numRows, numCols, widthOfSquare,
					heightOfSquare, 0.2);
			theMaze.setBlocked(0, 0, false);
			theMaze.setBlocked(numRows-1, numCols-1, false);
			theGuy = new Guy(width/2, height/2, 20,20);
			theMaze.markReachable(0, 0);
//			System.out.println("bottom right corner is reachable?" +
			theMaze.isReachable(numRows-1, numCols-1);
//			while ( ! theMaze.isReachable(numRows-1, numCols-1));
	} // end setup
	
	public void draw() {
		theMaze.display(this);
		float xPos = currentCol * widthOfSquare + widthOfSquare/2;
		float yPos = currentRow * heightOfSquare + heightOfSquare/2;
		theGuy.setxPos(xPos);
		theGuy.setyPos(yPos);
		theGuy.display(this);
		theMaze.markReachable(currentRow, currentCol);
		theMaze.drawSP(this);
		if (collide) {
	//		theSquare.prize;
		} // end if
	} // end draw
		
	boolean collide(Guy theGuy, Square theSquare) {
		return true;
	} // end collide

	public void mouseClicked() {
		theMaze.drawSP(this);
	} // end mouseClicked
	
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == LEFT && currentCol > 0 && !
					theMaze.isBlocked(currentRow, currentCol-1)) {
				currentCol--;
				
			} else if (keyCode == RIGHT && currentCol < numCols-1 &&
					! theMaze.isBlocked(currentRow, currentCol +1)) {
				currentCol++;
				
			} else if (keyCode == UP && currentRow > 0 && !
					theMaze.isBlocked(currentRow-1, currentCol)) {
				currentRow--;
				
			} else if (keyCode == DOWN && currentRow < numRows-1
					&& ! theMaze.isBlocked(currentRow+1, currentCol)) {
				currentRow++;

			} // end if
		} // end if
	} // end keyPressed
	
	public static void main(String[] args) {
		PApplet.main("Main");
	} // end main

} // end class Main
