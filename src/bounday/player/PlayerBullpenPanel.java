package bounday.player;

import javax.swing.JPanel;


import entity.player.Bullpen;
import entity.player.Level;
import entity.player.Piece;
import entity.player.PieceBuilder;
import entity.player.Square;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Draws the pieces that are in the bullpen when playing a level.
 * 
 * Used some code from the Tangram Project in paint and redraw methods
 * @author Nathan
 * @author Heineman
 */
public class PlayerBullpenPanel extends JPanel {

	/**All Pieces in bullpen*/
	Bullpen bullpen;
	PieceBuilder pb = new PieceBuilder();

	/** Core model. */
	Level aLevel; 

	/** around edges. */
	int offsetY = 20;
	int offsetX = 80;

	/** Size of edge of square */
	public final int N = 35;
	//size of panel
	int width = 3000;
	int height = 280;

	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;

	/**
	 * Create the panel.
	 */
	public PlayerBullpenPanel(Bullpen bp) {
		bullpen = bp;

		setBounds(0, 0, width, height);
		setBackground(Color.WHITE);
	}

	/**
	 * sets the pieces in the bullpen panel to the given bullpen.
	 * @param b
	 */
	public void setPieces(Bullpen b){
		bullpen = b;
	}
	@Override
	public Dimension getMinimumSize() {
		return new Dimension (width, height);
	}


	/** 
	 * Swing thing. We must be large enough to draw all Kabasuji pieces. 
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension (width, height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (offScreenImage == null) {
			// create on demand
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width, s.height);
			offScreenGraphics = offScreenImage.getGraphics();

			redraw();
		}

		// if no offscreenImage, then Swing hasn't fully initialized; leave now
		if (offScreenImage == null) {
			System.err.println("Swing not ready for drawing.");
			return;
		}

		// copy image into place.
		g.drawImage(offScreenImage, 0, 0, this);

		//double check if no model (for WindowBuilder)
		if (aLevel == null) { return; }

		//draw background of the panel
		g.setColor(Color.white);
		g.fillRect(0,0,width,height);

		int idx = 0;
		for(Piece p : bullpen.getPieces()){
			drawPiece(g, p, idx);
			idx++;
		}

	}


	/**
	 * Draws screen to the offScreenGraphics.
	 */
	public void redraw() {
		// Once created, draw each, with buffer.

		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);

		//Board b = model.getBoard();
		offScreenGraphics.setColor(Color.WHITE);
		offScreenGraphics.fillRect(0, 0, width, height);

		int idx = 0;
		ArrayList<Piece> pieces = bullpen.getPieces();
		if(pieces != null){
			for(Piece p : pieces){
				drawPiece(offScreenGraphics, p , idx);
				idx++;
			}
		}	
	}

	/** 
	 * Returns piece that is at given point.
	 * note: will also return null if there is no piece at the given point.
	 * 
	 *  @param point - the point at which we are checking for a piece
	 */ 
	public Piece getPieceAtCoordinate(Point point) {
		int i = 0;
		for(Piece p: bullpen.getPieces()){
			for(int j = 0; j<6; j++){
				Square[] drawn = p.getDependant();
				Rectangle r = new Rectangle(getX(i, j, drawn), getY(i, j, drawn), N, N);
				if(r.contains(point)){
					return p;
				}
			}
			i++;
		}
		return null;
	}

	/**
	 * Gets the y position of the squares of the jth square of the idxth shape.
	 * 
	 * @param idx - what number the piece is in the bullpen arraylist of pieces
	 * @param j - the jth square you are drawing
	 * @param drawn - the list of squares that make up the piece.
	 * @return an integer representing the y position of the square, relative to the piece
	 */
	private int getY(int idx, int j, Square[] drawn) {
		return offsetY + drawn[j].getY()*N;
	}

	/**
	 * gets the x position of the squares of the jth square of the idxth shape.
	 * 
	 * @param idx - what number the piece is in the bullpen arraylist of pieces
	 * @param j - the jth square you are drawing
	 * @param drawn - the list of squares that make up the piece.
	 * @return an integer representing the x position of the square, relative to the piece
	 */
	private int getX(int idx, int j, Square[] drawn) {
		return offsetX + idx*7*N + drawn[j].getX()*N;
	}

	/**
	 * Helper method to draw a piece.
	 * 
	 * @param g - the graphics object being drawn to.
	 * @param p - the piece being drawn.
	 * @param i - the number piece it is.
	 */
	private void drawPiece(Graphics g, Piece p, int i) {
		for(int j = 0; j<6; j++){
			Square[] drawn = p.getDependant(); 
			g.setColor(p.getColor());
			g.fillRect(getX(i, j, drawn), getY(i, j, drawn), N, N);
			g.setColor(Color.black);
			g.drawRect(getX(i, j, drawn), getY(i, j, drawn), N, N);
		}
	}

}
