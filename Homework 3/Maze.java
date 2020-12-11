import java.util.ArrayList;
import processing.core.PApplet;

public class Maze {

	Square[][] grid; // creates object reference
	float xPos;
	float yPos;
	int numRows;
	int numCols;
	
	Maze(float xPos, float yPos, int numRows, int numCols, float widthOfSquare,
			float heightOfSquare, double probOfBlocked) {
		grid = new Square[numRows][numCols]; // constructs the list
		this.xPos = xPos;
		this.yPos = yPos;
		this.numRows = numRows;
		this.numCols = numCols;
	
		for(int row = 0; row < numRows; row++) {
			for(int col = 0; col < numCols; col++) {
				grid[row][col] = new Square(col * widthOfSquare, row * heightOfSquare, 
						widthOfSquare, heightOfSquare, Math.random() < 
						probOfBlocked, true);
				grid[row][col].setRow(row);
				grid[row][col].setCol(col);
				
			} // end for
		} // end for
	} // end constructor
	
	public void display(PApplet main) {
		main.pushMatrix();
		main.translate(xPos, yPos);
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				grid[row][col].display(main);
			} // end for
		} // end for
		main.popMatrix();
		
	} // end display
	
	public boolean isBlocked(int row, int col) {
		return grid[row][col].isBlocked();
	} // end isBlocked
	
	public void setBlocked(int row, int col, boolean blocked){
		grid[row][col].setBlocked(blocked);
	} // end setBlocked
	
	public void markReachable(int row, int col) {
		ArrayList<Square> openList = new ArrayList <Square>();
		for (int i=0; i <numRows; i++){
			for (int j=0; j<numRows; j++) {
				grid[i][j].setParent(null);
				grid[i][j].setBeginning(false);
			} // end for
		} // end for
		openList.add(grid[row][col]);
		grid[row][col].setBeginning(true);
		
		while (openList.size() > 0) {
			Square current = openList.remove(0);
			processSquare(current, openList);
		} // end while
	} // end markReachable
	
	public void processSquare(Square theSquare, ArrayList <Square> list) {
		int row = theSquare.getRow();
		int col = theSquare.getCol();
		
		checkAndAdd(list, theSquare, row-1, col);
		checkAndAdd(list, theSquare, row+1, col);
		checkAndAdd(list, theSquare, row, col-1);
		checkAndAdd(list, theSquare, row, col+1);
	} // end processSquare
	
	void checkAndAdd(ArrayList<Square> list, Square current, int newRow,
			int newCol) {
		if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols
				&& !grid [newRow][newCol].isBlocked() && 
				grid[newRow][newCol].getParent() == null) {
			list.add(grid[newRow][newCol]);
			grid[newRow][newCol].setParent(current);
		} // end if
	} // end checkAndAdd
	
	void drawSP(PApplet main) {
		Square currentSquare = grid[numRows-1][numCols-1];
		Square parent = currentSquare.getParent();
		
		while (!currentSquare.isBeginning() && parent != null) {
			main.line(currentSquare.getxPos() + currentSquare.getWidth()/2, 
					currentSquare.getyPos() + currentSquare.getHeight()/2, 
					parent.getxPos() + parent.getWidth()/2,
					parent.getyPos() + parent.getHeight()/2);
			currentSquare = parent;
			parent = currentSquare.getParent();
		} // end while
	} // end drawSP
	
	boolean isReachable(int row, int col) {
		return grid[row][col].getParent() != null;
	} // end isReachable
	
	
} // end class
