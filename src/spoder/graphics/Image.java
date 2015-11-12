// Jumaah, Bilal, 12232659, Assignment 2, 159.235
package spoder.graphics;

import java.awt.image.BufferedImage;

public class Image {
	private static final int width = 256, height = 256;
	private static final int w = 64, h = 64;

	public static BufferedImage background;
	public static BufferedImage[] skeleton_birth, skeleton_idle, skeleton_walk, skeleton_death, skeleton_attack, fire, fire2;

	public static void init() { //initialize function
		//loads a new sprite sheet for the skeleton
		//COPYRIGHTS to Irina Mir via OpenGameArt.org and Arno Leist
		SpriteSheet skeletonSheet= new SpriteSheet(SpriteSheet.load("/character/skull.png"));
		//loads the campfire sprite sheets
		//fire camps COPYRIGHT to http://opengameart.org/content/camp-fire-animation-for-rpgs-finished
		SpriteSheet fireSheet = new SpriteSheet(SpriteSheet.load("/world/fire.png"));
		SpriteSheet fire2Sheet = new SpriteSheet(SpriteSheet.load("/world/fire2.png")); 
		//loads the background image
		//Background COPYRIGHT to Mortal Kombat maps creator :P
		SpriteSheet bgSheet = new SpriteSheet(SpriteSheet.load("/world/background.png"));
		//-------------------------------------------------------------------------
		background = bgSheet.singleImg(0, 0, 700, 216); 
		//-------------------------------------------------------------------------
		skeleton_birth = new BufferedImage[10]; //loads in the spawning frames to the array
		skeleton_birth[0] = skeletonSheet.singleImg(width * 0, height * 0, width, height);
		skeleton_birth[1] = skeletonSheet.singleImg(width * 1, height * 0, width, height);
		skeleton_birth[2] = skeletonSheet.singleImg(width * 2, height * 0, width, height);
		skeleton_birth[3] = skeletonSheet.singleImg(width * 3, height * 0, width, height);
		skeleton_birth[4] = skeletonSheet.singleImg(width * 4, height * 0, width, height);
		skeleton_birth[5] = skeletonSheet.singleImg(width * 5, height * 0, width, height);
		skeleton_birth[6] = skeletonSheet.singleImg(width * 6, height * 0, width, height);
		skeleton_birth[7] = skeletonSheet.singleImg(width * 7, height * 0, width, height);
		skeleton_birth[8] = skeletonSheet.singleImg(width * 8, height * 0, width, height);
		skeleton_birth[9] = skeletonSheet.singleImg(width * 9, height * 0, width, height);
		//-------------------------------------------------------------------------
		skeleton_idle = new BufferedImage[6]; //loads in idle frames
		skeleton_idle[0] = skeletonSheet.singleImg(width * 0, height * 1, width, height);
		skeleton_idle[1] = skeletonSheet.singleImg(width * 1, height * 1, width, height);
		skeleton_idle[2] = skeletonSheet.singleImg(width * 2, height * 1, width, height);
		skeleton_idle[3] = skeletonSheet.singleImg(width * 3, height * 1, width, height);
		skeleton_idle[4] = skeletonSheet.singleImg(width * 4, height * 1, width, height);
		skeleton_idle[5] = skeletonSheet.singleImg(width * 5, height * 1, width, height);
		//-------------------------------------------------------------------------
		skeleton_walk = new BufferedImage[8]; // loads in walking frames
		skeleton_walk[0] = skeletonSheet.singleImg(width * 0, height * 2, width, height);
		skeleton_walk[1] = skeletonSheet.singleImg(width * 1, height * 2, width, height);
		skeleton_walk[2] = skeletonSheet.singleImg(width * 2, height * 2, width, height);
		skeleton_walk[3] = skeletonSheet.singleImg(width * 3, height * 2, width, height);
		skeleton_walk[4] = skeletonSheet.singleImg(width * 4, height * 2, width, height);
		skeleton_walk[5] = skeletonSheet.singleImg(width * 5, height * 2, width, height);
		skeleton_walk[6] = skeletonSheet.singleImg(width * 6, height * 2, width, height);
		skeleton_walk[7] = skeletonSheet.singleImg(width * 7, height * 2, width, height);
		//-------------------------------------------------------------------------
		skeleton_death = new BufferedImage[8]; //loads in death frames
		skeleton_death[0] = skeletonSheet.singleImg(width * 0, height * 3, width, height);
		skeleton_death[1] = skeletonSheet.singleImg(width * 1, height * 3, width, height);
		skeleton_death[2] = skeletonSheet.singleImg(width * 2, height * 3, width, height);
		skeleton_death[3] = skeletonSheet.singleImg(width * 3, height * 3, width, height);
		skeleton_death[4] = skeletonSheet.singleImg(width * 4, height * 3, width, height);
		skeleton_death[5] = skeletonSheet.singleImg(width * 5, height * 3, width, height);
		skeleton_death[6] = skeletonSheet.singleImg(width * 6, height * 3, width, height);
		skeleton_death[7] = skeletonSheet.singleImg(width * 7, height * 3, width, height);
		//-------------------------------------------------------------------------
		skeleton_attack = new BufferedImage[8]; //loads in attack frames
		skeleton_attack[0] = skeletonSheet.singleImg(width * 0, height * 4, width, height);
		skeleton_attack[1] = skeletonSheet.singleImg(width * 1, height * 4, width, height);
		skeleton_attack[2] = skeletonSheet.singleImg(width * 2, height * 4, width, height);
		skeleton_attack[3] = skeletonSheet.singleImg(width * 3, height * 4, width, height);
		skeleton_attack[4] = skeletonSheet.singleImg(width * 4, height * 4, width, height);
		skeleton_attack[5] = skeletonSheet.singleImg(width * 5, height * 4, width, height);
		skeleton_attack[6] = skeletonSheet.singleImg(width * 6, height * 4, width, height);
		skeleton_attack[7] = skeletonSheet.singleImg(width * 7, height * 4, width, height);
		//-------------------------------------------------------------------------
		fire = new BufferedImage[4]; //loads in the campfire
		fire[0] = fireSheet.singleImg(w * 0, h * 0, w, h);
		fire[1] = fireSheet.singleImg(w * 1, h * 0, w, h);
		fire[2] = fireSheet.singleImg(w * 2, h * 0, w, h);
		fire[3] = fireSheet.singleImg(w * 3, h * 0, w, h);
		//-------------------------------------------------------------------------
		fire2 = new BufferedImage[4]; //loads in the second campfire
		fire2[0] = fire2Sheet.singleImg(w * 0, h * 0, w, h);
		fire2[1] = fire2Sheet.singleImg(w * 1, h * 0, w, h);
		fire2[2] = fire2Sheet.singleImg(w * 2, h * 0, w, h);
		fire2[3] = fire2Sheet.singleImg(w * 3, h * 0, w, h);
	}
}
