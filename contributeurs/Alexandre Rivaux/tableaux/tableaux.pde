//Info: http://processingjs.org/reference
float[] x;
float[] y;
float[] taille1;
float[] taille2;
float[] vy;
int nbParticules;

void setup()
{
  size(772, 250, JAVA2D);
  nbParticules = 50;
  x = new float[nbParticules];
  y = new float[nbParticules];
  taille1 = new float[nbParticules];
  taille2 = new float[nbParticules];
  vy = new float[nbParticules];

  for (int i=0; i<nbParticules; i++)
  {
      x[i] = width/nbParticules*i;
      y[i] = height;
      taille1[i] = random(0, 5);
      taille2[i] = random(10, 20);
      vy[i] = random(0.2, 1);
   }
   background(255);
}

void draw()
{

  for (int i=0; i<nbParticules; i++)
  {
    float d = dist(mouseX, mouseY, x[i], y[i]);
    float c = map(d, 0, width, 0, 255);
    
    float taille = random(taille1[i], taille2[i]);

    x[i] += random(-1, 1);
    y[i] -= vy[i];
    
    if(y[i] == height)
    {
      vy[i] *= -1;
    }
    
    stroke(random(c));
    fill(255);

    ellipse(x[i], y[i], taille, taille);
  }
}

void mousePressed(){
  saveFrame("banner-772x250.png");
}