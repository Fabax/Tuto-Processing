int cols, rows, tileSize ;
int w, h; 
float r,g,b;
int posX, posY; 

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

			r = map(posX, 0, width, 0, 255);
			g = map(posY, 0, height, 0, 255);
			b = map(mouseX, 0, width, 0, 255); 

			fill(r,g,b);

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
