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

public class exercice2 extends PApplet {

float widthRect = 0.0f;
float heightRect = 0.0f;

public void setup() {
	size(512, 512);	
	rectMode(CENTER);
}

public void draw() {
	background(0);

	widthRect = map(mouseX, 0, width, 0, width);
	heightRect = map(mouseY, 0, height, 0, height);
	rect(width/2, height/2, widthRect, heightRect);		
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "exercice2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
