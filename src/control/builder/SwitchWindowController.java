package control.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * Switches the frames for navigation in the builder application.
 * @author Nathan
 *
 */
public class SwitchWindowController implements ActionListener{

	JFrame currentFrame;
	JFrame nextFrame;
	/**
	 * Constructor for SwitchWindowController
	 * @param current - Current Frame
	 * @param next - Next Frame
	 */
	public SwitchWindowController(JFrame current, JFrame next){
		currentFrame = current;
		nextFrame = next;
	}
	
	@Override
	/**
	 * makes the next frame visible and the next fram invisible.
	 */
	public void actionPerformed(ActionEvent e) {
		nextFrame.setVisible(true);	
		currentFrame.setVisible(false);
		
	}
}
