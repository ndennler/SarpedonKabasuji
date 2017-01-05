package entity.player;

import java.util.ArrayList;
/**
 * Implementation of the abstract superclass Level for Puzzle variation
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class PuzzleLevel extends Level {

	private static final long serialVersionUID = 1L;
	/** the number of allowed moves left */
	Integer movesleft;
	
	/**
	 *  Default constructor, primarily used for testing purposes 
	 *  since Levels will be made in the level builder
	 */
	public PuzzleLevel(){
		super("Puzzle");
		this.board = new Board();
		this.bullpen = new Bullpen();
		this.stars = 0;
		this.completed = false;
		this.hints = new ArrayList<Hint>(); // new empty list
		this.number = 1;
		this.movesleft = 10; // arbitrary number to allow some testing
	}
	
	/**
	 * Constructor, primarily for testing purposes
	 * since Levels will be made in the level builder
	 * @param b the Board on which Pieces can be played
	 * @param bllpn the Bullpen from which Pieces can be played
	 * @param hnts a list of suggested locations for a selection of specific Pieces
	 */
	public PuzzleLevel(Board b, Bullpen bllpn, ArrayList<Hint> hnts){
		super("Puzzle");
		this.board = b;
		this.bullpen = bllpn;
		this.hints = hnts;
		this.stars = 0;
		this.completed = false;
		this.type = "Puzzle";
		this.number = 1;
		this.movesleft = 10; // arbitrary number to allow some testing
		this.updateStars();
	}

	/**
	 * Calculates the number of stars earned based on the number of Pieces left in the Bullpen
	 * and updates the stored value
	 */
	@Override
	public void updateStars(){
		int s = this.bullpen.piecesLeft();
		//add the selected piece to the count too, since it's not technically out of the bullpen.
		if(bullpen.getSelectedPiece() != null){
			s++;
		}
		if (s > 2){
			this.stars = 0;
			return;
		} else if (s == 2){
			this.stars = 1;
			return;
		} else if (s == 1){
			this.stars = 2;
		} else if (s == 0){
			this.stars = 3;
			return;
		} else {
			throw new RuntimeException("PuzzleLevel::updateStars: received incompatible bullpen");
		}
	}
	
	/**
	 * Gets the number of moves left
	 * @return the number of moves left
	 */
	public Integer getMovesLeft(){
		return movesleft;
	}
	/**
	 * Sets the number of moves left
	 * @param l the intended number of moves left
	 */
	public void setMovesLeft(int l){
		movesleft = l;
	}
	
	@Override
	public boolean getCompleted(){
		return(super.getCompleted() || movesleft == 0);
	}
	
	
	/**
	 * restores the Level to it's original state
	 */
	@Override
	public void restore(LevelMomento m){
		board = m.board;
		bullpen = m.bullpen;
		stars = m.stars;
		hints = m.hints;
		type = m.type;
		completed = m.completed;
		number = m.number;
		movesleft = m.movesAllotted;
	}
}
