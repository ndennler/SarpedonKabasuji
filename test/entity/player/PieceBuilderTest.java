package entity.player;

import junit.framework.TestCase;
/**
 *  Tests for Piece Builder
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class PieceBuilderTest extends TestCase {
	PieceBuilder pB;
	protected void setUp() throws Exception {
		super.setUp();
		pB = new PieceBuilder();
	}

	public void testInitialize() {
		pB.initialize();
		for(int i = 1; i<=35; i++){
			assertTrue(pB.pieces.containsKey(i));
			assertTrue(pB.pieces.get(i) instanceof Piece);
		}
		assertTrue(pB.pieces.get(1) == pB.P1);
		assertTrue(pB.pieces.get(2) == pB.P2);
		assertTrue(pB.pieces.get(3) == pB.P3);
		assertTrue(pB.pieces.get(4) == pB.P4);
		assertTrue(pB.pieces.get(5) == pB.P5);
		assertTrue(pB.pieces.get(6) == pB.P6);
		assertTrue(pB.pieces.get(7) == pB.P7);
		assertTrue(pB.pieces.get(8) == pB.P8);
		assertTrue(pB.pieces.get(9) == pB.P9);
		assertTrue(pB.pieces.get(10) == pB.P10);
		assertTrue(pB.pieces.get(11) == pB.P11);
		assertTrue(pB.pieces.get(12) == pB.P12);
		assertTrue(pB.pieces.get(13) == pB.P13);
		assertTrue(pB.pieces.get(14) == pB.P14);
		assertTrue(pB.pieces.get(15) == pB.P15);
		assertTrue(pB.pieces.get(16) == pB.P16);
		assertTrue(pB.pieces.get(17) == pB.P17);
		assertTrue(pB.pieces.get(18) == pB.P18);
		assertTrue(pB.pieces.get(19) == pB.P19);
		assertTrue(pB.pieces.get(20) == pB.P20);
		assertTrue(pB.pieces.get(21) == pB.P21);
		assertTrue(pB.pieces.get(22) == pB.P22);
		assertTrue(pB.pieces.get(23) == pB.P23);
		assertTrue(pB.pieces.get(24) == pB.P24);
		assertTrue(pB.pieces.get(25) == pB.P25);
		assertTrue(pB.pieces.get(26) == pB.P26);
		assertTrue(pB.pieces.get(27) == pB.P27);
		assertTrue(pB.pieces.get(28) == pB.P28);
		assertTrue(pB.pieces.get(29) == pB.P29);
		assertTrue(pB.pieces.get(30) == pB.P30);
		assertTrue(pB.pieces.get(31) == pB.P31);
		assertTrue(pB.pieces.get(32) == pB.P32);
		assertTrue(pB.pieces.get(33) == pB.P33);
		assertTrue(pB.pieces.get(34) == pB.P34);
		assertTrue(pB.pieces.get(35) == pB.P35);
	}

	public void testGetPiece() {
		pB.initialize();
		assertFalse(pB.getPiece(17).equals(pB.P17));
		
		Piece testPiece = pB.getPiece(17);
		for(int i= 0; i<=5; i++){
			assertTrue(pB.P17.getDependent()[i].getxFromAnchor() == testPiece.getDependent()[i].getxFromAnchor());
			assertTrue(pB.P17.getDependent()[i].getyFromAnchor() == testPiece.getDependent()[i].getyFromAnchor());
		}
	}

}
