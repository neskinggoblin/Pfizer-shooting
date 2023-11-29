package com.game.src.main;

import java.awt.image.BufferedImage;

public class Textures extends MouseInput {

	private static final long serialVersionUID = 1L;
	public BufferedImage[] player = new BufferedImage[3];
	public BufferedImage[] missile = new BufferedImage[3];
	public BufferedImage[] enemy = new BufferedImage[3];
	public BufferedImage[] item = new BufferedImage[3];	
	private SpriteSheet ss;
	
	public Textures(Game game) {
		ss = new SpriteSheet(game.getSpriteSheet());		
		getTextures();		
	}
	
	private void getTextures() {
		enemy[0] = ss.grabImage(3,1,64,64);
		enemy[1] = ss.grabImage(3,2,64,64);
		enemy[2] = ss.grabImage(3,3,64,64);		
		item[0] = ss.grabImage(4,1,64,64);
		item[1] = ss.grabImage(4,2,64,64);
		item[2] = ss.grabImage(4,3,64,64);
		
		if(MouseInput.skin == 1) {
			player[0] = ss.grabImage(1,1,64,64);
			player[1] = ss.grabImage(1,2,64,64);
			player[2] = ss.grabImage(1,3,64,64);			
			missile[0] = ss.grabImage(2, 1, 64, 64);
			missile[1] = ss.grabImage(2, 2, 64, 64);
			missile[2] = ss.grabImage(2, 3, 64, 64);
		}
		
		if(MouseInput.skin == 2) {
			player[0] = ss.grabImage(7,1,64,64);
			player[1] = ss.grabImage(7,2,64,64);
			player[2] = ss.grabImage(7,3,64,64);			
			missile[0] = ss.grabImage(8, 1, 64, 64);
			missile[1] = ss.grabImage(8, 2, 64, 64);
			missile[2] = ss.grabImage(8, 3, 64, 64);
		}
		
		if (MouseInput.skin == 3) {
			player[0] = ss.grabImage(5,1,64,64);
			player[1] = ss.grabImage(5,2,64,64);
			player[2] = ss.grabImage(5,3,64,64);			
			missile[0] = ss.grabImage(6, 1, 64, 64);
			missile[1] = ss.grabImage(6, 2, 64, 64);
			missile[2] = ss.grabImage(6, 3, 64, 64);			
		}
	}

}
