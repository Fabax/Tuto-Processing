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

public class RandomWalker extends PApplet {

//Sketch d'apprentissage qui montre comment faire un random walker
// Un random walker est une particule qui se deplace de facon al\u00e9atoire sur l'ecran 

ArrayList<Walker> walkers = new ArrayList<Walker>(); // tableau qui contiendra de multiples walkers

public void setup(){
	background(255);
	size(500,400);
	smooth();

	// On initialise notre tableau de random walker 
	for (int i = 0; i<200; i++){
		walkers.add(new Walker());
	}
}

public void draw(){
	for (int i = walkers.size()-1; i >= 0; i--) { 
    Walker walker = (Walker) walkers.get(i);
    walker.deplacement();
    walker.affichage();
  }  
}

//une fonction qui permet de sauvegarder l'image affich\u00e9e en jpg
public void mousePressed(){
	saveFrame("randomwalker"+random(3000)+".jpg");
}

class Walker {
	//Variables locales \u00e0 un object de type Walker
	int positionx = 0;
	int positiony = 0;
	int taille = 0;

	//Constructeur (fonction lanc\u00e9e automatiquement \u00e0 l'initialisation de l'objet)
	Walker () {
		positionx = PApplet.parseInt(random(0, width));
		positiony = PApplet.parseInt(random(0, height));
		taille = PApplet.parseInt(random(2, 20));
			fill(0);
	}

	public void deplacement(){
		positiony = PApplet.parseInt(positiony + random(-1, 2));
		positionx = PApplet.parseInt(positionx + random(-1, 2));
	}

	public void affichage(){
		stroke(random(255),random(255),random(255),random(255));
		ellipse(positionx, positiony, taille, taille);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "RandomWalker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
