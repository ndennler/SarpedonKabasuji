/**
 * 
 */
package control.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import bounday.player.LightningLevelGui;
import bounday.player.PlayerBoardPanel;
import bounday.player.PlayerBullpenPanel;
import bounday.player.PuzzleLevelGui;
import bounday.player.ReleaseLevelGui;
import entity.player.Level;
import entity.player.LevelMomento;
import entity.player.LightningLevel;
import entity.player.PuzzleLevel;
import entity.player.ReleaseLevel;
import entity.player.SarpedonKabasuji;

/**
 * @author Nathan
 *
 */
public class ResetLevelController implements ActionListener{

	Level level;
	JFrame parentFrame;
	SarpedonKabasuji game;
	/**
	 * Constructor for ResetLevelController
	 * @param l - Current Level
	 * @param g - Current Game
	 * @param parent - Current frame
	 */
	public ResetLevelController(Level l, SarpedonKabasuji g, JFrame parent){
		level = l;
		game = g;
		parentFrame = parent;
		
	}
	/**
	 * Resets Level when reset is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Loader l = new Loader();
		LevelMomento old = l.getMomento(level.getNumber());
		if(level instanceof PuzzleLevel){
			((PuzzleLevel)level).restore(old);
			parentFrame.dispose();
			new PuzzleLevelGui((PuzzleLevel)level, game).setVisible(true);
		}
		if(level instanceof LightningLevel){
			((LightningLevel)level).restore(old);
			parentFrame.dispose();
			new LightningLevelGui((LightningLevel)level, game).setVisible(true);
		}
		if(level instanceof ReleaseLevel){
			((ReleaseLevel)level).restore(old);
			parentFrame.dispose();
			new ReleaseLevelGui((ReleaseLevel)level, game).setVisible(true);
		}
	}
	
	
}
