package boundary.builder;

import junit.framework.TestCase;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.MouseEvent;
//import javax.swing.JPanel;
//import javax.swing.SwingConstants;
//import javax.swing.border.EmptyBorder;
import Main.BuilderApplication;
import boundary.builder.*;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
import entity.builder.BuildableLightning;
import entity.builder.BuildablePuzzle;
import entity.builder.BuildableRelease;
import entity.player.ReleaseTile;
import entity.player.Tile;


public class BuilderBoundaryTests extends TestCase {


	
	public void testBuilderBoundry(){
		BuilderApplication game = new BuilderApplication(); //constructs the builder application
		game.main(null); //runs the game builder application
		
		BuildableLightning model = new BuildableLightning(); //constructs a buildable lightning model
		LightningBuilderGui lbg = new LightningBuilderGui(model); //constructs a lightning level GUI
		lbg.setVisible(true); //ensures GUI is run and displays
		
		BuildablePuzzle model2 = new BuildablePuzzle(); //constructs a buildable puzzle model
		PuzzleBuilderGui pbg = new PuzzleBuilderGui(model2); //constructs a puzzle level GUI
		pbg.setVisible(true); //ensures GUI is run and displays
		
		BuildableRelease model3 = new BuildableRelease(); //constructs a buildable release model
		ReleaseBuilderGui rbg = new ReleaseBuilderGui(model3); //constructs a release level GUI
		rbg.setVisible(true); //ensures GUI is run and displays
		
		/*ReleaseTile t = new ReleaseTile(1, 5, 3, Color.white);
		Tile tt[][] = {{t},{t,t}};
		BuilderBoardPanel bbp = new BuilderBoardPanel(null);
		Graphics offScreenGraphics = null;
		Graphics g = offScreenGraphics.getGraphics();
		bbp.drawReleaseBoard(tt, g);*/
		
		//Tests run to ensure the models are constructed properly and get methods are functioning
		assertEquals(model.getType(),"Lightning");
		assertEquals(model2.getType(),"Puzzle");
		assertEquals(model3.getType(),"Release");
	}
}