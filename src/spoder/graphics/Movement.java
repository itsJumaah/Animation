// Jumaah, Bilal, 12232659, Assignment 2, 159.235
package spoder.graphics;

import java.awt.image.BufferedImage;

public class Movement {
	
	private int speed, i, num;
	private BufferedImage[] frames;
	private long t, x;
	
	public Movement(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames; //constructor and initilaizing
		i = 0;
		x = 0;
		num = 0;
		t = System.currentTimeMillis();
	}
//-------------------------------------------------------------------------
	public void update() { //update the variables via the game loop
		//clock written by CodeNMore
		//https://www.youtube.com/watch?v=uitt3vk-Xkk
		x += System.currentTimeMillis() - t;
		t = System.currentTimeMillis();

		if(x > speed){ //to control the animation speed
			num++; //counts frames number
			i++;
			x = 0;
			if(i >= frames.length) {
				i = 0;
			}
		}
	}
//-------------------------------------------------------------------------
	public BufferedImage getActionFrames() { //getter used for all actions
		return frames[i];
	}
//-------------------------------------------------------------------------
	public BufferedImage getAnkhFrames() { //getter used for death and respawn animation
		return frames[num];
	}
//-------------------------------------------------------------------------
	public int getFrameNum() { //getter used to get the animation frames number
		return num;
	}
//-------------------------------------------------------------------------
	public void setFrameNum(int num) { //setter for the animations frame number
		this.num = num;
	}
//-------------------------------------------------------------------------
	public BufferedImage getLastFrame() { //getter used to display if the skeleton is dead
		return frames[frames.length - 1];
	}
//-------------------------------------------------------------------------
	public BufferedImage getFirstFrame() { //getter used to display if the skeleton is underground
		return frames[0];
	}
}
