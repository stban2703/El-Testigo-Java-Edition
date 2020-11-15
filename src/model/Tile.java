package model;

import processing.core.PApplet;

public class Tile {

	private float posX;
	private float posY;
	private float width;
	private float height;
	private int type;
	private PApplet app;

	public Tile(float posX, float posY, float width, float height, int type, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.type = type;
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

}
