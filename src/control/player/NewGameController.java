package control.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bounday.player.LevelSelectGui;
import entity.player.Level;
import entity.player.SarpedonKabasuji;

/**
 * Resets any progress you have made in the game.
 * @author Nathan
 *
 */
public class NewGameController implements ActionListener{

	SarpedonKabasuji game;
	/**
	 * Constructor for NewGameController
	 * @param g - Current game
	 */
	public NewGameController(SarpedonKabasuji g){
		game = g;
	}
	
	@Override
	/** 
	 * go through each level in the game and reset the stars. 
	 * Then set the current level back to zero.
	 */
	public void actionPerformed(ActionEvent e) {
		for(Level l: game.getLevels()){
			if(l!=null){
			l.setStars(0);
			}
		}
		game.resetCurrentLevel();
		new LevelSelectGui(game).setVisible(true);	
	}

}
