package view;

import view.Main;
import model.Logic;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private Logic logic;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		
	}
	
	public void settings() {
		size(1200, 700);
	}
	
	public void setup() {
		logic = new Logic(this);
		background(155);
		
		logic.setTiles();
	}
	
	public void draw() {
		logic.paintScreen();
	}

}
