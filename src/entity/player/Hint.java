package entity.player;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

/**
 * A Hint is a suggested location for a specific Piece
 * @author Tesia Shizume (ttshiz@wpi.edu)
 * @author Nathan
 */
public class Hint implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -420200215792336927L;
	
	/** The piece who's location is being suggested */
	Piece piece;
	/** The row in which the origin of the piece is suggested to be placed */
	Integer row;
	/** The column in which the origin of the piece is suggested to be placed */
	Integer column;
	
	/** The constructor of a Hint 
	 * @param pc the Piece being suggested
	 * @param rw the row in which the origin of the piece is suggested to be placed
	 * @param clmn the column in which the origin of the piece is suggested to be placed
	 */
	public Hint(Piece pc, Integer rw, Integer clmn){
		piece = pc;
		row = rw;
		column = clmn;
	}
	/** Getter for the piece contained in the hint */
	public Piece getPiece(){
		return piece;
	}
	/** Getter for the row location of the hint */
	public Integer getRow(){
		return row;
	}
	/** Getter for the column location of the hint */
	public Integer getColumn(){
		return column;
	}
	
	/** Draws the hint to the given graphics object. */
	public void drawHint(Graphics g, int tileSize, Point p, int offset){
		for(Square s: piece.getDependant()){
			g.setColor(piece.getColor());
			int i = 2;
			while(p.y + i < p.y + tileSize){
				g.drawLine(offset + p.x*tileSize + s.getX()*tileSize +2, offset + p.y*tileSize + i + s.getY()*tileSize, 
						offset+ p.x*tileSize + tileSize + s.getX()*tileSize -2, offset + p.y*tileSize + i + s.getY()*tileSize);
				i += 4;
			}
		}
	}
	/**
	 * Tells if a this hint covers the tile at the given row, column. 
	 * @param row
	 * @param column
	 * @return True if the hint covers the tile at the given row and column
	 */
	public boolean covers(int row, int column) {
		for(Square s: piece.getDependant()){
			if (s.getX()+this.row == row && s.getY()+this.column == column){
				return true;
			}
		}
		return false;
	}

}
