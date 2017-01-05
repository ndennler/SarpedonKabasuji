package control.player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import entity.player.Level;
import entity.player.LevelMomento;
import entity.player.LightningLevel;
import entity.player.PuzzleLevel;
import entity.player.ReleaseLevel;
/**
 * Allows the loading of a level into the player 
 * @author Drew
 *
 */
public class Loader {
	/**
	 * Constructor for Loader
	 */
public Loader()
{
	
}
/**
 * 
 *Takes in a level number and returns the correct level
 */
public Level getLevel (int x) 
{
	FileInputStream saveFile;
	try {
		saveFile = new FileInputStream("Level" + x +".ext");

		ObjectInputStream restore = new ObjectInputStream(saveFile);
		LevelMomento obj = (LevelMomento) restore.readObject();
		restore.close();
		Level level = null;
		String type = obj.getType();
		if(type.equals("Release")){
			ReleaseLevel rlevel = new ReleaseLevel();
			rlevel.restore(obj);
			rlevel.setNumber(x);
			return rlevel;

		}
		if(type.equals("Lightning")){
			LightningLevel llevel = new LightningLevel();
			llevel.restore(obj);
			llevel.setNumber(x);
			return llevel;
		}
		if(type.equals("Puzzle")){
			PuzzleLevel plevel = new PuzzleLevel();
			plevel.restore(obj);
			plevel.setNumber(x);
			return plevel;
		}
		return level;

	} catch (Exception e) {
		System.err.println("There is no Level " + x + " saved." );
	}
	return null;
}
/**
 * Takes in a level number and returns the correct level momento
 * @param x - level number
 * @return correct level momento
 */
public LevelMomento getMomento(int x){
	FileInputStream saveFile;
	try {
		saveFile = new FileInputStream("Level" + x +".ext");

		ObjectInputStream restore = new ObjectInputStream(saveFile);
		LevelMomento obj = (LevelMomento) restore.readObject();
		restore.close();
		obj.setNumber(x);
		return obj;
	} catch (Exception e) {
		System.err.println("There is no Level " + x + " saved." );
	}
	return null;
}
}
