package entity;
/**
 * MobileElements test 
 */
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MobileElementsTest {
	/** A map */
	private static Map map;
	/** An object who can move */
	private static MobileElements mobileElements;
	/** Variable for comparaison */
	private String descriptionOfMap, descriptionOfMapAfterRefresh;
	
	/** New rock */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mobileElements = new Rock();
	}

	/** New map and reset of the description*/
	@Before
	public void setUp() throws Exception {
		map = new Map(3,3,"BBB!BOB!BBB");
		descriptionOfMap="";
		descriptionOfMapAfterRefresh="";
	}

	/** Constructor Test */
	@Test
	public void testMobileElements() {
		assertNotNull("Constructor should instantiate a mobile element.", mobileElements);
	}
	
	/** Movement test Go Up */
	@Test
	public void testGoUp() {
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((MobileElements)map.getEntity(1, 1)).goUp(map);
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Should make the mobile element going up on the map.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}
	/** Movement test Go Down*/
	@Test
	public void testGoDown() {
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((MobileElements)map.getEntity(1, 1)).goDown(map);
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Should make the mobile element going down on the map.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}
	/** Movement test Go Left */
	@Test
	public void testGoLeft() {
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((MobileElements)map.getEntity(1, 1)).goLeft(map);
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Should make the mobile element going left on the map.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}
	/** Movement test Go Right*/
	@Test
	public void testGoRight() {
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((MobileElements)map.getEntity(1, 1)).goRight(map);
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Should make the mobile element going right on the map.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}

}
