package control.player;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import bounday.player.KabasujiMenuGui;
import bounday.player.LevelSelectGui;
import bounday.player.LightningLevelGui;
import bounday.player.PlayerBoardPanel;
import bounday.player.PlayerBullpenPanel;
import bounday.player.PlayerSplashScreen;
import bounday.player.PuzzleLevelGui;
import bounday.player.ReleaseLevelGui;
import entity.player.Board;
import entity.player.Bullpen;
import entity.player.LightningLevel;
import entity.player.Piece;
import entity.player.PuzzleLevel;
import entity.player.ReleaseBoard;
import entity.player.ReleaseLevel;
import entity.player.SarpedonKabasuji;
import entity.player.Square;
import junit.framework.TestCase;

public class PlayerControlTest extends TestCase {
	BullpenToBoardController btbc;
	Board b;
	Bullpen bp;
	PlayerBoardPanel pbp;
	PlayerBullpenPanel pbup;
	PuzzleLevel pl;
	ReleaseLevel rl;
	LightningLevel ll;
	Piece p;
	Square s1, s2, s3, s4, s5;
	EndLevelController elc;
	SarpedonKabasuji sk;
	PuzzleLevelGui plg;
	LightningLevelGui llg;
	ReleaseLevelGui rlg;
	FlipController fc;
	LevelSelectController lsc;
	LevelSelectGui lsg;
	Loader l;
	NewGameController ngc;
	PlaceLightningPieceController plpc;
	PlacePuzzlePieceController pppc;
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	JLabel jl4;
	JLabel[] jla;
	PlaceReleasePieceController prpc;
	ResetController rc;
	ResetLevelController rlc;
	ReturnToMenuController rtmc;
	RotateController roc;
	SelectPieceController spc;
	SplashScreenController ssc;
	SwitchWindowController swc;
	TimeController tc;
	KabasujiMenuGui kmg;
	PlayerSplashScreen pss;
	ReleaseBoard rb;
	MenuController mc;
	
	protected void setUp() throws Exception{
		super.setUp();
		mc = new MenuController(rlg, sk, rl);
		rb = new ReleaseBoard();
		b = new Board();
		bp = new Bullpen();
		pl = new PuzzleLevel();
		rl = new ReleaseLevel();
		ll = new LightningLevel();
		pbp = new PlayerBoardPanel(pl);
		pbup = new PlayerBullpenPanel(bp);
		btbc = new BullpenToBoardController(b, bp, pbp, pbup);
		s1 = new Square(0, 0);
		s2 = new Square(0, 1);
		s3 = new Square(0, 2);
		s4 = new Square(0, 3);
		s5 = new Square(0, 4);
		p = new Piece(0, s1, s2, s3, s4, s5);
		sk = new SarpedonKabasuji();
		plg = new PuzzleLevelGui(pl, sk);
		rlg = new ReleaseLevelGui(rl, sk);
		llg = new LightningLevelGui(ll, sk);
		elc = new EndLevelController(sk, rlg, rl);
		fc = new FlipController(pbp, rl, false);
		lsg = new LevelSelectGui(sk);
		lsc = new LevelSelectController(lsg, rl);
		l = new Loader();
		ngc = new NewGameController(sk);
		plpc = new PlaceLightningPieceController(ll, llg);
		jl1 = new JLabel();
		jl2 = new JLabel();
		jl3 = new JLabel();
		jl4 = new JLabel();
		jla = new JLabel[10];
		jla[0] = jl2;
		jla[1] = jl3;
		jla[2] = jl4;
		pppc = new PlacePuzzlePieceController(pl, pbp, jl1, jl2);
		prpc = new PlaceReleasePieceController(rl, pbp, jla, jl1);
		rc = new ResetController(pbp);
		rlc = new ResetLevelController(rl, sk, rlg);
		kmg = new KabasujiMenuGui(sk);
		rtmc = new ReturnToMenuController(kmg);
		roc = new RotateController(pbp, rl, false);
		spc = new SelectPieceController(rl, pbp, pbup);
		pss = new PlayerSplashScreen();
		ssc = new SplashScreenController(pss);
		swc = new SwitchWindowController(kmg, rlg);
		tc = new TimeController(ll, jl1, llg, sk);
	}
	public void testMenuController() {
		rl.setStars(2);
		rl.setNumber(1);
		mc = new MenuController(rlg, sk, rl);
		mc.actionPerformed(null);
	}
	public void testBullpenToBoardController() {
		btbc.mouseDragged(null);
		btbc.mouseEntered(new MouseEvent(pbp, 0, 0, 0, 0, 0, 0, false));
		btbc.mouseExited(null);
		btbc.mouseMoved(null);
		btbc.move(p, 0, 0);
		bp.setSelected(p);
		btbc.mouseMoved(new MouseEvent(pbp, 0, 0, 0, 0, 0, 0, false));
	}
	public void testEndLevelController() {
		rl.setNumber(1);
		sk.setLevel(rl);
		elc.mouseClicked(null);
		elc.mouseEntered(null);
		elc.mouseExited(null);
		elc.mousePressed(null);
		elc.mouseReleased(null);
	}
	public void testFlipController() {
		fc.actionPerformed(null);
		rl.getBullpen().setSelected(p);
		fc.actionPerformed(null);
	}
	public void testLevelSelectController() {
		lsc.start(rl);
	}
	public void testLoader() {
		l.getLevel(1);
		l.getMomento(1);
	}
	public void testNewGameController() {
		ngc.actionPerformed(null);
	}
	public void testPlaceLightningPieceController() {
		plpc.mouseClicked(null);
		plpc.mouseEntered(null);
		plpc.mouseExited(null);
		plpc.mousePressed(null);
		plpc.mouseReleased(null);
	}
	public void testPlacePuzzleLevelController() {
		pppc.mouseClicked(null);
		pppc.mouseEntered(null);
		pppc.mouseExited(null);
		pppc.mousePressed(new MouseEvent(pbp, MouseEvent.MOUSE_PRESSED, 0, MouseEvent.BUTTON1_MASK, 0, 0, 1, false));
		pppc.mouseReleased(null);
	}
	public void testPlaceReleasePieceController() {
		prpc.mouseClicked(null);
		prpc.mouseEntered(null);
		prpc.mouseExited(null);
		b.addPiece(0, 0, p);
		prpc.mousePressed(new MouseEvent(pbp, MouseEvent.MOUSE_PRESSED, 0, MouseEvent.BUTTON1_MASK, 0, 0, 1, false));
		prpc.mouseReleased(null);
	}
	public void testResetController() {
		rc.actionPerformed(null);
	}
	public void testResetLevelController() {
		rl.setNumber(1);
		rlc = new ResetLevelController(rl, sk, rlg);
		rlc.actionPerformed(null);
		rlc = new ResetLevelController(ll, sk, llg);
		rlc.actionPerformed(null);
		rlc = new ResetLevelController(pl, sk, plg);
		rlc.actionPerformed(null);
	}
	public void testReturnToMenuController() {
		rtmc.actionPerformed(null);
	}
	public void testRotateController() {
		roc.actionPerformed(null);
		rl.getBullpen().addPiece(p);
		rl.getBullpen().setSelected(p);
		//System.out.println(rl.getBullpen().getSelectedPiece().toString());
		roc.actionPerformed(null);
	}
	public void testSelectPieceController() {
		spc.mouseClicked(null);
		spc.mouseDragged(null);
		spc.mouseEntered(null);
		spc.mouseExited(null);
		spc.mousePressed(new MouseEvent(pbup, 0, 0, 0, 0, 0, 0, false));
		spc.mouseReleased(null);
		spc.mouseWheelMoved(null);
		bp.setSelected(p);
		spc = new SelectPieceController(rl, pbp, pbup);
		spc.mousePressed(new MouseEvent(pbup, 0, 0, 0, 0, 0, 0, false));
	}
	public void testSplashScreenController() {
		
	}
	public void testSwitchWindowController() {
		swc.actionPerformed(null);
	}
	public void testTimeController() {
		tc.actionPerformed(null);
		
	}
}
