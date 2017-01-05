package entity.player;

import java.util.UUID;

import junit.framework.TestCase;
/**
 *  Tests for the entity.player.Tile class
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class TileTest extends TestCase {
	/** A arbitrary tile without an UUID */
	Tile testTileOrigin;
	
	/** A arbitrary tile with a UUID */
	UUID testUUIDa;
	Tile testTile11n9UUID;
	
	/** creates Tiles for testing */
	protected void setUp() throws Exception {
		testUUIDa = UUID.randomUUID();
		testTileOrigin = new Tile(0,0);
    	testTile11n9UUID = new Tile(11,9, testUUIDa);
    }
	
	/** tests the constructor by iterating over a feasible range of tile locations */
	public void testTileIntegerIntegerUUID() {
		UUID testUUID;
		for (int i = 0; i <= 11; i++){
			for (int j = 0; j <= 11; j++){
				testUUID = UUID.randomUUID();
				Tile testTile = new Tile(i,j, testUUID);
				assertTrue(testTile.col == j);
				assertTrue(testTile.row == i);
				assertTrue(testTile.coveredBy == testUUID);
			}
		}
	}
	
	/** tests the constructor by iterating over a feasible range of tile locations and UUIDs*/
	public void testTileIntegerInteger() {
		UUID testUUID;
		for (int i = 0; i <= 11; i++){
			for (int j = 0; j <= 11; j++){
				testUUID = UUID.randomUUID();
				Tile testTile = new Tile(i,j, null);
				assertTrue(testTile.col == j);
				assertTrue(testTile.row == i);
				assertTrue(testTile.coveredBy == null);
			}
		}
	}

	/** tests the getRow function by iterating over a selection of Tiles with feasible locations */
	public void testGetRow() {
		for (int i = 0; i <= 11; i++){
			for (int j = 0; j <= 11; j++){
				Tile testTile = new Tile(i,j, null);
				assertTrue(testTile.getRow() == i);
			}
		}
	}
	/** tests the getColumn function by iterating over a selection of Tiles with feasible locations */
	public void testGetColumn() {
		for (int i = 0; i <= 11; i++){
			for (int j = 0; j <= 11; j++){
				Tile testTile = new Tile(i,j, null);
				assertTrue(testTile.getColumn() == j);
			}
		}
	}
	/** tests the getCoveredBy function by checking a tile with a null UUID and iterating over 
	 * a selection of Tiles with feasible locations and UUIDs*/
	public void testGetCoveredBy() {
		UUID testUUID;
		for (int i = 0; i <= 11; i++){
			for (int j = 0; j <= 11; j++){
				testUUID = UUID.randomUUID();
				Tile testTile = new Tile(i,j, testUUID);
				assertTrue(testTile.getCoveredBy().equals(testUUID));
			}
		}
		assertTrue(testTileOrigin.getCoveredBy()==null);
	}
	/** tests setCoveredBy for changing to and from null */
	public void testSetCoveredBy() {
		UUID a = testTileOrigin.coveredBy;
		UUID b = testTile11n9UUID.coveredBy;
		//null to null
		testTileOrigin.setCoveredBy(null);
		assertTrue(testTileOrigin.coveredBy == null);
		//null to not null
		testTileOrigin.setCoveredBy(b);
		assertTrue(testTileOrigin.coveredBy.compareTo(b)==0);
		//not null to null
		testTile11n9UUID.setCoveredBy(null);
		assertTrue(testTile11n9UUID.coveredBy == null);
		// null to a new UUID
		UUID newUUID = UUID.randomUUID();
		testTile11n9UUID.setCoveredBy(newUUID);
		assertTrue(testTile11n9UUID.coveredBy.compareTo(newUUID) == 0);
	}
	/** tests the testOverTile function by iterating through a feasible range of locations and using the function */
	public void testOverTile() {
		//test the origin without a UUID
		for(int i = 0; i<=11; i++){
			for (int j = 0; j<=11; j++){
				if ((i==0) && (j==0)){
					assertTrue(testTileOrigin.overTile(i, j)); // the location of the tile
				} else {
					assertFalse(testTileOrigin.overTile(i, j)); // everywhere else
				}
			}
		}
		//test a tile with a UUID
		for(int i = 0; i<=11; i++){
			for (int j = 0; j<=11; j++){
				if ((i==11) && (j==9)){
					assertTrue(testTile11n9UUID.overTile(i, j)); // the location of the tile
				} else {
					assertFalse(testTile11n9UUID.overTile(i, j)); // everywhere else
				}
			}
		}
	}
}
