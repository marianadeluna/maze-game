import processing.core.PApplet;

public class Guy extends PApplet {

	float xPos;
	float yPos;
	float width;
	float height;
	
	public Guy(float xPos, float yPos, float width, float height) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	} // end constructor
	
	public void display (PApplet main) {
		main.stroke(10);
		main.fill(255,0,0);
		main.ellipse(xPos, yPos,  width,  height);
	} // end display

	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public float getyPos() {
		return yPos;
	}

	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	
	
} // end class Guy
