package entity.player;

import control.player.Loader;
/**
 * Main model class for team Sarpedon's implementation of the Kabasuji game
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class SarpedonKabasuji {
	/** an array storing the levels of the game */
	Level[] levels = new Level[15];
	/** a boolean representing whether the game has been completed */
	boolean gameOver;
	/** an integer representing integer progress through the game */
	int unlockedLevels;
	
	/** 
	 * Constructor for the model
	 *  initializes loader, fetches Levels, sets gameOver status to false 
	 *  and initializes unlockedLevels to 1
	 */
	public SarpedonKabasuji(){
		Loader loader = new Loader();
		for(int i = 0; i<15; i++){
		levels[i] = loader.getLevel(i+1);
		}
		gameOver = false;
		unlockedLevels = 1;
	}
	/**
	 * Gets the next unlocked level, throws an exception if there is none
	 * @return the next unlocked level
	 */
	Level nextLevel(){
		Level nxtlvl = levels[unlockedLevels+1];
		if(nxtlvl != null){
			return nxtlvl;
		} else {
			throw new RuntimeException("SarpedonKabasuji: no next level");
		}
	}
	/**
	 * Gets whether the game has been completed (all the levels finished)
	 * @return true if the game has been completed
	 */
	public boolean getGameOver(){
		return gameOver;
	}
	
	/**
	 * Gets the number of the highest unlocked level
	 * @return the number of the highest unlocked level
	 */
	public int getCurrentLevel(){
		return unlockedLevels;
	}
	/**
	 * Gets the ith level in the game
	 * @param i the ith number of the level wanted
	 * @return the ith level
	 */
	public Level getLevel(Integer i){
		return levels[i-1];
	}
	/**
	 * Updates the current set of playable levels to include the level specified
	 * @param l a level to add/overwrite a current level
	 */
	public void setLevel(Level l){
		if (l != null && levels != null) {
			levels[l.getNumber()-1] = l;
		}
	}
	/**
	 * increment the number of unlocked levels
	 */
	public void incrementLevel(){
		unlockedLevels++;
	}
	/**
	 * Gets the current array of levels
	 * @return  the current array of levels
	 */
	public Level[] getLevels(){
		return levels;
	}
	
	/**
	 * Sets the current unlocked level back to one.
	 */
	public void resetCurrentLevel(){
		unlockedLevels = 1;
	}

}
