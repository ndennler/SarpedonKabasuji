package entity.player;

import junit.framework.TestCase;
/**
 * Testing for SarpedonKabasuji main model class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class SarpedonKabasujiTest extends TestCase {
	SarpedonKabasuji sKbsj;
	protected void setUp() throws Exception {
		super.setUp();
		sKbsj = new SarpedonKabasuji();
	}

	public void testSarpedonKabasuji() {
		assertTrue(sKbsj.gameOver == false);
		assertTrue(sKbsj.unlockedLevels == 1);
		assertTrue(sKbsj.levels.length == 15);
	}

	public void testNextLevel() {
		for (int i = 0; i <= sKbsj.levels.length - 1; i++){
			sKbsj.levels[i] = null;
		}
		boolean thrown = false;
		try {
			sKbsj.nextLevel();
		} catch (RuntimeException e){
			thrown = true;
		}
		assertTrue(thrown);
	}

	public void testGetGameOver() {
		assertTrue(sKbsj.gameOver == false);
		assertTrue(sKbsj.gameOver == sKbsj.getGameOver());
	}

	public void testGetCurrentLevel() {
		assertTrue(sKbsj.unlockedLevels == sKbsj.getCurrentLevel());
	}

	public void testGetLevel() {
		assertTrue(sKbsj.getLevel(1) == sKbsj.levels[0]);
	}

	public void testSetLevel() {
		ReleaseLevel testRL = new ReleaseLevel();
		testRL.number = 3;
		assertFalse(sKbsj.levels[1] == testRL);
		assertFalse(sKbsj.levels[2] == testRL);
		assertFalse(sKbsj.levels[3] == testRL);
		sKbsj.setLevel(testRL);
		
		assertFalse(sKbsj.levels[1] == testRL);
		assertTrue(sKbsj.levels[2] == testRL);
		assertFalse(sKbsj.levels[3] == testRL);
	}

	public void testIncrementLevel() {
		assertTrue(sKbsj.unlockedLevels == 1);
		
		sKbsj.incrementLevel();
		assertTrue(sKbsj.unlockedLevels == 2);
	}

	public void testGetLevels() {
		assertTrue(sKbsj.getLevels() == sKbsj.levels);
	}

}
