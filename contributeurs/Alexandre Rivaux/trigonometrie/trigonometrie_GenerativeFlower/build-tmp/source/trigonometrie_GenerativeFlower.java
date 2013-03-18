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

public class trigonometrie_GenerativeFlower extends PApplet {

//Cliquez pour lancer l'animation

float oX, oY, d; //cible et distance de la cible
float[] posX; //position des partciules
float[] posY; //position des partciules
int[] c; //couleurs des particules
float[] r; //rayon des particules sur le cercle trigonom\u00e9trique
float[] angle; //angle des particules sur le cercle trigonom\u00e9trique
float[] vr; //vitesse des particules
float colorRatio; //plage de couleur

boolean etat = false;//animation on/off
int nbParticules;//notre de point

float angleGlobal; //angle de rotation de notre skecth
float vAngle; //sens de la rotation

float count; //notre d\u00e9compte. Toute les 500 frame nous effacerons notre fleur pour en dessiner une nouvelle.


public void setup()
{
  size(500, 500);
  colorMode(HSB, 360, 100, 100, 100); // ici nous passons en mode colorim\u00e9trique Teinte Saturation Luminosit\u00e9. Ce qui nous pemrettra de d\u00e9finir plus aisement nos plages de couleur
  update();  //fonction initialisant nos valeurs
  background(0);
}

public void draw()
{

  pushMatrix();
  /*rotation de la fleur*/
  if (etat == false) //si nous activons la rotation de la fleur
  {

    angleGlobal += vAngle;
  }
  else if (etat == true) //sinon la fleur reste droite
  {
    angleGlobal = angleGlobal;
  }
  translate(oX, oY);
  rotate(radians(angleGlobal));

  /*calcul des nouvelles positions de notre fleur*/
  for (int i=1; i<nbParticules; i++) { 
    r[i] += vr[i]; // reduction du rayon

    if (r[i]>200 || r[i]<0) //limite de la fleur. Si une des particules atteint le centre alors nous re initinalisons un cycle \u00e0 l'aide de la fonction update();
    {
      update();
    }
    //position des partciules
    posX[i] = cos(angle[i])*r[i];
    posY[i] = sin(angle[i])*r[i];
    stroke(c[i], 5);
    noFill();
   //dessin de la fleur
    if (i != nbParticules-1)
    {
      line(posX[i], posY[i], posX[i+1], posY[i+1]);
    }
    else
    {
      line(posX[i], posY[i], posX[1], posY[1]);
    }
  }
  popMatrix();
  //decompte
  count++;
  if(count >= 1000)
  {
    count = 0;
    background(0);
  }
}

public void keyPressed()
{
  if (key == 'a')
  {
    etat = !etat;
  }
}

//interactivit\u00e9
public void mousePressed()
{
  background(0);
  update();
}

public void update()
{
  vAngle = random(-0.1f, 0.1f); //d\u00e9finition du sens de rotation du sketch 
  colorRatio = random(0, 300); //choix d'un plage de couleur entre 0 et 300\u00b0 - notre plage sera entre cette valeur et cette valeur+60
  nbParticules = 50; 
  oX = width/2;
  oY = width/2;
  posX = new float[nbParticules];
  posY = new float[nbParticules];
  r = new float[nbParticules];
  angle = new float[nbParticules];
  vr = new float[nbParticules];  
  c = new int[nbParticules];
  
  for (int i=1; i<nbParticules; i++) { 
    angle[i] = ((2*PI)/nbParticules)*i; //Ici nous divisons le cercle 2PI par le nombre de particule multiplier par i pour obtenir l'angle de chaque particule et les placer \u00e0 \u00e9quidistance les une des autres
    vr[i] = random(-0.5f, -0.1f); 
    r[i] = 200; //ici nos particules ont un rayon de d\u00e9part identique pour former notre cercle mais nous pouvons aussi le d\u00e9finir en random et obtenir un autre visuel random(150, 200);
    posX[i] = oX+cos(angle[i])*r[i]; //position x sur le cercle x = cos(angle)*rayon
    posY[i] = oY+sin(angle[i])*r[i]; //position y sur le cercle y = cos(angle)*rayon
    d = dist(posX[i], posY[i], oX, oY); //distance entre les particules et la cible
    c[i] = color(random(colorRatio, colorRatio+60),random(80, 100), random(80,100)); //d\u00e9finissions de la couleur
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "trigonometrie_GenerativeFlower" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
