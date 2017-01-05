package control.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import boundary.builder.BuilderBoardPanel;
import bounday.player.PlayerBoardPanel;
import bounday.player.PlayerBullpenPanel;
import entity.builder.IBuilderModel;
import entity.player.Level;
import entity.player.Piece;
/**
 * Handles rotation of an active piece.
 * True -> Counter Clockwise Rotation
 * False -> Clockwise Rotation.
 * 
 * @author Nathan
 *
 */
public class RotateController implements ActionListener{

	Level model;
	PlayerBoardPanel boardPanel;
	boolean direction;
	
	/**
	 * Constructor for rotation controller.
	 * 
	 * @param newBoardPanel - the board view.
	 * @param l - the level being played.
	 * @param newdirection - direction of rotation. true means clockwise, false means counter clockwise.
	 */
	public RotateController(PlayerBoardPanel newBoardPanel, Level l, Boolean newdirection){
		boardPanel = newBoardPanel;
		model = l;
		direction = newdirection;
	}

	@Override
	/**
	 * We want to rotate the piece, but only if it didn't come from the board.
	 * i.e. if you want to rotate a piece on the board you have to put it in the bullpen first.
	 */
	public void actionPerformed(ActionEvent e) {
		Piece piece = model.getBullpen().getSelectedPiece();
		if (piece == null){return;}
		if(!piece.getBoardStatus()){
		if (direction){
			piece.rotateCounterClockwise();
		} else {
			piece.rotateClockwise();
		}
		model.getBullpen().setSelected(piece);
		boardPanel.redraw();
		boardPanel.repaint();
		}
		
	}

}
