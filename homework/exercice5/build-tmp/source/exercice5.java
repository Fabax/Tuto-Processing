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

public class exercice5 extends PApplet {

int cols, rows, tileSize ;
int w, h; 
float r,g,b;
int posX, posY; 

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

			r = map(posX, 0, width, 0, 255);
			g = map(posY, 0, height, 0, 255);
			b = 120; 

			fill(r,g,b);

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
    String[] appletArgs = new String[] { "exercice5" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
