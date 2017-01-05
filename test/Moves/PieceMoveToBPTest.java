package Moves;

import entity.player.Board;
import entity.player.Bullpen;
import entity.player.Piece;
import entity.player.Square;
import junit.framework.TestCase;
/**
 * Testing for the PieceMoveToBP class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class PieceMoveToBPTest extends TestCase {
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
	
	Board brd;
	Bullpen bull;
	protected void setUp() throws Exception {
		super.setUp();
		brd = new Board();
		bull = new Bullpen();
	}
	public void testPieceMoveToBP() {
		PieceMoveToBP vTest = new PieceMoveToBP(0, 1, brd, bull, verticalBar);
		assertTrue(vTest.startX == 0);
		assertTrue(vTest.startY == 1);
		assertTrue(vTest.bP == bull);
		assertTrue(vTest.aPiece == verticalBar);
		
		PieceMoveToBP hTest = new PieceMoveToBP(1, 0, brd, bull, horizontalBar);
		assertTrue(hTest.startX == 1);
		assertTrue(hTest.startY == 0);
		assertTrue(hTest.bP == bull);
		assertTrue(hTest.aPiece == horizontalBar);
	}

	public void testUndo() {
		PieceMoveToBP vTest = new PieceMoveToBP(0, 1, brd, bull, verticalBar);
		assertTrue(vTest.startX == 0);
		assertTrue(vTest.startY == 1);
		assertTrue(vTest.bP == bull);
		assertTrue(vTest.aPiece == verticalBar);
		
		bull.addPiece(verticalBar);
		assertTrue(vTest.undo());
		
		PieceMoveToBP hTest = new PieceMoveToBP(1, 0, brd, bull, horizontalBar);
		assertTrue(hTest.startX == 1);
		assertTrue(hTest.startY == 0);
		assertTrue(hTest.bP == bull);
		assertTrue(hTest.aPiece == horizontalBar);
		
		bull.addPiece(horizontalBar);
		assertTrue(hTest.undo());
	}

}
