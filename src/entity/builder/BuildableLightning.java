package entity.builder;

import java.util.ArrayList;

import control.builder.IMove;
import entity.player.Board;
import entity.player.Bullpen;
import entity.player.Level;
import entity.player.LevelMomento;
import entity.player.PieceBuilder;
import entity.player.ReleaseBoard;

public class BuildableLightning extends Level implements IBuilderModel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<IMove> MoveList = new ArrayList<IMove>();
	ArrayList<IMove> RedoList = new ArrayList<IMove>();
PieceBuilder PB = new PieceBuilder();
Integer timeAllotted;
	/**
	 * Constructor for BuildableLightning
	 */
	public BuildableLightning(){
		super("Lightning");
		this.type = "Lightning";
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
	 * gets the time allotted
	 * @return time allotted
	 */
	public Integer getTimeAllotted(){
		return timeAllotted;
	}
	/**
	 * sets the time allotted
	 * @param t - time allotted being set for the level
	 */
	public void setTimeAllotted(Integer t){
		timeAllotted = t;
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
	public void restore(LevelMomento m){
		super.restore(m);
		timeAllotted = m.getTimeAllotted();
	}
	/**
	 * returns the last move or null if it is empty
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
	@Override
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
