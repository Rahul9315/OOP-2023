package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		board = LifeBoard(size; 1000,this);
		
	}

	
	
	public void draw()
	{	
		background(0);
		
		
	}
}
