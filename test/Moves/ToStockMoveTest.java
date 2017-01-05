package Moves;

import entity.player.Board;
import entity.player.Bullpen;
import entity.player.Piece;
import entity.player.Square;
import junit.framework.TestCase;
/**
 * Testing for the ToStockMove class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class ToStockMoveTest extends TestCase {
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
	
	Bullpen bull;
	
	protected void setUp() throws Exception {
		super.setUp();
		bull = new Bullpen();
	}
	
	public void testToStockMove() {
		ToStockMove vTest = new ToStockMove(bull, verticalBar);
		assertTrue(vTest.bP == bull);
		assertTrue(vTest.aPiece == verticalBar);
		
		ToStockMove hTest = new ToStockMove(bull, horizontalBar);
		assertTrue(hTest.bP == bull);
		assertTrue(hTest.aPiece == horizontalBar);
	}

	public void testUndo() {
		ToStockMove vTest = new ToStockMove(bull, verticalBar);
		assertTrue(vTest.bP == bull);
		assertTrue(vTest.aPiece == verticalBar);
		assertTrue(vTest.undo());
		
		ToStockMove hTest = new ToStockMove(bull, horizontalBar);
		assertTrue(hTest.bP == bull);
		assertTrue(hTest.aPiece == horizontalBar);
		assertTrue(hTest.undo());
	}

}
