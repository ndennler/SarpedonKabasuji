package control.player;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bounday.player.PlayerBoardPanel;
import entity.player.Piece;
import entity.player.ReleaseLevel;
import entity.player.ReleaseTile;
import entity.player.Square;
/**
 * Controller for placing a release piece on the board and updating the star count.
 * -piece may cover numbers
 * -piece may not be picked up once it is placed.
 * @author Nathan
 *
 */
public class PlaceReleasePieceController implements MouseListener{

	ReleaseLevel model;
	PlayerBoardPanel boardView;
	/** an array of the labels that describe the number of red blue and green numbers covered. In that order.*/
	JLabel[] rgbCovered;
	JLabel stars;
	/**
	 * Constructor for PlaceReleasePieceController
	 * @param m - Current Release Level
	 * @param b - Current Player Board Panel
	 * @param rgb - Array of labels to describe the numbers covered
	 * @param s - Current stars
	 */
	public PlaceReleasePieceController(ReleaseLevel m, PlayerBoardPanel b, JLabel[] rgb, JLabel s){
		model = m;
		boardView = b;
		rgbCovered = rgb;
		stars = s;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		return;
		
	}
	/**
	 * Handles the placing of a release piece when the mouse is pressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		//only do this if you are left clicking
		if(e.getButton() == MouseEvent.BUTTON1){
			Piece adding = model.getBullpen().getSelectedPiece();
			Point clicked = boardView.getRowCol(e.getPoint());
			if(adding != null && clicked != null){
				//the piece may be placed.
				if(model.getBoard().addPiece(clicked.x, clicked.y, adding)){
					//you are successfully placing a piece.
					model.getBullpen().getSelectedPiece().onBoard();
					for(Square s: adding.getDependant()){
						ReleaseTile t = (ReleaseTile) model.getBoard().getTile(clicked.x + s.getX(), clicked.y + s.getY());
						if(t.getColor() != null && t.getNumber() > 0){
							model.setCovered(t.getNumber(), t.getColor());
						}
					}
					model.getBullpen().removeSelected();
					boardView.redraw();
					boardView.repaint();
					model.updateStars();
				}
			}
			rgbCovered[0].setText(model.getText(Color.red));
			rgbCovered[1].setText(model.getText(Color.green));
			rgbCovered[2].setText(model.getText(Color.blue));
			
			if(model.getStars() == 0){
				stars.setIcon(null);
			}
			if(model.getStars() == 1){
				stars.setIcon(new ImageIcon(PlacePuzzlePieceController.class.getResource("/images/OneStar.png")));
			}
			if(model.getStars() == 2){
				stars.setIcon(new ImageIcon(PlacePuzzlePieceController.class.getResource("/images/TwoStars.png")));
			}
			if(model.getStars() == 3){
				stars.setIcon(new ImageIcon(PlacePuzzlePieceController.class.getResource("/images/ThreeStars.png")));
			}
		}

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
