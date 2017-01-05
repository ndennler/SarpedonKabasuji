package control.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bounday.player.PlayerBoardPanel;
import entity.player.Level;
import entity.player.Piece;
/**
 * Handles the flipping of an active piece.
 * true -> Vertical Flipping 
 * false -> Horizontal Flipping
 * 
 * @author Nathan
 *
 */
public class FlipController implements ActionListener{
	
	PlayerBoardPanel boardPanel;
	Level model;
	Boolean direction;
	
	/**
	 * Constructor for Flip Controller.
	 * 
	 * @param newBoardPanel - the board panel the piece is being flipped in.
	 * @param l - the level being played.
	 * @param newdirection - the direction for the flip. True is vertical, false is horizontal.
	 */
	public FlipController(PlayerBoardPanel newBoardPanel, Level l, Boolean newdirection){
		boardPanel = newBoardPanel;
		model = l;
		direction = newdirection;
	}

	@Override
	/**
	 * We want to flip a piece if it did not come from the board.
	 * i.e. if it was picked up off the board, it must be returned to the bullpen first.
	 */
	public void actionPerformed(ActionEvent e) {
		
		Piece piece = model.getBullpen().getSelectedPiece();
		if (piece == null){return;}
		if (direction){
			piece.flipVertical();
		} else {
			piece.flipHorizontal();
		}
		model.getBullpen().setSelected(piece);
		boardPanel.redraw();
		boardPanel.repaint();
	}

}
