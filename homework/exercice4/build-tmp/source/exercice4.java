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

public class exercice4 extends PApplet {

float acceleration = 0.0f;
float rotationSpeed = 0.1f; 

public void setup() {
	size(512, 512);	
	fill(255);
	rectMode(CENTER);
}

public void draw() {
	background(0);

	acceleration = map(mouseX, 0, width, -0.1f, 0.1f);
	rotationSpeed +=acceleration;

	translate(width/2, height/2);
	rotate(rotationSpeed);
	rect(0, 0, 100, 200);	
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "exercice4" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
