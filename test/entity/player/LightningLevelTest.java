package entity.player;

import java.util.ArrayList;

import entity.builder.BuildableLightning;
import entity.builder.BuildablePuzzle;
import junit.framework.TestCase;
/**
 * Testing for the player.entity LightningLevel class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class LightningLevelTest extends TestCase {
	/** Lightning Levels for Testing */
	LightningLevel lL; // default
	LightningLevel testLL; // example
	
	/** a 12 x 12 Tile array with odd rows empty for the Board*/
	Tile[][] shapeOddsEmpty;
	
	/** a Board */
	LightningBoard oddsEmpty;
	
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
		// set up default LightningLevel
		lL = new LightningLevel();
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
		oddsEmpty = new LightningBoard(shapeOddsEmpty);
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
		// example LightningLevel
		testLL = new LightningLevel(oddsEmpty, bp, 0, false, hnts, 2, 50000);
	}

	public void testGetTimeLeft(){
		assertTrue(lL.timeLeft == lL.getTimeLeft());
		assertTrue(testLL.timeLeft == testLL.getTimeLeft());
	}
	
	public void testDecrementTime(){
		assertTrue(lL.timeLeft == 100000);
		lL.decrementTime();
		assertTrue(lL.timeLeft == 99999);
	}
	
	public void testUpdateStars() {
		lL.updateStars();
		assertTrue(lL.stars == 0);
		for (int i = 0; i <= lL.board.shape.length - 1; i++){
			assertTrue(lL.board.addPiece(i, 0, verticalBar));
		}
		lL.updateStars();
		assertTrue(lL.stars == 0);
		
		for (int i = 0; i <= lL.board.shape.length - 3; i++){
			assertTrue(lL.board.addPiece(i, 6, verticalBar));
		}
		lL.updateStars();
		assertTrue(lL.stars == 1);
		
		assertTrue(lL.board.addPiece(10, 6, verticalBar));
		lL.updateStars();
		assertTrue(lL.stars == 2);
		
		assertTrue(lL.board.addPiece(11, 6, verticalBar));
		lL.updateStars();
		assertTrue(lL.stars == 3);
	}

	public void testGetCompleted(){
		lL.updateStars();
		assertTrue(lL.stars == 0);
		lL.timeLeft = 0;
		assertTrue(lL.getCompleted());
		
		lL.timeLeft = 20;
		lL.completed = false;
		for (int i = 0; i <= lL.board.shape.length - 1; i++){
			assertTrue(lL.board.addPiece(i, 0, verticalBar));
		}
		lL.updateStars();
		assertFalse(lL.getCompleted());
		assertTrue(lL.getCompleted() == lL.completed);
		
		for (int i = 0; i <= lL.board.shape.length - 3; i++){
			assertTrue(lL.board.addPiece(i, 6, verticalBar));
		}
		lL.updateStars();
		assertFalse(lL.getCompleted());
		assertTrue(lL.getCompleted() == lL.completed);
		
		assertTrue(lL.board.addPiece(10, 6, verticalBar));
		lL.updateStars();
		assertFalse(lL.getCompleted());
		assertTrue(lL.getCompleted() == lL.completed);
		
		assertTrue(lL.board.addPiece(11, 6, verticalBar));
		lL.updateStars();
		assertTrue(lL.getCompleted());
		assertTrue(lL.getCompleted() == lL.completed);
	}
	
	public void testRestore(){
		BuildableLightning bL = new BuildableLightning();
		LevelMomento lM = new LevelMomento(bL);
		assertTrue(testLL.board == oddsEmpty);
		assertTrue(testLL.bullpen == bp);
		assertTrue(testLL.stars == 0);
		assertFalse(testLL.completed);
		assertTrue(testLL.hints == hnts);
		assertTrue(testLL.type == "Lightning");
		assertTrue(testLL.number == 2);
		assertTrue(testLL.timeLeft == 50000);
		
		testLL.restore(lM);
		//check original state
		assertFalse(testLL.board == oddsEmpty);
		assertFalse(testLL.bullpen == bp);
		assertTrue(testLL.stars == 0);
		assertFalse(testLL.completed);
		assertFalse(testLL.hints == hnts);
		assertTrue(testLL.type == "Lightning");
		assertTrue(testLL.number == null);
		assertTrue(testLL.timeLeft == null);
	}
	
	public void testLightningLevel() {
		assertTrue(lL.board.pieces.isEmpty());
		assertTrue(lL.board.shape.length == 12);
		assertTrue(lL.board.shape[0].length == 12);
		assertTrue(lL.bullpen.piecesLeft() == 0);
		assertTrue(lL.stars == 0);
		assertFalse(lL.completed);
		assertTrue(lL.hints.isEmpty());
		assertTrue(lL.type == "Lightning");
		assertTrue(lL.number == 2);
		assertTrue(lL.timeLeft == 100000);
	}

	public void testLightningLevelBoardBullpenArrayListOfHint() {
		assertTrue(testLL.board == oddsEmpty);
		assertTrue(testLL.bullpen == bp);
		assertTrue(testLL.stars == 0);
		assertFalse(testLL.completed);
		assertTrue(testLL.hints == hnts);
		assertTrue(testLL.type == "Lightning");
		assertTrue(testLL.number == 2);
		assertTrue(testLL.timeLeft == 50000);
	}
	public void testGetType() {
		assertTrue(lL.type == lL.getType());
		assertTrue(lL.type == "Lightning");
		assertTrue(testLL.type == testLL.getType());
		assertTrue(testLL.type == "Lightning");
	}

}
