package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput extends Game implements MouseListener,MouseMotionListener {

	Menu menu;
	public static int butState = 0;
	private static final long serialVersionUID = 1L;
	public static int skin;
	public Position mousePosition;
		
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	public void mousePressed(MouseEvent e) {
		mousePosition = new Position(e.getPoint().getX(), e.getPoint().getY());

		if(Game.State == Game.STATE.MENU )
		{
			//Play Button
			if(Menu.playButton.contains(mousePosition.intX(),mousePosition.intY()))
					//Pressed Play Button
					Game.State = Game.STATE.CHAR;		
		
			//Help Button
			if(Menu.helpButton.contains(mousePosition.intX(),mousePosition.intY()))
					//Pressed Help Button
					Game.State = Game.STATE.HELP;			
		
			//Quit Button
		    if(Menu.quitButton.contains(mousePosition.intX(),mousePosition.intY()))
					//Pressed Quit Button
					System.exit(1);			
		}
		
		else if(Game.State == STATE.CHAR)
		{
			//skin1
			if(Menu.skin1.contains(mousePosition.intX(),mousePosition.intY())) {
					skin=1;
					Game.State = Game.STATE.DIFF;
			}
		
			//skin2
			if(Menu.skin2.contains(mousePosition.intX(),mousePosition.intY())) { 
					skin=2;
					Game.State = Game.STATE.DIFF;
			}
			
			//skin3
			if(Menu.skin3.contains(mousePosition.intX(),mousePosition.intY())) { 
					skin=3;
					Game.State = Game.STATE.DIFF;
			}
			
			//Back Button
			if(Menu.backButton.contains(mousePosition.intX(),mousePosition.intY()))
					//Pressed Back Button
					Game.State = Game.STATE.MENU;		
		}
		
		else if(Game.State == Game.STATE.DIFF)
		{
			//Easy Button
			if(Menu.easyButton.contains(mousePosition.intX(),mousePosition.intY())) {
					//Pressed Easy Button
					Game.State = Game.STATE.GAME;
					Game.setDiffEasy();
			}
		
			//Hard Button
			if(Menu.hardButton.contains(mousePosition.intX(),mousePosition.intY())) {
					//Pressed Hard Button
					Game.State = Game.STATE.GAME;
					Game.setDiffHard();
			}
			
			//Back Button
			if(Menu.backButton.contains(mousePosition.intX(),mousePosition.intY()))
					//Pressed Back Button
					Game.State = Game.STATE.CHAR;
		}
		
		else if(Game.State == Game.STATE.DEAD || Game.State == Game.STATE.WIN || Game.State == Game.STATE.HELP)
		{
			//Back Button
			if(Menu.backButton.contains(mousePosition.intX(),mousePosition.intY()))
					//Pressed Back Button
					Game.State = Game.STATE.MENU;			
		}		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
	
	}

	public void mouseExited(MouseEvent e) {	
		
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		mousePosition = new Position(e.getPoint().getX(), e.getPoint().getY());
		if(Menu.playButton.contains(mousePosition.intX(),mousePosition.intY()))
			butState = 1;
		
		else if(Menu.helpButton.contains(mousePosition.intX(),mousePosition.intY()))
			butState = 2;
		
		else if(Menu.quitButton.contains(mousePosition.intX(),mousePosition.intY()))
			butState = 3;
		
		else if(Menu.easyButton.contains(mousePosition.intX(),mousePosition.intY()))
			butState = 4;
		
		else if(Menu.hardButton.contains(mousePosition.intX(),mousePosition.intY()))
			butState = 5;
		
		else if(Menu.backButton.contains(mousePosition.intX(),mousePosition.intY()))
			butState = 6;
		
		else
			butState = 0;
	}
}
