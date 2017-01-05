package entity.player;

import java.awt.Color;
import java.util.UUID;


/**
 *  An extension of the base Tile class that encapsulates the additional data required
 *  for Tiles of ReleaseBoards
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class ReleaseTile extends Tile {
	
	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 3044815580057386645L;
	/** the number associated with the instance of the Release Tile, or null if it has no number */
	Integer rnumber;
	
	public UUID getCoveredBy(){
		return this.coveredBy;
	}
	
	/** the color of the instance of the ReleaseTile */
	Color rcolor; 
	

	/** Gets the number assigned to the Tile */
	public Integer getNumber(){
		return this.rnumber;
	}
	/**
	 * Sets a number to a tile
	 * @param i - the number to be set to the tile
	 */
	public void setNumber(int i){
		rnumber = i;
	}
	
	
	/** Gets the color assigned to the Tile */
	public Color getColor(){
		return this.rcolor;
	}
	/** Sets the color of the tile based on the string it takes in. */
	public void setColor(String s){
		if(s.equals("Red")){
			rcolor = Color.RED;
		}
		else if(s.equals("Green")){
			rcolor = Color.GREEN;
		}
		else if(s.equals("Blue")){
			rcolor = Color.BLUE;
		}
		else{
			rcolor = null;
		}
	}
	/** Constructor with UUID provided 
	 * @param rw the row in which the ReleaseTile is located
	 * @param cl the column in which the ReleaseTile is located
	 * @param cvrd the UUID of the piece that covers the ReleaseTile, or null if there is no Piece covering the Tile 
	 */
	public ReleaseTile(Integer rw, Integer cl, UUID cvrd, Integer rnum, Color rcolr) {
		super(rw, cl, cvrd);
		rnumber = rnum;
		rcolor = rcolr;
	}
	/** Constructor without UUID 
	 * @param rw the row in which the ReleaseTile is located
	 * @param cl the column in which the ReleaseTile is located
	 * @param rnum the number assigned to the ReleaseTile
	 * @param rcolr the color assigned to the ReleaseTile
	 */
	public ReleaseTile(Integer rw, Integer cl, Integer rnum, Color rcolr) {
		super(rw, cl);
		rnumber = rnum;
		rcolor = rcolr;
	}
//	/** Provides a string representation of the Color */
//	public String getColorString(){
//		switch(this.rcolor){
//		case BLUE:
//			return "BLUE"; 
//		case GREEN:
//			return "GREEN"; 
//		case RED:
//			return "RED"; 
//		case NONE:
//			return "NONE";
//		default:
//			throw new RuntimeException("entity.player::ReleaseTile: Unexpected Color");
//		}
//	}
//	
//	/** Provides a AWT color for drawing*/
//	public java.awt.Color getAWTColor(){
//		String color = getColorString();
//		if(color.equals("RED")){
//			return new java.awt.Color(255,0,0);
//		}
//		if(color.equals("BLUE")){
//			return new java.awt.Color(0,0,255);
//		}
//		if(color.equals("GREEN")){
//			return new java.awt.Color(255,0,255);
//		}
//		else{
//			return null;
//		}
//	}
}
