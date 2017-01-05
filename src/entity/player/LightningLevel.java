package entity.player;

import java.util.ArrayList;
/**
 * Implementation of the abstract superclass Level for the Lightning variation
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class LightningLevel extends Level {

	private static final long serialVersionUID = 1267201638847484961L;
	/** the amount of time left */
	Integer timeLeft;
	
	/**
	 * Constructor, primarily for testing purposes
	 * since LightningLevels will be made in the level builder
	 * @param lboard a LigntningBoard on which Pieces can be played
	 * @param bull a Bullpen from which Pieces can be played
	 * @param hnts a list of suggested locations for a selection of specific Pieces
	 * @param tLeft
	 */
	
	public LightningLevel(LightningBoard lboard, Bullpen bull, Integer strs,
			boolean cmplted, ArrayList<Hint> hnts, Integer num, Integer tLeft) {
		super("Lightning");
		bullpen= bull;
		board = lboard;
		
		stars = strs;
		completed = cmplted;
		hints = hnts;
		number = num;
		timeLeft = tLeft;
	}
	/** 
	 * Default constructor, primarily for testing purposes
	 * since Lightning Levels will be made in the level builder
	 */
	public LightningLevel() {
		super("Lightning");
		this.board = new LightningBoard();
		this.bullpen = new Bullpen();
		this.hints = new ArrayList<Hint>();
		this.stars = 0;
		this.completed = false;
		this.type = "Lightning";
		this.number = 2;
		this.timeLeft = 100000;
	}
	public Integer getTimeLeft(){
		return timeLeft;
	}
	public void decrementTime(){
		timeLeft--;
	}
	/**
	 * Calculates the number of stars earned based on the number of spaces left on the Board
	 * and updates the stored value
	 */
	@Override
	public void updateStars(){
		int spcLeft =  board.spacesLeft();
		if (spcLeft > 12){
			this.stars = 0;
			return;
		} else if (spcLeft > 6){
			this.stars = 1;
			return;
		} else if (spcLeft > 0){
			this.stars = 2;
			return;
		} else if (spcLeft == 0){
			this.stars = 3;
			return;
		} else {
			throw new RuntimeException("LightningLevel::updateStars: Error calculating stars");
		}
	}
	/**
	 * Gets whether the level has been completed or not as a boolean
	 */
	@Override
	public boolean getCompleted(){
		return (super.getCompleted() || timeLeft == 0);
	}
	
	/**
	 * Restores the level to a given momento
	 */
	@Override
	public void restore(LevelMomento m){
	
		board = new LightningBoard(m.board.getTileArray());
		bullpen = m.bullpen;
		stars = m.stars;
		hints = m.hints;
		type = "Lightning";
		completed = m.completed;
		number = m.number;
		timeLeft = m.timeAllotted;
	}
	
	
	
}
