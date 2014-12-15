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

public class exercice3 extends PApplet {

float rotation = 0.0f;

public void setup() {
	size(512, 512);	
	rectMode(CENTER);
}

public void draw() {
	background(0);
	rotation = map(mouseX, 0, width, 0, 7);
	println("rotation: "+rotation);
	translate(width/2, height/2);
	rotate(rotation);
	fill(255);
	rect(0, 0, 100, 200);		
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "exercice3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
