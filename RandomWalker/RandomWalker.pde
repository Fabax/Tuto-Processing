//Sketch d'apprentissage qui montre comment faire un random walker
// Un random walker est une particule qui se deplace de facon aléatoire sur l'ecran 
Walker walker; 
ArrayList<Walker> walkers = new ArrayList<Walker>();

void setup(){
	background(255);
	size(700,375);
	smooth();
	for (int i = 0; i<200; i++){
		walkers.add(new Walker());
	}
}

void draw(){
	for (int i = walkers.size()-1; i >= 0; i--) { 
    Walker walker = (Walker) walkers.get(i);
    walker.deplacement();
    walker.affichage();
  }  
}

void mousePressed(){
	saveFrame("randomwalker.jpg");
}

class Walker {
	int positionx = 0;
	int positiony = 0;
	int taille = 0;
	//--------------------------------------
	//  CONSTRUCTOR
	//--------------------------------------
	
	Walker () {
		positionx = int(random(0, width));
		positiony = int(random(0, height));
		taille = int(random(2, 20));
	}

	void deplacement(){
		positiony = int(positiony + random(-1, 2));
		positionx = int(positionx + random(-1, 2));
	}

	void affichage(){
		ellipse(positionx, positiony, taille, taille);
	}
}
