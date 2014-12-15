float angle, rayon ; 

int satX, satY; 
int tailleEllipse; 
float angle360; 

void setup() {
	size(512, 512, P2D);
	background(255);
	tailleEllipse = 200;
	rayon = tailleEllipse/2; 
	angle = radians(angle360); 
	
	smooth(8);
	frameRate(30);
}

void draw() {
	background(0);

	pushMatrix();
		translate(width/2, height/2);

		for (int i = 1; i <= 10; ++i) {

			satX = int((20*i) * sin(angle*i));
			satY = int((20*i) * cos(angle*i));

			fill(120,120,255);
			noStroke();
			ellipse(satX, satY, 20, 20);
		}
		
	popMatrix();
	angle360 += 1;
	angle = radians(angle360); 
	
}