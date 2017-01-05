package boundary.builder;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.border.LineBorder;


import entity.player.Bullpen;

import entity.builder.IBuilderModel;
import entity.player.Piece;
import entity.player.PieceBuilder;
import entity.player.Square;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
/**
 * Draws the bullpen and contents when building a level.
 * 
 * Used some code from the Tangram Project in paint and redraw methods
 * @author Nathan
 * @author Heineman
 */
public class BuilderBullpenPanel extends JPanel {


	/**All Pieces in bullpen*/
	Bullpen bullpen;
	PieceBuilder pb = new PieceBuilder();

	/** Core model. */
	IBuilderModel model; 

	/** around edges. */
	int offsetY = 20;
	int offsetX = 50;

	/** Size of edge of square */
	public final int N = 16;
	//size of panel
	int width = 1210;
	int height = 130;

	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;

	/**
	 * Create the panel.
	 */
	public BuilderBullpenPanel(Bullpen bp) {
		bullpen = bp;

		setBounds(0, 0, width, height);
		setBackground(Color.WHITE);
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
		if (model == null) { return; }

		// draw the background.
		g.setColor(Color.white);
		g.fillRect(0,0,width,height);
		//draw all the pieces
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
		for(Piece p : bullpen.getPieces()){
			drawPiece(offScreenGraphics, p , idx);
			idx++;
		}	
	}

	/** 
	 * returns piece that is at given point.
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

	private int getY(int idx, int j, Square[] drawn) {
		return offsetY + drawn[j].getY()*N;
	}


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
