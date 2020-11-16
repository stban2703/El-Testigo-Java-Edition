package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Logic {
	private PApplet app;

	private int rows = 11;
	private int colums = 22;
	private Tile tileArray[][] = new Tile[rows][colums];
	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	private float tilezeroX = 59;
	private float tilezeroY = 115;
	private float tileWidth = 49;
	private Player player;
	private PImage playerImage;
	boolean lefCollision = false;
	boolean RightCollision = false;
	boolean TopCollision = false;
	boolean BottomCollision = false;

	public Logic(PApplet app) {
		this.app = app;
	}

	// Set up
	public void setPlayer() {
		this.playerImage = app.loadImage("../img/player.png");
		this.player = new Player(410, 456, 32, 45, 7, 3, 0, this.playerImage, this.app);
	}

	public void setTiles() {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.colums; j++) {
				this.tileArray[i][j] = new Tile(this.tilezeroX + (this.tileWidth * j),
						this.tilezeroY + (this.tileWidth * i), this.tileWidth, this.tileWidth, 0, this.app);
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

		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.colums; j++) {
				this.tileList.add(tileArray[i][j]);
			}
		}

	}

	public void paintScreen() {
		for (int i = 0; i < this.tileList.size(); i++) {
			this.tileList.get(i).paint();
		}
		this.player.paint();
	}

	public void checkCollision() {

		float playerX = this.player.getPosX();
		float playerY = this.player.getPosY();
		float playerWidth = this.player.getWidth();
		float playerHeight = this.player.getHeight();

		for (int i = 0; i < this.tileList.size(); i++) {
			Tile tile = this.tileList.get(i);
			float tileX = this.tileList.get(i).getPosX();
			float tileY = this.tileList.get(i).getPosY();
			float tileWidth = this.tileList.get(i).getWidth();
			float tileHeight = this.tileList.get(i).getHeight();

			if (playerX + playerWidth > tileX && playerX < tileX + tileWidth && playerY + playerHeight > tileY
					&& playerY < tileY + tileHeight && tile.getType() == 0) {
				//System.out.println("xd");
			}

		}

	}

	public void keyEvents() {

		float playerX = this.player.getPosX();
		float playerY = this.player.getPosY();
		float playerWidth = this.player.getWidth();
		float playerHeight = this.player.getHeight();

		for (int i = 0; i < this.tileList.size(); i++) {
			Tile tile = this.tileList.get(i);
			float tileX = this.tileList.get(i).getPosX();
			float tileY = this.tileList.get(i).getPosY();
			float tileWidth = this.tileList.get(i).getWidth();
			float tileHeight = this.tileList.get(i).getHeight();

			if (app.keyCode == app.RIGHT) {
				if (playerX + playerWidth > tileX && tile.getType() == 0) {
					break;
				} else {
					this.player.moveRight();
					break;
				}
			}
			
			
			if (app.keyCode == app.LEFT) {
				if (playerX < tileX + tileWidth && tile.getType() == 0) {
					break;
				} else {
					this.player.moveLeft();
					break;
				}
			}
			
			

			/*
			 * if (playerX + playerWidth > tileX && playerX < tileX + tileWidth && playerY +
			 * playerHeight > tileY && playerY < tileY + tileHeight && tile.getType() == 1)
			 * { if (app.keyCode == app.DOWN) { this.player.moveDown(); }
			 * 
			 * if (app.keyCode == app.UP) { this.player.moveUp(); }
			 * 
			 * if (app.keyCode == app.LEFT) { this.player.moveLeft(); }
			 * 
			 * if (app.keyCode == app.RIGHT) { this.player.moveRight(); } }
			 */

		}

	}

}
