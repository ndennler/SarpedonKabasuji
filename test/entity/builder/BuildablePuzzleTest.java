package entity.builder;

import java.util.ArrayList;

import Moves.PieceMoveToBoard;
import entity.player.Board;
import entity.player.Bullpen;
import entity.player.LevelMomento;
import entity.player.Piece;
import entity.player.Square;
import entity.player.Tile;
import junit.framework.TestCase;
/**
 * Testing for BuildablePuzzle
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class BuildablePuzzleTest extends TestCase {
	BuildablePuzzle bP;
	protected void setUp() throws Exception {
		super.setUp();
		bP= new BuildablePuzzle();
	}

	public void testGetBullpen() {
		assertTrue(bP.getBullpen() instanceof Bullpen);
		assertTrue(bP.getBullpen().piecesLeft() ==0);
	}

	public void testGetBoard() {
		assertTrue(bP.getBoard() instanceof Board);
		assertTrue(bP.getBoard().getSize() == 144);
	}

	public void testRestore() {
		//make momento
		LevelMomento lM = new LevelMomento(bP);
		//do things
		bP.setMovesAllotted(10);
		assertTrue(bP.getMovesAllotted() == 10);
		
		Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
		Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
		ArrayList <Piece> pcs;
		Bullpen testBull = new Bullpen();
		testBull.addPiece(horizontalBar);
		testBull.addPiece(verticalBar);
		bP.setBullpen(testBull);
		assertTrue(bP.getBullpen() == testBull);
		
		Tile[][] shapeOddsEmpty;
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
		Board testBoard = new Board(shapeOddsEmpty);
		bP.setBoard(testBoard);
		assertTrue(bP.getBoard()==testBoard);
		//restore
		bP.restore(lM);
		//check original state
		assertTrue(bP.movesAllotted == lM.getMovesAllotted());
		assertTrue(bP.getMovesAllotted() == null);
		assertFalse(bP.getBullpen() == testBull);
		assertFalse(bP.getBoard()==testBoard);
	}

	public void testGetMovesAllotted() {
		assertTrue(bP.getMovesAllotted() == bP.movesAllotted);
		bP.setMovesAllotted(10);
		assertTrue(bP.getMovesAllotted() == bP.movesAllotted);
	}

	public void testSetMovesAllotted() {
		assertTrue(bP.getMovesAllotted() == null);
		bP.setMovesAllotted(10);
		assertTrue(bP.getMovesAllotted() == 10);
	}

	public void testSetBullpen() {
		Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
		Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
		ArrayList <Piece> pcs;
		Bullpen testBull = new Bullpen();
		testBull.addPiece(horizontalBar);
		testBull.addPiece(verticalBar);
		assertFalse(bP.getBullpen() == testBull);
		bP.setBullpen(testBull);
		assertTrue(bP.getBullpen() == testBull);
		
	}

	public void testSetBoard() {
		Tile[][] shapeOddsEmpty;
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
		Board testBoard = new Board(shapeOddsEmpty);
		assertFalse(bP.getBoard()==testBoard);
		
		bP.setBoard(testBoard);
		assertTrue(bP.getBoard()==testBoard);
	}

	public void testSetType() {
		assertTrue(bP.getType().equals("Puzzle"));
		bP.setType("Puzzle");
		assertTrue(bP.getType().equals("Puzzle"));
		bP.setType("Release");
		assertTrue(bP.getType().equals("Release"));
		bP.setType("Lightning");
		assertTrue(bP.getType().equals("Lightning"));
		bP.setType("Puzzle");
		assertTrue(bP.getType().equals("Puzzle"));
	}

	public void testGetLastMove(){
		Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
		assertTrue(bP.MoveList.isEmpty());
		assertTrue(bP.getLastMove() == null);
		
		PieceMoveToBoard pM2B = new PieceMoveToBoard(0,0, bP.getBoard(), bP.getBullpen(), verticalBar);
		bP.addMove(pM2B);
		assertTrue(bP.MoveList.contains(pM2B));
		assertTrue(bP.getLastMove() == pM2B);
		assertTrue(bP.MoveList.isEmpty());
	}

}
