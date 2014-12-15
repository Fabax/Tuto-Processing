import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class exercice7 extends PApplet {

float angle, rayon ; 

int satX, satY; 
int tailleEllipse; 
float angle360; 

public void setup() {
	size(512, 512, P2D);
	background(255);
	tailleEllipse = 200;
	rayon = tailleEllipse/2; 
	angle = radians(angle360); 
	
	smooth(8);
	frameRate(30);
}

public void draw() {
	background(0);

	pushMatrix();
		translate(width/2, height/2);

		for (int i = 1; i <= 10; ++i) {

			satX = PApplet.parseInt((20*i) * sin(angle*i));
			satY = PApplet.parseInt((20*i) * cos(angle*i));

			fill(120,120,255);
			noStroke();
			ellipse(satX, satY, 20, 20);
		}
		
	popMatrix();
	angle360 += 1;
	angle = radians(angle360); 
	
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "exercice7" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
