import processing.core.PApplet;

public class Square {
	float xPos;
	float yPos;
	float width;
	float height;
	boolean blocked;
	int row;
	int col;
	Square parent;
	boolean prize;
	
	boolean beginning = false;
	
	public boolean isBeginning() {
		return beginning;
	} // end isBeginning
	
	public void setBeginning(boolean beginning) {
		this.beginning = beginning;
	} // end setBeginning
	
	public Square(float xPos, float yPos, float width, float height, 
			boolean blocked, boolean prize) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.blocked = blocked;
		this.parent = null;
		this.prize = prize;
	} // end constructor
	
	public void display(PApplet main) {
		if (blocked) {
			main.fill(0,0,255);
			prize = false;
		} else {
			main.fill(255,255,255);
		} // end if
		main.rect(xPos, yPos,  width, height);
		if (prize) {
			main.fill(255,255,51);
			main.ellipse(xPos +15,yPos+15, width/3, height/3);
		} // end if
	} // end display

	public float getxPos() {
		return xPos;
	}

	public float getyPos() {
		return yPos;
	}
	
	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Square getParent() {
		return parent;
	}

	public void setParent(Square parent) {
		this.parent = parent;
	}
	
	public String toString() {
		return "(" + row + "," +col + ")";
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	
} // end class Square
