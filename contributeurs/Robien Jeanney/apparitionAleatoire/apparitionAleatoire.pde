//Auteur : Robin Jeanney 
// Site : http://tutoprocessing.com

int count = 300;

void setup() {
  size(500, 300, JAVA2D);
  background(0);
  smooth();
}

void draw() {
  if (count < 0) {
    noLoop();
  }    
  else
  {
    count--;
    pattern();
  }
}


void pattern() {
  float x1 = random(0, 300);
  float x2 = random(-200, 200);
  float y1 = random(0, 300);
  float y2 = random(-200, 200);
  int alpha = 100;

  int blueTri = int(random(0, 10));
  if (blueTri == 5) {
    stroke(255, 192, 0, alpha);
  }
  else {
    stroke(255, alpha);
    noFill();
  }

  pushMatrix();
  translate(random(width), random(height));
  line(x1, y1, x2, y2);
  strokeWeight(4);
  popMatrix();
  filter(BLUR, 1);
}
