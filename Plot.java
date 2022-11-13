/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This is the plot class. It defines the properties of the plot class as well as constructors, getters, and setters.
 * Due: 11/06/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Daniel Xu
 */






public class Plot {




	// Instance Variables x, y, width, depth.
	private int x;
	private int y;
	private int width;
	private int depth;

	// Creates a default Plot with width and depth of 1.
	public Plot(){
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	// Creates a Plot using the given values.
	Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	// Creates a new plot given another plot.
	Plot(Plot otherPlot){
		this.x = otherPlot.x;
		this.y = otherPlot.x;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}



	// Set X
	public void setX(int x) {
		this.x = x;
	}

	// Set Y
	public void setY(int y) {
		this.y = y;
	}

	// Set Depth
	public void setDepth(int depth) {
		this.depth = depth;
	}

	// Set Width
	public void setWidth(int width) {
		this.width = width;
	}

	// Get X
	public int getX() {
		return x;
	}

	// Get Y
	public int getY() {
		return y;
	}

	// Get Depth
	public int getDepth() {
		return depth;
	}

	// Get Width
	public int getWidth() {
		return width;
	}





	// Takes a plot instance and determines if it is overlapped by the current plot. 
	public boolean overlaps(Plot plot){
		
		if(plot.getX() > this.getX() && plot.getY() < this.getY() + this.getDepth()) // test that top right of plot square is within instance square
			return true;
		if(this.getX() > plot.getX() && this.getY() < plot.getY() + plot.getDepth()) // test that top right of instance square is within plot square
			return true;

		if(plot.getY() > this.getY() && plot.getX() < this.getX() + this.getWidth()) // test that top left of plot square is within instance square
			return true;
		if(this.getY() > plot.getY() && this.getX() < plot.getX() + plot.getWidth()) // test that top left of instance square is within plot square
			return true;
		
			return false;


	}

	// Takes a plot instance and determines if the current plot encompasses it
	public boolean encompasses(Plot plot){

		boolean plotEncompasses = true;

		if ((plot.getX() >= this.getX() && plot.getY() >= this.getY()) // check top left
				&&
				((plot.getX() + plot.getWidth()) + plot.getDepth() <= this.getX() + this.getWidth() + this.getDepth())) // check bottom right
			plotEncompasses = false;

		return plotEncompasses;

	}

	// ToString method.
	public String toString() {
		String str = "[" + getX() + "],[" + getY() + "],[" + getWidth() + "],[" + getDepth() + "]";

		return str;
	}


// i want to die~




}
