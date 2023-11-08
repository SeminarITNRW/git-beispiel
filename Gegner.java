package Gameobjekt;

import java.awt.Rectangle;

public abstract class Gegner {
	public abstract void update();
	 public abstract void draw(Graphics g);
	 public abstract Rectangle getBound();
	 public abstract boolean isOutOfScreen();
	
}
