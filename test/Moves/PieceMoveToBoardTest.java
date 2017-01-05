package Moves;

import entity.player.Board;
import entity.player.Bullpen;
import entity.player.Piece;
import entity.player.Square;
import junit.framework.TestCase;
/**
 * Testing for the PieceMoveToBoard class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class PieceMoveToBoardTest extends TestCase {
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
	
	Board brd;
	Bullpen bull;
	protected void setUp() throws Exception {
		super.setUp();
		brd = new Board();
		bull = new Bullpen();
	}

	public void testPieceMoveToBoard() {
		PieceMoveToBoard vTest = new PieceMoveToBoard(0, 1, brd, bull, verticalBar);
		assertTrue(vTest.endX == 0);
		assertTrue(vTest.endY == 1);
		assertTrue(vTest.bP == bull);
		assertTrue(vTest.aPiece == verticalBar);
		
		PieceMoveToBoard hTest = new PieceMoveToBoard(1, 0, brd, bull, horizontalBar);
		assertTrue(hTest.endX == 1);
		assertTrue(hTest.endY == 0);
		assertTrue(hTest.bP == bull);
		assertTrue(hTest.aPiece == horizontalBar);
	}

	public void testUndo() {
		PieceMoveToBoard vTest = new PieceMoveToBoard(0, 1, brd, bull, verticalBar);
		assertTrue(vTest.endX == 0);
		assertTrue(vTest.endY == 1);
		assertTrue(vTest.bP == bull);
		assertTrue(vTest.aPiece == verticalBar);
		
		brd.addPiece(0, 1, verticalBar);
		assertTrue(vTest.undo());
		
		PieceMoveToBoard hTest = new PieceMoveToBoard(1, 0, brd, bull, horizontalBar);
		assertTrue(hTest.endX == 1);
		assertTrue(hTest.endY == 0);
		assertTrue(hTest.bP == bull);
		assertTrue(hTest.aPiece == horizontalBar);
		
		brd.addPiece(1, 0, horizontalBar);
		assertTrue(hTest.undo());
	}

}
