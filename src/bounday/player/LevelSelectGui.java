package bounday.player;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.PlayerApplication;
import control.builder.LevelNumberController;
import control.player.Loader;
import control.player.SwitchWindowController;
import entity.player.SarpedonKabasuji;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
/**
 * Allows the selection of various levels and shows which are unlocked
 *  and how many stars the player has earned on each level.
 * @author Drew 
 *
 */
public class LevelSelectGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JButton btnLevel1;
	 JButton btnLevel2;
	JButton btnLevel3;
	JButton btnLevel4;
	JButton btnLevel5;
	JButton btnLevel6;
	JButton btnLevel7;
	JButton btnLevel8;
	JButton btnLevel9;
	JButton btnLevel10;
	JButton btnLevel11;
	JButton btnLevel12;
	JButton btnLevel13;
	JButton btnLevel14;
	JButton btnLevel15;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	

	/**
	 * gets the list of buttons so you can iterate through them to attach controllers.
	 * @return the list of buttons so you can iterate through them to attach controllers.
	 */
	public JButton[] getButtons(){
		return new JButton[]{btnLevel1, btnLevel2, btnLevel3, btnLevel4, btnLevel5, btnLevel6, btnLevel7, 
				btnLevel8, btnLevel9, btnLevel10, btnLevel11, btnLevel12, btnLevel13, btnLevel14, btnLevel15 };
	}
	/**
	 * gets an array of labels so that you can iterate through them when displaying stars.
	 * @return an array of labels so that you can iterate through them when displaying stars.
	 */
	public JLabel[] getLabels(){
		return new JLabel[]{lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11, lbl12, lbl13, 
				lbl14, lbl15};
	}

	/**
	 * Create the frame.
	 * @param game 
	 */
	public LevelSelectGui(SarpedonKabasuji game) {
		setTitle("Level Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLevel1 = new JButton("Level 1");
		btnLevel1.setBackground(Color.LIGHT_GRAY);
		btnLevel1.setBounds(26, 359, 250, 120);
		contentPane.add(btnLevel1);
		
		btnLevel2 = new JButton("Level 2");
		btnLevel2.setEnabled(true);
		btnLevel2.setBackground(Color.LIGHT_GRAY);
		btnLevel2.setBounds(26, 541, 250, 120);
		contentPane.add(btnLevel2);
		
		btnLevel3 = new JButton("Level 3");
		btnLevel3.setEnabled(true);
		btnLevel3.setBackground(Color.LIGHT_GRAY);
		btnLevel3.setBounds(26, 722, 250, 120);
		contentPane.add(btnLevel3);
		
		btnLevel4 = new JButton("Level 4");
		btnLevel4.setEnabled(false);
		btnLevel4.setBackground(Color.LIGHT_GRAY);
		btnLevel4.setBounds(327, 359, 250, 120);
		contentPane.add(btnLevel4);
		
		btnLevel5 = new JButton("Level 5");
		btnLevel5.setEnabled(false);
		btnLevel5.setBackground(Color.LIGHT_GRAY);
		btnLevel5.setForeground(Color.BLACK);
		btnLevel5.setBounds(327, 541, 250, 120);
		contentPane.add(btnLevel5);
		
		btnLevel6 = new JButton("Level 6");
		btnLevel6.setEnabled(false);
		btnLevel6.setBackground(Color.LIGHT_GRAY);
		btnLevel6.setForeground(Color.BLACK);
		btnLevel6.setBounds(327, 722, 250, 120);
		contentPane.add(btnLevel6);
		
		btnLevel7 = new JButton("Level 7");
		btnLevel7.setEnabled(false);
		btnLevel7.setBackground(Color.LIGHT_GRAY);
		btnLevel7.setForeground(Color.BLACK);
		btnLevel7.setBounds(637, 359, 250, 120);
		contentPane.add(btnLevel7);
		
		btnLevel8 = new JButton("Level 8");
		btnLevel8.setEnabled(false);
		btnLevel8.setBackground(Color.LIGHT_GRAY);
		btnLevel8.setForeground(Color.BLACK);
		btnLevel8.setBounds(637, 541, 250, 120);
		contentPane.add(btnLevel8);
		
		btnLevel9 = new JButton("Level 9");
		btnLevel9.setEnabled(false);
		btnLevel9.setBackground(Color.LIGHT_GRAY);
		btnLevel9.setForeground(Color.BLACK);
		btnLevel9.setBounds(637, 722, 250, 120);
		contentPane.add(btnLevel9);
		
		btnLevel10 = new JButton("Level 10");
		btnLevel10.setEnabled(false);
		btnLevel10.setBackground(Color.LIGHT_GRAY);
		btnLevel10.setForeground(Color.BLACK);
		btnLevel10.setBounds(923, 359, 250, 120);
		contentPane.add(btnLevel10);
		
		btnLevel11 = new JButton("Level 11");
		btnLevel11.setEnabled(false);
		btnLevel11.setBackground(Color.LIGHT_GRAY);
		btnLevel11.setForeground(Color.BLACK);
		btnLevel11.setBounds(923, 541, 250, 120);
		contentPane.add(btnLevel11);
		
		btnLevel12 = new JButton("Level 12");
		btnLevel12.setEnabled(false);
		btnLevel12.setBackground(Color.LIGHT_GRAY);
		btnLevel12.setForeground(Color.BLACK);
		btnLevel12.setBounds(923, 722, 250, 120);
		contentPane.add(btnLevel12);
		
		btnLevel13 = new JButton("Level 13");
		btnLevel13.setEnabled(false);
		btnLevel13.setBackground(Color.LIGHT_GRAY);
		btnLevel13.setForeground(Color.BLACK);
		btnLevel13.setBounds(1210, 359, 250, 120);
		contentPane.add(btnLevel13);
		
		btnLevel14 = new JButton("Level 14");
		btnLevel14.setEnabled(false);
		btnLevel14.setBackground(Color.LIGHT_GRAY);
		btnLevel14.setForeground(Color.BLACK);
		btnLevel14.setBounds(1210, 541, 250, 120);
		contentPane.add(btnLevel14);
		
		btnLevel15 = new JButton("Level 15");
		btnLevel15.setEnabled(false);
		btnLevel15.setBackground(Color.LIGHT_GRAY);
		btnLevel15.setForeground(Color.BLACK);
		btnLevel15.setBounds(1210, 722, 250, 120);
		contentPane.add(btnLevel15);
		
		JLabel lblSelectALevel = new JLabel("Select a Level");
		lblSelectALevel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblSelectALevel.setBounds(531, 64, 636, 168);
		contentPane.add(lblSelectALevel);
		
		lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(26, 490, 250, 40);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(26, 672, 250, 40);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setBounds(26, 853, 250, 40);
		contentPane.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setBounds(327, 490, 250, 40);
		contentPane.add(lbl4);
		
		lbl5 = new JLabel("");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setBounds(327, 671, 250, 40);
		contentPane.add(lbl5);
		
		lbl6 = new JLabel("");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setBounds(327, 853, 250, 40);
		contentPane.add(lbl6);
		
		lbl7 = new JLabel("");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setBounds(637, 490, 250, 40);
		contentPane.add(lbl7);
		
		lbl8 = new JLabel("");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setBounds(637, 671, 250, 40);
		contentPane.add(lbl8);
		
		lbl9 = new JLabel("");
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setBounds(637, 853, 250, 40);
		contentPane.add(lbl9);
		
		lbl10 = new JLabel("");
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		lbl10.setBounds(923, 490, 250, 40);
		contentPane.add(lbl10);
		
		lbl11 = new JLabel("");
		lbl11.setHorizontalAlignment(SwingConstants.CENTER);
		lbl11.setBounds(923, 672, 250, 40);
		contentPane.add(lbl11);
		
		lbl12 = new JLabel("");
		lbl12.setHorizontalAlignment(SwingConstants.CENTER);
		lbl12.setBounds(923, 853, 250, 40);
		contentPane.add(lbl12);
		
		lbl13 = new JLabel("");
		lbl13.setHorizontalAlignment(SwingConstants.CENTER);
		lbl13.setBounds(1210, 490, 250, 40);
		contentPane.add(lbl13);
		
		lbl14 = new JLabel("");
		lbl14.setHorizontalAlignment(SwingConstants.CENTER);
		lbl14.setBounds(1210, 671, 250, 40);
		contentPane.add(lbl14);
		
		lbl15 = new JLabel("");
		lbl15.setHorizontalAlignment(SwingConstants.CENTER);
		lbl15.setBounds(1210, 853, 250, 40);
		contentPane.add(lbl15);
		
		JButton[] buttons = getButtons();
		JLabel[] labels = getLabels();
		Loader loader = new Loader();
		
		
		for(int i = 0; i<15; i++){
			buttons[i].setEnabled(false);
			if(game.getLevel(i+1) != null){
			if(i < game.getCurrentLevel()){
				int stars = game.getLevel(i+1).getStars();
				if(stars == 3){
					labels[i].setIcon(new ImageIcon(PlayerApplication.class.getResource("/images/ThreeSmallStars.png")));
				}
				if(stars == 2){
					labels[i].setIcon(new ImageIcon(PlayerApplication.class.getResource("/images/TwoSmallStars.png")));
				}
				if(stars == 1){
					labels[i].setIcon(new ImageIcon(PlayerApplication.class.getResource("/images/OneSmallStar.png")));
				}
				if(stars == 0){
					labels[i].setIcon(null);
				}
				
				buttons[i].setEnabled(true);
				LevelNumberController lC = new LevelNumberController(loader.getLevel(i+1), game);
				buttons[i].addActionListener(new SwitchWindowController(this, lC.getFrame()));
			}
			}
		}
	}
}
