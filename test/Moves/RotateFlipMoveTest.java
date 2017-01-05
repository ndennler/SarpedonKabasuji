package Moves;

import entity.player.Bullpen;
import entity.player.Piece;
import entity.player.Square;
import junit.framework.TestCase;
/**
 * Testing for the RotateFlipMove
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class RotateFlipMoveTest extends TestCase {
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
	
	Bullpen testBull;
	protected void setUp() throws Exception {
		super.setUp();
		testBull = new Bullpen();
	}

	public void testRotateFlipMove() {
		RotateFlipMove vCtest = new RotateFlipMove(verticalBar, "Clockwise");
		assertTrue(vCtest.aPiece == verticalBar);
		assertTrue(vCtest.Type.equals("Clockwise"));
		RotateFlipMove hCNtest = new RotateFlipMove(horizontalBar, "Counter");
		assertTrue(hCNtest.aPiece == horizontalBar);
		assertTrue(hCNtest.Type.equals("Counter"));
		RotateFlipMove vVtest = new RotateFlipMove(verticalBar, "Horizontal");
		assertTrue(vVtest.aPiece == verticalBar);
		assertTrue(vVtest.Type.equals("Horizontal"));
		RotateFlipMove hHtest = new RotateFlipMove(horizontalBar, "Vertical");
		assertTrue(hHtest.aPiece == horizontalBar);
		assertTrue(hHtest.Type.equals("Vertical"));
		
	}

	public void testUndo() {
		RotateFlipMove vCtest = new RotateFlipMove(verticalBar, "Clockwise");
		assertTrue(vCtest.aPiece == verticalBar);
		assertTrue(vCtest.Type.equals("Clockwise"));
		verticalBar.rotateClockwise();
		assertTrue(vCtest.undo());
		
		RotateFlipMove hCNtest = new RotateFlipMove(horizontalBar, "Counter");
		assertTrue(hCNtest.aPiece == horizontalBar);
		assertTrue(hCNtest.Type.equals("Counter"));
		horizontalBar.rotateClockwise();
		assertTrue(hCNtest.undo());
		
		RotateFlipMove vVtest = new RotateFlipMove(verticalBar, "Horizontal");
		assertTrue(vVtest.aPiece == verticalBar);
		assertTrue(vVtest.Type.equals("Horizontal"));
		verticalBar.rotateClockwise();
		assertTrue(vVtest.undo());
		
		RotateFlipMove hHtest = new RotateFlipMove(horizontalBar, "Vertical");
		assertTrue(hHtest.aPiece == horizontalBar);
		assertTrue(hHtest.Type.equals("Vertical"));
		horizontalBar.rotateClockwise();
		assertTrue(hHtest.undo());
	}

}
