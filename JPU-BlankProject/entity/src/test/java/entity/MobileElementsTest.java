package entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MobileElementsTest {

	private static Map map;
	private static MobileElements mobileElements;
	private String descriptionOfMap, descriptionOfMapAfterRefresh;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mobileElements = new Rock();
	}

	@Before
	public void setUp() throws Exception {
		map = new Map(3,3,"BBB!BOB!BBB");
		descriptionOfMap="";
		descriptionOfMapAfterRefresh="";
	}

	@Test
	public void testMobileElements() {
		assertNotNull("Constructor should instantiate a mobile element.", mobileElements);
	}

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
