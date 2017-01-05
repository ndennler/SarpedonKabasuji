package bounday.player;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.player.NewGameController;
import control.player.SwitchWindowController;
import entity.player.SarpedonKabasuji;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 * Gui for the opening menu for the Kabasuji player 
 * (includes option to immediatly start first level)
 * 
 * @author Drew 
 *
 */
public class KabasujiMenuGui extends JFrame {

	private JPanel contentPane;

	JButton btnNewGame;
	JButton btnLevelSelect;
	
	SarpedonKabasuji game;

	/**
	 * Create the frame.
	 */
	public KabasujiMenuGui(SarpedonKabasuji game) {
		this.game = game;
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBackground(Color.YELLOW);
		btnNewGame.setForeground(Color.RED);
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewGame.setBounds(561, 287, 304, 110);
		contentPane.add(btnNewGame);
		
		btnLevelSelect = new JButton("Level Select");
		btnLevelSelect.setBackground(Color.GREEN);
		btnLevelSelect.setForeground(Color.BLUE);
		btnLevelSelect.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnLevelSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLevelSelect.setBounds(561, 534, 304, 82);
		contentPane.add(btnLevelSelect);
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setFont(new Font("Tahoma", Font.PLAIN, 72));
		lblKabasuji.setBounds(575, 28, 492, 159);
		contentPane.add(lblKabasuji);
		
		btnLevelSelect.addActionListener(new SwitchWindowController(this, new LevelSelectGui(game)));
		btnNewGame.addActionListener(new NewGameController(game));
	}

	/**
	 * gets the actionable level select button element.
	 * @return the actionable level select button element.
	 */
	public JButton getBtnLevelSelect() {
		return btnLevelSelect;
	}

	/**
	 * gets the actionable new game button element.
	 * @return the actionable new game button element.
	 */
	public JButton getBtnNewGame() {
		return btnNewGame;
	}
}
