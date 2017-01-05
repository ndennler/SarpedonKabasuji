package boundary.builder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import control.builder.AddPieceToBullpenController;
import control.builder.BackToStockController;
import control.builder.BoardSizeController;
import control.builder.BullpenToBoardController;
import control.builder.FlipController;
import control.builder.HintController;
import control.builder.MoveTilesController;
import control.builder.PlacePieceController;
import control.builder.RotateController;
import control.builder.SaveLevelController;
import control.builder.SelectPieceController;
import control.builder.SwitchWindowController;
import control.builder.UndoController;
import control.builder.UpdateMovesController;
import entity.builder.BuildableLightning;
import entity.builder.BuildablePuzzle;

import entity.builder.IBuilderModel;
import entity.player.Bullpen;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

/**
 * The Puzzle Level Builder Graphical User Interface.
 * 
 * @author Nathan 
 *
 */
public class PuzzleBuilderGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
	
	JComboBox<Integer> boardSizeCombo;
	
	
	BuilderBullpenPanel bullpenView;
	BuilderStockPanel stockView;
	BuilderBoardPanel boardView;
	
	
	BuildablePuzzle model;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PuzzleBuilderGui frame = new PuzzleBuilderGui();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public PuzzleBuilderGui(BuildablePuzzle bp) {
		model = bp;
		model.setType("Puzzle");
		
		setTitle("Kabasuji Puzzle Level Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		boardView = new BuilderBoardPanel(model);
		boardView.setBounds(738, 205, 600, 600);
		
		JScrollPane bullpenScrollPane = new JScrollPane();
		bullpenScrollPane.setBounds(738, 48, 600, 153);
		
		bullpenView = new BuilderBullpenPanel(model.getBullpen());
		bullpenView.setPreferredSize(new Dimension(1000, 130));
		bullpenScrollPane.setViewportView(bullpenView);
		
		JLabel lblTotalMoves = new JLabel("Total Moves");
		lblTotalMoves.setBounds(16, 682, 148, 33);
		
		JScrollPane stockScrollPane = new JScrollPane();
		stockScrollPane.setBounds(429, 48, 303, 757);
		
		stockView = new BuilderStockPanel();
		stockView.setPreferredSize(new Dimension(280, 1200));
		stockScrollPane.setViewportView(stockView);
		
		JLabel lblBoardsize = new JLabel("Board Size");
		lblBoardsize.setBounds(16, 143, 138, 41);
		
		boardSizeCombo = new JComboBox<Integer>();
		boardSizeCombo.setBounds(220, 141, 85, 45);
		boardSizeCombo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boardSizeCombo.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24}));
		boardSizeCombo.setSelectedIndex(23);
		
		textField = new JTextField();
		if(model.getMovesAllotted() != null){
			textField.setText(model.getMovesAllotted().toString());
		}
		textField.setBounds(190, 679, 105, 39);
		textField.setColumns(10);
		
		warningLabel = new JLabel("Possible Warning");
		warningLabel.setBounds(26, 745, 451, 33);
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setForeground(Color.RED);
		
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.setBounds(26, 28, 279, 41);
		
		btnUndo = new JButton("Undo");
		btnUndo.setBackground(Color.LIGHT_GRAY);
		btnUndo.setBounds(26, 80, 279, 41);
		
		addHintRadio = new JRadioButton("Add Hint");
		addHintRadio.setBounds(82, 361, 251, 41);
		addHintRadio.setBackground(Color.WHITE);
		buttonGroup.add(addHintRadio);
		
		movePiecesRadio = new JRadioButton("Move Pieces");
		movePiecesRadio.setSelected(true);
		movePiecesRadio.setBounds(82, 422, 251, 41);
		movePiecesRadio.setBackground(Color.WHITE);
		buttonGroup.add(movePiecesRadio);
		
		moveTilesRadio = new JRadioButton("Move Tiles");
		moveTilesRadio.setBounds(82, 483, 251, 41);
		moveTilesRadio.setBackground(Color.WHITE);
		buttonGroup.add(moveTilesRadio);
		
	
		
		
		
		JButton btnFlipVert = new JButton("Flip Vertically");
		btnFlipVert.setBounds(1059, 813, 125, 125);
		btnFlipVert.setBackground(Color.LIGHT_GRAY);
		
		btnRotateClockwise = new JButton("Rotate Clockwise");
		btnRotateClockwise.setBounds(738, 813, 125, 125);
		btnRotateClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRotateClockwise.setBackground(Color.LIGHT_GRAY);
		
		btnRotateCClockwise = new JButton("Rotate C. Clockwise");
		btnRotateCClockwise.setBounds(897, 813, 125, 125);
		btnRotateCClockwise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRotateCClockwise.setBackground(Color.LIGHT_GRAY);
		
		btnFlipHor = new JButton("Flip Horizontally");
		btnFlipHor.setBounds(1213, 813, 125, 125);
		btnFlipHor.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_panel = new GroupLayout(boardView);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 598, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 598, Short.MAX_VALUE)
		);
		boardView.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(btnSave);
		contentPane.add(btnUndo);
		contentPane.add(lblBoardsize);
		contentPane.add(boardSizeCombo);

		contentPane.add(moveTilesRadio);
		contentPane.add(addHintRadio);
		contentPane.add(movePiecesRadio);
		contentPane.add(lblTotalMoves);
		contentPane.add(textField);
		contentPane.add(warningLabel);
		contentPane.add(btnRotateClockwise);
		contentPane.add(btnRotateCClockwise);
		contentPane.add(stockScrollPane);
		contentPane.add(bullpenScrollPane);
		contentPane.add(boardView);
		contentPane.add(btnFlipVert);
		contentPane.add(btnFlipHor);
		
		//install controllers
		
		
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
		
		textField.addActionListener(new UpdateMovesController(textField, model, warningLabel));
		btnSave.addActionListener(new SaveLevelController(warningLabel, model, this));
	}
}
