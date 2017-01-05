package control.player;

import bounday.player.LevelSelectGui;
import entity.player.Level;

public class LevelSelectController {
	
	LevelSelectGui parentPanel;
	Level level;
	/**
	 * Constructor for LevelSelectController
	 * @param parentPanel - current level select GUI
	 * @param level - Current Level
	 */
	LevelSelectController(LevelSelectGui parentPanel, Level level) {
		this.parentPanel = parentPanel;
		this.level = level;
	}
	
	void start (Level level) {
		
	}
}
