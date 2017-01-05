package boundary.builder;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import entity.builder.IBuilderModel;
import entity.player.Board;
import entity.player.Hint;
import entity.player.Piece;
import entity.player.ReleaseBoard;
import entity.player.ReleaseTile;
import entity.player.Square;
import entity.player.Tile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
/**
 * Handles the drawing of the board entity class.
 * 
* Used some code from the Tangram Project in paint and redraw methods
 * @author Nathan
 * @author Heineman
 */
public class BuilderBoardPanel extends JPanel {

	/** Core model. */
	IBuilderModel model;
	/** around edges. */
	int offset = 20;
	
	/** Size of a tile */
	public final int N = 46;  

	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	Point mouse = null;
	
	/**
	 * sets the point of the mouse so the panel can know where to draw the piece or tile.
	 * @param p
	 */
	public void setMouse(Point p){
		mouse = p;
	}
	
	
	/**
	 * Create the panel.
	 */
	public BuilderBoardPanel(IBuilderModel model) {
		this.model = model;
		
		setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 598, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 598, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}
	
	/**
	 * returns the offScreenGraphics so it can be drawn to elsewhere
	 * @return the off screen graphics object
	 */
	public Graphics getOffscreenGraphics(){
		return offScreenGraphics;
	}
	
	@Override
	public Dimension getMinimumSize() {
		int width = 12*N + 2*offset;
		int height = 12*N + 2*offset;

		return new Dimension (width, height);
	}


	/** 
	 * Swing thing. We must be large enough to draw all Kabasuji pieces. 
	 */
	@Override
	public Dimension getPreferredSize() {
		int width = 16*N + 2*offset;
		int height = 16*N + 2*offset;
		
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

		// draw board.
		g.setColor(new Color(240, 240, 240));
		g.fillRect(0,0,16*N,16*N);
		//draws the board's tiles
		
		
		
		if(model.getBoard() instanceof ReleaseBoard){
			drawReleaseBoard(model.getBoard().getTileArray(), g);
			return;
		}
		else {
		Tile[][] tiles = model.getBoard().getTileArray();
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				Tile tile = tiles[i][j];
				if(tile != null){
					int x = offset + i*N;
					int y = offset + j*N;
					g.setColor(Color.white); 
					g.fillRect(x, y, N, N);
					if(model.getBoard().getPiece(i, j)!= null){
						g.setColor(model.getBoard().getPiece(i, j).getColor());
						g.fillRect(x, y, N, N);		
					}
					//draw the outline of the tile if it exists
					g.setColor(Color.black);
					g.drawRect(offset + i*N, offset + j*N, N, N);
				}
			}
		}
		//draw the hints
				for(Hint h: model.getHints()){
					h.drawHint(g, N, new Point(h.getRow(),h.getColumn()),offset);
				}
		//draw the selected piece at the mouse tip
		Piece selected = model.getBullpen().getSelectedPiece();
		if (selected != null){
			if(mouse!= null){
				drawPiece(g, selected, mouse);
			}
			if(mouse == null){
				drawPiece(g, selected, new Point(offset + N*6, offset + N*6));
			}

		}
		//draw a moving tile at the tip of the mouse
		if(model.getBoard().getMovingTile() && mouse != null){
			g.setColor(Color.white);
			g.fillRect(mouse.x-N/2, mouse.y-N/2, N, N);
			g.setColor(Color.BLACK);
			g.drawRect(mouse.x-N/2, mouse.y-N/2, N, N);
		}
	}
	}
	/**
	 * redraws the offscreenGraphics for double buffering.
	 */
	public void redraw() {

		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);

		Board b = model.getBoard();
		offScreenGraphics.setColor(Color.WHITE);
		offScreenGraphics.fillRect(0, 0, 16*N, 16*N);
		offScreenGraphics.setColor(Color.black);
		if(model.getBoard()instanceof ReleaseBoard){

			drawReleaseBoard( model.getBoard().getTileArray(), offScreenGraphics);

			

			return;
		}
		
		Tile[][] tiles = model.getBoard().getTileArray();
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				if(tiles[i][j] != null)
					offScreenGraphics.drawRect(offset + i*N, offset + j*N, N, N);				
			}
		}
	}
	
	/**
	 * Helper method to draw a piece.
	 * 
	 * This belongs in the boundary class because it is the one drawing the pixels.
	 * 
	 * @param g - the graphics object being drawn to.
	 * @param p - the piece being drawn.
	 * @param point - the location
	 */
	public void drawPiece(Graphics g, Piece p, Point point) {
		Square[] drawn = p.getDependant();
		for(int j = 0; j<6; j++){ 
			Square sq = drawn[j];
			g.setColor(p.getColor());
			g.fillRect(point.x+sq.getX()*N, point.y+sq.getY()*N, N, N);
			g.setColor(Color.black);
			g.drawRect(point.x+sq.getX()*N, point.y+sq.getY()*N, N, N);
		}
	}
	/**
	 * Gets a tile at a specific location.
	 * Note: Returns null if you try to get a tile outside the array bounds.
	 * 
	 * @param p - the point at which you want the tile
	 * @return tile
	 */
	public Tile getTile(Point p){
		int x = (p.x-offset)/N;
		int y = (p.y-offset)/N;
		if(x < 12 && y < 12 && x >= 0 && y >= 0){
		return model.getBoard().getTileArray()[x][y];
		}
		else{ 
			return null;
		}
	}
	/**
	 * Returns row and column in point format corresponding to x,y location.
	 * Note: will return null if the point is not within the 12 by 12 array of tiles.
	 * 
	 * @param p -point at which you want the row, column
	 * @return point where x is the row number and y is the column number
	 */
	public Point getRowCol(Point p){
		int x = (p.x-offset)/N;
		int y = (p.y-offset)/N;
		if(x < 12 && y < 12 && x >= 0 && y >= 0){
		return new Point(x,y);
		}
		else{ 
			return null;
		}
	}
	
	/**
	 * draws the numbers when a release board is the board being drawn.
	 * @param rTiles
	 * @param g
	 */
	public void drawReleaseBoard(Tile[][] rTiles, Graphics g){
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				
				if(rTiles[i][j] != null){
					ReleaseTile tile = (ReleaseTile)rTiles[i][j];
					int x = offset + i*N;
					int y = offset + j*N;
					g.setColor(Color.white);
					g.fillRect(x, y, N, N);

					if(tile.getColor() != null){
						if(tile.getNumber() != null && tile.getNumber() != 0){

							g.setColor(tile.getColor().darker());
							g.setFont(new Font("Default", Font.BOLD, 22));
							g.drawString(tile.getNumber().toString(), x + N/2, y + N/2);
						}}
					if(model.getBoard().getPiece(i, j)!= null){
						g.setColor(model.getBoard().getPiece(i, j).getColor());
						g.fillRect(x, y, N, N);		
					}
					//draw the outline of the tile if it exists
					g.setColor(Color.black);
					g.drawRect(offset + i*N, offset + j*N, N, N);
				}
			}
		}
		//draw the hints
		for(Hint h: model.getHints()){
			h.drawHint(g, N, new Point(h.getRow(),h.getColumn()), offset);
		}
		
		//draw the selected piece at the mouse tip
		Piece selected = model.getBullpen().getSelectedPiece();
		if (selected != null){
			if(mouse!= null){
				drawPiece(g, selected, mouse);
			}
			if(mouse == null){
				drawPiece(g, selected, new Point(offset + N*6, offset + N*6));
			}

		}
		//draw a moving tile at the tip of the mouse
		if(model.getBoard().getMovingTile() && mouse != null){
			g.setColor(Color.white);
			g.fillRect(mouse.x-N/2, mouse.y-N/2, N, N);
			g.setColor(Color.BLACK);
			g.drawRect(mouse.x-N/2, mouse.y-N/2, N, N);

		}
	}
	
	

}