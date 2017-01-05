package Moves;

import entity.player.Board;
import entity.player.Tile;
import junit.framework.TestCase;
/**
 * Testing for the TileMove class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class TileMoveTest extends TestCase {
	Board brd;
	Tile s;
	Tile e;
	protected void setUp() throws Exception {
		super.setUp();
		brd = new Board();
		s = new Tile(2,3);
		e = new Tile(7,9);
	}

	public void testTileMove() {
		TileMove test1 = new TileMove(s, e, brd);
		assertTrue(test1.aBoard == brd);
		assertTrue(test1.start == s);
		assertTrue(test1.end == e);
		
		TileMove test2 = new TileMove(e, s, brd);
		assertTrue(test2.aBoard == brd);
		assertTrue(test2.start == e);
		assertTrue(test2.end == s);
	}

	public void testUndo() {
		TileMove test1 = new TileMove(s, e, brd);
		assertTrue(test1.aBoard == brd);
		assertTrue(test1.start == s);
		assertTrue(test1.end == e);
		brd.setTile(e);
		assertTrue(test1.undo());
		
		TileMove test2 = new TileMove(e, s, brd);
		assertTrue(test2.aBoard == brd);
		assertTrue(test2.start == e);
		assertTrue(test2.end == s);
		brd.setTile(s);
		assertTrue(test2.undo());
	}

}
