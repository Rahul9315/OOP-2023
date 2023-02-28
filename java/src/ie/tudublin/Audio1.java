package ie.tudublin;


import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{

    Minim minim;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

	public void settings()
	{
		size(500, 500);
	}

	int frameSize = 1024;

	public void setup() {
		colorMode(HSB);
		background(0);

		minim = new Minim(this);

		ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
		ab = ai.mix;

		smooth();
		
	}

	
	
	public void draw()
	{	
		background(0);
		stroke(255);

		float half = height / 2;
		float cgap = 255 / (float)(ab.size());

		float ccgao = abs(ab.get(ARGB)/2);

		float total = 0;

		for (int i = 0; i < ab.size(); i++) {

			total += abs(ab.get(i));
			stroke(cgap*i,255,255);
			line(i, half, i , (half) + ab.get(i) * half);
		}
		float average = total / (float)ab.size();
		float r = average *200;
		fill(0,255,255);
		circle(100, total, r);
	}
}
