package bounday.player;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.PlayerApplication;
import boundary.builder.BuilderBoardPanel;
import control.player.*;
import entity.player.*;

import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;
/**
 * Displays interface for a playable lightning level
 * 
 * @author Nathan
 *
 */
public class LightningLevelGui extends JFrame {

	private JPanel contentPane;

	JLabel lblStars;
	JLabel lblTime;
	
	JButton btnReset;
	JButton btnReturn;
	JButton btnRotateClockwise;
	JButton btnrotateCClockwise;
	JButton btnFlipVert;
	JButton btnFlipHor;

	PlayerBullpenPanel bullpenView;
	PlayerBoardPanel boardView;
	
	LightningLevel level;

	/**
	 * gets the bullpen panel.
	 * @return the bullpen panel
	 */
	public PlayerBullpenPanel getBullpenView(){
		return bullpenView;
	}
	/**
	 * gets the board panel.
	 * @return the board panel.
	 */
	public PlayerBoardPanel getBoardView(){
		return boardView;
	}
	/**
	 * gets the label that displays the current number of stars.
	 * @return the label that displays the current number of stars
	 */
	public JLabel getStarsView(){
		return lblStars;
	}
	/**
	 * sets the number of stars label to the given string.
	 * @param s
	 */
	public void setStarsView(String s){
		lblStars.setText(s); 
	}

	/**
	 * Create the frame.
	 * @param l a lightning level in the SarpedonKabasuji game being played
	 * @param game the SarpedonKabasuji game being played
	 */
	public LightningLevelGui(LightningLevel l, SarpedonKabasuji game) {
		level = l;
		setTitle("Lightning Level");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 503, 600, 300);
		contentPane.add(scrollPane);
		
		bullpenView = new PlayerBullpenPanel(l.getBullpen());
		bullpenView.setPreferredSize(new Dimension(1200, 150));
		scrollPane.setViewportView(bullpenView);
		
		JLabel lblTimeLeft = new JLabel("Time Left:");
		lblTimeLeft.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblTimeLeft.setBounds(10, 333, 271, 49);
		contentPane.add(lblTimeLeft);
		
		lblTime = new JLabel(level.getTimeLeft().toString());
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblTime.setBounds(300, 333, 122, 49);
		contentPane.add(lblTime);
		
		lblStars = new JLabel("");
		lblStars.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblStars.setBounds(200, 251, 344, 54);
		contentPane.add(lblStars);
		
		JLabel lblStars1 = new JLabel("Stars:");
		lblStars1.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblStars1.setBounds(26, 268, 444, 54);
		contentPane.add(lblStars1);
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(45, 167, 171, 41);
		contentPane.add(btnReset);
		
		JLabel lblLevel = new JLabel("Level " + l.getNumber());
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblLevel.setBounds(174, 11, 327, 82);
		contentPane.add(lblLevel);
		
		btnReturn = new JButton("Return to Main Menu");
		btnReturn.setBackground(Color.LIGHT_GRAY);
		btnReturn.setBounds(300, 167, 171, 41);
		contentPane.add(btnReturn);
		
		boardView = new PlayerBoardPanel(l);
		boardView.setBounds(620, 83, 720, 720);
		contentPane.add(boardView);
		
		btnRotateClockwise = new JButton("Rotate Clockwise");
		btnRotateClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRotateClockwise.setBackground(Color.LIGHT_GRAY);
		btnRotateClockwise.setBounds(1350, 83, 125, 125);
		contentPane.add(btnRotateClockwise);
		
		btnrotateCClockwise = new JButton("Rotate C. Clockwise");
		btnrotateCClockwise.setBackground(Color.LIGHT_GRAY);
		btnrotateCClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnrotateCClockwise.setBounds(1350, 257, 125, 125);
		contentPane.add(btnrotateCClockwise);
		
		btnFlipVert = new JButton("Flip Vertically");
		btnFlipVert.setBackground(Color.LIGHT_GRAY);
		btnFlipVert.setBounds(1350, 503, 125, 125);
		contentPane.add(btnFlipVert);
		
		btnFlipHor = new JButton("Flip Horizontally");
		btnFlipHor.setBackground(Color.LIGHT_GRAY);
		btnFlipHor.setBounds(1350, 678, 125, 125);
		contentPane.add(btnFlipHor);
		
		//attach controllers
		btnFlipVert.addActionListener(new FlipController(boardView, level, true));
		btnFlipHor.addActionListener(new FlipController(boardView, level, false));
		btnRotateClockwise.addActionListener(new RotateController(boardView, level, true));
		btnrotateCClockwise.addActionListener(new RotateController(boardView, level, false));
		
		SelectPieceController spc = new SelectPieceController(level, boardView, bullpenView);
		bullpenView.addMouseListener(spc);
		BullpenToBoardController movePiece = new BullpenToBoardController(level.getBoard(), level.getBullpen(), boardView, bullpenView);
		boardView.addMouseMotionListener(movePiece);
		boardView.addMouseListener(new PlaceLightningPieceController(level, this));
		boardView.addMouseListener(new EndLevelController(game, this, level));
		
		MenuController toMenu = new MenuController (this, game, level);
		btnReturn.addActionListener(toMenu);
		
		ActionListener updateTime = new TimeController(level, lblTime, this, game);
		Timer timer = new Timer(1000, updateTime);
		timer.start();
		btnReset.addActionListener(new ResetLevelController(level, game, this));
	}

}
