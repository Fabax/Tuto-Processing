import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class apparitionAleatoire extends PApplet {

int count = 300;

public void setup() {
  size(500, 300, JAVA2D);
  background(0);
  smooth();
}

public void draw() {
  if (count < 0) {
    noLoop();
  }    
  else
  {
    count--;
    pattern();
  }
}


public void pattern() {
  float x1 = random(0, 300);
  float x2 = random(-200, 200);
  float y1 = random(0, 300);
  float y2 = random(-200, 200);
  int alpha = 100;

  int blueTri = PApplet.parseInt(random(0, 10));
  if (blueTri == 5) {
    stroke(255, 192, 0, alpha);
  }
  else {
    stroke(255, alpha);
    noFill();
  }

  pushMatrix();
  translate(random(width), random(height));
  line(x1, y1, x2, y2);
  strokeWeight(4);
  popMatrix();
  filter(BLUR, 1);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "apparitionAleatoire" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
