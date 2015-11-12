// Jumaah, Bilal, 12232659, Assignment 2, 159.235
package spoder;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
	private JFrame window;
	private Canvas displayArea;
	private int width, height;
	
	public String title;
	
	public Display(String title, int width, int height) {
		this.title = title;  //constructor
		this.width = width;
		this.height = height;
		
		mkWindow();  //creates JFrame settings
		mkDisplay();  //creats Canvas settings
		
	}
//-------------------------------------------------------------------------
	private void mkWindow() {
		window = new JFrame(title);
		window.setSize(width, height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
//-------------------------------------------------------------------------
	private void mkDisplay() {
		displayArea = new Canvas();
		displayArea.setPreferredSize(new Dimension(width, height));
		displayArea.setMaximumSize(new Dimension(width, height));
		displayArea.setMinimumSize(new Dimension(width, height));
		displayArea.setFocusable(false);
		
		window.add(displayArea); //adds canvas to the jframe
		window.pack();
	}
//-------getters for jframe and canvas------------------------------------
	public Canvas getDisplay() {
		return displayArea;
	}
	
	public JFrame getWindow() {
		return window;
	} 
}
