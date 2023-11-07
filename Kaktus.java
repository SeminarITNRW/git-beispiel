package Gameobjekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// Klasse angelegt und erbt die astrabkte Klasse Gegner
public class Kaktus extends Gegner{

	// Attribute Gesetzt
	public static final int Y_Land = 125;
	
	private int posX;
	private int width;
	private int height;
	
	private BufferedImage image;
	private Dino dino;
	
	private Rectangle rectBound;
	
	// Konstrukoren Gesetzt
	public Kaktus (Dino dino, int posX, int width, int height, BufferedImage image) {
		this.posX = posX;
		this.width = width;
		this.height = height;
		this.image = image;
		this.dino = dino;
		rectBound = new Rectangle ();		
	}
	
	// Geschwindigkeit auf die angezeigt Katenen anwenden
	public void update () {
		posX -= dino.getSpeedX ();
	}
	
	
	// katus wird auf das Jpanel gezeichnet
	public void draw (Graphics g) {
		g.drawImage(image, posX, Y_Land - image.getHeight (), null);
		g.setColor(Color.red);
	}
	
	
	// Rechteckausgabe, Kollisunsabfrage vierecke werden erstellt die bei Kollisun ein ergnisausführen
	public Rectangle getBound() {
		rectBound = new Rectangle ();
		rectBound.x = (int) posX + (image.getWidth() - width)/2;
		rectBound.y = Y_Land - image.getHeight() + (image.getHeight() -height)/2;
		rectBound.width = width;
		rectBound.height = height;
		return rectBound;
				
	}
	// Schaut ob, der Katus aus dem Bild raus is, bei true wird der Katus in der anderen Methode gelöscht
	@Override
	public boolean isOutOfScreen() {
		if(posX < -image.getWidth()) {
			return true;
		}
		return false;
	}
		
	
}
