package control.builder;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import entity.player.*;
import boundary.builder.*;

/**
 * Moves the selected piece around on the board panel.
 * 
 * @author Nathan
 *
 */
public class BullpenToBoardController implements MouseMotionListener{

	Board board;
	Bullpen bullpen;
	BuilderBoardPanel boardView;
	BuilderBullpenPanel bullpenPanel;
	/**
	 * Constructor for BullpenToBoardController
	 * @param newboard - Current board
	 * @param newbullpen - Current bullpen
	 * @param newboardPanel - Current board panel
	 * @param newbullpenPanel - Current bullpen panel
	 */
	public BullpenToBoardController(Board newboard, Bullpen newbullpen, BuilderBoardPanel newboardPanel, BuilderBullpenPanel newbullpenPanel){
		board = newboard;
		bullpen = newbullpen;
		boardView = newboardPanel;
		bullpenPanel = newbullpenPanel;
	}
	
	public void move(Piece piece, int col, int row){

	}

	/**
	 * let the board panel know the mouse is in it.
	 * @param me
	 */
	public void mouseEntered(MouseEvent me) {
		boardView.setMouse(me.getPoint());
	}
	
	/**
	 * let the boar panel know the mouse has moved.
	 */
	public void mouseMoved (MouseEvent me) {
		Piece selected = bullpen.getSelectedPiece();
		if (selected == null) { return; }
		Point p = new Point(me.getX() - boardView.N/2, me.getY() - boardView.N/2);
		boardView.setMouse(p);
		boardView.redraw();
		boardView.repaint();
		
	}
	
	/**
	 * let the board panel know the mouse left.
	 * @param me
	 */
	public void mouseExited(MouseEvent me) {
		boardView.setMouse(null);
		boardView.redraw();
		boardView.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
}