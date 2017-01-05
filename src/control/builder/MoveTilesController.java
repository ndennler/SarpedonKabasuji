package control.builder;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entity.builder.IBuilderModel;
import entity.player.*;

import javax.swing.*;

import Moves.TileMove;
import boundary.builder.BuilderBoardPanel;
/**
 * controls the movement of the board tiles from one location to another.
 * 
 * @author Nathan
 *
 */
public class MoveTilesController extends MouseAdapter {

	BuilderBoardPanel boardView;
	IBuilderModel model;
	JRadioButton moveTiles;
	Point origin;
	Tile startTile;
	/**
	 * Constructor for MoveTilesController
	 * @param m - Current model
	 * @param newboard - Current board
	 * @param movingTiles - tile movement button
	 */
	public MoveTilesController(IBuilderModel m, BuilderBoardPanel newboard, JRadioButton movingTiles){
		boardView = newboard;
		model = m;
		moveTiles = movingTiles;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {	
		return;
	}

	@Override
	/**
	 * Select the tile to move at the clicked point.
	 * will not select the tile if it's covered by the piece.
	 */
	public void mousePressed(MouseEvent e) {
		if(moveTiles.isSelected()){
			Board b = model.getBoard();
			Tile t = boardView.getTile(e.getPoint());
			if(t == null){return;}
			if(t.getCoveredBy() != null){return;}
			origin = new Point(t.getRow(), t.getColumn());
			b.removeTile(t.getRow(),t.getColumn());
			b.setMovingTile(true);
			 startTile = t;
		}
		
	}

	@Override
	/**
	 * place the tile on the board somewhere.
	 * if it is not valid, it will put it back where it came from.
	 */
	public void mouseReleased(MouseEvent e) {
		if(moveTiles.isSelected() && model.getBoard().getMovingTile()){
			Point rowCol = boardView.getRowCol(e.getPoint());
			
			Tile t = new Tile(origin.x, origin.y);
			if(model.getBoard() instanceof ReleaseBoard){
				t = new ReleaseTile(origin.x, origin.y, null, null);
			}
			
			if(rowCol != null){
				
				Tile aT = model.getBoard().getTile(rowCol.x, rowCol.y);
				
				
				if(aT == null){
					t = new Tile(rowCol.x, rowCol.y);
					if(model.getBoard() instanceof ReleaseBoard){
						t = new ReleaseTile(rowCol.x, rowCol.y, null, null);
					}
					
					//this is a valid place to put a tile
					model.getBoard().setTile(t);
					TileMove T = new TileMove(startTile,t,model.getBoard());
					model.addMove(T);
				}
				else {
					//trying to place a tile on an already existing tile.
					//also if you are trying to place a piece outside the range of the board.
					model.getBoard().setTile(t);
				}
				
			}
			else {
				//trying to place a tile on an already existing tile.
				//also if you are trying to place a piece outside the range of the board.
				model.getBoard().setTile(t);
			}
			model.getBoard().setMovingTile(false);
			boardView.setMouse(null);
			boardView.redraw();
			boardView.repaint();
		}

	}
	/**
	 * Update the location of the tile.
	 */
	public void mouseDragged(MouseEvent e){
		boardView.setMouse(e.getPoint());
		boardView.redraw();
		boardView.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		return;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(model.getBoard().getMovingTile()){
			Tile t = new Tile(origin.x, origin.y);
			if(model.getBoard() instanceof ReleaseBoard){
				t = new ReleaseTile(origin.x, origin.y, null, null);
			}

			model.getBoard().setMovingTile(false);
			model.getBoard().setTile(t);
		}
	}


	
}