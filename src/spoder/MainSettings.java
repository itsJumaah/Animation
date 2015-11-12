// Jumaah, Bilal, 12232659, Assignment 2, 159.235
package spoder;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import spoder.graphics.Image;
import spoder.input.KeyInput;
import spoder.sound.Sound;


public class MainSettings implements Runnable { //implements runnable to use threads

	private Display display;
	private Thread thread;
	private BufferStrategy bufferSt;
	private Graphics graphics;
	private KeyInput keyInput;
	private SubSettings skeleton;
	private boolean running = false;
	
	public int width, height;
	public String title;

	public MainSettings(String title, int width, int height) {
		this.width = width;	//constructor
		this.height = height;
		this.title = title;
		
		keyInput = new KeyInput(); //key listner
	}
//-------------------------------------------------------------------------
	private void init() {
		display = new Display(title, width, height); //creating a new window display
		display.getWindow().addKeyListener(keyInput); //adds keylistener to it
		Image.init();  //initialize the image class
		
		skeleton = new SubSettings(this, (width - 64) / 2, 130, 64, 64); //makes a new settings
																		//skeleton centered the screen
																		//scaled to 64px squared
		Sound.soundBG.play();				//play sound background :D
	}
//-------------------------------------------------------------------------
	private void update() { //updates animations variables
		keyInput.update();		//updates key listener
		skeleton.update();		//updates the skeleton 
	}
//-------------------------------------------------------------------------
	private void render() { //updates the screen animations
		//some drawings settings
		bufferSt = display.getDisplay().getBufferStrategy();
		if(bufferSt == null) {
			display.getDisplay().createBufferStrategy(3);
			return;
		}
		graphics = bufferSt.getDrawGraphics();
		graphics.clearRect(0, 0, width, height); //clear the screen canvas
		
		skeleton.draw(graphics);		//all subsettings objects get drawn here

		bufferSt.show();
		graphics.dispose();
	}
//-------------------------------------------------------------------------
	public void run() {
		
		init();
		//ideas and some code was originally written by CodeNMore
		//https://www.youtube.com/watch?v=vFRuEgEdO9Q
		//https://www.youtube.com/watch?v=w1aB5gc38C8
		int fpsToggle = 60, fps = 0;
		double alpha = 0, timePerUpdate = 1000000000 / fpsToggle;
		long x, y = System.nanoTime(), timer = 0;
		
		while(running) { //the game loop starts here
			x = System.nanoTime(); 		//settings adjusts the frames per second (fps)
			alpha += (x - y) / timePerUpdate;	//so it doesnt go too fast
			timer += x - y;
			y = x;
			
			if(alpha >= 1) {
				update(); //updating variables every time the game loops go thru
				render(); //updating visuals every time the game loops go thru
				fps++;
				alpha--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS: " + fps); //prints the current fps of the screen to console
				fps = 0;
				timer = 0;
			}
		}
		stop(); //if the game isnt running stops
	}
//-------------------------------------------------------------------------
	public KeyInput getKeyInput() {
		return keyInput;		//getter for key input listner
	}
//-------------------------------------------------------------------------
	public synchronized void start() { 
		if(running == true) { 
			return; //if running exit this
		}
		running = true; //if not running do the rest and make a new thread
		thread = new Thread(this);
		thread.start();
	}
//-------------------------------------------------------------------------
	public synchronized void stop() {
		if(running == false) { 
			return; //if not running exit this
		}
		running = false; //if running stop it and wait for the thread to die
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
