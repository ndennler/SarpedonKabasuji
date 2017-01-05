package Moves;

import javax.swing.JComboBox;

import entity.builder.BuildableLightning;
import entity.builder.BuildablePuzzle;
import entity.builder.BuildableRelease;
import junit.framework.TestCase;
/**
 * Testing for the SizeMove class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class SizeMoveTest extends TestCase {
	int sz;
	JComboBox<Integer> brdSz;
	BuildablePuzzle buildP;
	BuildableRelease buildR;
	BuildableLightning buildL;
	
	protected void setUp() throws Exception {
		super.setUp();
		brdSz = new JComboBox<Integer>();
		buildP = new BuildablePuzzle();
		buildR = new BuildableRelease();
		buildL = new BuildableLightning();
	}

	public void testSizeMove() {
		sz = 7;
		SizeMove test1 = new SizeMove(sz, buildP, brdSz);
		assertTrue(test1.boardSize == brdSz);
		assertTrue(test1.size == sz);
		assertTrue(test1.model == buildP);
		
		SizeMove test2 = new SizeMove(sz, buildR, brdSz);
		assertTrue(test2.boardSize == brdSz);
		assertTrue(test2.size == sz);
		assertTrue(test2.model == buildR);
		
		SizeMove test3 = new SizeMove(sz, buildL, brdSz);
		assertTrue(test3.boardSize == brdSz);
		assertTrue(test3.size == sz);
		assertTrue(test3.model == buildL);
	}

	public void testUndo() {
		sz = 7;
		SizeMove test1 = new SizeMove(sz, buildP, brdSz);
		assertTrue(test1.boardSize == brdSz);
		assertTrue(test1.size == sz);
		assertTrue(test1.model == buildP);
		assertTrue(test1.undo());
		
		SizeMove test2 = new SizeMove(sz, buildR, brdSz);
		assertTrue(test2.boardSize == brdSz);
		assertTrue(test2.size == sz);
		assertTrue(test2.model == buildR);
		assertTrue(test2.undo());
		
		SizeMove test3 = new SizeMove(sz, buildL, brdSz);
		assertTrue(test3.boardSize == brdSz);
		assertTrue(test3.size == sz);
		assertTrue(test3.model == buildL);
		assertTrue(test3.undo());
		
		sz = 12;
		SizeMove test4 = new SizeMove(sz, buildL, brdSz);
		assertTrue(test4.boardSize == brdSz);
		assertTrue(test4.size == sz);
		assertTrue(test4.model == buildL);
		assertTrue(test4.undo());
	}

}
