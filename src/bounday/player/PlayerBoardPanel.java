package bounday.player;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import entity.player.*;
/**
 * Draws the Board when playing a level.
 * 
 * Used some code from the Tangram Project in paint and redraw methods
 * @author Nathan
 * @author Heineman
 */
public class PlayerBoardPanel extends JPanel {

	/** Core model. */
	Level level;
	
	/** around edges. */
	int offset = 32;
	
	/** Base size of puzzle. */
	public final int N = 55;   // size of the edge of one tile
	
	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	Point mouse = null;

	/**
	 * sets the current mouse location so the panel knows where to draw the moving piec or tile.
	 * @param p - the mouse point.
	 */
	public void setMouse(Point p){
		mouse = p;
	}
	
	/**
	 * Create the panel.
	 */
	public PlayerBoardPanel(Level l) {
		level = l;
		setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		setBackground(Color.WHITE);

	}
	
	@Override
	public Dimension getMinimumSize() {
		int width = 2*N + 2*offset;
		int height = 2*N + 2*offset;

		return new Dimension (width, height);
	}


	/** 
	 * Swing thing. We must be large enough to draw all Kabasuji pieces. 
	 */
	@Override
	public Dimension getPreferredSize() {
		int width = 12*N + 2*offset;
		int height = 12*N + 2*offset;
		
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
		if (level == null) { return; }
		
		if(level.getBoard()instanceof ReleaseBoard){
			drawReleaseBoard(level.getBoard().getTileArray(), g);
			return;
		}

		// draw board.
		g.setColor(new Color(240, 240, 240));
		g.fillRect(0,0,16*N,16*N);
		//draws the board
		Tile[][] tiles = level.getBoard().getTileArray();
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				Tile tile = tiles[i][j];
				if(tile != null){
					g.setColor(Color.white);
					g.fillRect(offset + i*N, offset + j*N, N, N);
					if(level.getBoard().getPiece(i, j)!= null){
						g.setColor(level.getBoard().getPiece(i, j).getColor());
						g.fillRect(offset + i*N, offset + j*N, N, N);
					}
					g.setColor(Color.black);
					g.drawRect(offset + i*N, offset + j*N, N, N);
				}
			}
		}
		//draw the hints
		for(Hint h: level.getHints()){
			h.drawHint(g, N, new Point(h.getRow(), h.getColumn()), offset);
		}

		//draw the selected piece at the mouse tip
		Piece selected = level.getBullpen().getSelectedPiece();
		if (selected != null){
			if(mouse!= null){
				drawPiece(g, selected, mouse);
			}
			if(mouse == null){
				drawPiece(g, selected, new Point(offset + N*6, offset + N*6));
			}

		}
		//draw a moving tile at the tip of the mouse
		if(level.getBoard().getMovingTile() && mouse != null){
			g.setColor(Color.white);
			g.fillRect(mouse.x-N/2, mouse.y-N/2, N, N);
			g.setColor(Color.BLACK);
			g.drawRect(mouse.x-N/2, mouse.y-N/2, N, N);
		}
	}
	
	/***
	 * redraws offscreenGraphics for double buffering.
	 */
	public void redraw() {

		Dimension dim = getPreferredSize();
		if (offScreenGraphics != null) {
			offScreenGraphics.clearRect(0, 0, dim.width, dim.height);
		

			//Board b = level.getBoard();
			offScreenGraphics.setColor(Color.WHITE);
			offScreenGraphics.fillRect(0, 0, 16*N, 16*N);
			offScreenGraphics.setColor(Color.black);
		
			Tile[][] tiles = level.getBoard().getTileArray();

			if(level.getBoard()instanceof ReleaseBoard){
				drawReleaseBoard(level.getBoard().getTileArray(), offScreenGraphics);
				return;
			}

			for(int i = 0; i<12; i++){
				for(int j = 0; j<12; j++){
					if(tiles[i][j] != null)
						offScreenGraphics.drawRect(offset + i*N, offset + j*N, N, N);				
				}
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
	 * Returns row and column in point format corresponding to x,y location.
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
	 * draws the release board and numbers.
	 * @param rTiles - release tiles.
	 * @param g - the graphics object.
	 */
	public void drawReleaseBoard(Tile[][] rTiles, Graphics g){
		for(int i = 0; i<12; i++){
			for(int j = 0; j<12; j++){
				ReleaseTile tile = (ReleaseTile)rTiles[i][j];
				if(tile != null){
					int x = offset + i*N;
					int y = offset + j*N;
					g.setColor(Color.white);
					g.fillRect(x, y, N, N);

					if(tile.getColor() != null){
						
						if(tile.getNumber() != null && tile.getNumber() != 0){
							g.setColor(tile.getColor().darker());
							g.setFont(new Font("Default", Font.BOLD, 22));
							g.drawString(tile.getNumber().toString(), x + N/2, y + N/2);
						}
					}
					if(level.getBoard().getPiece(i, j)!= null){
						g.setColor(level.getBoard().getPiece(i, j).getColor());
						g.fillRect(x, y, N, N);		
					}
					//draw the outline of the tile if it exists
					g.setColor(Color.black);
					g.drawRect(offset + i*N, offset + j*N, N, N);
				}
			}
		}
		//draw the hints
		for(Hint h: level.getHints()){
			h.drawHint(g, N, new Point(h.getRow(),h.getColumn()), offset);
		}
		//draw the selected piece at the mouse tip
		Piece selected = level.getBullpen().getSelectedPiece();
		if (selected != null){
			if(mouse!= null){
				drawPiece(g, selected, mouse);
			}
			if(mouse == null){
				drawPiece(g, selected, new Point(offset + N*6, offset + N*6));
			}

		}
		//draw a moving tile at the tip of the mouse
		if(level.getBoard().getMovingTile() && mouse != null){
			g.setColor(Color.white);
			g.fillRect(mouse.x-N/2, mouse.y-N/2, N, N);
			g.setColor(Color.BLACK);
			g.drawRect(mouse.x-N/2, mouse.y-N/2, N, N);

		}
	}

}
