package entity.player;

import junit.framework.TestCase;
/**
 *  Tests for the entity.player.Board class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class BoardTest extends TestCase {
	/** a 12 x 12 Tile array */
	Tile[][] shapeFull;
	/** a 12 x 12 Tile array with odd rows empty */
	Tile[][] shapeOddsEmpty;
	/** a 13 x 13 Tile array */
	Tile[][] bigShape;
	/** a 6 x 6 Tile array */
	Tile[][] mediumShape;
	/** a 0 x 0 Tile array */
	Tile[][] minShape;
	
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
					shapeOddsEmpty[i][j]	= new Tile(i,j);
				} else {
					shapeOddsEmpty[i][j] = null;
				}
			}
		}
		
		bigShape = new Tile[13][13];
		for(int i=0; i< 12; i++){
			for(int j =0; j<12;j++){
				shapeFull[i][j]	= new Tile(i,j);
			}
		}
		
		mediumShape = new Tile[6][6];
		for(int i=0; i< 6; i++){
			for(int j =0; j<6;j++){
				shapeFull[i][j]	= new Tile(i,j);
			}
		}
		minShape = new Tile[0][0];
	}
	/** tests the default Board constructor */
	public void testBoard() {
		// call the constructor with no arguments
		Board b = new Board();
		// check size of shape array
		assertTrue(b.shape.length == 12);
		assertTrue(b.shape[0].length == 12);
		// check hash is initialized empty
		assertTrue(b.pieces.isEmpty());
	}

	/** tests the general Board constructor */
	public void testBoardTileArrayArray() {
		//Using the default Tile array
		Board fullBoard = new Board(shapeFull);
		// check size of shape array
		assertTrue(fullBoard.shape.length == 12);
		assertTrue(fullBoard.shape[0].length == 12);
		// check hash is initialized empty
		assertTrue(fullBoard.pieces.isEmpty());
		
		//Using a tile array with nulls
		Board oddBoard = new Board(shapeOddsEmpty);
		// check size of shape array
		assertTrue(oddBoard.shape.length == 12);
		assertTrue(oddBoard.shape[0].length == 12);
		// check hash is initialized empty
		assertTrue(oddBoard.pieces.isEmpty());
		for(int i=0; i< 12; i++){
			for(int j =0; j<12;j++){
				if (i%2 !=0){
					assertTrue(oddBoard.shape[i][j] == null); // check odds are null
				} else {
					assertTrue(oddBoard.shape[i][j] instanceof Tile); // check evens are Tiles
				}
			}
		}
		
		//Using an intermediate size Tile array
		Board mediumBoard = new Board (mediumShape);
		// check size of shape array
		assertTrue(mediumBoard.shape.length == 6);
		assertTrue(mediumBoard.shape[0].length == 6);
		// check hash is initialized empty
		assertTrue(mediumBoard.pieces.isEmpty());
		
		//Testing that exceptions are thrown appropriately when Tile array is not within the specification
		Board bigBoard;
		Board minBoard;
		boolean thrown = false;
		// Too big
		try {
			bigBoard = new Board(bigShape);
		} catch (RuntimeException e) {
			thrown = true;
		}
		// Too small
		try {
			minBoard = new Board(minShape);
		} catch (RuntimeException e) {
			thrown = true;
		}
		  assertTrue(thrown);
	}
	
	public void testGetPiece() {
		Board b = new Board();
		assertTrue(b.getPiece(0, 0) == null);
		b.addPiece(0, 0, horizontalBar);
		assertTrue(b.getPiece(0, 0) instanceof Piece);
		Piece testPiece = b.getPiece(0, 0);
		assertTrue(b.pieces.get(b.shape[0][0].getCoveredBy()) == testPiece);
		
		Board oddBoard = new Board(shapeOddsEmpty);
		assertTrue(oddBoard.getPiece(1, 0) == null);
				
	}

	public void testGetTileArray() {
		Board b = new Board();
		Tile[][] test = b.getTileArray();
		assertTrue(test.length == 12);
		assertTrue(test[0].length == 12);
		
		Board oddBoard = new Board(shapeOddsEmpty);
		Tile[][] test2 = oddBoard.getTileArray();
		assertTrue(test2.length == 12);
		assertTrue(test2[0].length == 12);
		assertTrue(test2[1][0] == null);
		assertTrue(test2[0][0] instanceof Tile);
	}

	public void testAvailableTile() {
		Board b = new Board();
		assertFalse(b.availableTile(-1, 0));
		assertFalse(b.availableTile(0, -1));
		assertFalse(b.availableTile(12, 0));
		assertFalse(b.availableTile(0, 12));
		
		assertTrue(b.availableTile(0, 0));
		assertTrue(b.availableTile(11, 11));
		assertTrue(b.availableTile(6, 6));
		
		Board oddsEmpty = new Board(shapeOddsEmpty);
		assertFalse(oddsEmpty.availableTile(3, 0));
		
	}

	public void testAddPiece() {
		Board b = new Board();
		assertTrue(b.addPiece(0, 0, verticalBar));
		assertFalse(b.addPiece(0, 0, verticalBar));
		assertTrue(b.addPiece(6, 0, verticalBar));
		
		Board oddBoard = new Board(shapeOddsEmpty);
		//vertical pieces should not be playable on this board
		assertFalse(oddBoard.addPiece(0, 0, horizontalBar));
		assertFalse(oddBoard.addPiece(1, 0, horizontalBar));
		assertFalse(oddBoard.addPiece(0, 1, horizontalBar));
		
		//testing horizontal pieces
		assertTrue(oddBoard.addPiece(0, 0, verticalBar));
		//there is now a piece in the top corner
		assertFalse(oddBoard.addPiece(0, 5, verticalBar));
		assertTrue(oddBoard.addPiece(0, 6, verticalBar));
		//this row should not be playable
		assertFalse(oddBoard.addPiece(1, 0, verticalBar));
		//should overlap edge of board
		assertFalse(oddBoard.addPiece(2, 7, verticalBar));
	}

	public void testRemovePiece() {
		Board b = new Board();
		assertFalse (b.removePiece(0, 0));
		assertTrue(b.addPiece(0, 0, verticalBar));
		assertTrue(b.getPiece(0, 0) != null);
		
		assertFalse(b.removePiece(7, 7));
		assertTrue(b.removePiece(0, 0));
		assertTrue(b.getPiece(0, 0) == null);
		
		Board oddBoard = new Board(shapeOddsEmpty);
		assertFalse(oddBoard.removePiece(1, 0));
		assertTrue(oddBoard.addPiece(0, 0, verticalBar));
		assertTrue(oddBoard.removePiece(0, 0));
	}

	public void testMovePiece() {
		Board b = new Board();
		assertTrue(b.addPiece(0, 0, verticalBar));
		assertTrue(b.getPiece(0, 0) != null);
		
		Piece testPiece = b.getPiece(0, 0);
		assertTrue(b.pieces.get(b.shape[0][0].getCoveredBy()) == testPiece);
		
		assertFalse(b.movePiece(7, 7, 6, 6));
		assertFalse(b.movePiece(0, 0, 7, 7));
		assertTrue(b.movePiece(0, 0, 6, 6));
		assertTrue(b.getPiece(0, 0) == null);
		assertTrue(b.getPiece(6, 6) != null);
		assertTrue(b.pieces.get(b.shape[6][6].getCoveredBy()) == testPiece);
	
	}

	public void testRemoveAll() {
		Board b = new Board();
		assertTrue(b.addPiece(0, 0, verticalBar));
		assertTrue(b.addPiece(6, 0, verticalBar));
		assertTrue(b.getPiece(0, 0) != null);
		assertTrue(b.getPiece(6, 0) != null);
		b.removeAll();
		assertTrue(b.getPiece(0, 0) == null);
		assertTrue(b.getPiece(6, 0) == null);
		
		Board oddBoard = new Board(shapeOddsEmpty);
		assertTrue(oddBoard.addPiece(0, 0, verticalBar));
		assertTrue(oddBoard.addPiece(0, 6, verticalBar));
		assertTrue(oddBoard.getPiece(0, 0) != null);
		assertTrue(oddBoard.getPiece(0, 6) != null);
		oddBoard.removeAll();
		assertTrue(oddBoard.getPiece(0, 0) == null);
		assertTrue(oddBoard.getPiece(0, 6) == null);
		
	}
	
	public void testGetSize(){
		Board b = new Board();
		assertTrue(b.getSize() == 144);
		
		Board oddBoard = new Board(shapeOddsEmpty);
		assertTrue(oddBoard.getSize() == 72);
	}
	
	public void testRemoveTile(){
		Board b = new Board();
		assertTrue(b.shape[0][0] != null);
		b.removeTile(0, 0);
		assertTrue(b.shape[0][0] == null);
	}
	
	public void testSetTile(){
		Board b = new Board();
		assertTrue(b.shape[0][0] != null);
		b.removeTile(0, 0);
		assertTrue(b.shape[0][0] == null);
		
		Tile testTile = new Tile(0,0);
		b.setTile(testTile);
		assertTrue(b.shape[0][0] == testTile);
	}
	
	public void testGetTile(){
		Board oddBoard = new Board(shapeOddsEmpty);
		assertTrue(oddBoard.shape[0][0] != null);
		assertTrue(oddBoard.getTile(0, 0) instanceof Tile);
		assertTrue(oddBoard.getTile(1, 0) == null);
	}
	
	public void testSetMovingTile(){
		Board oddBoard = new Board(shapeOddsEmpty);
		assertFalse(oddBoard.movingTile);
		
		oddBoard.setMovingTile(true);
		assertTrue(oddBoard.movingTile);
		
		oddBoard.setMovingTile(false);
		assertFalse(oddBoard.movingTile);
	}
	
	public void testGetMovingTile(){
		Board oddBoard = new Board(shapeOddsEmpty);
		assertTrue(oddBoard.movingTile == oddBoard.getMovingTile());
	
		oddBoard.setMovingTile(true);	
		assertTrue(oddBoard.movingTile == oddBoard.getMovingTile());
		
		oddBoard.setMovingTile(false);
		assertTrue(oddBoard.movingTile == oddBoard.getMovingTile());
		
	}

}
