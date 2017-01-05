package entity.player;

import java.util.UUID;
/**
 * the Lightning variant of a Board
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class LightningBoard extends Board {

	private static final long serialVersionUID = -6838121895530945975L;
	/**
	 * default constructor for the Lightning Board
	 */
	public LightningBoard() {
		super();
	}
	/** 
	 * Contructor for the Lightning Board
	 * @param s a two dimensional array of Tiles
	 */
	public LightningBoard(Tile[][] s){
		super(s);
	}
	/**
	 * Overrides base availableTile method to remove UUID check
	 * Pieces can overlap on LightningBoards
	 */
	@Override
	public
	boolean availableTile(Integer row, Integer col){
		// check if out of bounds of rectangular representation of the board
		if ((row > shape[0].length - 1) || (col > shape.length - 1)){
			return false;
		}
		if ((row < 0) || (col < 0)){
			return false;
		}
//		System.out.println(shape[row][col]);
		if (shape[row][col] == null){
			return false; // location not a playable tile
		} else {
			return true;
		}
	}
	/**
	 * checks to see if a given piece can be placed on the given spot on a lightning board
	 */
	@Override
	protected boolean piecePlaceable(Integer row, Integer col, Piece p){
		boolean placeable = true;
			for (Square s : p.getDependent()){
				int drow = row + s.getxFromAnchor();
				int dcol = col + s.getyFromAnchor();
				if (!availableTile(drow, dcol)){
					placeable = false;
				}
			}
			return placeable;
	}
	/**
	 * adds a piece to the lightning board
	 */
	@Override
	public
	boolean addPiece(Integer row, Integer col, Piece p){
		if (piecePlaceable(row, col, p)){
			UUID pUUID = UUID.randomUUID(); // generating UUID for hash
			while (pieces.get(pUUID) != null){ // ensuring a unique UUID
				pUUID = UUID.randomUUID();
			}
			Tile t = shape[row][col];
			for (Square s : p.getDependent()){ // mark the rest 
				int drow = row + s.getxFromAnchor();
				int dcol = col + s.getyFromAnchor();
				t = shape[drow][dcol];
				t.setCoveredBy(pUUID);
			}
			pieces.put(pUUID, p); // put mapping into hashmap
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Returns false if a piece is attempted to be moved on a lightning board
	 */
	@Override
	boolean movePiece(Integer startRow, Integer startCol, Integer endRow, Integer endCol){
		return false; // can't move a piece on a board in Lightning
	}
	

}
