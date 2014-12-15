float rotation = 0.0;

void setup() {
	size(512, 512);	
	rectMode(CENTER);
}

void draw() {
	background(0);
	rotation = map(mouseX, 0, width, 0, 7);
	println("rotation: "+rotation);
	translate(width/2, height/2);
	rotate(rotation);
	fill(255);
	rect(0, 0, 100, 200);		
}