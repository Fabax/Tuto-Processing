  import java.util.Random; //on importe la librairie Random
  float y; // notre variable pour la position y de l'objet 
  Random generateur; // notre generateur de random gaussien

  void setup(){
    background(0);
    size(500,300);
    generateur = new Random();
    smooth(8); // Pour rendre l'ellipse plus jolie :) 
  }

  void draw(){
    translate(width/2, height/2); // je repositionne le point 0,0 de mon sketch au centre de l'ecran
    y = (float)generateur.nextGaussian() * 10; // on génère un random entre 0 et 10
    ellipse(y, 0, 10, 10); // on dessine l'ellipse
}