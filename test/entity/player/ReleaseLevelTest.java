package entity.player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.UUID;

import entity.builder.BuildableRelease;
import entity.builder.BuildableReleaseBoard;
import junit.framework.TestCase;
/**
 * Testing for ReleaseLevel
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class ReleaseLevelTest extends TestCase {
	/** Lightning Levels for Testing */
	ReleaseLevel rL; // default
	ReleaseLevel testrL; // example
	
	/** a 12 x 12 Tile array with odd rows empty for the Board*/
	Tile[][] shapeOddsEmpty;
	
	/** a Board */
	ReleaseBoard oddsEmpty;
	
	/** pieces for use in testing */
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
	Piece h2 = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
	Piece v2 = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	
	/** an arrayList of Pieces for the Bullpen */
	ArrayList<Piece> pcs;
	
	/** a Bullpen */
	Bullpen bp;
	
	/** a Hint */
	Hint hint1; 
	
	/** Hints */
	ArrayList<Hint> hnts;
	
	protected void setUp() throws Exception {
		super.setUp();
		// set up default ReleaseLevel
		rL = new ReleaseLevel();
		// set up Tile array for Board
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
		// create Board
		oddsEmpty = new ReleaseBoard(shapeOddsEmpty);
		// create Bullpen
		pcs = new ArrayList<Piece>();
		bp = new Bullpen(pcs, null);
		bp.addPiece(horizontalBar);
		bp.addPiece(verticalBar);
		bp.addPiece(h2);
		bp.addPiece(v2);
		
		// create hint
		hint1 = new Hint(horizontalBar,6,3);
		// create hint array
		hnts = new ArrayList<Hint>();
		hnts.add(hint1);
		// example ReleaseLevel
		testrL = new ReleaseLevel();
	}
	public void testGetCompleted() {
		assertTrue(rL.getCompleted());
		
		rL.bullpen.addPiece(horizontalBar);
		rL.updateStars();
		assertTrue(rL.stars == 0);
		assertFalse(rL.getCompleted());
		assertTrue(rL.getCompleted() == rL.completed);
		
		rL.bullpen.getPieces().clear();
		assertTrue(rL.bullpen.getPieces().isEmpty());
		assertTrue(rL.getCompleted());
	}

	public void testUpdateStars() {
		rL.updateStars();
		assertTrue(rL.stars == 0);
		rL.board.shape[0][0] = new ReleaseTile(0,0, UUID.randomUUID(), 1, Color.BLUE);
		rL.updateStars();
		
		rL.blueNumCovered.add(true);
		rL.blueNumCovered.add(false);
		rL.updateStars();
//		System.out.println(rL.numBlue);
//		assertTrue(rL.numBlue == 1);
//		rL.blueNumCovered.remove(false);
//		rL.updateStars();
	}

	public void testRestore() {
		BuildableRelease bR = new BuildableRelease();
		LevelMomento lM = new LevelMomento(bR);
		assertTrue(testrL.board instanceof ReleaseBoard);
		assertTrue(testrL.bullpen instanceof Bullpen);
		assertTrue(testrL.stars == 0);
		assertFalse(testrL.completed);
		assertTrue(testrL.hints instanceof ArrayList<?>);
		assertTrue(testrL.type == "Release");
		assertTrue(testrL.number == null);
		
		testrL.restore(lM);
		//check original state
		assertFalse(testrL.board == oddsEmpty);
		assertFalse(testrL.bullpen == bp);
		assertTrue(testrL.stars == 0);
		assertFalse(testrL.completed);
		assertFalse(testrL.hints == hnts);
		assertTrue(testrL.type == "Release");
		assertTrue(testrL.number == null);
	}

	public void testReleaseLevel() {
		assertTrue(rL.board.pieces.isEmpty());
		assertTrue(rL.board.shape.length == 12);
		assertTrue(rL.board.shape[0].length == 12);
		assertTrue(rL.bullpen.piecesLeft() == 0);
		assertTrue(rL.stars == 0);
		assertFalse(rL.completed);
		assertTrue(rL.hints.isEmpty());
		assertTrue(rL.type == "Release");
		assertTrue(rL.numBlue == 0);
		assertTrue(rL.numGreen == 0);
		assertTrue(rL.numRed == 0);
	}

	public void testCalculateColor() {
		rL.calculateColor(rL.blueNumCovered, Color.blue);
		assertTrue(rL.numBlue == 0);
		rL.blueNumCovered.add(true);
		
//		rL.calculateColor(rL.blueNumCovered, rL.numBlue);
//		assertTrue(rL.numBlue == 0);
	}

}
