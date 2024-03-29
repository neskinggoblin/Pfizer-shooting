package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.libs.Animation;

public class Enemy extends GameObject implements EntityB{
	
	Random r = new Random();
	private int speed = r.nextInt(3) + 1;
	private Game game;
	private Controller c;	
	Animation anim;
	
	public Enemy(double x , double y,Textures tex,Controller c,Game game) {
		super(x,y);
		this.c = c;
		this.game = game;
		
		anim = new Animation(10,tex.enemy[0],tex.enemy[1],tex.enemy[2]);
	}
	
	public void tick(){
		y += speed;
		
		if(y > (Game.HEIGHT * Game.SCALE)) {
			speed = r.nextInt(3) + 1;
			y = -10;
			x = r.nextInt(940);
		}
		
		for(int i = 0;i< game.ea.size();i++)
		{
			EntityA tempEnt = game.ea.get(i);
			
			if(Physics.Collision(this,tempEnt))
			{			
				c.removeEntity(tempEnt);
				c.removeEntity(this);
				
				game.setEnemy_killed(game.getEnemy_killed() + 1);
				game.setScore_killed();			
			}
		}		
		anim.runAnimation();
	}
	
	public void render(Graphics g) {
		anim.drawAnimation(g, x, y, 0);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,50,50);
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}
}
