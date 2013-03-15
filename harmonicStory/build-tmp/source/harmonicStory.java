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

public class harmonicStory extends PApplet {

/* 
Part of the ReCode Project (http://recodeproject.com)
Based on "Harmonic Story" by Jean Claude Marquette
Originally published in "Computer Graphics and Art" v1n2, 1976
Copyright (c) 2013 Alexandre Rivaux - OSI/MIT license (http://recodeproject/license).
*/

/* @pjs pauseOnBlur="true"; */

Pattern[] myPattern;
int nbPattern;

public void setup() 
{
  size( 500, 500, JAVA2D);
  smooth();
  background(140);
  rotate(radians(-1)); //rotation de -0.01 radian pour etre cal\u00e9 avec la cr\u00e9ation originale
  nbPattern = 2;
  myPattern = new Pattern[nbPattern];
  for(int i=0; i<nbPattern; i++)
  {
    myPattern[i] = new Pattern(i);
    myPattern[i].display();
  }
  
}

public void draw() 
{

}

public void mousePressed() 
{
  rotate(radians(-1)); //rotation de -0.01 radian pour etre cal\u00e9 avec la cr\u00e9ation originale
  background(140);
  for(Pattern p : myPattern)
  {
   p.update();
  }
}

/*Class Pattern*/

class Pattern
{
  /*
  l'id\u00e9e ici est de dessiner une grille de 270*2
   compos\u00e9e de carr\u00e9s de 18 pixels de cot\u00e9s. (donc double boucle for)
   
   par la suite chaque couleur du carr\u00e9 sera d\u00e9finie de mani\u00e8re al\u00e9atoire
   et en binaire. Pour chacun des carr\u00e9s nous attribuons une valeur enti\u00e8re
   random comprise entre 0 et 1.
   
   Si cette valeur est \u00e9gales \u00e0 1 alors nous remplirons notre carr\u00e9 
   avec la couleurs de fond grise.
   Si elle est \u00e9gales \u00e0 0 nous n'appliquerons pas de couleur de fond.
   
   Enfin nous dessinons nos rectangles.
   
   Au clic de la souris nous regenerons le visuel.
   */
  //variables
  int widthPattern;
  int heightPattern;
  int tailleRect; 
  int greyLevel;

  float[] x;
  float[] y;
  
  float posX;
  float posY;
  
  int range;
  
  //constructor
  Pattern(int _greyLevel)
  {
    this.heightPattern = 270;
    this.widthPattern = 270;
    this.tailleRect = 18;
    this.range=0;
    this.greyLevel = PApplet.parseInt(map(_greyLevel, 0, 1, 200, 44));
    
    this.x = new float[this.widthPattern/this.tailleRect];
    this.y = new float[this.heightPattern/this.tailleRect];
    
    for(int i = 0; i< this.widthPattern/this.tailleRect; i++)
    {
      this.x[i] = i*this.tailleRect;
    }
    
    for(int j = 0; j< this.heightPattern/this.tailleRect; j++)
    {
      this.y[j] = j*this.tailleRect;
    }
    
    this.posX = this.x[PApplet.parseInt(random(1, this.x.length-2))];
    this.posY = this.y[PApplet.parseInt(random(1, this.y.length-2))];
    
  }
  //function display
  public void display()
  {
    pushMatrix();
    translate(this.posX, this.posY);
    for (int i = 0; i< this.widthPattern/this.tailleRect; i++) {
      for ( int j = 0; j < this.heightPattern/this.tailleRect; j++ ) {
        this.range = (int)(random(0, 2));
        noStroke();
        if ( this.range == 1) {
          fill(this.greyLevel);
        } 
        else {
          noFill();
        }
        
        /*marge internes*/
        if(this.greyLevel==200)
        {
          if(i<2)
          {
            fill(this.greyLevel);
          }
          if(i==2)
          {
            noFill();
          }
        }
        if(this.greyLevel==44)
        {
          if(i>this.x.length-3)
          {
            fill(this.greyLevel);
          }
          if(i==this.x.length-3)
          {
            noFill();
          }
        }
        rect( i*tailleRect, j*tailleRect, tailleRect+1, tailleRect+1 );
        /*
        Ici pour \u00e9viter l'impression de bordure pour chacun des carr\u00e9s du \u00e0 la rotation.
         nous faisons des carr\u00e9s plus grand de 1 pixel que la grille de sorte \u00e0 ce qu'il
         d\u00e9bordent les un sur les autres.
         */
      }
    }
    popMatrix();
  }

  //update function
  public void update()
  {
    this.posX = this.x[PApplet.parseInt(random(1, this.x.length-2))];
    this.posY = this.y[PApplet.parseInt(random(1, this.y.length-2))];
    display();
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "harmonicStory" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
