float widthRect = 0.0;
float heightRect = 0.0;

void setup() {
	size(512, 512);	
	rectMode(CENTER);
}

void draw() {
	background(0);

	widthRect = map(mouseX, 0, width, 0, width);
	heightRect = map(mouseY, 0, height, 0, height);
	rect(width/2, height/2, widthRect, heightRect);		
}