package entity.player;

import java.util.ArrayList;
import java.util.UUID;
import java.awt.Color;

import junit.framework.TestCase;
/**
 * Tests for the player.entity ReleaseTile class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class ReleaseTileTest extends TestCase {
	/** A arbitrary tile without an UUID */
	ReleaseTile testTileOrigin;
	
	/** A arbitrary tile with a UUID */
	UUID testUUIDa;
	ReleaseTile testTile11n9UUID;
	
	/** creates Tiles for testing */
	protected void setUp() throws Exception {
		testUUIDa = UUID.randomUUID();
		testTileOrigin = new ReleaseTile(0,0,1, Color.BLUE);
    	testTile11n9UUID = new ReleaseTile(11,9,testUUIDa, 3, Color.RED);
    }
	
	public void testGetNumber() {
		assertTrue(testTileOrigin.rnumber == testTileOrigin.getNumber());
		assertTrue(testTile11n9UUID.rnumber == testTile11n9UUID.getNumber());
	}
	
	public void testSetNumber(){
		assertTrue(testTileOrigin.rnumber == 1);
		testTileOrigin.setNumber(5);
		assertTrue(testTileOrigin.rnumber == 5);
		testTileOrigin.setNumber(1);
		assertTrue(testTileOrigin.rnumber == 1);
	}

	public void testGetColor() {
		assertTrue(testTileOrigin.rcolor == testTileOrigin.getColor());
		assertTrue(testTile11n9UUID.rcolor == testTile11n9UUID.getColor());
	}

	public void testSetColor(){
		assertTrue(testTileOrigin.rcolor.equals(Color.BLUE));
		testTileOrigin.setColor("Blue");
		assertTrue(testTileOrigin.rcolor.equals(Color.BLUE));
		testTileOrigin.setColor("Red");
		assertTrue(testTileOrigin.rcolor.equals(Color.RED));
		testTileOrigin.setColor("Green");
		assertTrue(testTileOrigin.rcolor.equals(Color.GREEN));
		testTileOrigin.setColor("Aqua");
		assertTrue(testTileOrigin.rcolor == null);
	}

	public void testReleaseTile() {
		ArrayList<Color> colorArray = new ArrayList<Color>();
		colorArray.add(Color.BLUE);
		colorArray.add(Color.RED);
		colorArray.add(Color.GREEN);
		UUID testUUID;
		for (int i = 0; i <= 11; i++){
			for (int j = 0; j <= 11; j++){
				for (int k = 1; k <=6; k++){
					for(Color c: colorArray){
						testUUID = UUID.randomUUID();
						ReleaseTile testTile = new ReleaseTile(i,j, testUUID, k, c);
						assertTrue(testTile.col == j);
						assertTrue(testTile.row == i);
						assertTrue(testTile.coveredBy == testUUID);
						assertTrue(testTile.rnumber == k);
						assertTrue(testTile.rcolor == c);
					}
				}
			}
		}
	}

}
