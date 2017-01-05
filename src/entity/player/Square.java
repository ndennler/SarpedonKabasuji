package entity.player;

import java.io.Serializable;
/**
 * A combination of six of these makes a piece
 * @author Drew
 *
 */
public class Square implements Serializable {
	
	
	private static final long serialVersionUID = 1967981073234849684L;
	
	/**
	 * the piece's distance from the anchor piece
	 */
	private int xFromAnchor;
	/**
	 * the piece's distance from the anchor piece
	 */
	private int yFromAnchor;
	/**
	 * creates a square given an x and y coordinate
	 * @param xFromAnchor
	 * @param yFromAnchor
	 */
	public Square(int xFromAnchor, int yFromAnchor){
		this.setxFromAnchor(xFromAnchor);
		this.setyFromAnchor(yFromAnchor);
	}
	/**
	 * 
	 * @return the horizontal distance from the anchor
	 */
	public int getX(){
		return this.getxFromAnchor();
	}
	/**
	 * 
	 * @return the vertical distance from the anchor
	 */
	public int getY(){
		return this.getyFromAnchor();
	}
	/**
	 * 
	 * @param x sets the x distance from anchor
	 */
	public void setX(int x)	{
		setxFromAnchor(x);
	}
	/**
	 * 
	 * @param y sets the y distance from the anchor
	 */
	public void setY(int y){
		setyFromAnchor(y);
	}
	
	/**
	 * places a square where it should be if the piece is rotated clockwise
	 */
	void rotateClockwise(){
		int currentY = getyFromAnchor(); 
			setyFromAnchor(-1*getxFromAnchor());
			setxFromAnchor(currentY);
	}
	/**
	 * places a square where it should be if the piece is rotated counter clockwise
	 */
	void rotateCounter(){
		int currentY = getyFromAnchor();
			setyFromAnchor(getxFromAnchor());
			setxFromAnchor(-1* currentY);
	}
	/**
	 * places a square where it should be if the piece is flipped horizontally
	 */
	void flipHorizontal(){
		setxFromAnchor(-1*getxFromAnchor());
	}
	/**
	 * places a square where it should be if the piece is flipped vertically
	 */
	void flipVertical(){
		setyFromAnchor(-1*getyFromAnchor());
	}
	/**
	 * Gets y from the anchor
	 * @return y from anchor as an integer
	 */
	public int getyFromAnchor() {
		return yFromAnchor;
	}
	/**
	 * Sets the y from the anchor
	 * @param yFromAnchor - distance from anchor in the y direction
	 */
	public void setyFromAnchor(int yFromAnchor) {
		this.yFromAnchor = yFromAnchor;
	}
	/**
	 * Gets x from the anchor
	 * @return x from anchor as an integer
	 */
	public int getxFromAnchor() {
		return xFromAnchor;
	}
	/**
	 * Sets the x from the anchor
	 * @param xFromAnchor - distance from anchor in the x direction
	 */
	public void setxFromAnchor(int xFromAnchor) {
		this.xFromAnchor = xFromAnchor;
	}
}