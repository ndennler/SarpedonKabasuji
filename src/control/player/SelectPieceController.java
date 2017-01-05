package control.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import bounday.player.PlayerBoardPanel;
import bounday.player.PlayerBullpenPanel;
import entity.player.Bullpen;
import entity.player.Level;
import entity.player.Piece;
import entity.player.PuzzleLevel;

/**
 * selects a Piece from the bullpen and adds it to the board panel for moving.
 * Works for 
 * 
 * @author Nathan
 *
 */
public class SelectPieceController extends MouseAdapter {
	Level level;
	PlayerBoardPanel boardView;
	PlayerBullpenPanel bullpenView;
	JLabel movesLeft = null;
	
	/**
	 * Primary constructor.
	 * 
	 * @param l - level that is being played
	 * @param boardv - the board view
	 * @param bullv - the bullpen view
	 */
	public SelectPieceController(Level l, PlayerBoardPanel boardv, PlayerBullpenPanel bullv){
		level = l;
		boardView = boardv;
		bullpenView = bullv;
	}
	/**
	 * Secondary constructor for puzzle levels. 
	 * This is needed because adding a piece back to the bullpen from the board counts as a move.
	 * functionality remains the same for the controller except for the one extra thing.
	 * 
	 * @param l
	 * @param boardv
	 * @param bullv
	 * @param ml
	 */
	public SelectPieceController(Level l, PlayerBoardPanel boardv, PlayerBullpenPanel bullv, JLabel ml){
		level = l;
		boardView = boardv;
		bullpenView = bullv;
		movesLeft = ml;
	}

	/**
	 * If the mouse is pressed we want to select the piece that is being clicked on.
	 * Additionally, if we also have a piece currently selected, we want to put it back in the bullpen.
	 */
	public void mousePressed (MouseEvent me) {
		//first check if there is a selected piece in play, if there is you add it to the bullpen.
		Bullpen bullpen = level.getBullpen();
		Piece selected = bullpen.getSelectedPiece();
		if(selected != null){
			if(movesLeft != null){
				if(selected.getBoardStatus()){
					Integer moves = ((PuzzleLevel)level).getMovesLeft()- 1;
					((PuzzleLevel)level).setMovesLeft(moves);
					movesLeft.setText(moves.toString());
					selected.offBoard();
				}
			}
			bullpen.addPiece(selected);
			bullpen.removeSelected();
			bullpenView.redraw();
			bullpenView.repaint();
			boardView.redraw();
			boardView.repaint();
		}
		Piece p = bullpenView.getPieceAtCoordinate(me.getPoint());
		if(p == null){return;}
		// if this is the selected piece, add it to the bullpen
		bullpen.setSelected(p);
		bullpen.removePiece(p);
		bullpenView.redraw();
		bullpenView.repaint();
		boardView.redraw();
		boardView.repaint();

	}
}
