package bounday.player;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.PlayerApplication;
import boundary.builder.BuilderBoardPanel;
import control.player.*;
import entity.player.PieceBuilder;
import entity.player.PuzzleLevel;
import entity.player.ReleaseLevel;
import entity.player.SarpedonKabasuji;

import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

/**
 * Class for displaying a playable puzzle level.
 * @author Nathan
 *
 */
public class PuzzleLevelGui extends JFrame {

	private JPanel contentPane;
	
	JLabel lblStars;
	JLabel lblMoves;
	
	JButton btnReset;
	JButton btnReturn;
	JButton btnRotateClockwise;
	JButton btnrotateCClockwise;
	JButton btnFlipVert;
	JButton btnFlipHor;

	PlayerBullpenPanel bullpenView;
	PlayerBoardPanel boardView;
	
	PuzzleLevel level;
	SarpedonKabasuji game;


	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PieceBuilder pb = new PieceBuilder();
					PuzzleLevel l = new PuzzleLevel();
					for(int i = 0; i < 6; i++){
					l.getBullpen().addPiece(pb.getPiece(1));
					}
					PuzzleLevelGui frame = new PuzzleLevelGui(l);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public PuzzleLevelGui(PuzzleLevel l, SarpedonKabasuji g) {
		level = l;
		game = g;
		setTitle("Puzzle Level");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		boardView = new PlayerBoardPanel(level);
		boardView.setBounds(620, 123, 720, 720);
		contentPane.add(boardView);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 522, 600, 300);
		contentPane.add(scrollPane);
		
		bullpenView = new PlayerBullpenPanel(level.getBullpen());
		bullpenView.setBounds(0, 0, 1200, 150);
		scrollPane.setViewportView(bullpenView);
		
		JLabel lblNewLabel = new JLabel("Moves Left:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblNewLabel.setBounds(26, 350, 271, 49);
		contentPane.add(lblNewLabel);
		
		lblMoves = new JLabel(level.getMovesLeft().toString());
		lblMoves.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblMoves.setBounds(316, 350, 122, 49);
		contentPane.add(lblMoves);
		
		lblStars = new JLabel("");
		lblStars.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblStars.setBounds(200, 268, 444, 54);
		contentPane.add(lblStars);
		
		JLabel lblStars1 = new JLabel("Stars:");
		lblStars1.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblStars1.setBounds(26, 268, 444, 54);
		contentPane.add(lblStars1);
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(61, 184, 171, 41);
		contentPane.add(btnReset);
		
		JLabel lblLevel = new JLabel("Level " + l.getNumber());
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblLevel.setBounds(190, 28, 327, 82);
		contentPane.add(lblLevel);
		
		btnReturn = new JButton("Return to Main Menu");
		btnReturn.setBackground(Color.LIGHT_GRAY);
		btnReturn.setBounds(316, 184, 171, 41);
		contentPane.add(btnReturn);
		
		btnRotateClockwise = new JButton("Rotate Clockwise");
		btnRotateClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRotateClockwise.setBackground(Color.LIGHT_GRAY);
		btnRotateClockwise.setBounds(1349, 123, 125, 125);
		contentPane.add(btnRotateClockwise);
		
		btnFlipHor = new JButton("Flip Horizontally");
		btnFlipHor.setBackground(Color.LIGHT_GRAY);
		btnFlipHor.setBounds(1349, 718, 125, 125);
		contentPane.add(btnFlipHor);
		
		btnFlipVert = new JButton("Flip Vertically");
		btnFlipVert.setBackground(Color.LIGHT_GRAY);
		btnFlipVert.setBounds(1349, 543, 125, 125);
		contentPane.add(btnFlipVert);
		
		btnrotateCClockwise = new JButton("Rotate C. Clockwise");
		btnrotateCClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnrotateCClockwise.setBackground(Color.LIGHT_GRAY);
		btnrotateCClockwise.setBounds(1349, 297, 125, 125);
		contentPane.add(btnrotateCClockwise);
		
		//attach controllers
		btnFlipVert.addActionListener(new FlipController(boardView, level, true));
		btnFlipHor.addActionListener(new FlipController(boardView, level, false));
		btnRotateClockwise.addActionListener(new RotateController(boardView, level, true));
		btnrotateCClockwise.addActionListener(new RotateController(boardView, level, false));
		
		SelectPieceController spc = new SelectPieceController(level, boardView, bullpenView, lblMoves);
		bullpenView.addMouseListener(spc);
		BullpenToBoardController movePiece = new BullpenToBoardController(level.getBoard(), level.getBullpen(), boardView, bullpenView);
		boardView.addMouseMotionListener(movePiece);
		
		MenuController toMenu = new MenuController (this, game, level);
		btnReturn.addActionListener(toMenu);
		
		PlacePuzzlePieceController place = new PlacePuzzlePieceController(level, boardView, lblMoves, lblStars);
		boardView.addMouseListener(place);
		boardView.addMouseListener(new EndLevelController(game, this, level));
		btnReset.addActionListener(new ResetLevelController(level, game, this));
	}
}
