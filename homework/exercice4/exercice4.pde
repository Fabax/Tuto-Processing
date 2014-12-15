float acceleration = 0.0;
float rotationSpeed = 0.1; 

void setup() {
	size(512, 512);	
	fill(255);
	rectMode(CENTER);
}

void draw() {
	background(0);

	acceleration = map(mouseX, 0, width, -0.1, 0.1);
	rotationSpeed +=acceleration;

	translate(width/2, height/2);
	rotate(rotationSpeed);
	rect(0, 0, 100, 200);	
}