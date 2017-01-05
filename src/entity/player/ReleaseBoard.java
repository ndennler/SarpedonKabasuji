package entity.player;

import java.util.HashMap;
import java.util.UUID;
/**
 * The Release variant of a Board
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class ReleaseBoard extends Board {

	private static final long serialVersionUID = 9055398407614672409L;


	
	/**
	 * Constructor for the Release Board
	 * @param s a two dimensional array of ReleaseTiles
	 */
	public ReleaseBoard(Tile[][] s) {
		// enforce size restriction, array must be at least 1 x 1 and less than 12 x 12
		if ((s.length <= 12)&&(s.length>=1)){
			if ((s[0].length <= 12)&&(s[0].length >=1)){
				this.shape =  s;
			}
		} else {
			throw new RuntimeException("entity.player::Board: invalid board array");
		}
		pieces = new HashMap<UUID, Piece>();
	}
	
	public ReleaseBoard(){
		this.shape = new Tile[12][12];
		for(int i=0; i< 12; i++){
			for(int j =0; j<12;j++){
				shape[i][j]	= new ReleaseTile(i,j, null, null);
			}
		}
		pieces = new HashMap<UUID, Piece>();
	}
	
	/**
	 * Returns the release tile array, since this is a release board.
	 */
	@Override
	public Tile[][] getTileArray(){
		return  shape;
	}
	
	/**
	 * Overrides base removePiece method to always return false
	 * Pieces are not removable from ReleaseBoards
	 */
	@Override
	public
	boolean removePiece(Integer row, Integer col){
		return false; // pieces not removable in Release
	}
	/**
	 * Overrides base movePiece method to always return false
	 * Pieces are not movable on ReleaseBoards
	 */
	@Override
	boolean movePiece(Integer startRow, Integer startCol, Integer endRwo, Integer endCol){
		return false; // pieces not movable after placement in Release
	}
	/**
	 * removes a tile from the release board
	 */
	@Override
	public void removeTile(int row, int column){
		shape[row][column] = null;
	}
}
