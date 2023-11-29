package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu extends MouseInput {

	private static final long serialVersionUID = 1L;
	public static Rectangle playButton = new Rectangle((Game.WIDTH / 2)+150,200,200,50);
	public static Rectangle helpButton = new Rectangle((Game.WIDTH / 2)+150,350,200,50);
	public static Rectangle quitButton = new Rectangle((Game.WIDTH / 2)+150,500,200,50);
	public static Rectangle backButton = new Rectangle((Game.WIDTH / 2)-220,660,150,50);
	public static Rectangle easyButton = new Rectangle((Game.WIDTH / 2)+150,270,200,50);
	public static Rectangle hardButton = new Rectangle((Game.WIDTH / 2)+150,420,200,50);
	public static Rectangle skin1 = new Rectangle((Game.WIDTH / 2)-95,270,205,205);
	public static Rectangle skin2 = new Rectangle((Game.WIDTH / 2)+160,270,205,205);
	public static Rectangle skin3 = new Rectangle((Game.HEIGHT / 2)+465,270,205,205);	
	
    public void renderMenu(Graphics g) {
        
    	Graphics2D g2d = (Graphics2D) g;
		
		//Play		
		Font fnt1 = new Font("arial", Font.BOLD, 38);		
		g.setColor(Color.DARK_GRAY);
    	g.fillRect((Game.WIDTH / 2)+150,200,200,50);
		g.setFont(fnt1);
		g.setColor(Color.white);
		g.drawString("Play", playButton.x +60, playButton.y +35);
		g2d.draw(playButton);
		
		if(butState == 1)
		{
			g.setColor(Color.white);
	    	g.fillRect((Game.WIDTH / 2)+150,200,200,50);
			g.setColor(Color.red);
			g.drawString("Play", playButton.x +60, playButton.y +35);
			g2d.draw(playButton);
		}
		
		else if(butState == 0)
		{
			g.setColor(Color.DARK_GRAY);
	    	g.fillRect((Game.WIDTH / 2)+150,200,200,50);
			g.setColor(Color.white);
		    g.drawString("Play", playButton.x +60, playButton.y +35);
		    g2d.draw(playButton);
		}
		
		//Help		
		g.setFont(fnt1);
		g.setColor(Color.DARK_GRAY);
    	g.fillRect((Game.WIDTH / 2)+150,350,200,50);
		g.setColor(Color.white);
		g.drawString("Help", helpButton.x +60, helpButton.y +35);
		g2d.draw(helpButton);
		
		if(butState == 2)
		{
			g.setColor(Color.white);
	    	g.fillRect((Game.WIDTH / 2)+150,350,200,50);
			g.setColor(Color.green);
			g.drawString("Help", helpButton.x +60, helpButton.y +35);
			g2d.draw(helpButton);
		}
		
		else if(butState == 0)
		{
			g.setColor(Color.DARK_GRAY);
	    	g.fillRect((Game.WIDTH / 2)+150,350,200,50);
			g.setColor(Color.white);
		    g.drawString("Help", helpButton.x +60, helpButton.y +35);
		    g2d.draw(helpButton);
		}
		
		//Quit
		g.setFont(fnt1);
		g.setColor(Color.DARK_GRAY);
    	g.fillRect((Game.WIDTH / 2)+150,500,200,50);
		g.setColor(Color.white);
		g.drawString("Quit", quitButton.x +60, quitButton.y +35);
		g2d.draw(quitButton);
		
		if(butState == 3)
		{
			g.setColor(Color.white);
	    	g.fillRect((Game.WIDTH / 2)+150,500,200,50);
			g.setColor(Color.blue);
			g.drawString("Quit", quitButton.x +60, quitButton.y +35);
			g2d.draw(quitButton);
		}
		
		else if(butState == 0)
		{
			g.setColor(Color.DARK_GRAY);
	    	g.fillRect((Game.WIDTH / 2)+150,500,200,50);
			g.setColor(Color.white);
		    g.drawString("Quit", quitButton.x +60, quitButton.y +35);
		    g2d.draw(quitButton);
		}		     
	}
    
    public void renderDiff(Graphics g) {
    	
    	Graphics2D g2d = (Graphics2D) g;
    	
    	//Easy    	
		Font fnt2 = new Font("arial",  Font.BOLD, 30);		
		g.setFont(fnt2);
		g.setColor(Color.DARK_GRAY);
    	g.fillRect((Game.WIDTH / 2)+150,270,200,50);
		g.setColor(Color.white);
		g.drawString("Easy", easyButton.x +60, easyButton.y +35);
		g2d.draw(easyButton);
		
		if(butState == 4)
		{
			g.setColor(Color.white);
	    	g.fillRect((Game.WIDTH / 2)+150,270,200,50);
			g.setColor(Color.blue);
			g.drawString("Easy", easyButton.x +60, easyButton.y +35);
			g2d.draw(easyButton);
		}
		
		else if(butState == 0)
		{
			g.setColor(Color.DARK_GRAY);
	    	g.fillRect((Game.WIDTH / 2)+150,270,200,50);
			g.setColor(Color.white);
		    g.drawString("Easy", easyButton.x +60, easyButton.y +35);
		    g2d.draw(easyButton);
		}
		
		// Hard		
		g.setFont(fnt2);
		g.setColor(Color.DARK_GRAY);
    	g.fillRect((Game.WIDTH / 2)+150,420,200,50);
		g.setColor(Color.white);
		g.drawString("Hard", hardButton.x +60, hardButton.y +35);
		g2d.draw(hardButton);
		
		if(butState == 5)
		{
			g.setColor(Color.white);
	    	g.fillRect((Game.WIDTH / 2)+150,420,200,50);
			g.setColor(Color.green);
			g.drawString("Hard", hardButton.x +60, hardButton.y +35);
			g2d.draw(hardButton);
		}
		
		else if(butState == 0)
		{
			g.setColor(Color.DARK_GRAY);
	    	g.fillRect((Game.WIDTH / 2)+150,420,200,50);
			g.setColor(Color.white);
		    g.drawString("Hard", hardButton.x +60, hardButton.y +35);
		    g2d.draw(hardButton);
		}
		
		//Back		
		g.setFont(fnt2);
		g.setColor(Color.DARK_GRAY);
    	g.fillRect((Game.WIDTH / 2)-220,660,150,50);
		g.setColor(Color.white);
		g.drawString("Back", backButton.x +40, backButton.y +35);
		g2d.draw(backButton);
		
		if(butState == 6)
		{
			g.setColor(Color.white);
	    	g.fillRect((Game.WIDTH / 2)-220,660,150,50);
			g.setColor(Color.red);
			g.drawString("Back", backButton.x +40, backButton.y +35);
			g2d.draw(backButton);
		}
		
		else if(butState == 0)
		{
			g.setColor(Color.DARK_GRAY);
	    	g.fillRect((Game.WIDTH / 2)-220,660,150,50);
			g.setColor(Color.white);
		    g.drawString("Back", backButton.x +40, backButton.y +35);
		    g2d.draw(backButton);
		}		
    }

	public void renderBack(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;		
		Font fnt3 = new Font("arial",  Font.BOLD, 30);
		//Back
		g.setFont(fnt3);
		g.setColor(Color.DARK_GRAY);
    	g.fillRect((Game.WIDTH / 2)-220,660,150,50);
		g.setColor(Color.white);
		g.drawString("Back", backButton.x +40, backButton.y +35);
		g2d.draw(backButton);
		
		if(butState == 6)
		{
			g.setColor(Color.white);
	    	g.fillRect((Game.WIDTH / 2)-220,660,150,50);
			g.setColor(Color.red);
			g.drawString("Back", backButton.x +40, backButton.y +35);
			g2d.draw(backButton);
		}
		
		else if(butState == 0)
		{
			g.setColor(Color.DARK_GRAY);
	    	g.fillRect((Game.WIDTH / 2)-220,660,150,50);
			g.setColor(Color.white);
		    g.drawString("Back", backButton.x +40, backButton.y +35);
		    g2d.draw(backButton);
		}
	}
}
