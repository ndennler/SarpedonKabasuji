package control.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bounday.player.PlayerBoardPanel;

public class ResetController implements ActionListener{
	PlayerBoardPanel parentPanel;
	/**
	 * Constructor for ResetController
	 * @param parentPanel - Current Player Board Panel
	 */
	ResetController(PlayerBoardPanel parentPanel) {
		this.parentPanel = parentPanel;
	}
	
	void reset() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
