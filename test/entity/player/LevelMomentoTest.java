package entity.player;

import entity.builder.BuildableLightning;
import entity.builder.BuildablePuzzle;
import entity.builder.BuildableRelease;
import junit.framework.TestCase;
/**
 * Testing for LevelMomento
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class LevelMomentoTest extends TestCase {
	BuildableRelease bR = new BuildableRelease();
	BuildableLightning bL = new BuildableLightning();
	BuildablePuzzle bP = new BuildablePuzzle();
	
	LevelMomento rM; 
	LevelMomento lM; 
	LevelMomento pM;
	protected void setUp() throws Exception {
		super.setUp();
		rM = new LevelMomento(bR);
		lM = new LevelMomento(bL);
		pM = new LevelMomento(bP);
		
	}

	public void testGetType() {
		assertTrue(rM.getType().equals("Release"));
		assertTrue(lM.getType().equals("Lightning"));
		assertTrue(pM.getType().equals("Puzzle"));
	}

	public void testGetTimeAllotted() {
		assertTrue(lM.getTimeAllotted() == null);
		assertTrue(pM.getTimeAllotted() == null);
		assertTrue(rM.getTimeAllotted() == null);
	}

	public void testGetMovesAllotted() {
		assertTrue(lM.getMovesAllotted() == null);
		assertTrue(pM.getMovesAllotted() == null);
		assertTrue(rM.getMovesAllotted() == null);
	}

}
