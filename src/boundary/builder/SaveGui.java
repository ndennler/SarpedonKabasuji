package boundary.builder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.builder.AddPieceToBullpenController;
import control.builder.SaveController;
import entity.builder.IBuilderModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *Gui that appears when save level is selected
 * @author Drew
 *
 */
public class SaveGui extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterHere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveGui frame = new SaveGui(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param model 
	 */
	public SaveGui(IBuilderModel model) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNameYourFile = new JLabel("Name your File:");
		contentPane.add(lblNameYourFile);
		
		JButton btnSaveGuiAndQuit = new JButton("SaveGui \n and \n Quit");
		
		txtEnterHere = new JTextField();
		txtEnterHere.setText("Enter Here");
		contentPane.add(txtEnterHere);
		txtEnterHere.setColumns(10);
		contentPane.add(btnSaveGuiAndQuit);
	
	SaveController sVC = new SaveController(txtEnterHere, model);
	btnSaveGuiAndQuit.addActionListener(sVC);
	}
}
