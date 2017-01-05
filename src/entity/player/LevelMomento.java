package entity.player;

import java.io.Serializable;
import java.util.ArrayList;

import entity.builder.BuildableLightning;
import entity.builder.BuildablePuzzle;
import entity.builder.BuildableRelease;
import entity.builder.IBuilderModel;

public class LevelMomento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3727069688336446332L;

	
	/** A Board which describes what locations are playable and where Pieces are */
	Board board;
	/** A collection of Pieces that can be played on the Board */
	Bullpen bullpen;
	/** An indicator of progress through the level */
	Integer stars;
	/** whether or not the level is completed */
	boolean completed;
	/** a series of hints as to where specific Pieces should go */
	ArrayList <Hint> hints;
	/** the type of the Level: Lightning, Puzzle, or Release */
	String type;
	/** a number indicating the Level's position in the ordering for the overarching game */
	Integer number;
	/**a number indicating total time allowed in a lightning round*/
	Integer timeAllotted;
	/**a number indicating moves allotted in a puzzle round*/
	Integer movesAllotted;
	/** Alternate Board for Lightning*/
	LightningBoard lBoard;
	/**
	 * LevelMomento Constructor
	 * @param m - Current model
	 */
	public LevelMomento(IBuilderModel m){
		board = m.getBoard();
		bullpen = m.getBullpen();
		stars = 0;
		completed = false;
		hints = m.getHints();
		type = m.getType();
		if(type.equals("Lightning")){

			timeAllotted = ((BuildableLightning)m).getTimeAllotted();
			board = (LightningBoard) m.getBoard();


		}
		if(type.equals("Puzzle")){
			movesAllotted = ((BuildablePuzzle)m).getMovesAllotted();
		}
		if(type.equals("Release")){
			
			board = (ReleaseBoard)m.getBoard();
			
		}
	}
	/**
	 * Gets the level type
	 * @return the level type as a string
	 */
	public String getType(){
		return type;
	}
	/**
	 * Gets the time allotted for the level
	 * @return the time the level has allotted as an integer
	 */
	public Integer getTimeAllotted(){
		return timeAllotted;
	}
	/**
	 * Gets the amount of moves allotted for the level
	 * @return the amount of moves alloted as an integer
	 */
	public Integer getMovesAllotted(){
		return movesAllotted;
	}
	/**
	 * Sets the level number
	 * @param n - level number
	 */
	public void setNumber(int n){
		number = n;
	}
	
	
}
