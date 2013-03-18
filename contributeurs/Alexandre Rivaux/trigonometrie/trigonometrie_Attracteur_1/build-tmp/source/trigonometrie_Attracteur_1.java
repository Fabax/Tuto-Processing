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

public class trigonometrie_Attracteur_1 extends PApplet {

//Cliquez pour lancer l'animation
float posX, posY, oX, oY, d, angle, r, v;
boolean etat = true;


public void setup()
{
  size(500, 500);
  update();
}

public void draw()
{
  background(255);
  //calcul de l'angle
  angle = atan2(posY - oY, posX - oX);
  //deplacement de la balle
  if (etat == true)
  {
    r=d; //si nous n'activons pas l'attracteur le rayon est \u00e9gale \u00e0 la distance entre nos \u00e9l\u00e9ments
  }
  if (etat == false)
  {
    r+=v; //sinon notre rayon s'incr\u00e9mente de la vitesse (-1 donc n\u00e9gative)
  }

  if ( r<1 || r>d)
  {
    v = -v;//si nous atteignons les limite rayon ou 0 notre vitesse s'inverse. Nous attirons puis repoussons notre balle
  }

  //position de la balle
  posX = oX+cos(angle)*r;
  posY = oY+sin(angle)*r;

  //balle
  stroke(0);
  strokeWeight(5);
  point(posX, posY);
  strokeWeight(1); 
  stroke(255, 0, 0);
  line(posX, posY, oX, oY);
  ellipse(posX, posY, 15, 15);
  
  
  //cercle trigonom\u00e9trique
  stroke(0);
  point(oY, oY);
  strokeWeight(1);
  noFill();
  ellipse(oX, oY, d*2, d*2);
  fill(255);
  ellipse(oX, oY, 10, 10);
}

public void keyPressed()
{
  if (key == 'a')
  {
    update();
  }
}

public void mousePressed()
{
  etat = !etat;  
}

//fonction initialisant notre balle
public void update()
{
  oX = width/2;
  oY = width/2;
  posX = random(width);
  posY = random(height);
  d = dist(posX, posY, oX, oY);
  v = -1;
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "trigonometrie_Attracteur_1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
