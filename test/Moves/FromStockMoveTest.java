package Moves;

import entity.player.Bullpen;
import entity.player.Piece;
import entity.player.Square;
import junit.framework.TestCase;
/**
 * Testing for the FromStockMove class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class FromStockMoveTest extends TestCase {
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
	
	Bullpen bp;
	protected void setUp() throws Exception {
		super.setUp();
		bp = new Bullpen();
	}

	public void testFromStockMove() {
		FromStockMove vTest = new FromStockMove(bp, verticalBar);
		assertTrue(vTest.bP == bp);
		assertTrue(vTest.aPiece == verticalBar);
		
		FromStockMove hTest = new FromStockMove(bp, horizontalBar);
		assertTrue(hTest.bP == bp);
		assertTrue(hTest.aPiece == horizontalBar);
	}

	public void testUndo() {
		FromStockMove vTest = new FromStockMove(bp, verticalBar);
		assertTrue(vTest.bP == bp);
		assertTrue(vTest.aPiece == verticalBar);
		
		bp.addPiece(verticalBar);
		assertTrue(vTest.undo());
		
		FromStockMove hTest = new FromStockMove(bp, horizontalBar);
		assertTrue(hTest.bP == bp);
		assertTrue(hTest.aPiece == horizontalBar);
		
		bp.addPiece(horizontalBar);
		assertTrue(hTest.undo());
	}

}
