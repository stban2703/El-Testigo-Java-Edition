package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemy {
	private float posX;
	private float posY;
	private float width;
	private float height;
	private String type;
	private int damage;
	private int directionX;
	private int directionY;
	private float speed;
	private boolean isChanged;
	private PImage enemyimage;
	private PApplet app;

	public Enemy(float posX, float posY, float width, float height, String type, int directionX, int directionY,
			float speed, int damage, boolean isChanged, PImage enemyimage, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.type = type;
		this.damage = damage;
		this.directionX = directionX;
		this.directionY = directionY;
		this.speed = speed;
		this.isChanged = isChanged;
		this.enemyimage = enemyimage;
		this.app = app;
	}

	public void paint() {
		//app.rect(this.posX, this.posY, this.width, this.height);
		
		switch(type) {
		case "death":
			app.image(this.enemyimage, this.posX, this.posY, this.width, this.height);
			break;
			
		case "apathy":
			app.image(this.enemyimage, this.posX + 15, this.posY - 6, this.width - 26, this.height + 4);
			break;
			
		case "forget":
			app.image(this.enemyimage, this.posX + 15, this.posY - 6, this.width - 24, this.height + 4);
			break;
			
		case "unkwon":
			app.image(this.enemyimage, this.posX + 15, this.posY - 6, this.width - 26, this.height + 4);
			break;
		}
		
	}

	public void changeDirection(String type) {
		switch (type) {
		case "top":
			this.directionX = 0;
			this.directionY = -1;
			break;

		case "bottom":
			this.directionX = 0;
			this.directionY = 1;
			break;

		case "left":
			this.directionX = -1;
			this.directionY = 0;
			break;

		case "right":
			this.directionX = 1;
			this.directionY = 0;
			break;
		}
	}

	public void moveX() {
		this.posX += speed * directionX;
	}

	public void moveY() {
		this.posY += speed * directionY;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isChanged() {
		return isChanged;
	}

	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

	public PImage getEnemyimage() {
		return enemyimage;
	}

	public void setEnemyimage(PImage enemyimage) {
		this.enemyimage = enemyimage;
	}

}
