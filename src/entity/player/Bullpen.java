package entity.player;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * The Bullpen is a collection of Pieces, one of which may be selected at a time
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class Bullpen implements Serializable{

	private static final long serialVersionUID = -6879604314610676141L;
	/** the Pieces the Bullpen has */
	ArrayList <Piece> pieces;
	/** the currently selected Piece */
	Piece selectedPiece;
	
	/** 
	 * Constructor for a new Bullpen, taking parameters
	 * @param pcs an ArrayList of the Pieces, which the Bullpen is to contain
	 * @param sPiece the currently selected Piece, or null if there is not one
	 */
	Bullpen(ArrayList <Piece> pcs, Piece sPiece){
		pieces = pcs;
		selectedPiece = sPiece; 
	}
	/**
	 * Default constructor for a new empty Bullpen 
	 */
	public Bullpen(){
		pieces = new ArrayList<Piece>();
		selectedPiece = null;
	}
	/**
	 * sets the value of the selected Piece to the given Piece
	 * @param p the given Piece
	 */
	public void setSelected(Piece p){
			selectedPiece = p;
	}
	/**
	 * gets the Bullpen's ArrayList
	 * @return the Bulpen's ArrayList
	 */
	public ArrayList<Piece> getPieces(){
		return pieces;
	}
	/**
	 * sets the selected Piece of the Bullpen to null
	 */
	public void removeSelected(){
		selectedPiece = null;
	}
	/**
	 * adds a Piece to the Bullpen
	 * @param p the Piece to be added
	 */
	public void addPiece(Piece p){
		pieces.add(p);
	}
	/**
	 * gets the selected Piece
	 * @return the selected Piece
	 */
	public Piece getSelectedPiece(){
		return selectedPiece;
	}
	/**
	 * removes a Piece from the Bullpen, throws an exception of the Piece was not in the Bullpen
	 * @param p the Piece to be removed
	 * @return the Piece 
	 */
	public Piece removePiece(Piece p){
		int i = pieces.indexOf(p);
		// checks for invalid index then removes piece, otherwise throws error
		if (i != -1){
			Piece ret = pieces.remove(i);
			return ret;
		}
		else {
			throw new RuntimeException ("Piece not found in Bullpen!");
		}
	}
	/**
	 * calculates the number of Pieces left in the Bullpen
	 * @return int representing the number of Pieces left in the Bullpen
	 */
	public int piecesLeft(){
		return pieces.size();
	}
}
