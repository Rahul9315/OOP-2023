package ie.tudublin;

import ddf.minim.ugens.Line;
import processing.core.PApplet;
import processing.opengl.PSurfaceJOGL.DrawListener;

public class Loops extends PApplet {

	int mode = 0;
	int screenSize= 900;
	int boxes = 10;

	public void settings() {
		size(screenSize, screenSize);
		//fullScreen(SPAN);
	}

	public void setup() {
		colorMode(HSB);
	}

	public void keyPressed() {

		mode = key - '0';
		println(mode);
	}

	float off = 0;

	public void draw() {
		background(255);
		fill(255);
		//noStroke();
		stroke(0);
		smooth();
		strokeWeight(2);
		
		//for loops:
		//Use a loop, rect and the HSB colour space:
		/* for (int i = 0; i < 1001; i= i + 100) {
			rect(i,0, 100 , 1000,60);
			fill((i + off) % 256, 255, 255);
		} */

		/*Use a loop, rect and the HSB colour space: 
		for (int i = 0; i < 1001; i= i + 100) {
			rect(i,i, 100 , 100);
			rect(900 - i,i, 100 , 100);
			fill((i + off) % 256, 255, 255);
		}
		*/

		/*Use a loop, ellipse, and the HSB colour space: 

		for (int i = 900; i >= 0; i = i - 50) {
			circle(450, 450, i );
			fill((i + off) % 256, 255, 255);	
		}
		*/

	/*			Try and draw this using ONE for loop. You will need the text and textAlign functions:


		background(255);
		stroke(0,150,0);
		textSize(25);
		fill(0, 408, 612);

		for (int i = 1; i < 12; i++) {
			line(69, 69*i, 759, i*69);
			line(69*i, 69, i*69, 759);
			text(i-6, 35, i*69 + 10);
			text(i-6, i*69-10,40);
		}
		
	*/
	/*
		float lineSpace = screenSize/boxes;

		background(255,255,255);
		fill(0,0,200);
		for (int i = 0; i < boxes/2; i++) {
			for (int j = 0; j < boxes/2; j++) {
				rect(i*2*lineSpace, j*2*lineSpace, lineSpace, lineSpace);
				rect((i*2*lineSpace) + lineSpace, (j*2*lineSpace)+lineSpace, lineSpace, lineSpace);
				
			}
			
		}*/
		
		float angle = (float) (180 * Math.PI / 180);
		line(screenSize/2, screenSize/2,(screenSize/2) + (float) (200*Math.sin(angle)), (screenSize/2)+(float) (200*Math.cos(angle)));

		/*switch (mode) {
			case 0:
				int numCircles = (int) max(1, mouseX / 50.0f);
				float d = width / numCircles;
				for (int j = 0; j < numCircles; j++) {
					for (int i = 0; i < numCircles; i++) {
						float x = (d * 0.5f) + (d * i);
						float y = (d * 0.5f) + (d * j);
						float c = ((i + j) / ((numCircles - 1) * 2.0f)) * 255.0f;
						fill((c + off) % 256, 255, 255);
						circle(x, y, d);
					}
				}
				off += (mouseY / 50.0f);
				break;
			case 1:
				break;
			default:
				break;
		}*/

	}
}
