float rotation = 0.0;
boolean debug = true;
float x, y; 

void setup() {
	size(512, 512);	
}

void draw() {

	x = map(mouseX, 0, width, 0, 255);
	y = map(mouseY, 0, height, 0, 255);
	background(x,y,125);

	if(debug){
		showInfos();
	}
}

void showInfos(){
	text("x = "+mouseX, mouseX+15, mouseY);
	text("y = "+mouseY, mouseX+15, mouseY+15);
	text("color = ("+x+","+y+", 125)", mouseX+15, mouseY+30);
}