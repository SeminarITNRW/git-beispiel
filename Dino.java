package Gameobjekt;
//CHANGED!
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;


import util.Animation;
import util.Resource;

public class Dino {

	public static final int Land_PosY = 80;
	public static final float GRAVITY = 0.4f;
	
	private static final int NORMAL_RUN = 0;
	private static final int JUMPING = 1;
	private static final int DOWN_Run = 2;
	private static final int DEATH = 3;
	
	private float posY;
	private float posX;
	private float speedX;
	private float speedY;
	private Rectangle rectBound;
	
	public int score = 0;
	
	private int state = NORMAL_RUN;
	
	//private Animation normalRunAnim;
	private BufferedImage jumping;
	//private Animation downRunAnim;
	private BufferedImage deathImage;
	private BufferedImage dinoimage;
	private BufferedImage downimage;
	
	public Dino() {
		posX = 50;
		posY= Land_PosY;
		rectBound = new Rectangle();
		dinoimage = Resource.getResourceImage("data/main-character1.png");
		downimage = Resource.getResourceImage("data/main-character5.png");
		deathImage = Resource.getResourceImage("data/main-character4.png");
		//normalRunAnim = new Animation(90);	
		//normalRunAnim.addA(Resource.getResourceImage("data/main-character1.png"));
	}
	
	public float getSpeedX() {
		  return speedX;
		 }
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	
	public void draw(Graphics g) {
		switch(state) {
		case NORMAL_RUN:
			g.drawImage(dinoimage, (int) posX, (int) posY, null);
			break;
		case JUMPING:
			g.drawImage(jumping, (int) posX, (int) (posY), null);
			break;
		case DOWN_Run:
			g.drawImage(downimage, (int) posX, (int) (posY + 20), null);
			break;
		case DEATH:
			g.drawImage(deathImage, (int) posX, (int) posY, null);
			break;
			
		}
	}
	 public void jump() {
		  if(posY >= Land_PosY) {
		   speedY = -7.5f;
		   posY += speedY;
		   state = JUMPING;
		  }
		 }
		 
	
	
	public void down(boolean isDown) {
		  if(state == JUMPING) {
		   return;
		  }
		  if(isDown) {
		   state = DOWN_Run;
		  } else {
		   state = NORMAL_RUN;
		  }
		 }
	
	
	
	
}
