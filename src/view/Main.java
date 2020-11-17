package view;

import view.Main;

import java.util.ArrayList;

import model.Enemy;
import model.Player;
import model.Star;
import model.Tile;
import processing.core.PApplet;
import processing.core.PImage;
import processing.serial.Serial;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	Serial serial;

	private int screen;
	private int starsCount = 0;
	private int rows = 11;
	private int colums = 22;
	private Tile tileArray[][] = new Tile[rows][colums];
	private float tilezeroX = 59;
	private float tilezeroY = 115;
	private float tileWidth = 49;

	private Player player;
	private PImage playerImage;
	private int playerMatX = 7;
	private int playerMatY = 7;

	private ArrayList<Star> starList = new ArrayList<Star>();
	private PImage starImage;
	
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	
	private int deathMatX;
	private int deathMatY;

	private int apathyMatX;
	private int apathyMatY;

	private int forgetMatX;
	private int forgetMatY;

	private int unkwonMatX;
	private int unkwnMatY;

	
	private PImage deathImage;
	private PImage apathyImage;
	private PImage forgetImage;
	private PImage unkwonImage;
	
	private PImage gameplayImage;

	private PImage firstImage;
	private PImage secondImage;
	private PImage thirdImage;
	private PImage fourthImage;
	private PImage fifthImage;

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		background(155);

		screen = 0;
		starsCount = 0;

		String[] puertos = Serial.list();
		printArray(puertos);
		serial = new Serial(this, puertos[0], 9600);
		serial.bufferUntil('\n');

		this.playerImage = loadImage("../img/player.png");
		this.player = new Player(7 + tilezeroX + tileWidth * playerMatX, 3 + tilezeroY + tileWidth * playerMatY, 32, 45, 49,
				3, 0, this.playerImage, this);

		this.starImage = loadImage("../img/star.png");
		
		deathImage = loadImage("../img/muerte.png");
		apathyImage = loadImage("../img/apatia.png");
		forgetImage = loadImage("../img/olvido.png");
		unkwonImage = loadImage("../img/desconocimiento.png");
		
		deathMatX = 6;
		deathMatY = 0;

		apathyMatX = 7;
		apathyMatY = 7;

		forgetMatX = 7;
		forgetMatY = 7;

		unkwonMatX = 7;
		unkwnMatY = 7;
		
		this.enemyList.add(new Enemy(tilezeroX + tileWidth * deathMatX, tilezeroY + tileWidth * deathMatY, 49, 49, "death",
				1, 1, tileWidth, 3, deathImage, this));

		this.firstImage = loadImage("../img/pantalla01.jpg");
		this.secondImage = loadImage("../img/pantalla02.jpg");
		this.thirdImage = loadImage("../img/pantalla03.jpg");
		this.fourthImage = loadImage("../img/pantalla04.jpg");
		this.fifthImage = loadImage("../img/pantalla05.jpg");
		this.gameplayImage = loadImage("../img/mapa.jpg");

		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.colums; j++) {
				this.tileArray[i][j] = new Tile(this.tilezeroX + (this.tileWidth * j),
						this.tilezeroY + (this.tileWidth * i), this.tileWidth, this.tileWidth, 0, this);
			}
		}

		// row 0
		this.tileArray[0][6].setType(1);
		this.tileArray[0][7].setType(1);
		this.tileArray[0][8].setType(1);
		this.tileArray[0][9].setType(1);
		this.tileArray[0][10].setType(1);
		this.tileArray[0][11].setType(1);
		this.tileArray[0][12].setType(1);

		// row 1
		this.tileArray[1][3].setType(1);
		this.tileArray[1][4].setType(1);
		this.tileArray[1][5].setType(1);
		this.tileArray[1][6].setType(1);
		this.tileArray[1][12].setType(1);

		// row 2
		this.tileArray[2][3].setType(1);
		this.tileArray[2][12].setType(1);
		this.tileArray[2][13].setType(1);
		this.tileArray[2][14].setType(1);
		this.tileArray[2][15].setType(1);
		this.tileArray[2][16].setType(1);
		this.tileArray[2][17].setType(1);
		this.tileArray[2][18].setType(1);
		this.tileArray[2][19].setType(1);
		this.tileArray[2][20].setType(1);
		this.tileArray[2][21].setType(1);

		// row 3
		this.tileArray[3][3].setType(1);
		this.tileArray[3][12].setType(1);
		this.tileArray[3][18].setType(1);
		this.tileArray[3][21].setType(1);

		// row 4
		this.tileArray[4][0].setType(1);
		this.tileArray[4][1].setType(1);
		this.tileArray[4][2].setType(1);
		this.tileArray[4][3].setType(1);
		this.tileArray[4][12].setType(1);
		this.tileArray[4][18].setType(1);
		this.tileArray[4][21].setType(1);

		// row 5
		this.tileArray[5][0].setType(1);
		this.tileArray[5][7].setType(1);
		this.tileArray[5][8].setType(1);
		this.tileArray[5][9].setType(1);
		this.tileArray[5][10].setType(1);
		this.tileArray[5][11].setType(1);
		this.tileArray[5][12].setType(1);
		this.tileArray[5][18].setType(1);
		this.tileArray[5][19].setType(1);
		this.tileArray[5][20].setType(1);
		this.tileArray[5][21].setType(1);

		// row 6
		this.tileArray[6][0].setType(1);
		this.tileArray[6][7].setType(1);
		this.tileArray[6][12].setType(1);
		this.tileArray[6][21].setType(1);

		// row 7
		this.tileArray[7][0].setType(1);
		this.tileArray[7][7].setType(1);
		this.tileArray[7][12].setType(1);
		this.tileArray[7][13].setType(1);
		this.tileArray[7][14].setType(1);
		this.tileArray[7][15].setType(1);
		this.tileArray[7][16].setType(1);
		this.tileArray[7][17].setType(1);
		this.tileArray[7][21].setType(1);

		// row 8
		this.tileArray[8][0].setType(1);
		this.tileArray[8][1].setType(1);
		this.tileArray[8][2].setType(1);
		this.tileArray[8][3].setType(1);
		this.tileArray[8][4].setType(1);
		this.tileArray[8][5].setType(1);
		this.tileArray[8][6].setType(1);
		this.tileArray[8][7].setType(1);
		this.tileArray[8][8].setType(1);
		this.tileArray[8][9].setType(1);
		this.tileArray[8][10].setType(1);
		this.tileArray[8][11].setType(1);
		this.tileArray[8][12].setType(1);
		this.tileArray[8][17].setType(1);
		this.tileArray[8][18].setType(1);
		this.tileArray[8][19].setType(1);
		this.tileArray[8][20].setType(1);
		this.tileArray[8][21].setType(1);

		// row 9
		this.tileArray[9][4].setType(1);
		this.tileArray[9][12].setType(1);
		this.tileArray[9][17].setType(1);

		// row 10
		this.tileArray[10][4].setType(1);
		this.tileArray[10][5].setType(1);
		this.tileArray[10][6].setType(1);
		this.tileArray[10][7].setType(1);
		this.tileArray[10][8].setType(1);
		this.tileArray[10][9].setType(1);
		this.tileArray[10][10].setType(1);
		this.tileArray[10][11].setType(1);
		this.tileArray[10][12].setType(1);
		this.tileArray[10][13].setType(1);
		this.tileArray[10][14].setType(1);
		this.tileArray[10][15].setType(1);
		this.tileArray[10][16].setType(1);
		this.tileArray[10][17].setType(1);

	}

	public void draw() {

		switch (screen) {
		case 0:
			image(this.firstImage, 0, 0, 1200, 700);
			if(mouseX > 507 && mouseX < 507 + 186 && mouseY > 479 && mouseY < 479 + 52) {
				cursor(HAND);
			} else {
				cursor(ARROW);
			}
			break;

		case 1:
			image(this.secondImage, 0, 0, 1200, 700);
			if(mouseX > 907 && mouseX < 907 + 222 && mouseY > 571 && mouseY < 571 + 52) {
				cursor(HAND);
			} else {
				cursor(ARROW);
			}
			break;

		case 2:
			image(this.thirdImage, 0, 0, 1200, 700);
			if(mouseX > 907 && mouseX < 907 + 222 && mouseY > 571 && mouseY < 571 + 52) {
				cursor(HAND);
			} else {
				cursor(ARROW);
			}
			break;

		case 3:
			image(this.fourthImage, 0, 0, 1200, 700);
			if(mouseX > 907 && mouseX < 907 + 222 && mouseY > 571 && mouseY < 571 + 52) {
				cursor(HAND);
			} else {
				cursor(ARROW);
			}
			break;

		case 4:
			image(this.fifthImage, 0, 0, 1200, 700);
			if(mouseX > 600 && mouseX < 600 + 222 && mouseY > 582 && mouseY < 582 + 52) {
				cursor(HAND);
			} else {
				cursor(ARROW);
			}
			break;

		case 5:
			cursor(ARROW);
			
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.colums; j++) {
					this.tileArray[i][j].paint();
				}
			}

			image(this.gameplayImage, 0, 0, 1200, 700);
			fill(255);
			textSize(20);
			text(starsCount, 895, 45);

			this.player.paint();

			// Generate star
			if (frameCount % 40 == 0) {

				int randomRow = (int) Math.floor(random(11));
				int randomColum = (int) Math.floor(random(22));

				Tile tile = tileArray[randomRow][randomColum];

				if (tile.getType() == 1) {
					starList.add(new Star(tile.getPosX() + 9, tile.getPosY() + 9, 30, 30, this.starImage, this));
				}
			}
			
			
			// Paint star
			for (int i = 0; i < starList.size(); i++) {
				starList.get(i).paint();
			}

			float playerX = this.player.getPosX();
			float playerY = this.player.getPosY();
			float playerWidth = this.player.getWidth();
			float playerHeight = this.player.getHeight();

			// Get stars
			for (int i = 0; i < this.starList.size(); i++) {
				Star star = this.starList.get(i);
				float starX = star.getPosX();
				float starY = star.getPosY();

				if (starX > playerX && starX < playerX + playerWidth && starY > playerY
						&& starY < playerY + playerHeight) {
					starList.remove(i);
					serial.write("ledon\n");
					starsCount++;
				}

			}
			
			for (int i = 0; i < this.enemyList.size(); i++) {
				Enemy enemy = this.enemyList.get(i);
				enemy.paint();
			}	
			
			
			// Collision enemies
			for (int i = 0; i < this.enemyList.size(); i++) {
				Enemy enemy = this.enemyList.get(i);
				float enemyX = enemy.getPosX();
				float enemyY = enemy.getPosY();
				float enemyWidth = enemy.getWidth();
				float enemyHeight = enemy.getHeight();
				
				if (playerX >= enemyX && playerX < enemyX + enemyWidth && playerY > enemyY
						&& playerY < enemyY + enemyHeight) {
					System.out.println("Colision");
				}

			}
			break;

		default:
			break;
		}

	}

	public void mousePressed() {
		switch (screen) {
		case 0:
			if(mouseX > 507 && mouseX < 507 + 186 && mouseY > 479 && mouseY < 479 + 52) {
				screen = 1;
			}
			break;

		case 1:
			if(mouseX > 907 && mouseX < 907 + 222 && mouseY > 571 && mouseY < 571 + 52) {
				screen = 2;
			}
			break;

		case 2:
			if(mouseX > 907 && mouseX < 907 + 222 && mouseY > 571 && mouseY < 571 + 52) {
				screen = 3;
			}
			break;

		case 3:
			if(mouseX > 907 && mouseX < 907 + 222 && mouseY > 571 && mouseY < 571 + 52) {
				screen = 4;
			}
			break;

		case 4:
			if(mouseX > 600 && mouseX < 600 + 222 && mouseY > 582 && mouseY < 582 + 52) {
				screen = 5;
			}
			break;

		case 5:

			break;

		default:
			break;
		}
	}

	public void keyPressed() {

		switch (screen) {
		case 5:
			// logic.keyEvents();
			if (keyCode == UP) {
				// if we aren't in the top row and the cell above us doesn't contain an obstacle
				// then we can move up
				if (player.getPosY() > 115 && tileArray[playerMatY - 1][playerMatX].getType() != 0) {
					this.player.moveUp();
					playerMatY--;
				}
			} else if (keyCode == DOWN) {
				// if we aren't in the bottom row and the cell below us doesn't contain an
				// obstacle
				// then we can move down
				if (player.getPosY() < 115 + (490) && tileArray[playerMatY + 1][playerMatX].getType() != 0) {
					this.player.moveDown();
					playerMatY++;
				}
			} else if (keyCode == LEFT) {
				// if we aren't in the left-most column and the cell to our left doesn't contain
				// an obstacle
				// then we can move left
				if (player.getPosX() > 59 + 7 && tileArray[playerMatY][playerMatX - 1].getType() != 0) {
					this.player.moveLeft();
					playerMatX--;
				}
			} else if (keyCode == RIGHT) {
				// if we aren't in the right-most column and the cell to our right doesn't
				// contain an obstacle
				// then we can move right
				if (player.getPosX() < 59 + 1029 && tileArray[playerMatY][playerMatX + 1].getType() != 0) {
					this.player.moveRight();
					playerMatX++;
				}
			}
			break;
		}

	}

	public void serialEvent(Serial serial) {

		try {
			String mensajeRecibido = serial.readStringUntil('\n');
			if (mensajeRecibido != null) {
				mensajeRecibido = mensajeRecibido.trim();
				System.out.println(mensajeRecibido);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}
