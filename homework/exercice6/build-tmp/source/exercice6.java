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

public class exercice6 extends PApplet {

int cols, rows, tileSize ;
int w, h; 
int posX, posY; 
float d; 

public void setup() {
	initGrid();
	size(w, h);
	noStroke();
}

public void draw() {
	for (int i = 0; i < cols; i++) {
		for (int j = 0; j < rows; ++j) {

			posX = i*tileSize;
			posY = j*tileSize;

			d = dist(posX, posY, mouseX, mouseY);

			if(d < (tileSize/2)){
				fill(0);
			}else{
				fill(255);
			}

			rect(posX, posY, tileSize, tileSize);
		}
	}
}

public void initGrid() {
	tileSize = 50; 
	cols = 10; 
	rows = 10; 
	w = cols * tileSize;
	h = w; 
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "exercice6" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
