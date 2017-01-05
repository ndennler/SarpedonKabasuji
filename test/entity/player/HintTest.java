package entity.player;

import java.awt.Graphics;

import junit.framework.TestCase;
/**
 * Testing for the player.entity Hint class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class HintTest extends TestCase {
	/**Pieces for used in testing */
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );

	/** Hints for testing */
	Hint hint1;
	Hint hint2;
	
	protected void setUp() throws Exception {
		super.setUp();
		hint1 = new Hint(verticalBar,0,0);
		hint2 = new Hint(horizontalBar,6,7);
	}

	/** tests the constructor */
	public void testHint() {
		assertTrue(hint1.piece == verticalBar);
		assertTrue(hint1.row == 0);
		assertTrue(hint1.column == 0);
		
		assertTrue(hint2.piece == horizontalBar);
		assertTrue(hint2.row == 6);
		assertTrue(hint2.column == 7);
	}
	/** tests of the getters */
	public void testGetPiece() {
		assertTrue(hint1.piece == hint1.getPiece());
		assertTrue(hint2.piece == hint2.getPiece());
	}

	public void testGetRow() {
		assertTrue(hint1.row == hint1.getRow());
		assertTrue(hint2.row == hint2.getRow());
	}

	public void testGetColumn() {
		assertTrue(hint1.column == hint1.getColumn());
		assertTrue(hint2.column == hint2.getColumn());
	}
	
	public void testCovers(){
		assertTrue(hint1.covers(0, 0));
		assertTrue(hint1.covers(0, 1));
		//assertFalse(hint1.covers(1, 0));
		
		//assertFalse(hint2.covers(0, 0));
		//assertFalse(hint2.covers(0, 1));
		//assertFalse(hint2.covers(1, 0));
		//assertTrue(hint2.covers(6, 7));
		
	}

}
