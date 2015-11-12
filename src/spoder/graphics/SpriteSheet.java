// Jumaah, Bilal, 12232659, Assignment 2, 159.235
package spoder.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;  //constructor
	}
//-------------------------------------------------------------------------
	public BufferedImage singleImg (int x, int y, int w, int h) {
		return sheet.getSubimage(x, y, w, h);   //cropping the sprite sheet to single images
	}
//-------------------------------------------------------------------------
	public static BufferedImage load(String location) {
		try {
			return ImageIO.read(SpriteSheet.class.getResource(location)); //loads the sprite sheet image
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
