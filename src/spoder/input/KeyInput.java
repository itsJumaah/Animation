// Jumaah, Bilal, 12232659, Assignment 2, 159.235
package spoder.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	
	private boolean[] keys;
	
	public boolean upArrow, downArrow, leftArrow, rightArrow, spaceKey;
	
	public KeyInput() {
		keys = new boolean[100]; //constructor
	}
//-------------------------------------------------------------------------
	public void update() {
		upArrow  	= keys[KeyEvent.VK_UP];  //key assignments 
		downArrow   = keys[KeyEvent.VK_DOWN];
		leftArrow   = keys[KeyEvent.VK_LEFT];
		rightArrow  = keys[KeyEvent.VK_RIGHT];
		spaceKey 	= keys[KeyEvent.VK_SPACE];
	}
//-------------------------------------------------------------------------
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true; //make the key boolean true when its pressed
	}
//-------------------------------------------------------------------------
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false; //make the key boolean false when its released
		
	}
//-------------------------------------------------------------------------
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
