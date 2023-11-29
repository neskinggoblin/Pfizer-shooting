package com.game.src.main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;

public class Controller {
	private LinkedList<EntityA> ea =new LinkedList<EntityA>();
	private LinkedList<EntityB> eb =new LinkedList<EntityB>();
	private LinkedList<EntityC> ec =new LinkedList<EntityC>();
	
	EntityA enta;
	EntityB entb;
	EntityC entc;
	Textures tex;
	Random r = new Random();
	private Game game;
	
	public Controller(Textures tex,Game game) {
		this.tex = tex;
		this.game = game;
	}
	
	public void createEnemy(int enemy_count) {
		for(int i=0;i < enemy_count;i++) {
			addEntity(new Enemy(r.nextInt(800), -10,tex,this,game));			
		}
	}
	
	public void createItem(int item_count) {
		for(int i=0;i < item_count;i++) {
			addEntity(new Item(r.nextInt(800), -10,tex,this,game));			
		}
	}
		
	public void tick() {
		//A CLASS
		for(int i=0 ; i<ea.size() ; i++) {
			enta = ea.get(i);
			
			enta.tick();
		}
		//B CLASS
		for(int i=0 ; i<eb.size() ; i++) {
			entb = eb.get(i);
			
			entb.tick();
		}
		for(int i=0 ; i<ec.size() ; i++) {
			entc = ec.get(i);
			
			entc.tick();
		}
	}
	
	public void render(Graphics g) {
		//A CLASS
		for(int i=0 ; i<ea.size() ; i++) {
			enta = ea.get(i);
			
			enta.render(g);
		}
		//B CLASS
		for(int i=0 ; i<eb.size() ; i++) {
			entb = eb.get(i);
			
			entb.render(g);
		}
		for(int i=0 ; i<ec.size() ; i++) {
			entc = ec.get(i);
			
			entc.render(g);
		}	
	}
	
	public void addEntity (EntityA block) {
		ea.add(block);
	}
	
	public void removeEntity(EntityA block) {
		ea.remove(block);
	}
	
	public void addEntity (EntityB block) {
		eb.add(block);
	}
	
	public void removeEntity(EntityB block) {
		eb.remove(block);
	}
	
	public void addEntity (EntityC block) {
		ec.add(block);
	}
	
	public void removeEntity(EntityC block) {
		ec.remove(block);
	}
	
	public LinkedList<EntityA> getEntityA(){
		return ea;
	}
	
	public LinkedList<EntityB> getEntityB(){
		return eb;
	}
	
	public LinkedList<EntityC> getEntityC(){
		return ec;
	}		
}
