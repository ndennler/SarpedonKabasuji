package boundary.builder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.builder.LoadExistingToEditController;
import control.builder.SwitchWindowController;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Small screen that allows you to type in the level you want to load.
 * @author Nathan
 *
 */
public class LoadGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	JButton btnLoad;
	private JButton btnNewButton;


	/**
	 * Create the frame.
	 */
	public LoadGui(LevelBuilderGui l) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		setTitle("Enter the Name of the Level You Want to Load");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 263, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnLoad = new JButton("Load");
		btnLoad.setBounds(283, 11, 127, 41);
		contentPane.add(btnLoad);
		

		
		btnNewButton = new JButton("Return to Menu");
		btnNewButton.setBounds(126, 63, 137, 37);
		contentPane.add(btnNewButton);
		
		btnLoad.addActionListener(new LoadExistingToEditController(textField, this));
		btnNewButton.addActionListener(new SwitchWindowController(this, l));
	}
}
