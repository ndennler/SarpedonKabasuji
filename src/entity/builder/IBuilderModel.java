package entity.builder;

import java.util.ArrayList;

import control.builder.IMove;
import entity.player.*;

public interface IBuilderModel{

PieceBuilder PB = new PieceBuilder();
	/**
	 * Method given to all builder models that returns the last move
	 * @return returns a move
	 */
public IMove getLastMove();
	public Board getBoard();
	public Bullpen getBullpen();
	public ArrayList<Hint> getHints();
	public String getType();
	public void setBullpen(Bullpen bp);
	public void setBoard(Board b);
	public void setType(String s);
	public void addMove(IMove aMove);
	
	public void restore(LevelMomento m);
	public IMove getRedoMove();
}
