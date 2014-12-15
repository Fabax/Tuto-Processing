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

public class exercice1 extends PApplet {

float rotation = 0.0f;
boolean debug = true;
float x, y; 

public void setup() {
	size(512, 512);	
}

public void draw() {

	x = map(mouseX, 0, width, 0, 255);
	y = map(mouseY, 0, height, 0, 255);
	background(x,y,125);

	if(debug){
		showInfos();
	}
}

public void showInfos(){
	text("x = "+mouseX, mouseX+15, mouseY);
	text("y = "+mouseY, mouseX+15, mouseY+15);
	text("color = ("+x+","+y+", 125)", mouseX+15, mouseY+30);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "exercice1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
