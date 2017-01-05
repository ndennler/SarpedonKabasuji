package entity.player;

import java.util.ArrayList;

import entity.builder.BuildablePuzzle;
import junit.framework.TestCase;
/**
 * Testing for the player.entity PuzzleLevel class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class PuzzleLevelTest extends TestCase {
	/** Puzzle Levels for Testing */
	PuzzleLevel pL; // default
	PuzzleLevel testPL; // example
	
	/** a 12 x 12 Tile array with odd rows empty for the Board*/
	Tile[][] shapeOddsEmpty;
	
	/** a Board */
	Board oddsEmpty;
	
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
		// set up default PuzzleLevel
		pL = new PuzzleLevel();
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
		oddsEmpty = new Board(shapeOddsEmpty);
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
		// example PuzzleLevel
		testPL = new PuzzleLevel(oddsEmpty, bp, hnts);
	}

	public void testPuzzleLevel() {
		assertTrue(pL.board.pieces.isEmpty());
		assertTrue(pL.board.shape.length == 12);
		assertTrue(pL.board.shape[0].length == 12);
		assertTrue(pL.bullpen.piecesLeft() == 0);
		assertTrue(pL.stars == 0);
		assertFalse(pL.completed);
		assertTrue(pL.hints.isEmpty());
		assertTrue(pL.type == "Puzzle");
		assertTrue(pL.number == 1);
		assertTrue(pL.movesleft == 10);
	}

	public void testPuzzleLevelBoardBullpenArrayListOfHint() {
		assertTrue(testPL.board == oddsEmpty);
		assertTrue(testPL.bullpen == bp);
		assertTrue(testPL.stars == 0);
		assertFalse(testPL.completed);
		assertTrue(testPL.hints == hnts);
		assertTrue(testPL.type == "Puzzle");
		assertTrue(testPL.number == 1);
		assertTrue(testPL.movesleft == 10);
	}

	public void testUpdateStars() {
		assertTrue(testPL.bullpen.piecesLeft() == 4);
		assertTrue(testPL.stars == 0);
		
		testPL.bullpen.removePiece(v2);
		assertTrue(testPL.bullpen.piecesLeft() == 3);
		assertTrue(testPL.stars == 0);
		testPL.updateStars();
		assertTrue(testPL.stars == 0);
		
		testPL.bullpen.removePiece(h2);
		assertTrue(testPL.bullpen.piecesLeft() == 2);
		assertTrue(testPL.stars == 0);
		testPL.updateStars();
		assertTrue(testPL.stars == 1);
		
		testPL.bullpen.removePiece(verticalBar);
		assertTrue(testPL.bullpen.piecesLeft() == 1);
		assertTrue(testPL.stars == 1);
		testPL.updateStars();
		assertTrue(testPL.stars == 2);
		
		testPL.bullpen.setSelected(horizontalBar);
		assertTrue(testPL.bullpen.piecesLeft() == 1);
		assertTrue(testPL.stars == 2);
		testPL.updateStars();
		assertTrue(testPL.stars == 1);
		
		testPL.bullpen.removeSelected();
		testPL.bullpen.removePiece(horizontalBar);
		assertTrue(testPL.bullpen.piecesLeft() == 0);
		assertTrue(testPL.stars == 1);
		testPL.updateStars();
		assertTrue(testPL.stars == 3);
	}

	public void testGetMovesLeft() {
		assertTrue(pL.movesleft == pL.getMovesLeft());
		assertTrue(testPL.movesleft == testPL.getMovesLeft());
	}

	public void testGetBullpen() {
		assertTrue(pL.getBullpen().piecesLeft() == 0);
		assertTrue(testPL.getBullpen() == bp);
	}

	public void testGetType() {
		assertTrue(pL.type == pL.getType());
		assertTrue(pL.type == "Puzzle");
		assertTrue(testPL.type == testPL.getType());
		assertTrue(testPL.type == "Puzzle");
	}

	public void testGetCompleted() {
		assertTrue(pL.getCompleted());
		assertFalse(testPL.getCompleted());
				
		testPL.bullpen.removePiece(v2);
		assertTrue(testPL.getStars() == 0);
		assertFalse(testPL.getCompleted());
		
		testPL.bullpen.removePiece(h2);
		testPL.updateStars();
		assertTrue(testPL.getStars() == 1);
		assertFalse(testPL.getCompleted());
		
		testPL.bullpen.removePiece(verticalBar);
		testPL.updateStars();
		assertTrue(testPL.getStars() == 2);
		assertFalse(testPL.getCompleted());
		
		testPL.bullpen.removePiece(horizontalBar);
		testPL.updateStars();
		assertTrue(testPL.getStars() == 3);
		assertTrue(testPL.getCompleted());
		
		testPL = new PuzzleLevel(oddsEmpty, bp, hnts);
		testPL.setMovesLeft(0);
		assertTrue(testPL.getCompleted());
	}


	public void setCompleted(){
		pL.setCompleted(true);
		assertTrue(pL.completed);
		
		pL.setCompleted(false);
		assertFalse(pL.completed);
		
		testPL.setCompleted(true);
		assertTrue(testPL.completed);
		
		testPL.setCompleted(false);
		assertFalse(testPL.completed);
	}
	
	public void testGetStars() {
		assertTrue(pL.getStars()==0);
		assertTrue(testPL.getStars() == 0);
	}
	
	public void testSetStars(){
		assertTrue(pL.getStars()==0);
		pL.setStars(2);
		assertTrue(pL.getStars()==2);
		pL.setStars(0);
		assertTrue(pL.getStars()==0);
		
		assertTrue(testPL.getStars() == 0);
		testPL.setStars(3);
		assertTrue(testPL.getStars()==3);
		testPL.setStars(0);
		assertTrue(testPL.getStars()==0);
	}

	public void testGetBoard() {
		assertTrue(pL.board.pieces.isEmpty() == pL.getBoard().pieces.isEmpty());
		assertTrue(pL.board.shape.length == pL.getBoard().shape.length);
		assertTrue(pL.board.shape[0].length == pL.getBoard().shape[0].length);
		
		assertTrue(testPL.board == testPL.getBoard());
	}

	public void testGetHints() {
		assertTrue(pL.hints.isEmpty()==pL.getHints().isEmpty());
		assertTrue(testPL.hints == testPL.getHints());
	}

	public void testGetNumber() {
		assertTrue(pL.number == pL.getNumber());
		assertTrue(testPL.number == testPL.getNumber());
	}

	public void testSetNumber() {
		assertTrue(pL.number == 1);
		pL.setNumber(6);
		assertTrue(pL.number == 6);
		pL.setNumber(0);
		assertTrue(pL.number == 0);
		boolean thrown = false;
		// Too high
		try {
			pL.setNumber(-1);
		} catch (RuntimeException e) {
			thrown = true;
		}
		assertTrue(thrown);
		boolean thrown2 = false;
		try {
			pL.setNumber(16);
		} catch (RuntimeException e) {
			thrown2 = true;
		}
		assertTrue(thrown2);
	}
	
	public void testSetMoves(){
		assertTrue(pL.movesleft == 10);
		pL.setMovesLeft(5);
		assertTrue(pL.movesleft == 5);
		
		pL.setMovesLeft(100);
		assertTrue(pL.movesleft == 100);
	}

	public void testRestore(){
		BuildablePuzzle bP = new BuildablePuzzle();
		LevelMomento lM = new LevelMomento(bP);
		assertTrue(testPL.board == oddsEmpty);
		assertTrue(testPL.bullpen == bp);
		assertTrue(testPL.stars == 0);
		assertFalse(testPL.completed);
		assertTrue(testPL.hints == hnts);
		assertTrue(testPL.type == "Puzzle");
		assertTrue(testPL.number == 1);
		assertTrue(testPL.movesleft == 10);
		
		testPL.restore(lM);
		//check original state
		assertFalse(testPL.board == oddsEmpty);
		assertFalse(testPL.bullpen == bp);
		assertTrue(testPL.stars == 0);
		assertFalse(testPL.completed);
		assertFalse(testPL.hints == hnts);
		assertTrue(testPL.type == "Puzzle");
		assertTrue(testPL.number == null);
		assertTrue(testPL.movesleft == null);
	}
}
