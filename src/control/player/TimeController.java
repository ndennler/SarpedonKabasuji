package control.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import bounday.player.EndLevelGui;
import bounday.player.LightningLevelGui;
import entity.player.LightningLevel;
import entity.player.SarpedonKabasuji;
/**
 * Decrements the time by one.
 * This will be executed by the timer every second.
 * 
 * @author Nathan
 *
 */
public class TimeController implements ActionListener {

	LightningLevel level;
	JLabel timeLeft;
	LightningLevelGui frame;
	SarpedonKabasuji game;

	/**
	 * Constructor for decrementing the timer.
	 * Note this is executed by the swing timer.
	 * 
	 * @param l - level that you are setting the time in.
	 * @param time - Label that displays the time.
	 */
	public TimeController(LightningLevel l, JLabel time, LightningLevelGui g, SarpedonKabasuji s) {
		level = l;
		timeLeft = time;
		frame  = g;
		game = s;
	}

	@Override
	/**
	 * Decrements timer if the time hasn't already run out.
	 * Also won't decrement time if the level has been completed with three stars.
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(level.getTimeLeft() > 0 && level.getStars() != 3 && frame.isVisible()){
			level.decrementTime();
			timeLeft.setText(level.getTimeLeft().toString());
		}
		if(level.getTimeLeft() == 0){
			level.decrementTime();
				if(level.getStars() > 0 && level.getNumber() == game.getCurrentLevel()){
					game.incrementLevel();
				}
				int currStars = level.getStars();
				int prevStars = game.getLevel(level.getNumber()).getStars();
				if(currStars >= prevStars){
					game.setLevel(level);
				}
				if (currStars> 0)
						new EndLevelGui(game, frame, true ).setVisible(true);
				else {
					new EndLevelGui(game, frame, false ).setVisible(true);
				}

		}
	}
}
