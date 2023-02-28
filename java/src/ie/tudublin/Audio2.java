package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;
    FFT fft;

    public void settings(){
        size(1024,1024 , P3D);
    }

    public void setup(){
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        leapedbuffer = new float[width];
    }

    float leapedbuffer[];

    public void draw(){
        colorMode(HSB);
        background(0);
        stroke(255);
        float half = height/2;
        for (int i = 0; i < ab.size(); i++) {
            stroke(map(i, 0, ab.size(), 0, 255),255,255);
            leapedbuffer[i] = lerp(leapedbuffer[i], ab.get(i), 0.1f);
            Float f = abs(leapedbuffer[i] * half * 2.0f);
            line(i, half +f , i, half -f);
        }

        fft.forward(ab);
        stroke(255);

        int highestIndex = 0;
        for (int i = 0; i < fft.specSize()/2; i++) {
            line(i, height,i, height-fft.getBand(i) * 5.0f);

            if (fft.getBand(i) > fft.getBand(highestIndex)) {
                highestIndex = i;
            }
        }

        float freq = fft.indexToFreq(highestIndex);
        fill(255,255,255);
        text("Freq is ::  "+ freq, 500, 50);

        float y = map(freq, 1000.0f, 2500.0f, height, 0);
        circle(200, y, 60);

        //println(map(5, 0,10, 1000, 2000));
        //println(map1(5, 2, 10, 1000, 2000));

    }

    float map1(float a, float b ,float c, float d, float e){
        //it means a is in between range b to c,
        float range1 = c -b;
        float range2 = e -d;
        float howfar = a -b;

        return d + ((howfar / range1) * range2);
    }
    
}

