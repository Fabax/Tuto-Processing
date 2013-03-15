//Sketch d'apprentissage qui montre comment faire un random walker
// Un random walker est une particule qui se deplace de facon aléatoire sur l'ecran 

ArrayList<Walker> walkers = new ArrayList<Walker>(); // tableau qui contiendra de multiples walkers

void setup(){
	background(255);
	size(500,400);
	smooth();

	// On initialise notre tableau de random walker 
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

//une fonction qui permet de sauvegarder l'image affichée en jpg
void mousePressed(){
	saveFrame("randomwalker.jpg");
}

class Walker {
	//Variables locales à un object de type Walker
	int positionx = 0;
	int positiony = 0;
	int taille = 0;
	
	//Constructeur (fonction lancée automatiquement à l'initialisation de l'objet)
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
