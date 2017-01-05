package entity.builder;

import java.util.ArrayList;

import Moves.PieceMoveToBoard;
import entity.player.Board;
import entity.player.Bullpen;
import entity.player.LevelMomento;
import entity.player.LightningBoard;
import entity.player.Piece;
import entity.player.Square;
import entity.player.Tile;
import junit.framework.TestCase;
/**
 * Testing for BuildableLightning
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class BuildableLightningTest extends TestCase {
	BuildableLightning bL;
	protected void setUp() throws Exception {
		super.setUp();
		bL = new BuildableLightning();
	}

	public void testGetBullpen() {
		assertTrue(bL.getBullpen() instanceof Bullpen);
		assertTrue(bL.getBullpen().piecesLeft() ==0);
	}

	public void testGetBoard() {
		assertTrue(bL.getBoard() instanceof Board);
		assertTrue(bL.getBoard().getSize() == 144);
	}

	public void testRestore() {
		//make momento
		LevelMomento lM = new LevelMomento(bL);
		//do things
		bL.setTimeAllotted(10);
		assertTrue(bL.getTimeAllotted() == 10);
		
		Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
		Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
		ArrayList <Piece> pcs;
		Bullpen testBull = new Bullpen();
		testBull.addPiece(horizontalBar);
		testBull.addPiece(verticalBar);
		bL.setBullpen(testBull);
		assertTrue(bL.getBullpen() == testBull);
		
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
		LightningBoard testBoard = new LightningBoard(shapeOddsEmpty);
		bL.setBoard(testBoard);
		assertTrue(bL.getBoard()==testBoard);
		//restore
		bL.restore(lM);
		//check original state
		assertTrue(bL.timeAllotted == lM.getTimeAllotted());
		assertTrue(bL.getTimeAllotted() == null);
		assertFalse(bL.getBullpen() == testBull);
		assertFalse(bL.getBoard()==testBoard);
	}

	public void testGetTimeAllotted() {
		assertTrue(bL.getTimeAllotted() == bL.timeAllotted);
		bL.setTimeAllotted(10);
		assertTrue(bL.getTimeAllotted() == bL.timeAllotted);
	}

	public void testSetTimeAllotted() {
		assertTrue(bL.getTimeAllotted() == null);
		bL.setTimeAllotted(10);
		assertTrue(bL.getTimeAllotted() == 10);
	}

	public void testSetBullpen() {
		Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
		Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
		ArrayList <Piece> pcs;
		Bullpen testBull = new Bullpen();
		testBull.addPiece(horizontalBar);
		testBull.addPiece(verticalBar);
		assertFalse(bL.getBullpen() == testBull);
		bL.setBullpen(testBull);
		assertTrue(bL.getBullpen() == testBull);
		
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
		assertFalse(bL.getBoard()==testBoard);
		
		bL.setBoard(testBoard);
		assertTrue(bL.getBoard()==testBoard);
	}

	public void testSetType() {
		assertTrue(bL.getType().equals("Lightning"));
		bL.setType("Lightning");
		assertTrue(bL.getType().equals("Lightning"));
		bL.setType("Release");
		assertTrue(bL.getType().equals("Release"));
		bL.setType("Puzzle");
		assertTrue(bL.getType().equals("Puzzle"));
		bL.setType("Lightning");
		assertTrue(bL.getType().equals("Lightning"));
	}


	public void testGetLastMove(){
		Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
		assertTrue(bL.MoveList.isEmpty());
		assertTrue(bL.getLastMove() == null);
		
		PieceMoveToBoard pM2B = new PieceMoveToBoard(0,0, bL.getBoard(), bL.getBullpen(), verticalBar);
		bL.addMove(pM2B);
		assertTrue(bL.MoveList.contains(pM2B));
		assertTrue(bL.getLastMove() == pM2B);
		assertTrue(bL.MoveList.isEmpty());
	}

}
