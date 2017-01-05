package bounday.player;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.PlayerApplication;
import boundary.builder.BuilderBoardPanel;
import control.player.BullpenToBoardController;
import control.player.EndLevelController;
import control.player.FlipController;
import control.player.MenuController;
import control.player.PlaceReleasePieceController;
import control.player.ResetLevelController;
import control.player.RotateController;
import control.player.SelectPieceController;
import control.player.SwitchWindowController;
import entity.player.ReleaseLevel;
import entity.player.SarpedonKabasuji;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollBar;
/**
 * Displays the interface for a release level
 * 
 * @author Nathan
 *
 */
public class ReleaseLevelGui extends JFrame {

	private JPanel contentPane;

	JLabel lblStars;
	JLabel lblRedNums;
	JLabel lblBlueNums;
	JLabel lblGreenNums;
	
	JButton btnReset;
	JButton btnReturn;
	JButton btnRotateClockwise;
	JButton btnrotateCClockwise;
	JButton btnFlipVert;
	JButton btnFlipHor;

	
	PlayerBoardPanel boardView;
	PlayerBullpenPanel bullpenView;
	
	ReleaseLevel level;
	SarpedonKabasuji game;

	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReleaseLevel l = new ReleaseLevel();
					ReleaseLevelGui frame = new ReleaseLevelGui(l);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ReleaseLevelGui(ReleaseLevel l, SarpedonKabasuji g) {
		level = l;
		game = g;
		setTitle("Release Level");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PlayerBoardPanel panel = new PlayerBoardPanel(level);
		panel.setBounds(620, 126, 720, 720);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 544, 600, 300);
		contentPane.add(scrollPane);
		
		bullpenView = new PlayerBullpenPanel(level.getBullpen());
		bullpenView.setPreferredSize(new Dimension(1200, 150));
		scrollPane.setViewportView(bullpenView);
		
		JLabel lblNumbersCovered = new JLabel("Numbers Covered:");
		lblNumbersCovered.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNumbersCovered.setBounds(31, 334, 420, 49);
		contentPane.add(lblNumbersCovered);
		
		lblStars = new JLabel("");
		lblStars.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblStars.setBounds(200, 269, 144, 54);
		contentPane.add(lblStars);
		
		JLabel lblStars1 = new JLabel("Stars:");
		lblStars1.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblStars1.setBounds(26, 268, 444, 54);
		contentPane.add(lblStars1);
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(66, 185, 171, 41);
		contentPane.add(btnReset);
		
		JLabel lblLevel = new JLabel("Level " + l.getNumber());
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblLevel.setBounds(195, 29, 327, 82);
		contentPane.add(lblLevel);
		
		btnReturn = new JButton("Return to Main Menu");
		btnReturn.setBackground(Color.LIGHT_GRAY);
		btnReturn.setBounds(321, 185, 171, 41);
		contentPane.add(btnReturn);
		
		lblRedNums = new JLabel(level.getText(Color.red));
		lblRedNums.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRedNums.setForeground(Color.RED);
		lblRedNums.setBounds(66, 394, 285, 23);
		contentPane.add(lblRedNums);
		
		lblBlueNums = new JLabel(level.getText(Color.blue));
		lblBlueNums.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBlueNums.setForeground(Color.BLUE);
		lblBlueNums.setBounds(66, 419, 285, 23);
		contentPane.add(lblBlueNums);
		
		lblGreenNums = new JLabel(level.getText(Color.green));
		lblGreenNums.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGreenNums.setForeground(Color.GREEN);
		lblGreenNums.setBounds(66, 444, 285, 23);
		contentPane.add(lblGreenNums);
		
		btnRotateClockwise = new JButton("Rotate Clockwise");
		btnRotateClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRotateClockwise.setBackground(Color.LIGHT_GRAY);
		btnRotateClockwise.setBounds(1350, 126, 125, 125);
		contentPane.add(btnRotateClockwise);
		
		btnrotateCClockwise = new JButton("Rotate C. Clockwise");
		btnrotateCClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnrotateCClockwise.setBackground(Color.LIGHT_GRAY);
		btnrotateCClockwise.setBounds(1350, 300, 125, 125);
		contentPane.add(btnrotateCClockwise);
		
		boardView = new PlayerBoardPanel(level);
		boardView.setBounds(620, 123, 720, 720);
		contentPane.add(boardView);
		
		btnFlipVert = new JButton("Flip Vertically");
		btnFlipVert.setBackground(Color.LIGHT_GRAY);
		btnFlipVert.setBounds(1350, 546, 125, 125);
		contentPane.add(btnFlipVert);
		
		btnFlipHor = new JButton("Flip Horizontally");
		btnFlipHor.setBackground(Color.LIGHT_GRAY);
		btnFlipHor.setBounds(1350, 721, 125, 125);
		contentPane.add(btnFlipHor);
		
		//attach controllers
		btnFlipVert.addActionListener(new FlipController(boardView, level, true));
		btnFlipHor.addActionListener(new FlipController(boardView, level, false));
		btnRotateClockwise.addActionListener(new RotateController(boardView, level, true));
		btnrotateCClockwise.addActionListener(new RotateController(boardView, level, false));
		
		MenuController toMenu = new MenuController (this, game, level);
		btnReturn.addActionListener(toMenu);
		
		SelectPieceController spc = new SelectPieceController(level, boardView, bullpenView);
		bullpenView.addMouseListener(spc);
		BullpenToBoardController movePiece = new BullpenToBoardController(level.getBoard(), level.getBullpen(), boardView, bullpenView);
		boardView.addMouseMotionListener(movePiece);
		JLabel[] rgbCovered= new JLabel[]{lblRedNums, lblGreenNums, lblBlueNums};
		PlaceReleasePieceController prpc = new PlaceReleasePieceController(l, boardView, rgbCovered, lblStars);
		boardView.addMouseListener(prpc);
		boardView.addMouseListener(new EndLevelController(game, this, level));
		btnReset.addActionListener(new ResetLevelController(level, game, this));
	}

}
