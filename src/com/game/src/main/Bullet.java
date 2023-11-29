package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityA;
import com.game.src.main.libs.Animation;

public class Bullet extends GameObject implements EntityA{

	Animation anim;
	
	public Bullet(double x,double y,Textures tex,Game game) {
		super(x,y);
		anim = new Animation(10,tex.missile[0],tex.missile[1],tex.missile[2]);
	}
	
	public void tick() {
		y -= 10;
		
		anim.runAnimation();
		
	}
	
	public void render(Graphics g) {
		anim.drawAnimation(g, x, y+70, 0);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,50,50);
	}
		
	public double getY() {
		return y;
	}
	
	public double getX() {
		return x;
	}
}
