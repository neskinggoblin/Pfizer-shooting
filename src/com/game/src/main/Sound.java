package com.game.src.main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	
	Clip clip;	
	URL soundURL[] = new URL[30];
	
	public Sound() {		
		soundURL[0] = getClass().getResource("/Music.wav");
		soundURL[1] = getClass().getResource("/Dead.wav");
		soundURL[2] = getClass().getResource("/Item_Health.wav");
		soundURL[3] = getClass().getResource("/Bullet.wav");
		soundURL[4] = getClass().getResource("/EnemyCollision.wav");
	}
	
	public void setFile(int i) {
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void play() {
		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(-18.0f);
		clip.start();
	}
	
	public void playItem() {
		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(-12.0f);
		clip.start();
	}
	
	public void playBullet() {
		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(-16.0f);
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
	

}
