package entity.builder;

import entity.player.Piece;
import entity.player.ReleaseBoard;
import entity.player.ReleaseTile;
import entity.player.Square;
import junit.framework.TestCase;
/**
 * Testing for the BuildableReleaseBoard
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class BuildableReleaseBoardTest extends TestCase {
	BuildableReleaseBoard brb;
	Piece verticalBar = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );
	
	protected void setUp() throws Exception {
		super.setUp();
		brb = new BuildableReleaseBoard();
	}

	public void testRemovePiece() {
		brb.addPiece(0, 0, verticalBar);
		assertTrue(brb.removePiece(0, 0));
		assertFalse(brb.removePiece(7, 7));
	}

	public void testBuildableReleaseBoard() {
		assertTrue(brb.getMovingTile() == false);
		assertTrue(brb.getTileArray().length == 12);
		assertTrue(((ReleaseTile)brb.getTileArray()[0][0]).getColor() == null);
		assertTrue(((ReleaseTile)brb.getTileArray()[0][0]).getNumber() == null);
	}

}
