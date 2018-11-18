/**
 * 
 */
package gamemain;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * @author Spentpillow
 *
 */
public class Window extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3802313628976550610L;
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title); //Created a window frame
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Binding the windows close operation
		frame.setResizable(false); // No resize to window
		frame.setLocationRelativeTo(null); //Position the window in the middle of the screen
		frame.add(game); // Adding game class to the frame
		frame.setVisible(true); 
		game.start();
		
	}

}
