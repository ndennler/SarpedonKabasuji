package entity.player;

import junit.framework.TestCase;
/**
 * Testing for the player.entity LightningBoard class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class LightningBoardTest extends TestCase {
	/** a 12 x 12 Tile array */
	Tile[][] shapeFull;
	/** a 12 x 12 Tile array with odd rows empty */
	Tile[][] shapeOddsEmpty;
	
	/** pieces for use in testing */
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );

	/** Sets up shape arrays for use in testing */
	protected void setUp() throws Exception {
		super.setUp();
		shapeFull = new Tile[12][12];
		for(int i=0; i< 12; i++){
			for(int j =0; j<12;j++){
				shapeFull[i][j]	= new Tile(i,j);
			}
		}
		
		shapeOddsEmpty = new Tile[12][12];
		for(int i=0; i< 12; i++){
			for(int j =0; j<12;j++){
				if (i%2 ==0){
					shapeOddsEmpty[i][j] = new Tile(i,j);
				} else {
					shapeOddsEmpty[i][j] = null;
				}
			}
		}
	
	}	
	
	public void testAvailableTile() {
		LightningBoard lB = new LightningBoard();
		assertFalse(lB.availableTile(-1, 0));
		assertFalse(lB.availableTile(0, -1));
		assertFalse(lB.availableTile(12, 0));
		assertFalse(lB.availableTile(0, 12));
		
		assertTrue(lB.availableTile(0, 0));
		assertTrue(lB.availableTile(11, 11));
		assertTrue(lB.availableTile(6, 6));
		
		LightningBoard lBOddsEmpty = new LightningBoard(shapeOddsEmpty);
		assertFalse(lBOddsEmpty.availableTile(-1, 0));
		assertFalse(lBOddsEmpty.availableTile(0, -1));
		assertFalse(lBOddsEmpty.availableTile(12, 0));
		assertFalse(lBOddsEmpty.availableTile(0, 12));
		assertFalse(lBOddsEmpty.availableTile(1, 0));
		assertFalse(lBOddsEmpty.availableTile(11, 11));
		
		assertTrue(lBOddsEmpty.availableTile(0, 0));
		assertTrue(lBOddsEmpty.availableTile(2, 0));
		assertTrue(lBOddsEmpty.availableTile(6, 6));
	}

	public void testAddPiece() {
		LightningBoard b = new LightningBoard();
		assertTrue(b.addPiece(0, 0, verticalBar));
		assertTrue(b.addPiece(0, 0, horizontalBar));
		assertTrue(b.addPiece(6, 0, horizontalBar));
		
		LightningBoard oddLightningBoard = new LightningBoard(shapeOddsEmpty);
		//horizontal pieces should not be playable on this LightningBoard
		assertFalse(oddLightningBoard.addPiece(0, 0, horizontalBar));
		assertFalse(oddLightningBoard.addPiece(1, 0, horizontalBar));
		assertFalse(oddLightningBoard.addPiece(0, 1, horizontalBar));
		
		//testing vertical pieces
		assertTrue(oddLightningBoard.addPiece(0, 0, verticalBar));
		//there is now a piece in the top corner but overlaps allowed
		assertTrue(oddLightningBoard.addPiece(0, 5, verticalBar));
		assertTrue(oddLightningBoard.addPiece(0, 6, verticalBar));
		//this row should not be playable
		assertFalse(oddLightningBoard.addPiece(1, 0, verticalBar));
		//should overlap edge of LightningBoard
		assertFalse(oddLightningBoard.addPiece(2, 7, verticalBar));
	}

	public void testRemovePiece() {
		LightningBoard lB = new LightningBoard();
		assertFalse (lB.removePiece(0, 0));
		assertTrue(lB.addPiece(0, 0, verticalBar));
		assertTrue(lB.getPiece(0, 0) != null);
		
		assertFalse(lB.removePiece(7, 7));
		assertTrue(lB.removePiece(0, 0));
		assertTrue(lB.getPiece(0, 0) == null);
		
		LightningBoard oddBoard = new LightningBoard(shapeOddsEmpty);
		assertFalse(oddBoard.removePiece(1, 0));
		assertTrue(oddBoard.addPiece(0, 0, verticalBar));
		assertTrue(oddBoard.removePiece(0, 0));
	}

	public void testMovePiece() {
		LightningBoard lB = new LightningBoard();
		assertTrue(lB.addPiece(0, 0, verticalBar));
		assertTrue(lB.getPiece(0, 0) != null);
		
		Piece testPiece = lB.getPiece(0, 0);
		assertTrue(lB.pieces.get(lB.shape[0][0].getCoveredBy()) == testPiece);
		
		assertFalse(lB.movePiece(7, 7, 6, 6));
		assertFalse(lB.movePiece(0, 0, 7, 7));
		assertFalse(lB.movePiece(0, 0, 6, 6));
		assertFalse(lB.getPiece(0, 0) == null);
		assertFalse(lB.getPiece(6, 6) != null);
		assertFalse(lB.pieces.get(lB.shape[6][6].getCoveredBy()) == testPiece);
	}

	public void testSpacesLeft() {
		LightningBoard lB = new LightningBoard();
		assertTrue(lB.spacesLeft() == 144);
		assertTrue(lB.addPiece(0, 0, verticalBar));
		assertTrue(lB.getPiece(0, 0) != null);
		assertTrue(lB.spacesLeft() == 138);
		
		LightningBoard oddBoard = new LightningBoard(shapeOddsEmpty);
		assertTrue(oddBoard.spacesLeft() == 72);
	}

}
