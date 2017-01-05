package entity.builder;

import java.util.ArrayList;

import entity.player.Board;
import entity.player.Bullpen;
import entity.player.LevelMomento;
import entity.player.Piece;
import Moves.PieceMoveToBoard;
import entity.player.ReleaseBoard;
import entity.player.ReleaseTile;
import entity.player.Square;
import entity.player.Tile;
import junit.framework.TestCase;
/**
 * Testing for BuildableRelease
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class BuildableReleaseTest extends TestCase {
	BuildableRelease bR;
	protected void setUp() throws Exception {
		super.setUp();
		bR= new BuildableRelease();
	}

	public void testGetBullpen() {
		assertTrue(bR.getBullpen() instanceof Bullpen);
		assertTrue(bR.getBullpen().piecesLeft() ==0);
	}

	public void testGetBoard() {
		assertTrue(bR.getBoard() instanceof ReleaseBoard);
		assertTrue(bR.getBoard().getSize() == 144);
	}

	public void testRestore() {
		//make momento
		LevelMomento lM = new LevelMomento(bR);
		//do things
		
		Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
		Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
		ArrayList <Piece> pcs;
		Bullpen testBull = new Bullpen();
		testBull.addPiece(horizontalBar);
		testBull.addPiece(verticalBar);
		bR.setBullpen(testBull);
		assertTrue(bR.getBullpen() == testBull);
		
		BuildableReleaseBoard testBoard = new BuildableReleaseBoard();
		
		bR.setBoard(testBoard);
		assertTrue(bR.getBoard()==testBoard);
		//restore
		bR.restore(lM);
		//check original state
		assertFalse(bR.getBullpen() == testBull);
		assertFalse(bR.getBoard()==testBoard);
	}

	public void testSetBullpen() {
		Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
		Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
		ArrayList <Piece> pcs;
		Bullpen testBull = new Bullpen();
		testBull.addPiece(horizontalBar);
		testBull.addPiece(verticalBar);
		assertFalse(bR.getBullpen() == testBull);
		bR.setBullpen(testBull);
		assertTrue(bR.getBullpen() == testBull);
		
	}

//	public void testSetBoard() {
//		ReleaseTile[][] shapeOddsEmpty= new ReleaseTile[12][12];
//		for(int i=0; i< 12; i++){
//			for(int j =0; j<12;j++){
//				if (i%2 ==0){
//					shapeOddsEmpty[i][j]	= new ReleaseTile(i,j, null, null);
//				} else {
//					shapeOddsEmpty[i][j] = null;
//				}
//			}
//		}
//		Board testBoard = new Board(shapeOddsEmpty);
//		assertFalse(bR.getBoard()==testBoard);
//		
//		bR.setBoard(testBoard);
//		assertTrue(bR.getBoard()==testBoard);
//	}

	public void testSetType() {
		assertTrue(bR.getType().equals("Release"));
		bR.setType("Release");
		assertTrue(bR.getType().equals("Release"));
		bR.setType("Puzzle");
		assertTrue(bR.getType().equals("Puzzle"));
		bR.setType("Lightning");
		assertTrue(bR.getType().equals("Lightning"));
		bR.setType("Release");
		assertTrue(bR.getType().equals("Release"));
	}
	
	public void testGetLastMove(){
		Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
		assertTrue(bR.MoveList.isEmpty());
		assertTrue(bR.getLastMove() == null);
		
		PieceMoveToBoard pM2B = new PieceMoveToBoard(0,0, bR.rBoard, bR.getBullpen(), verticalBar);
		bR.addMove(pM2B);
		assertTrue(bR.MoveList.contains(pM2B));
		assertTrue(bR.getLastMove() == pM2B);
		assertTrue(bR.MoveList.isEmpty());
	}

}
