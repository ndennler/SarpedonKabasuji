package Main;

import java.awt.EventQueue;

import javax.swing.JButton;

import bounday.player.KabasujiMenuGui;
import bounday.player.LevelSelectGui;
import bounday.player.PlayerSplashScreen;
import entity.player.SarpedonKabasuji;


public class PlayerApplication {

	PlayerSplashScreen splashScreen = new PlayerSplashScreen();
	
	SarpedonKabasuji game = new SarpedonKabasuji();
	LevelSelectGui levelSelect = new LevelSelectGui(game);
	private KabasujiMenuGui menu = new KabasujiMenuGui(game);
	
	
	
	public PlayerApplication(){
	}
	

	public static void main(String[] args) {
		final PlayerApplication app = new PlayerApplication();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//show splash screen window
					app.splashScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			//wait three seconds
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//show main menu
		app.splashScreen.setVisible(false);
		app.splashScreen.dispose();
		app.menu.setVisible(true);
	}
}
