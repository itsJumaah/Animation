// Jumaah, Bilal, 12232659, Assignment 2, 159.235
package spoder;

import java.awt.Graphics;
import spoder.graphics.*;

public class SubSettings {
	
	private Movement aniSpawn, aniIdle, aniLeft, aniDie, aniAttack, aniFire1, aniFire2;
	private boolean dead = false, underground = true, idle = false, spawn = false, die = false;
	private MainSettings main;
	private float x, y;
	private int w, h;
	
	public SubSettings(MainSettings main, float x, float y, int w, int h) {
		this.x = x;
		this.y = y;	//constructor
		this.w = w;
		this.h = h;
		this.main = main;
		
		aniSpawn = new Movement (100, Image.skeleton_birth); //skeleton animations
		aniIdle = new Movement (100, Image.skeleton_idle);
		aniLeft = new Movement (100, Image.skeleton_walk);
		aniDie = new Movement (100, Image.skeleton_death);
		aniAttack = new Movement (100, Image.skeleton_attack);
		
		aniFire1 = new Movement (100, Image.fire); //fire camp animation
		aniFire2 = new Movement (100, Image.fire2);
	}
//-------variables updates for subsettings----------------------------------------
	public void update() {
		aniFire1.update(); //updates campfire vaiables
		aniFire2.update();
		
		respawnSettings(); //respawning and dying settings
		
		if(spawn && (dead || underground)) {
			aniSpawn.update(); //updating animations variables
		}
		
		else if(die && !dead && !underground) {
			aniDie.update();
		}
		
		else if (main.getKeyInput().spaceKey && !dead && !underground) {
			aniAttack.update();
		}
		
		else if(main.getKeyInput().leftArrow && !dead && !underground) {
			aniLeft.update();
			if(x!=65) { //this so he cant go beyond the fire
				x -= 1; //moves 1 px at the time
			}
		}
		else if(main.getKeyInput().rightArrow && !dead && !underground) {
			aniLeft.update();
			if(x!=575) { //same as above
				x += 1; //same as above
			}
		}
		else if (idle){
			aniIdle.update(); 
		}
	}
//-------------------------------------------------------------------------
	public void draw(Graphics graphics) {
		graphics.drawImage(Image.background, 0, 0, 700, 216, null);
		//background image
		graphics.drawImage(aniFire1.getActionFrames(), 30, 130, 64, 64, null);
		graphics.drawImage(aniFire2.getActionFrames(), 600, 130, 64, 64, null);
		//camp fire images
		drawSkeleton(graphics); //drawing the skeleton method called
	}
//-------------------------------------------------------------------------
	private void respawnSettings() {
		if(main.getKeyInput().upArrow == true) {
			spawn = true;
			die = false; //sets a boolean if the arrow key pressed
		}
		else if(main.getKeyInput().downArrow == true) {
			die = true;
			spawn = false;//same as above
		}

		if(aniDie.getFrameNum() == 7) { //death animation have 8 frames
			die = false; //sets the boolean back to false when the animation ends
			spawn = false;
			dead = true;
			underground = false;
			idle = false;
			aniDie.setFrameNum(0); //sets the frames number counter back to 0
			aniSpawn.setFrameNum(0);
		}
		if(aniSpawn.getFrameNum() == 9) { //spawning animation have 10 frames
			spawn = false;
			die = false; //same as above
			dead = false;
			underground = false;
			idle = true;
			aniDie.setFrameNum(0); //same as above
			aniSpawn.setFrameNum(0); 
		}
	}
//-------------------------------------------------------------------------
	private void drawSkeleton(Graphics graphics) {
		//when skeleton move to the right
		if(main.getKeyInput().rightArrow && !dead && !underground) {
			graphics.drawImage(aniLeft.getActionFrames(), (int) x + 50, (int) y, -w, h, null);
			//the 50 is the number of pixels the skeleton image get shifted when mirrored
		}
		//when skeleton move to the left
		else if (main.getKeyInput().leftArrow && !dead && !underground) {
			graphics.drawImage(aniLeft.getActionFrames(), (int) x, (int) y, w, h, null);
		}
		//when the skeleton move make attack animation
		else if (main.getKeyInput().spaceKey && !dead && !underground) {
			graphics.drawImage(aniAttack.getActionFrames(), (int) x, (int) y, w, h, null);
		}
		//when the skeleton die
		else if (die && !dead && !underground) {
			graphics.drawImage(aniDie.getAnkhFrames(), (int) x, (int) y, w, h, null);
		}
		//when the skeleton spawning
		else if (spawn && (dead || underground)) {
			graphics.drawImage(aniSpawn.getAnkhFrames(), (int) x, (int) y, w, h, null);
		}
		//when the skeleton is dead
		else if (dead) {
			graphics.drawImage(aniDie.getLastFrame(), (int) x, (int) y, w, h, null);
		}
		//when the skeleton is underground
		else if (underground) {
			graphics.drawImage(aniSpawn.getFirstFrame(), (int) x, (int) y, w, h, null);
		}
		//when the skeleton is idle
		else if (idle){
			graphics.drawImage(aniIdle.getActionFrames(), (int) x, (int) y, w, h, null);
		}
	}
}
