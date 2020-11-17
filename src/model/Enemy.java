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
	private PImage enemyimage;
	private PApplet app;
	
	public Enemy(float posX, float posY, float width, float height, String type, 
			int directionX, int directionY, float speed, int damage, PImage enemyimage, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.type = type;
		this.damage = damage;
		this.directionX = directionX;
		this.directionY = directionY;
		this.speed = speed;
		this.enemyimage = enemyimage;
		this.app = app;
	}
	
	public void paint() {
		app.image(this.enemyimage, this.posX, this.posY, this.width, this.height);
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
		this.directionX *= directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY *= directionY;
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

	public PImage getEnemyimage() {
		return enemyimage;
	}

	public void setEnemyimage(PImage enemyimage) {
		this.enemyimage = enemyimage;
	}
	
}
