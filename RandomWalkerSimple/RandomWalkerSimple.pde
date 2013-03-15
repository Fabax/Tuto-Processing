// Auteur : Fabien Bonnamy
// Site web : tutoprocessing.com/random-walker
//Sketch d'apprentissage qui montre comment faire un random walker
// Un random walker est une particule qui se deplace de facon aléatoire sur l'ecran 

//On initialise toutes les variables
int positionx ,positiony, directionx, directiony, taille;

void setup(){
	background(255); // on donne un fond blanc
	size(500,300); // on choisi la taille du sketcj 
	smooth(); // on ameliore le rendu (en option)

	// on place notre future ellipse au centre de l'ectan
	positionx = width/2;
	positiony = height/2;
}

void draw(){
	//on choisi au hasard un mouvement pour x et y compris entre -1 et 1 
	directionx = int(random(-2, 2));
	directiony = int(random(-2, 2));

	// La nouvelle position de l'ellispe est egale a son ancienne position (x et y) + un int entre -1 et 1
	positiony = positiony + directiony;
	positionx = positionx + directionx;

	taille = int(random(2, 20)); // on change la taille de l'ellispe a chaque tour du draw pour rendre ca plus funky


	ellipse(positionx, positiony, taille, taille); // enfin on dessinne notre ellispse
}