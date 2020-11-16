package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Star {
	private float posX;
	private float posY;
	private float width;
	private float height;
	private PApplet app;
	private PImage playerImage;
	
	public Star(float posX, float posY, float width, float height,  PImage playerImage, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.playerImage = playerImage;
		this.app = app;
	}
	
	public void paint() {
		this.app.image(this.playerImage, this.posX, this.posY, this.width, this.height);
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

	public PImage getPlayerImage() {
		return playerImage;
	}

	public void setPlayerImage(PImage playerImage) {
		this.playerImage = playerImage;
	}
	
	
}
