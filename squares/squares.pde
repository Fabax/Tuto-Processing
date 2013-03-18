int x1,x2,y1,y2,aleatoire,ecart,marge,taille; 
int h = 25; // Mettre un multiple de 3
int[] check = {0,1,2,3,4,5,6,7};
int[][] lines = { {0,0,h,h}, {h,0,0,h}, {h/2,0,h/2,h}, {0,h/2,h,h/2}, {0,h/2,h/2,0}, {0,h/2,h/2,h}, {h/2,0,h,h/2}, {h,h/2,h/2,h} }; 
boolean couleur = true;
void setup(){
	smooth(); // pour que mes traits soient plus net
	aleatoire = 0; //
	marge = h/3; // l'espace entre les carrés
	ecart = h+marge; // la place dans laquelle evelue un carré
	taille = ((h+marge)*15 ); // la taille de mon carré
	size(taille +marge , taille + marge, OPENGL); // notez que rajoute marge encore une fois afin dessiner la border droit et bas
}

void draw(){
	background(255);
	translate(marge,marge);// je deplace le point initial de mon ecran pour creer une marge en haut et à gauche
	stroke(0);
	strokeWeight(1); 

	// j'utilise une double bouble for pour placé chaque carrés sur l'ecran. 
	// Ici je place 15 carrés en long (i) et 15 en large (j)
	for (int i = 0; i <15; i++){
		for (int j = 0; j < 15; j++){
			//Je deplace le point 0,0 de mon ecran à chaque tour de boucle. cela me permet de toujour utilser 0,0 comme point de reference.
			// pour ce faire je vais un translate encapsuluer dans un pushMatrix, popMatrix
			pushMatrix();
			translate(i*ecart, j*ecart);
			fill(255,255,255);

			//maintenant en fonction de l'emplacement de mon carré je dessine plus ou moins de trais à l'interieur

			// carré est au centre
			if(j == 7 && i == 7){
				rect(0, 0, h, h);
			}

			//puis en partant du centre je m'attaque aux autres carrés de maniere concentrique
			// carrés qui sont 1 carrés du centre
			else if(j>=6 && j<9 && i>=6 && i<9){
				generateSquare(1);
			}
			// carrés qui sont 2 carrés du centre
			else if(j>=5 && j<10 && i>=5 && i<10){
				generateSquare(2);
			}
			// carrés qui sont 3 carrés du centre
			else if(j>=4 && j<11 && i>=4 && i<11){
				generateSquare(3);
			}
			// carrés qui sont 4 carré du centre
			else if(j>=3 && j<12 && i>=3 && i<12){
				generateSquare(4);
			}
			// carrés qui sont 5 carré du centre
			else if(j>=2 && j<13 && i>=2 && i<13){
				generateSquare(5);
			}
			// carrés qui sont 6 carré du centre
			else if(j>=1 && j<14 && i>=1 && i<14){
				generateSquare(6);
			}
			// carrés qui sont 7 carré du centre
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
void generateSquare(int numberOfLines) {
	if(couleur == true){fill(random(255), random(255), random(255), numberOfLines*20);} // petit plus pour mettre de la couleur 
	rect(0, 0, h, h);	
	strokeWeight(2);
	// nous avons un tableau initial allant de 0 à 7
	// on echange quelques valeurs 
	for (int i = 0; i<8; i++){
		int rand1 = int(random(8));
		int rand2 = int(random(8));
		int temp;

		temp = check[rand1];
		check[rand1] = 	check[rand2];
		check[rand2] = temp;
	}

	// puis on lit un nombre d'entrées egale à l'argument passé
	for (int i = 0; i< numberOfLines; i++){

		aleatoire = check[i];
		line(lines[aleatoire][0], lines[aleatoire][1], lines[aleatoire][2], lines[aleatoire][3]);	
	}
}


// Ces deux fonctions sont des bonus 

void keyPressed() {
if(key == 'c'){ 
	if(couleur == false){
		couleur = true;
	}else{
		couleur = false;
	}
  }
  if(key == 'n'){ 

  }
loop();
}

void mousePressed(){
	saveFrame("squares_tutoprocessing_"+int(random(1000))+".jpg");
}