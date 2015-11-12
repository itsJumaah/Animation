// Jumaah, Bilal, 12232659, Assignment 2, 159.235
package spoder.sound;

import java.applet.*;

public class Sound {
	//this class was originally by Matthew Jemmett
	//https://www.youtube.com/watch?v=1eagJ2XVZZM
	private AudioClip clip;
	
	public static final Sound soundBG = new Sound("/sound/background.wav"); //loads the sound
	//this audio file was made by Zeke
	//https://soundcloud.com/ursidae-3/chernobyl-nintendo-2-2-a-bit-more-in-order
	
	public Sound(String filename) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(filename));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
//-------------------------------------------------------------------------
	public void play() {
		try {
			new Thread() {
				public void run() {
					clip.play();
				}
			}.start();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
