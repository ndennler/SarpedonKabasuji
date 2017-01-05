package entity.player;

import junit.framework.TestCase;
import java.awt.Color;
/**
 * Testing for the Piece class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class PieceTest extends TestCase {

	Piece P3;
	protected void setUp() throws Exception {
		super.setUp();
		P3 = new Piece(3,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(-1, 3) );
		
	}


//	public void testPieceSquareArrayIntColor() {
//		Square s1 = new Square(0,1);
//		Square s2 = new Square(0,2);
//		Square s3 = new Square(0,3);
//		Square s4 = new Square(0,4);
//		Square s5 = new Square(0,0);
//		Square[] sqrs = {s1, s2, s3, s4, s5};
//		Piece testPiece = new Piece(sqrs, 5, new Color(0,0,255));
//		
//		assertTrue(testPiece.number == 5);
//		assertTrue(testPiece.)
//	}
	public void testClone() {
		Piece P3 = new Piece(3,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(-1, 3) );
		Piece P3Clone = P3.clone();
		for(int i= 0; i<=5; i++){
			assertTrue(P3.getDependent()[i].getxFromAnchor() == P3Clone.getDependent()[i].getxFromAnchor());
			assertTrue(P3.getDependent()[i].getyFromAnchor() == P3Clone.getDependent()[i].getyFromAnchor());
		}
		assertFalse(P3 == P3Clone);
	}

	public void testShiftDown() {
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
		
		P3.shiftDown(5);
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == -4);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == -3);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == -2);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == -1);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == -2);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == -5);
	}

	public void testCenterPiece() {
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
		
		P3.centerPiece();
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
		
		P3.shiftDown(5);
		P3.centerPiece();
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
		
		Piece T3 = new Piece(3,  new Square(4, 1), new Square(4, 2), new Square(4, 3), new Square(4, 4), new Square(3, 3) );
		T3.centerPiece();
		assertTrue(T3.getDependent()[0].getxFromAnchor() == 2);
		assertTrue(T3.getDependent()[1].getxFromAnchor() == 2);
		assertTrue(T3.getDependent()[2].getxFromAnchor() == 2);
		assertTrue(T3.getDependent()[3].getxFromAnchor() == 2);
		assertTrue(T3.getDependent()[4].getxFromAnchor() == 1);
		assertTrue(T3.getDependent()[5].getxFromAnchor() == -2);
		assertTrue(T3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(T3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(T3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(T3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(T3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(T3.getDependent()[5].getyFromAnchor() == 0);
	}

	public void testGetDependant() {
		Piece P3 = new Piece(3,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(-1, 3) );
		assertTrue(P3.getDependent() == P3.getDependant());
	}

	public void testSetColor() {
		assertTrue(P3.color == null);
		P3.setColor(new Color(0,0,255));
		assertTrue(P3.color.equals(new Color(0,0,255)));
	}

	public void testGetColor() {
		assertTrue(P3.getColor() == null);
		
		P3.setColor(new Color(0,0,255));
		assertTrue(P3.color.equals(P3.getColor()));
	}

	public void testGetBoardStatus() {
		assertFalse(P3.board);
		assertTrue(P3.board == P3.getBoardStatus());
		P3.onBoard();
		assertTrue(P3.board);
		assertTrue(P3.board == P3.getBoardStatus());
	}

	public void testOnBoard() {
		assertFalse(P3.board);
		P3.onBoard();
		assertTrue(P3.board);
		P3.onBoard();
		assertTrue(P3.board);
	}

	public void testOffBoard() {
		assertFalse(P3.board);
		P3.onBoard();
		assertTrue(P3.board);
		P3.offBoard();
		assertFalse(P3.board);
		P3.offBoard();
		assertFalse(P3.board);
	}

	public void testInBullpen() {
		assertFalse(P3.bullpen);
		P3.inBullpen();
		assertTrue(P3.bullpen);
		P3.inBullpen();
		assertTrue(P3.bullpen);
	}

	public void testOutBullpen() {
		assertFalse(P3.bullpen);
		P3.inBullpen();
		assertTrue(P3.bullpen);
		P3.outBullpen();
		assertFalse(P3.bullpen);
		P3.outBullpen();
		assertFalse(P3.bullpen);
	}

	public void testRotateClockwise() {
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
		
		P3.rotateClockwise();
		assertTrue(P3.getDependent()[0].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 1);
		
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 2);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == 1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == -2);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
	}

	public void testRotateCounterClockwise() {
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
		
		P3.rotateCounterClockwise();
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == -1);
		
		assertTrue(P3.getDependent()[3].getxFromAnchor() == -2);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 2);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 0);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 1);
	}

	public void testFlipHorizontal() {
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
		
		P3.flipHorizontal();
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == 1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
	}

	public void testFlipVertical() {
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 4);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 0);
		
		P3.flipVertical();
		assertTrue(P3.getDependent()[0].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[1].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[2].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[3].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getxFromAnchor() == -1);
		assertTrue(P3.getDependent()[5].getxFromAnchor() == 0);
		assertTrue(P3.getDependent()[0].getyFromAnchor() == 3);
		assertTrue(P3.getDependent()[1].getyFromAnchor() == 2);
		assertTrue(P3.getDependent()[2].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[3].getyFromAnchor() == 0);
		assertTrue(P3.getDependent()[4].getyFromAnchor() == 1);
		assertTrue(P3.getDependent()[5].getyFromAnchor() == 4);
	}

//	public void testFits() {
//		Tile t1 = new Tile(0,1);
//		Tile t2 = new Tile(0,2);
//		Tile t3 = new Tile(0,3);
//		Tile t4 = new Tile(0,4);
//		Tile t5 = new Tile(-1,3);
//		Tile t6 = new Tile(0,0);
//		Tile[] testTiles = {t1,t2,t3,t4,t5,t6};
//		assertTrue(P3.fits(testTiles));
//	}

	public void testTileFit() {
		Tile t1 = new Tile(0,0);
		Tile t2 = new Tile(3,4);
		
		Square s1 = new Square(0,0);
		Square s2 = new Square(0,4);
		
		assertTrue(P3.tileFit(t1,s1));
		assertFalse(P3.tileFit(t2, s1));
		assertFalse(P3.tileFit(t1, s2));
	}

}
