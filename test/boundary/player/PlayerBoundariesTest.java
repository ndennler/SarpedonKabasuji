package boundary.player;

import Main.PlayerApplication;
import bounday.player.LightningLevelGui;
import bounday.player.PuzzleLevelGui;
import bounday.player.ReleaseLevelGui;
import entity.player.Board;
import entity.player.Bullpen;
import entity.player.LightningBoard;
import entity.player.LightningLevel;
import entity.player.PuzzleLevel;
import entity.player.ReleaseLevel;
import entity.player.SarpedonKabasuji;
import junit.framework.TestCase;

public class PlayerBoundariesTest extends TestCase {
	public void testPlayer(){
		PlayerApplication game = new PlayerApplication(); //constructs the player application
		game.main(null); //runs the player application
		
		SarpedonKabasuji g = new SarpedonKabasuji(); //constructs a new game
		Bullpen bp = new Bullpen(); //constructs an empty bullpen
		Board b = new Board(); //constructs an empty board
		LightningBoard lb = new LightningBoard(); //constructs an empty lightning board
		
		PuzzleLevel pl = new PuzzleLevel(b, bp, null); //constructs a new puzzle level
		PuzzleLevelGui plg = new PuzzleLevelGui(pl, g); //constructs a new puzzle level GUI
		plg.setVisible(true); //ensures GUI is run and displays
		
		ReleaseLevel rl = new ReleaseLevel(); //constructs a new release level
		ReleaseLevelGui rlg = new ReleaseLevelGui(rl, g); //constructs a new release level GUI
		rlg.setVisible(true); //ensures GUI is run and displays
		
		LightningLevel ll = new LightningLevel(lb, bp, null, false, null, 7, 5); //constructs a new lightning level
		LightningLevelGui llg = new LightningLevelGui(ll, g); //constructs a new lightning level GUI
		llg.setVisible(true); //ensures GUI is run and displays
		
		//test to confirm objects are being created and working correctly
		assertEquals(bp.piecesLeft(),0);
	}
}
