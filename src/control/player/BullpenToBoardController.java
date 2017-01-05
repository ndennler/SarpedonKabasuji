package control.player;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import boundary.builder.BuilderBoardPanel;
import boundary.builder.BuilderBullpenPanel;
import bounday.player.PlayerBoardPanel;
import bounday.player.PlayerBullpenPanel;
import entity.player.Board;
import entity.player.Bullpen;
import entity.player.Piece;

/**
 * Moves the bullpen's active piece around in the board panel.
 * Suitable for all Level types.
 * 
 * @author Nathan
 *
 */
public class BullpenToBoardController implements MouseMotionListener{
	
	Board board;
	Bullpen bullpen;
	PlayerBoardPanel boardView;
	PlayerBullpenPanel bullpenPanel;
	/**
	 * Constructor for BullpenToBoardController
	 * @param newboard - Current board
	 * @param newbullpen - Current bullpen
	 * @param newboardPanel - Current board panel
	 * @param newbullpenPanel - Current bullpen panel
	 */
	public BullpenToBoardController(Board newboard, Bullpen newbullpen, PlayerBoardPanel newboardPanel, PlayerBullpenPanel newbullpenPanel){
		board = newboard;
		bullpen = newbullpen;
		boardView = newboardPanel;
		bullpenPanel = newbullpenPanel;
	}
	
	public void move(Piece piece, int col, int row){

	}

	/**
	 * if the mouse entered the board, let the board know.
	 * 
	 * @param me
	 */
	public void mouseEntered(MouseEvent me) {
		boardView.setMouse(me.getPoint());
	}
	
	/**
	 * if the mouse is moved on the board, let the board know.
	 * The board needs to redraw the active piece.
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
	 * tell the board that you left the component.
	 * @param me
	 */
	public void mouseExited(MouseEvent me) {
		boardView.setMouse(null);
		boardView.redraw();
		boardView.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		return;
		
	}
	
}
