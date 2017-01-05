package entity.player;
import java.awt.Color;
import java.io.Serializable;
import java.util.HashMap;

public class PieceBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap<Integer, Piece> pieces = new HashMap<Integer, Piece>();
	Color[] palette = new Color[] {Color.BLUE, Color.RED, Color.MAGENTA, Color.YELLOW, Color.ORANGE};

	//Square R = new Square(1, 0);
	//Square D = new Square(0, 1);
	//Square L = new Square(-1, 0);

	//Square R2 = new Square(2, 0);
	//Square D2 = new Square(0, 2);
	//Square L2 = new Square(-2, 0);

	//Square D3 = new Square(0, 3);
	//Square D4 = new Square(0, 4);
	//Square D5 = new Square(0, 5);

	//Square DL = new Square(-1, 1);
	//Square DR = new Square(1, 1);

	//Square D2L = new Square(-1, 2);
	//Square D2R = new Square(1, 2);

	//Square D3L = new Square(-1, 3);
	//Square D3R = new Square(1, 3);

	//Square D4L = new Square(-1, 4);
	//Square D4R = new Square(1, 4);

	 //Square DL2 = new Square(-2, 1);
	 //Square DR2 = new Square(2, 1);

	//Square D2L2 = new Square(-2, 2);
	//Square D2R2 = new Square(2, 2);

	//Square D3L2 = new Square(-2, 3);
	//Square D3R2 = new Square(2, 3);

	Piece P1 = new Piece(1,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5) );

	Piece P2 = new Piece(2,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(1, 0) );

	Piece P3 = new Piece(3,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(-1, 3) );

	Piece P4 = new Piece(4,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(1, 2) );

	Piece P5 = new Piece(5,  new Square(0, 1), new Square(0, 2), new Square(1, 3), new Square(1, 2), new Square(-1, 0) ); // rotated
	// clockwise
	// once

	Piece P6 = new Piece(6,  new Square(0, 1), new Square(0, 2), new Square(1, 3), new Square(1, 2), new Square(1, 4) ); // rotated
	// clockwise
	// once

	Piece P7 = new Piece(7,  new Square(0, 1), new Square(-1, 2), new Square(-1, 3), new Square(-1, 1), new Square(-1, 4) );

	Piece P8 = new Piece(8,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(-1, 2), new Square(-1, 3) );

	Piece P9 = new Piece(9,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(1, 3), new Square(-1, 0) );

	Piece P10 = new Piece(10,  new Square(0, 1), new Square(1, 0), new Square(-1, 0), new Square(0, 2), new Square(0, 3) );

	Piece P11 = new Piece(11,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(-1, 3), new Square(-2, 3) );

	Piece P12 = new Piece(12,  new Square(0, 1), new Square(0, 2), new Square(1, 0), new Square(1, 1), new Square(1, 2) );

	Piece P13 = new Piece(13,  new Square(0, 1), new Square(1, 0), new Square(-1, 1), new Square(-1, 2), new Square(-1, 3) );

	Piece P14 = new Piece(14,  new Square(0, 1), new Square(-1, 1), new Square(-1, 2), new Square(-2, 2), new Square(-2, 3) );

	Piece P15 = new Piece(15,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(-1, 1), new Square(-1, 2) );

	Piece P16 = new Piece(16,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(-1, 1), new Square(1, 1) );

	Piece P17 = new Piece(17,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(1, 3), new Square(1, 1) );

	Piece P18 = new Piece(18,  new Square(0, 1), new Square(0, 2), new Square(1, 2), new Square(2, 2), new Square(1, 3) );

	Piece P19 = new Piece(19,  new Square(0, 1), new Square(0, 2), new Square(-1, 2), new Square(-2, 2), new Square(-2, 3) ); // rotated
	// clockwise

	Piece P20 = new Piece(20,  new Square(0, 1), new Square(0, 2), new Square(1, 2), new Square(1, 3), new Square(1, 1) ); // rotated
	// clockwise

	Piece P21 = new Piece(21,  new Square(0, 1), new Square(0, 2), new Square(1, 2), new Square(-1, 0), new Square(-1, 1) ); // rotated
	// clockwise

	Piece P22 = new Piece(22,  new Square(0, 1), new Square(0, 2), new Square(-1, 1), new Square(-1, 2), new Square(1, 1) );

	Piece P23 = new Piece(23,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(-1, 0), new Square(-1, 3) );

	Piece P24 = new Piece(24,  new Square(0, 1), new Square(-1, 1), new Square(1, 1), new Square(-1, 2), new Square(1, 2) );

	Piece P25 = new Piece(25,  new Square(0, 1), new Square(0, 2), new Square(-1, 0), new Square(-2, 0), new Square(-2, 1) ); // rotated
	// clockwise

	Piece P26 = new Piece(26,  new Square(0, 1), new Square(0, 2), new Square(1, 0), new Square(2, 0), new Square(1, 1) ); // rotated
	// clockwise

	Piece P27 = new Piece(27,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(-1, 0), new Square(1, 1));

	Piece P28 = new Piece(28,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(-1, 2), new Square(-2, 2) );

	Piece P29 = new Piece(29,  new Square(0, 1), new Square(0, 2), new Square(1, 0), new Square(1, 2), new Square(1, 3) ); // rotated
	// clockwise

	Piece P30 = new Piece(30,  new Square(0, 1), new Square(0, 2), new Square(-1, 0), new Square(-1, 2), new Square(1, 2) ); // rotated
	// clockwise

	Piece P31 = new Piece(31,  new Square(0, 1), new Square(0, 2), new Square(1, 2), new Square(1, 1), new Square(2, 1) ); 

	Piece P32 = new Piece(32,  new Square(0, 1), new Square(0, 2), new Square(-1, 3), new Square(-1, 2), new Square(1, 2) );

	Piece P33 = new Piece(33,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(-1, 2), new Square(1, 0) ); // rotated
	// clockwise

	Piece P34 = new Piece(34,  new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(1, 1), new Square(-1, 2) ); // rotated
	// clockwise

	Piece P35 = new Piece(35,  new Square(0, 1), new Square(1, 1), new Square(1, 2), new Square(2, 2), new Square(1, 3) ); // rotated
	// clockwise
	/**
	 * Constructor for PieceBuilder
	 */
	public PieceBuilder(){
		//make all pieces then set their colors
		initialize();
		for(int i=1; i<36; i++ ){
			pieces.get(i).centerPiece();
			pieces.get(i).setColor(palette[i%palette.length]);
		}
	}
	/**
	 * initialized the game pieces
	 */
	public void initialize() {
		pieces.put(1,P1);
		pieces.put(2,P2);
		pieces.put(3,P3);
		pieces.put(4,P4);
		pieces.put(5,P5);
		pieces.put(6,P6);
		pieces.put(7, P7);
		pieces.put(8, P8);
		pieces.put(9, P9);
		pieces.put(10, P10);

		pieces.put(11, P11);
		pieces.put(12, P12);
		pieces.put(13, P13);
		pieces.put(14, P14);
		pieces.put(15, P15);
		pieces.put(16, P16);
		pieces.put(17, P17);
		pieces.put(18, P18);
		pieces.put(19, P19);
		pieces.put(20, P20);

		pieces.put(21,P21);
		pieces.put(22,P22);
		pieces.put(23,P23);
		pieces.put(24,P24);
		pieces.put(25,P25);
		pieces.put(26, P26);
		pieces.put(27, P27);
		pieces.put(28, P28);
		pieces.put(29, P29);
		pieces.put(30, P30);

		pieces.put(31, P31);
		pieces.put(32,P32);
		pieces.put(33, P33);
		pieces.put(34, P34);
		pieces.put(35, P35);

	}
	/**
	 * Gets a piece based on its number
	 * @param num - Desired piece's number
	 * @return the desired piece
	 */
	public Piece getPiece (int num){
		return pieces.get(num).clone();
	}
}
