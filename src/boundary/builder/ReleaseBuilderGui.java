package boundary.builder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.builder.*;
import entity.builder.BuildablePuzzle;
import entity.builder.BuildableRelease;
import entity.builder.IBuilderModel;
import entity.player.Bullpen;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
/**
 * The graphical user interface for the Release Level Builder.
 * 
 * @author Nathan
 *
 */
public class ReleaseBuilderGui extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JLabel warningLabel;
	
	JButton btnSave;
	JButton btnUndo;

	JButton btnFlipVert;
	JButton btnFlipHor;
	JButton btnRotateClockwise;
	JButton btnRotateCClockwise;
	
	JRadioButton addHintRadio;
	JRadioButton movePiecesRadio;
	JRadioButton moveTilesRadio;
	JRadioButton rdbtnNumberTile;
	
	JComboBox<Integer> boardSizeCombo;
	
	JComboBox<String> colorCombo;
	JComboBox<Integer> numberCombo;
	
	BuilderBullpenPanel bullpenView;
	BuilderStockPanel stockView;
	BuilderBoardPanel boardView;

	
	BuildableRelease model;

	/**
	 * Create the frame.
	 */
	public ReleaseBuilderGui(BuildableRelease bm) {
		model = bm;
		
		model.setType("Release");
		setTitle("Kabasuji Release Level Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		warningLabel = new JLabel("Possible Warning");
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setForeground(Color.RED);
		warningLabel.setBounds(25, 741, 451, 33);
		contentPane.add(warningLabel);
		
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.setBounds(25, 24, 279, 41);
		contentPane.add(btnSave);
		
		btnUndo = new JButton("Undo");
		btnUndo.setBackground(Color.LIGHT_GRAY);
		btnUndo.setBounds(25, 80, 279, 41);
		contentPane.add(btnUndo);
		
		 addHintRadio = new JRadioButton("Add Hint");
		buttonGroup.add(addHintRadio);
		addHintRadio.setBackground(Color.WHITE);
		addHintRadio.setBounds(81, 357, 251, 41);
		contentPane.add(addHintRadio);
		
		movePiecesRadio = new JRadioButton("Move Pieces");
		movePiecesRadio.setSelected(true);
		buttonGroup.add(movePiecesRadio);
		movePiecesRadio.setBackground(Color.WHITE);
		movePiecesRadio.setBounds(81, 418, 251, 41);
		contentPane.add(movePiecesRadio);
		
		moveTilesRadio = new JRadioButton("Move Tiles");
		buttonGroup.add(moveTilesRadio);
		moveTilesRadio.setBackground(Color.WHITE);
		moveTilesRadio.setBounds(81, 479, 251, 41);
		contentPane.add(moveTilesRadio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(767, 54, 600, 148);
		contentPane.add(scrollPane);
		
		bullpenView = new BuilderBullpenPanel(model.getBullpen());
		scrollPane.setViewportView(bullpenView);
		
		JScrollPane stockScrollPane = new JScrollPane();
		stockScrollPane.setBounds(440, 54, 323, 758);
		contentPane.add(stockScrollPane);
		
		stockView = new BuilderStockPanel();
		stockScrollPane.setViewportView(stockView);
		
		JLabel label_2 = new JLabel("Board Size");
		label_2.setBounds(35, 151, 138, 41);
		contentPane.add(label_2);
		
		boardSizeCombo = new JComboBox<Integer>();
		boardSizeCombo.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24}));
		boardSizeCombo.setSelectedIndex(23);
		boardSizeCombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boardSizeCombo.setBounds(223, 151, 75, 45);
		contentPane.add(boardSizeCombo);
		
		boardView = new BuilderBoardPanel(model);
		boardView.setBounds(767, 213, 600, 600);
		contentPane.add(boardView);
		
		rdbtnNumberTile = new JRadioButton("Number Tile");
		buttonGroup.add(rdbtnNumberTile);
		rdbtnNumberTile.setBackground(Color.WHITE);
		rdbtnNumberTile.setBounds(81, 548, 109, 23);
		contentPane.add(rdbtnNumberTile);
		
		colorCombo = new JComboBox<String>();
		colorCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Blue", "Green", "Red"}));
		colorCombo.setSelectedIndex(1);
		colorCombo.setBounds(155, 578, 64, 20);
		contentPane.add(colorCombo);
		
		numberCombo = new JComboBox<Integer>();
		numberCombo.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0,1,2,3,4,5,6}));
		numberCombo.setBounds(155, 609, 64, 20);
		contentPane.add(numberCombo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(108, 581, 37, 14);
		contentPane.add(lblColor);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(108, 612, 53, 14);
		contentPane.add(lblNumber);
		
	
		
		btnRotateClockwise = new JButton("Rotate Clockwise");
		btnRotateClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRotateClockwise.setBackground(Color.LIGHT_GRAY);
		btnRotateClockwise.setBounds(767, 824, 125, 125);
		contentPane.add(btnRotateClockwise);
		
		btnRotateCClockwise = new JButton("Rotate C. Clockwise");
		btnRotateCClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRotateCClockwise.setBackground(Color.LIGHT_GRAY);
		btnRotateCClockwise.setBounds(931, 824, 125, 125);
		contentPane.add(btnRotateCClockwise);
		
		btnFlipVert = new JButton("Flip Vertically");
		btnFlipVert.setBackground(Color.LIGHT_GRAY);
		btnFlipVert.setBounds(1088, 824, 125, 125);
		contentPane.add(btnFlipVert);
		
		btnFlipHor = new JButton("Flip Horizontally");
		btnFlipHor.setBackground(Color.LIGHT_GRAY);
		btnFlipHor.setBounds(1242, 824, 125, 125);
		contentPane.add(btnFlipHor);
		
		//install controllers
		btnSave.addActionListener(new SaveLevelController(warningLabel, model, this));
		
		AddPieceToBullpenController apb = new AddPieceToBullpenController(model.getBullpen(), stockView, bullpenView, model);
		stockView.addMouseListener(apb);
		BackToStockController bsc = new BackToStockController(model.getBullpen(), stockView, boardView, model);
		stockView.addMouseListener(bsc);
		
		SelectPieceController spc = new SelectPieceController(model.getBullpen(), boardView, bullpenView, movePiecesRadio);
		bullpenView.addMouseListener(spc);
		SelectPieceController selectHint = new SelectPieceController(model.getBullpen(), boardView, bullpenView, addHintRadio);
		bullpenView.addMouseListener(selectHint);
		
		BullpenToBoardController movePiece = new BullpenToBoardController(model.getBoard(), model.getBullpen(), boardView, bullpenView);
		boardView.addMouseMotionListener(movePiece);
		PlacePieceController place = new PlacePieceController(model, boardView, movePiecesRadio);
		boardView.addMouseListener(place);
		MoveTilesController mtc = new MoveTilesController(model, boardView, moveTilesRadio);
		boardView.addMouseListener(mtc);
		boardView.addMouseMotionListener(mtc);
		NumberTileController numTiles = new NumberTileController(numberCombo, colorCombo, model, boardView, rdbtnNumberTile);
		boardView.addMouseListener(numTiles);
		
		HintController aHint = new HintController(model, boardView, addHintRadio);
		boardView.addMouseListener(aHint);
		
		btnFlipVert.addActionListener(new FlipController(boardView, model, true));
		btnFlipHor.addActionListener(new FlipController(boardView, model, false));
		btnRotateClockwise.addActionListener(new RotateController(boardView, model, true));
		btnRotateCClockwise.addActionListener(new RotateController(boardView, model, false));
		BoardSizeController size = new BoardSizeController(boardSizeCombo, boardView, bullpenView, model);
		boardSizeCombo.addActionListener(size);
	
		UndoController uC = new UndoController(this.model, boardView, bullpenView);
		btnUndo.addMouseListener(uC);
		
	}
}
