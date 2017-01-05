package control.builder;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Main.BuilderApplication;
import boundary.builder.BuilderBoardPanel;
import boundary.builder.BuilderBullpenPanel;
import boundary.builder.BuilderStockPanel;
import boundary.builder.LevelBuilderGui;
import boundary.builder.LoadGui;
import entity.builder.BuildableLightning;
import entity.builder.BuildablePuzzle;
import entity.builder.BuildableRelease;
import entity.player.Board;
import entity.player.Bullpen;
import entity.player.LightningLevel;
import entity.player.Piece;
import entity.player.PuzzleLevel;
import entity.player.ReleaseLevel;
import entity.player.SarpedonKabasuji;
import entity.player.Square;
import junit.framework.TestCase;

public class BuilderControlTest extends TestCase {
	Bullpen bp;
	BuilderStockPanel bsp;
	BuilderBullpenPanel bbp;
	BuildableRelease br;
	AddPieceToBullpenController aptbc;
	BuilderBoardPanel bbop;
	BackToStockController btsc;
	JComboBox<Integer> jcb;
	BoardSizeController bsc;
	Board b;
	BullpenToBoardController btbp;
	FlipController fc;
	BuilderApplication ba;
	SarpedonKabasuji sk;
	JTextField jtf;
	LevelBuilderGui lbg;
	LoadGui lg;
	LoadExistingToEditController letec;
	LevelNumberController lnc1;
	LevelNumberController lnc2;
	LevelNumberController lnc3;
	ReleaseLevel rl;
	Piece p;
	Square s1;
	Square s2;
	Square s3;
	Square s4;
	Square s5;
	Square s6;
	HintController hc;
	JRadioButton jrb;
	MoveTilesController mtc;
	NumberTileController ntc;
	PlacePieceController ppc;
	RotateController rc;
	SaveController sc;
	SaveLevelController slc;
	SelectPieceController spc;
	SplashScreenController ssc;
	SwitchWindowController swc;
	UndoController uc;
	UpdateMovesController umc;
	UpdateTimeController utc;
	BuildablePuzzle bup;
	BuildableLightning bl;
	JLabel jl;
	JComboBox<String> jcbs;
	LightningLevel ll;
	PuzzleLevel pl;
	
	protected void setUp() throws Exception{
		super.setUp();
		jl = new JLabel();
		jcbs = new JComboBox<String>();
		bp = new Bullpen();
		bsp = new BuilderStockPanel();
		bbp = new BuilderBullpenPanel(bp);
		br = new BuildableRelease();
		br.setBullpen(bp);
		aptbc = new AddPieceToBullpenController(bp, bsp, bbp, bl);
		bbop = new BuilderBoardPanel(br);
		btsc = new BackToStockController(bp, bsp, bbop, bl);
		jcb = new JComboBox<Integer>();
		bsc = new BoardSizeController(jcb, bbop, bbp, br);
		b = new Board();
		btbp = new BullpenToBoardController(b, bp, bbop, bbp);
		fc = new FlipController(bbop, br, false);
		ba = new BuilderApplication();
		sk = new SarpedonKabasuji();
		jtf = new JTextField();
		lbg = new LevelBuilderGui();
		lg = new LoadGui(lbg);
		letec = new LoadExistingToEditController(jtf, lg);
		rl = new ReleaseLevel();
		pl = new PuzzleLevel();
		ll = new LightningLevel();
		lnc1 = new LevelNumberController(rl, sk);
		lnc2 = new LevelNumberController(ll, sk);
		lnc3 = new LevelNumberController(pl, sk);
		s1 = new Square(0, 0);
		s2 = new Square(0, 1);
		s3 = new Square(0, 2);
		s4 = new Square(0, 3);
		s5 = new Square(0, 4);
		p = new Piece(0, s1, s2, s3, s4, s5);
		jrb = new JRadioButton();
		//hc = new HintController(br, bbop, jrb, jcbs, jcb);
		mtc = new MoveTilesController(br, bbop, jrb);
		ntc = new NumberTileController(jcb, jcbs, br, bbop, jrb);
		ppc = new PlacePieceController(br, bbop, jrb);
		rc = new RotateController(bbop, br, true);
		sc = new SaveController(jtf, br);
		slc = new SaveLevelController(jl, br, lbg);
		spc = new SelectPieceController(bp, bbop, bbp, jrb);
		ssc = new SplashScreenController(null);
		swc = new SwitchWindowController(lbg, lg);
		//uc = new UndoController(bbop);
		bup = new BuildablePuzzle();
		umc = new UpdateMovesController(jtf, bup, jl);
		bl = new BuildableLightning();
		utc = new UpdateTimeController(jtf, bl, jl);
		
	}
	
	
	public void testAddPieceToBullpeController() {
		aptbc.mousePressed(new MouseEvent(bbp, 0, 0, 0, 0, 0, 0, false));
	}
	public void testBackToStockController() {
		btsc.mouseClicked(new MouseEvent(bbp, 0, 0, 0, 0, 0, 0, false));
		btsc.mousePressed(new MouseEvent(bbp, 0, 0, 0, 0, 0, 0, false));
		btsc.mouseReleased(new MouseEvent(bbp, 0, 0, 0, 0, 0, 0, false));
		btsc.mouseEntered(new MouseEvent(bbp, 0, 0, 0, 0, 0, 0, false));
		btsc.mouseExited(new MouseEvent(bbp, 0, 0, 0, 0, 0, 0, false));
	}
	public void testBoardSizeController() {
		jcb.setBounds(220, 141, 85, 45);
		jcb.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24}));
		jcb.setSelectedIndex(23);
		bbp.repaint();
		//bsc.actionPerformed(null);
	}
	public void testBullpenToBoardController() {
		bbop.repaint();
		btbp.mouseDragged(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		btbp.mouseEntered(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		//btbp.mouseExited(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		btbp.mouseMoved(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		btbp.move(p, 0, 0);
	}
	public void testFlipController() {
		fc.actionPerformed(new ActionEvent(bbp, 0, null));
		bp.addPiece(p);
		bp.setSelected(p);
		//fc.actionPerformed(null);
	}

	public void testLevelNumberController() {
		lnc1.changeLevelNumber(5);
		lnc2.changeLevelNumber(5);
		lnc3.changeLevelNumber(5);
		//assertEquals(lnc1.getFrame(), new ReleaseLevelGui((ReleaseLevel)rl, sk));
	}
	public void testLoadExistingToEditController() {
		letec.actionPerformed(null);
		jtf.setText("Level1");
		letec.actionPerformed(null);
		jtf.setText("Level2");
		letec.actionPerformed(null);
		jtf.setText("Level3");
		letec.actionPerformed(null);
	}
	public void testMoveTilesController() {
		mtc.mouseClicked(null);
		mtc.mousePressed(null);
		mtc.mouseReleased(null);
		//mtc.mouseDragged(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		mtc.mouseEntered(null);
		mtc.mouseExited(null);
		mtc.mousePressed(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		jrb.setSelected(false);
		b.setMovingTile(false);
		mtc.mouseReleased(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		jrb.setSelected(true);
		mtc.mouseReleased(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		b.setMovingTile(true);
		jrb.setSelected(false);
		mtc.mouseReleased(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		jrb.setSelected(true);
		mtc.mouseReleased(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		mtc.mousePressed(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		
	}
	public void testNumberTileController(){
		ntc.mouseClicked(null);
		ntc.mouseEntered(null);
		ntc.mouseExited(null);
		ntc.mousePressed(null);
		ntc.mouseReleased(null);
		jrb.setSelected(true);
		jcb.addItem(5);
		jcbs.addItem("kek");
		jcb.setSelectedIndex(0);
		jcbs.setSelectedIndex(0);
		//ntc.mousePressed(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
	}
	public void testPlacePieceController() {
		ppc.mouseClicked(null);
		ppc.mouseEntered(null);
		ppc.mouseExited(null);
		ppc.mousePressed(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, false));
		ppc.mouseReleased(null);
		jrb.setSelected(true);
		ppc.mousePressed(new MouseEvent(bbop, 0, 0, 0, 0, 0, 0, true, 1));
	}
	public void testRotateController() {
		rc.actionPerformed(null);
		rc.rotate(false);
		bp.addPiece(p);
		bp.setSelected(p);
		//rc.actionPerformed(null);
		rc.rotate(true);
	}
//	public void testSaveController() {
//		sc.actionPerformed(null);
//	}
	public void testSaveLevelController() {
		slc.actionPerformed(null);
	}
	public void testSelectPieceController() {
		spc.mouseClicked(null);
		spc.mouseDragged(null);
		spc.mouseEntered(null);
		spc.mouseExited(null);
		spc.mouseMoved(null);
		spc.mousePressed(null);
		spc.mouseReleased(null);
	}
	public void testSplashScreenController() {
		ssc.actionPerformed(null);
		ssc.newLightningLevel();
		ssc.newPuzzleLevel();
		ssc.newReleaseLevel();
		ssc.editExistingLevel();
	}
	public void testSwitchWindowController() {
		swc.actionPerformed(null);
	}

	public void testUpdateMovesController() {
		jtf.setText("1");
		umc.actionPerformed(null);
		jtf.setText("kek");
		umc.actionPerformed(null);
	}
	public void testUpdateTimeController() {
		jtf.setText("2");
		utc.actionPerformed(null);
		jtf.setText("0");
		utc.actionPerformed(null);
		jtf.setText("kek");
		utc.actionPerformed(null);
	}
	
}
