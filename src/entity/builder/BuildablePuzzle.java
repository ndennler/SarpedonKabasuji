package entity.builder;

import java.util.ArrayList;

import control.builder.IMove;
import entity.player.*;

public class BuildablePuzzle extends Level implements IBuilderModel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<IMove> MoveList = new ArrayList<IMove>();
	ArrayList<IMove> RedoList = new ArrayList<IMove>();
PieceBuilder PB = new PieceBuilder();
Integer movesAllotted;	
	/**
	 * BuildablePuzzle Constructor
	 */
	public BuildablePuzzle(){
		super("Puzzle");
		this.type = "Puzzle";
	}
	/**
	 * gets the board
	 */
	public Board getBoard(){
		return super.getBoard();
	}
	/**
	 * gets the bullpen
	 */
	public Bullpen getBullpen(){
		return super.getBullpen();
	}
	/**
	 * gets the amound of moves alloted
	 */
	public Integer getMovesAllotted(){
		return movesAllotted;
	}
	/**
	 * sets the amount of moves alloted
	 */
	public void setMovesAllotted(Integer m){
		movesAllotted = m;
	}
	/**
	 * sets the bullpen
	 */
	public void setBullpen(Bullpen bp){
		bullpen = bp;
	}
	/**
	 * sets the board
	 */
	public void setBoard(Board b){
		board = b;
	}
	/**
	 * sets the level type
	 */
	public void setType(String s){
		type = s;
	}
	/**
	 * Restores level state to another given momento
	 */
	@Override
	public void restore(LevelMomento m){
		super.restore(m);
		movesAllotted = m.getMovesAllotted();
	}
	/**
	 *returns the last move or null if empty
	 */
	public IMove getLastMove() {
		if (MoveList.isEmpty())
		{
			return null;
		}
		IMove aMove= MoveList.get(MoveList.size()-1);
		RedoList.add(aMove);
		MoveList.remove(MoveList.size()-1);
		return aMove;
	}
	/**
	 * adds a move to the list of moves
	 * @param aMove - most recent move
	 */
	public void addMove(IMove aMove)
	{
		MoveList.add(aMove);
	}
	
	/**
	 * Redoes a move
	 */
	public IMove getRedoMove() {
		if (RedoList.isEmpty())
		{
			return null;
		}
		IMove aMove= RedoList.get(RedoList.size()-1);
		RedoList.remove(RedoList.size()-1);
		return aMove;
	}
}
