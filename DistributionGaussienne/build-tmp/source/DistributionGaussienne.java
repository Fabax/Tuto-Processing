import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Random; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class DistributionGaussienne extends PApplet {

   //on importe la librairie Random
  float y; // notre variable pour la position y de l'objet 
  Random generateur; // notre generateur de random gaussien

  public void setup(){
    background(0);
    size(500,300);
    generateur = new Random();
    smooth(8); // Pour rendre l'ellipse plus jolie :) 
  }

  public void draw(){
    translate(width/2, height/2); // je repositionne le point 0,0 de mon sketch au centre de l'ecran
    y = (float)generateur.nextGaussian() * 10; // on g\u00e9n\u00e8re un random entre 0 et 10
    ellipse(y, 0, 10, 10); // on dessine l'ellipse
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "DistributionGaussienne" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
