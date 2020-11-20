package model;

import processing.core.PApplet;

public class Path {
	private float posX;
	private float posY;
	private float width;
	private float height;
	private String type;
	private PApplet app;

	public Path(float posX, float posY, float width, float height, String type, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.type = type;
		this.app = app;
	}

	public void paint() {
		app.ellipseMode(app.CORNER);
		app.fill(255);
		app.ellipse(this.posX, this.posY, this.width, this.height);
	}

	public String randomDirection() {
		String[] directions = type.split(",");

		int random = (int) (Math.random() * directions.length);
		
		return directions[random];
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

}
