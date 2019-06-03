package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RockTest {

	private static Rock rock;
	private Map map;
	private String descriptionOfMap, descriptionOfMapAfterRefresh;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rock = new Rock();
	}

	@Before
	public void setUp() throws Exception {
		map = new Map(3,3,"BBB!BRB!BBB");
		descriptionOfMap="";
		descriptionOfMapAfterRefresh="";
	}

	@Test
	public void testRock() {
		assertNotNull("Constructor should instantiate a Rock.", rock);
	}

	@Test
	public void testPushedLeft() {
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((Rock)map.getEntity(1, 1)).pushedLeft(map);
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Rock should move left.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}

	@Test
	public void testPushedRight() {
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((Rock)map.getEntity(1, 1)).pushedRight(map);
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Rock should move right.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}

}
