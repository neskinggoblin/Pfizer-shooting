package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.libs.Animation;

public class Player extends GameObject implements EntityA{
	
	private double velX=0;
	private double velY=0;
	private int damage;
	Game game;
	Controller controller;
	Animation anim;	
	
	public Player(double x ,double y,Textures tex,Game game,Controller controller ) {
		
		super(x,y);
		this.game = game;
		this.controller = controller;		
		anim = new Animation(10,tex.player[0],tex.player[1],tex.player[2]);
	}
	
	public void tick() {
		x+=velX;
		y+=velY;
		
		if(x <= 0) 
			x=0;
		
		if(x >= 1000-60)
			x=1000-60;
		
		if(y <= 0)
			y=0;
		
		if(y >= 800-130)
			y=800-130;
		
		for(int i = 0; i < game.eb.size();i++ )
		{
			EntityB tempEnt = game.eb.get(i);
			
			if(Physics.Collision(this, tempEnt))
			{
				if( Game.HEALTH <=0)
				{
					Game.State = Game.STATE.DEAD;
					x = 500;
					y = 600;
				}				
				controller.removeEntity(tempEnt);
				Game.HEALTH -= damage;
				game.setEnemy_killed(game.getEnemy_killed() + 1);
				game.playSE(4);	
			}
		}
		anim.runAnimation();		
	}	
	
	public void render (Graphics g) {
		anim.drawAnimation(g, x, y, 0);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,50,50);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setVelX(double velX) {
		this.velX = velX;
	}
	
	public void setVelY(double velY) {
		this.velY = velY;
	}
	
	public void setDamage(char diff) {
		if(diff == 'e'){
			damage = 40;
		
		}else if(diff == 'h'){
			damage = 80;
		}
	}
}
