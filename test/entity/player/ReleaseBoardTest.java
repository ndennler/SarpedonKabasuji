package entity.player;

import junit.framework.TestCase;
/**
 * Testing for the player.entity ReleaseBoard class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class ReleaseBoardTest extends TestCase {
	/** a 12 x 12 ReleaseTile array */
	ReleaseTile[][] shapeFull;
	/** a 13 x 13 ReleaseTile array */
	ReleaseTile[][] bigShape;
	/** a 0 x 0 ReleaseTile array */
	ReleaseTile[][] minShape;
	
	/** a Release Board to do testing on */
	ReleaseBoard rb;
	/** a Piece to be used for testing */
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	
	protected void setUp() throws Exception {
		super.setUp();
		shapeFull = new ReleaseTile[12][12];
		for(int i=0; i< 12; i++){
			for(int j =0; j<12;j++){
				shapeFull[i][j]	= new ReleaseTile(i,j, null, null);
			}
		}
		bigShape = new ReleaseTile[13][13];
		for(int i=0; i< 12; i++){
			for(int j =0; j<12;j++){
				shapeFull[i][j]	= new ReleaseTile(i,j, null, null);
			}
		}
		minShape = new ReleaseTile[0][0];
		
		rb = new ReleaseBoard(shapeFull);
		
	}

	public void testRemovePiece() {
		rb.addPiece(0, 0, verticalBar);
		assertFalse(rb.removePiece(0, 0));
	}

	public void testMovePiece() {
		rb.addPiece(0, 0, verticalBar);
		assertFalse(rb.movePiece(0, 0, 2, 2));
	}

	public void testReleaseBoard() {
		assertTrue(rb.movingTile == false);
		assertTrue(rb.pieces.isEmpty());
		assertTrue(rb.shape == shapeFull);
		assertTrue(((ReleaseTile)rb.shape[0][0]).rcolor==null);
		assertTrue(((ReleaseTile)rb.shape[0][0]).rnumber== null);
		
		Board bigBoard;
		Board minBoard;
		boolean thrown = false;
		// Too big
		try {
			bigBoard = new ReleaseBoard(bigShape);
		} catch (RuntimeException e) {
			thrown = true;
		}
		// Too small
		try {
			minBoard = new ReleaseBoard(minShape);
		} catch (RuntimeException e) {
			thrown = true;
		}
		  assertTrue(thrown);
	}
	
	public void testRemoveTile(){
		assertTrue(rb.shape[0][0] instanceof Tile);
		rb.removeTile(0, 0);
		assertTrue(rb.shape[0][0] == null);
	}

}
