package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Player {

	private float posX;
	private float posY;
	private float width;
	private float height;
	private int lives;
	private int stars;
	private int speed;
	private boolean hurted;
	private PApplet app;
	private PImage playerImage;

	public Player(float posX, float posY, float width, float height, int speed, int lives, int stars, PImage image,
			PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.lives = lives;
		this.stars = stars;
		this.hurted = false;
		this.app = app;
		this.playerImage = image;
	}

	public void paint() {
		this.app.image(this.playerImage, this.posX, this.posY, this.width, this.height);
		if(this.hurted && app.frameCount%120 ==0) {
			this.hurted = false;
		}
	}

	public void moveUp() {
		this.posY -= speed;
	}

	public void moveDown() {
		this.posY += speed;
	}

	public void moveLeft() {
		this.posX -= speed;
	}

	public void moveRight() {
		this.posX += speed;
	}

	public void getDamage(int i) {
		if (!this.hurted) {
			this.lives -= i;
			this.hurted = true;
		}
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public boolean isHurted() {
		return hurted;
	}

	public void setHurted(boolean hurted) {
		this.hurted = hurted;
	}

}
