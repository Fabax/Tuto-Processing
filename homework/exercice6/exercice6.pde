int cols, rows, tileSize ;
int w, h; 
int posX, posY; 
float d; 

void setup() {
	initGrid();
	size(w, h);
	noStroke();
}

void draw() {
	for (int i = 0; i < cols; i++) {
		for (int j = 0; j < rows; ++j) {

			posX = i*tileSize;
			posY = j*tileSize;

			d = dist(posX, posY, mouseX, mouseY);

			if(d < (tileSize/2)){
				fill(0);
			}else{
				fill(255);
			}

			rect(posX, posY, tileSize, tileSize);
		}
	}
}

void initGrid() {
	tileSize = 50; 
	cols = 10; 
	rows = 10; 
	w = cols * tileSize;
	h = w; 
}
