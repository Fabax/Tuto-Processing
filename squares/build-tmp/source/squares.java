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

public class squares extends PApplet {

int x1,x2,y1,y2,aleatoire,ecart,marge,taille; 
int h = 25; // Mettre un multiple de 3
int[] check = {0,1,2,3,4,5,6,7};
int[][] lines = { {0,0,h,h}, {h,0,0,h}, {h/2,0,h/2,h}, {0,h/2,h,h/2}, {0,h/2,h/2,0}, {0,h/2,h/2,h}, {h/2,0,h,h/2}, {h,h/2,h/2,h} }; 
boolean couleur = true;
public void setup(){
	smooth(); // pour que mes traits soient plus net
	aleatoire = 0; //
	marge = h/3; // l'espace entre les carr\u00e9s
	ecart = h+marge; // la place dans laquelle evelue un carr\u00e9
	taille = ((h+marge)*15 ); // la taille de mon carr\u00e9
	size(taille +marge , taille + marge, OPENGL); // notez que rajoute marge encore une fois afin dessiner la border droit et bas
}

public void draw(){
	background(255);
	translate(marge,marge);// je deplace le point initial de mon ecran pour creer une marge en haut et \u00e0 gauche
	stroke(0);
	strokeWeight(1); 

	// j'utilise une double bouble for pour plac\u00e9 chaque carr\u00e9s sur l'ecran. 
	// Ici je place 15 carr\u00e9s en long (i) et 15 en large (j)
	for (int i = 0; i <15; i++){
		for (int j = 0; j < 15; j++){
			//Je deplace le point 0,0 de mon ecran \u00e0 chaque tour de boucle. cela me permet de toujour utilser 0,0 comme point de reference.
			// pour ce faire je vais un translate encapsuluer dans un pushMatrix, popMatrix
			pushMatrix();
			translate(i*ecart, j*ecart);
			fill(255,255,255);

			//maintenant en fonction de l'emplacement de mon carr\u00e9 je dessine plus ou moins de trais \u00e0 l'interieur

			// carr\u00e9 est au centre
			if(j == 7 && i == 7){
				rect(0, 0, h, h);
			}

			//puis en partant du centre je m'attaque aux autres carr\u00e9s de maniere concentrique
			// carr\u00e9s qui sont 1 carr\u00e9s du centre
			else if(j>=6 && j<9 && i>=6 && i<9){
				generateSquare(1);
			}
			// carr\u00e9s qui sont 2 carr\u00e9s du centre
			else if(j>=5 && j<10 && i>=5 && i<10){
				generateSquare(2);
			}
			// carr\u00e9s qui sont 3 carr\u00e9s du centre
			else if(j>=4 && j<11 && i>=4 && i<11){
				generateSquare(3);
			}
			// carr\u00e9s qui sont 4 carr\u00e9 du centre
			else if(j>=3 && j<12 && i>=3 && i<12){
				generateSquare(4);
			}
			// carr\u00e9s qui sont 5 carr\u00e9 du centre
			else if(j>=2 && j<13 && i>=2 && i<13){
				generateSquare(5);
			}
			// carr\u00e9s qui sont 6 carr\u00e9 du centre
			else if(j>=1 && j<14 && i>=1 && i<14){
				generateSquare(6);
			}
			// carr\u00e9s qui sont 7 carr\u00e9 du centre
			else if(j>=0 && j<15 && i>=0 && i<15){
				generateSquare(7);
			}
			popMatrix();
		}	
		noLoop();
	}
	//decommenter pour enregistrer l'image produite
	//saveFrame("squareColor"+h+".jpg");
}

// fonction qui recoit un nombre de lignes en arguments
// Cette dessine les trais et fait aussi attention ne pas en dessiner les uns sur les autres
public void generateSquare(int numberOfLines) {
	if(couleur == true){fill(random(255), random(255), random(255), numberOfLines*20);} // petit plus pour mettre de la couleur 
	rect(0, 0, h, h);	
	strokeWeight(2);
	// nous avons un tableau initial allant de 0 \u00e0 7
	// on echange quelques valeurs 
	for (int i = 0; i<8; i++){
		int rand1 = PApplet.parseInt(random(8));
		int rand2 = PApplet.parseInt(random(8));
		int temp;

		temp = check[rand1];
		check[rand1] = 	check[rand2];
		check[rand2] = temp;
	}

	// puis on lit un nombre d'entr\u00e9es egale \u00e0 l'argument pass\u00e9
	for (int i = 0; i< numberOfLines; i++){

		aleatoire = check[i];
		line(lines[aleatoire][0], lines[aleatoire][1], lines[aleatoire][2], lines[aleatoire][3]);	
	}
}


// Ces deux fonctions sont des bonus 

public void keyPressed() {
if(key == 'c'){ 
	if(couleur == false){
		couleur = true;
	}else{
		couleur = false;
	}
  }
loop();
}

public void mousePressed(){
	loop();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "squares" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
