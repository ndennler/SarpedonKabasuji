package control.builder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Moves.FromStockMove;
import boundary.builder.BuilderBullpenPanel;
import boundary.builder.BuilderStockPanel;
import entity.builder.IBuilderModel;
import entity.player.Bullpen;
import entity.player.Piece;
/**
 * adds a piece from the stock to the bullpen for use in level builder.
 * 
 * @author Nathan
 *
 */
public class AddPieceToBullpenController extends MouseAdapter {

	BuilderStockPanel stock;
	BuilderBullpenPanel bullpenView;
	Bullpen bullpen;
	IBuilderModel aModel;
	/**
	 * Constructor for AddPieceToBullpenController
	 * @param bp - Current bullpen
	 * @param s - current stock panel
	 * @param bv - current bullpen panel
	 * @param aModel - current builder model
	 */
	public AddPieceToBullpenController(Bullpen bp, BuilderStockPanel s, BuilderBullpenPanel bv, IBuilderModel aModel){
		stock = s;
		bullpen = bp;
		bullpenView = bv;
		this.aModel = aModel;
	}
	
	/**
	 * adds the piece at the point clicked, or adds nothing if there is not piece at the point.
	 */
	public void mousePressed (MouseEvent me) {
		Piece p = stock.getPieceAtCoordinate(me.getPoint());
		if(p == null){
			return;
		}
		IMove aMove = new FromStockMove(bullpen,p);
		aModel.addMove(aMove);
		// if this is the selected piece, add it to the bullpen
		bullpen.addPiece(p);
		bullpenView.redraw();
		bullpenView.repaint();
	}
	
}
