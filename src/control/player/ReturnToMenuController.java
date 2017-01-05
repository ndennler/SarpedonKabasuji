package control.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bounday.player.KabasujiMenuGui;

public class ReturnToMenuController implements ActionListener{
	KabasujiMenuGui parentPanel;
	/**
	 * Constructor for ReturnToMenuConroller
	 * @param parentPanel - The Kabasuji Menu GUI
	 */
	ReturnToMenuController(KabasujiMenuGui parentPanel) {
		this.parentPanel = parentPanel;
	}
	
	void quit() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
