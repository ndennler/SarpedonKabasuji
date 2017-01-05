package control.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entity.player.*;

import javax.swing.*;

import Main.PlayerApplication;
import bounday.player.LightningLevelGui;
import bounday.player.PlayerBullpenPanel;
import bounday.player.PuzzleLevelGui;
import bounday.player.ReleaseLevelGui;
/**
 * Class that creates new Jframes for loaded levels in the player
 * ex. creates a puzzle player gui for a puzzle level
 * @author Drew 
 *
 */
public class LevelNumberController {


	Level level;
	String type;	
JFrame LG;
/**
 * 
 * Takes in a level and creates an appropriate Gui
 */
	public LevelNumberController( Level newlevel, SarpedonKabasuji aGame){
		
		level = newlevel;
		type = level.getType();
		if (type.equals("Puzzle"))
		{
			PuzzleLevelGui pLG = new PuzzleLevelGui((PuzzleLevel)level, aGame);
			LG = pLG;
			
		} else
		if (type.equals("Lightning"))
		{		LightningLevelGui lLG = new LightningLevelGui((LightningLevel)level, aGame);
			LG = lLG;			
		
			
		}else
		if (type.equals("Release"))
		{	ReleaseLevelGui rLG = new ReleaseLevelGui((ReleaseLevel)level, aGame);
			LG = rLG;
			
			
			
		}else
		{
			System.out.println("Not Correct Name");
		}
		type = level.getType();
	}
	
	public JFrame getFrame(){
return LG;
	}
	/**
	 * Sets the level's number to a new number
	 * @param number - Given new level number
	 */
	public void changeLevelNumber(Integer number){
		level.setNumber(number);
	}


}
