package model;

import processing.core.PApplet;

public class Tile {

	private float posX;
	private float posY;
	private float width;
	private float height;
	private int matX;
	private int matY;
	private int type;
	private boolean occupied;
	private PApplet app;

	public Tile(float posX, float posY, float width, float height, int type, boolean occupied, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.type = type;
		this.matX = 0;
		this.matY = 0;
		this.app = app;
	}

	public void paint() {
		if (this.type == 0) {
			app.fill(255);
		} else {
			app.fill(0);
		}

		app.rect(this.posX, this.posY, this.width, this.height);
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getMatX() {
		return matX;
	}

	public void setMatX(int matX) {
		this.matX = matX;
	}

	public int getMatY() {
		return matY;
	}

	public void setMatY(int matY) {
		this.matY = matY;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

}
