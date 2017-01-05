package Moves;

import entity.builder.BuildableLightning;
import entity.builder.BuildablePuzzle;
import entity.builder.BuildableRelease;
import entity.player.Hint;
import entity.player.Piece;
import entity.player.Square;
import junit.framework.TestCase;
/**
 * Testing for HintMove class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class HintMoveTest extends TestCase {
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	Piece horizontalBar = new Piece(1,  new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0) );
	
	BuildablePuzzle buildP;
	BuildableRelease buildR;
	BuildableLightning buildL;
	
	Hint rHint;
	Hint pHint;
	Hint lHint;
	
	protected void setUp() throws Exception {
		super.setUp();
		buildP = new BuildablePuzzle();
		buildR = new BuildableRelease();
		buildL = new BuildableLightning();
		
		rHint = new Hint(verticalBar, 5,3);
		pHint = new Hint(horizontalBar, 4, 6);
		lHint = new Hint(verticalBar, 3, 9);
	}

	public void testHintMoveIBuilderModelHint() {
		HintMove rTest = new HintMove(buildR, rHint);
		assertTrue(rTest.aHint == rHint);
		assertTrue(rTest.aModel == buildR);
		assertTrue(rTest.aPiece == null);
		assertTrue(rTest.add == false);
		
		HintMove pTest = new HintMove(buildP, pHint);
		assertTrue(pTest.aHint == pHint);
		assertTrue(pTest.aModel == buildP);
		assertTrue(pTest.aPiece == null);
		assertTrue(pTest.add == false);
		
		HintMove lTest = new HintMove(buildL, lHint);
		assertTrue(lTest.aHint == lHint);
		assertTrue(lTest.aModel == buildL);
		assertTrue(lTest.aPiece == null);
		assertTrue(lTest.add == false);
	}

	public void testHintMoveIBuilderModelPieceHint() {
		HintMove rTest = new HintMove(buildR, horizontalBar, rHint);
		assertTrue(rTest.aHint == rHint);
		assertTrue(rTest.aModel == buildR);
		assertTrue(rTest.aPiece == null);
		assertTrue(rTest.add == true);
		
		HintMove pTest = new HintMove(buildP, verticalBar, pHint);
		assertTrue(pTest.aHint == pHint);
		assertTrue(pTest.aModel == buildP);
		assertTrue(pTest.aPiece == null);
		assertTrue(pTest.add == true);
		
		HintMove lTest = new HintMove(buildL, verticalBar, lHint);
		assertTrue(lTest.aHint == lHint);
		assertTrue(lTest.aModel == buildL);
		assertTrue(lTest.aPiece == null);
		assertTrue(lTest.add == true);
	}

	public void testUndo() {
		HintMove rTest = new HintMove(buildR, horizontalBar, rHint);
		assertTrue(rTest.aHint == rHint);
		assertTrue(rTest.aModel == buildR);
		assertTrue(rTest.aPiece == null);
		assertTrue(rTest.add == true);
		buildR.getHints().add(rHint);
		assertTrue(rTest.undo());
		
		HintMove pTest = new HintMove(buildP, pHint);
		assertTrue(pTest.aHint == pHint);
		assertTrue(pTest.aModel == buildP);
		assertTrue(pTest.aPiece == null);
		assertTrue(pTest.add == false);
		buildP.getHints().add(pHint);
		assertTrue(pTest.undo());
		
		HintMove lTest = new HintMove(buildL, verticalBar, lHint);
		assertTrue(lTest.aHint == lHint);
		assertTrue(lTest.aModel == buildL);
		assertTrue(lTest.aPiece == null);
		assertTrue(lTest.add == true);
		buildL.getHints().add(lHint);
		assertTrue(lTest.undo());
	}

}
