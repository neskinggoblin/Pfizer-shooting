package com.game.src.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
    public static final int WIDTH = 500;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "Pfizer game";
    private boolean running = false;
    private Thread thread;
    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_BGR);
    private BufferedImage spriteSheet = null;
    private BufferedImage background= null;
    private BufferedImage Dead = null;
    private BufferedImage Menu = null;
    private BufferedImage Char = null;
    private BufferedImage Help = null;
    private BufferedImage Win = null;    
    private boolean is_shooting = false;    
    private int enemy_count = 3;
    private int item_count = 1;
    private int item_killed = 0;
    private int enemy_killed = 0;
    private int score_killed = 0;
    private static char diff;    
    private Player p;
    private Controller c;
    private Textures tex;
    private Menu menu;   
    public LinkedList<EntityA> ea;
    public LinkedList<EntityB> eb;
    public LinkedList<EntityC> ec;    
    public static int HEALTH = 100*2;
    public static enum STATE{
    	MENU,
    	GAME,
    	HELP,
    	DEAD,
    	WIN,
    	DIFF,
    	CHAR
    };
    public static STATE State = STATE.MENU;
    Sound sound = new Sound();
	private int Stage = 1;
	private int cen = 1;

    public void init() {
    	
    	tex = new Textures(this);
    	c = new Controller(tex,this);
    	p = new Player(500,600,tex,this,c);
    	menu = new Menu();    	
    	ea = c.getEntityA();
    	eb = c.getEntityB();
    	ec = c.getEntityC();    	
    	c.createEnemy(enemy_count);
    	c.createItem(item_count);
    }

    private synchronized void start() {
    	playMusic(0);
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public void run() {
    	BufferedImageLoader loader = new BufferedImageLoader();
    	
    	try {
    		spriteSheet = loader.loadImage("/sprite_sheet.png");   	
    		background = loader.loadImage("/background.png");
    	    Help = loader.loadImage("/Help.png");
    	    Dead = loader.loadImage("/Dead.png");
    	    Win= loader.loadImage("/Win.png");
    	    Menu = loader.loadImage("/Menu.png");
    	    Char =loader.loadImage("/Char.png");
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	this.addKeyListener(new KeyInput(this));
    	this.addMouseListener(new MouseInput());
    	this.addMouseMotionListener(new MouseInput());    	
    	init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Ticks, Fps"+ frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {        
    	if (HEALTH <=0) 
    		Game.State = Game.STATE.DEAD;
    	
    	if(State == STATE.GAME) {
    		p.tick();
    		c.tick();
    	}
    	
    	if(enemy_killed >= enemy_count)
    	{
    		cen++;
    		Stage++;
    		enemy_count += cen+1;
    		enemy_killed = 0;
    		c.createEnemy(enemy_count);
    	}
    
    	if(item_killed >=item_count)
    	{
    		item_count =1;
    		item_killed =0;
    		c.createItem(item_count);
    		
    		
    	}
    
    	if(State == STATE.DEAD || State == STATE.WIN)
    	{
    		item_count =1;
    		item_killed =0;
    		enemy_count = 3;
    		enemy_killed = 0;
    		c.createEnemy(enemy_count);
    		c.createItem(item_count);
    	}
    }
    
    private void render() {
        BufferStrategy bs =  this.getBufferStrategy();

        if(bs == null ) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();   
        /////////////////////////////////
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
        g.drawImage(Menu,0,0,null);
        
        if (HEALTH <=0) 
    		Game.State = Game.STATE.DEAD;
        
        if(State == STATE.GAME) {
        	p.setDamage(diff);
        	g.drawImage(background,0,0,null);
        	p.render(g);
        	c.render(g);    	
        	g.setColor(Color.gray);
        	g.fillRect(5, 5, 200, 50);        	
        	g.setColor(Color.green);
        	g.fillRect(5, 5, HEALTH, 50);        	
        	g.setColor(Color.white);
        	g.drawRect(5, 5, 200, 50);        	
        	Font fnt0 = new Font("arial",  Font.BOLD, 40);
    		g.setFont(fnt0);
    		g.setColor(Color.white);
    		g.drawString("Score:" + score_killed, (Game.WIDTH /2)+550, 50);
    		g.drawString("Stage " + Stage, (Game.WIDTH /2)+170, 50);
        	
        	if(score_killed == 150) {
        		Game.State = Game.STATE.WIN;
        		Stage = 1;
        	}
        	
        	if(HEALTH <=0) {
        		Game.State = Game.STATE.DEAD;
        		Stage = 1;
        	}
        	
        }else if(State == STATE.MENU ) {
        	tex = new Textures(this);
        	p = new Player(500,600,tex,this,c);
        	Stage = 1;
        	menu.renderMenu(g);
        	
        }else if(State == STATE.DIFF) {   
        	tex = new Textures(this);
        	p = new Player(500,600,tex,this,c);
        	Stage = 1;
        	menu.renderDiff(g);  
        	
        }else if(State == STATE.CHAR) {
        	tex = new Textures(this);
        	p = new Player(500,600,tex,this,c);
        	Stage = 1;
        	g.drawImage(Char,0,0,null);
        	
        	menu.renderBack(g);
        	
        }else if(State == STATE.HELP) {
        	tex = new Textures(this);
        	p = new Player(500,600,tex,this,c);
        	Stage = 1;
        	g.drawImage(Help,0,0,null);
        	menu.renderBack(g);
        	
        }else if(State == STATE.DEAD) {
        	g.drawImage(Dead,0,0,null);
        	menu.renderBack(g);
        	Font fnt0 = new Font("arial",  Font.BOLD, 50);
    		g.setFont(fnt0);
    		g.setColor(Color.white);
    		Stage = 1;
    		init();
    		score_killed = 0;
    		HEALTH = 100*2;
    		
        }else if(State == STATE.WIN) {
        	g.drawImage(Win,0,0,null);
        	menu.renderBack(g);
        	Font fnt0 = new Font("arial",  Font.BOLD, 50);
    		g.setFont(fnt0);
    		g.setColor(Color.white);
    		Stage = 1;
    		init();    		
    		score_killed = 0;
    		HEALTH = 100*2;
        }       
        /////////////////////////////        
        g.dispose();
        bs.show();       
    }
    
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
	
    	if(State == STATE.GAME) {
    		if(key == KeyEvent.VK_RIGHT) {
    			p.setVelX(5);
    			
    		}else if(key == KeyEvent.VK_LEFT) {
    			p.setVelX(-5);
    			
    		}else if(key == KeyEvent.VK_DOWN) {
    			p.setVelY(5);
    			
    		}else if(key == KeyEvent.VK_UP) {
    			p.setVelY(-5);
    			
    		}
    		if (key == KeyEvent.VK_SPACE  &&  ! is_shooting) {
    			is_shooting = true;
    			c.addEntity(new Bullet(p.getX(),p.getY(),tex,this));
    			playBull(3);
    		}
    	}
    }
    
    public void keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if(key == KeyEvent.VK_RIGHT) {
    		p.setVelX(0);
    		
    	}else if(key == KeyEvent.VK_LEFT) {
    		p.setVelX(0);
    		
    	}else if(key == KeyEvent.VK_DOWN) {
    		p.setVelY(0);
    		
    	}else if(key == KeyEvent.VK_UP) {
    		p.setVelY(0);
    		
    	}else if (key == KeyEvent.VK_SPACE ) {
    		is_shooting = false;
    	}	
    }
    
    public void playMusic(int i) {
    	sound.setFile(i);
    	sound.play();
    	sound.loop();
    }
    
    public void stopMusic() {
    	sound.stop();
    }
    
    public void playSE(int i) {
    	sound.setFile(i);
    	sound.playItem();
    }
    
    public void playBull(int i) {
    	sound.setFile(i);
    	sound.playBullet();
    }
    
    public static void setDiffEasy() {
    	diff = 'e';
    }
    
    public static void setDiffHard() {
    	diff = 'h';
    }
    
    public static void main(String args[]) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
        game.start();        
    }
    
    public BufferedImage getSpriteSheet() {
    	return spriteSheet;
    }
    
    public int getEnemy_count() {
    	return enemy_count;
    }
    
    public void setEnemy_count(int enemy_count) {
    	this.enemy_count = enemy_count;
    }
    
    public int getItem_count() {
    	return item_count;
    }
    
    public void setItem_count(int item_count) {
    	this.item_count = item_count;
    }
    
    public void setItem_killed(int item_killed) {
    	this.item_killed = item_killed+1;
    }
    
    public int getItem_killed() {
    	return item_killed;
    }
    
    public int getEnemy_killed() {
    	return enemy_killed;
    }
    
    public void setScore_killed() {
    	this.score_killed = score_killed + 1;
    }
    
    public void setEnemy_killed(int enemy_killed) {
    	this.enemy_killed = enemy_killed;
    }

	public boolean hasFocus(Rectangle button) {
		return false;
	}
}