package boundary.builder;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.border.LineBorder;

import entity.builder.IBuilderModel;
import entity.player.Piece;
import entity.player.PieceBuilder;
import entity.player.Square;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * draws the stock panel which consists of all possible Kabasuji Pieces.
 * 
 * Used some code from the Tangram Project in paint and redraw methods
 * @author Nathan
 * @author Heineman
 */
public class BuilderStockPanel extends JPanel {
	
	/**All possible Pieces*/
	PieceBuilder pieces = new PieceBuilder();
	
	/** Core model. */
	IBuilderModel model; 
	
	/** around edges. */
	int offsetY = 20;
	int offsetX = 60;
	
	/** Size of edge of square */
	public final int N = 20;
	//size of panel
	int width = 280;
	int height = 2500;
	//colors the pieces can be
	
	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	
	/**
	 * Create the panel.
	 */
	public BuilderStockPanel() {
		
		setBounds(0,0,width,height);
		setBorder(null);
		setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 301, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1051, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

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
	
	/** gets the x position of the j square of the ith piece in the stock*/
	private int getX(int i, int j, Square[] drawn){
		//modulus 2 is the number of columns of pieces
		return offsetX + ((i-1)%2)*7*N + drawn[j].getX()*N;	
	}
	/** gets the y position of the j square of the ith piece in the stock*/
	private int getY(int i, int j, Square[] drawn){
		//(i-1)/2 is due to the two columns as well
		return offsetY + (i-1)/2*7*N + drawn[j].getY()*N;
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
		
		// draw active polygon.
			g.setColor(Color.white);
			g.fillRect(0,0,width,height);
			
			for(int i = 1; i<36; i++){
				Piece p = pieces.getPiece(i);
				drawPiece(g, p, i);
			}

	}
	/**
	 * redraws the offScreenGraphics for double buffering.
	 */
	public void redraw() {
		// Once created, draw each, with buffer.

		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);

		//Board b = model.getBoard();
		offScreenGraphics.setColor(Color.WHITE);
		offScreenGraphics.fillRect(0, 0, width, height);
		for(int i = 1; i<36; i++){
			Piece p = pieces.getPiece(i);
			drawPiece(offScreenGraphics, p, i);

		}
	}

	/** returns piece that is at given point, or null if the point does not contain a piece*/ 
	public Piece getPieceAtCoordinate(Point point) {
		for(int i = 1; i<36; i++){
			for(int j = 0; j<6; j++){
				Square[] drawn = pieces.getPiece(i).getDependant();
				Rectangle r = new Rectangle(getX(i, j, drawn), getY(i, j, drawn), N, N);
				if(r.contains(point)){
					return pieces.getPiece(i);
				}
			}
		}
		return null;
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
