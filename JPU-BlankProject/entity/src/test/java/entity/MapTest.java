package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.exceptions.OutOfMapException;

public class MapTest {

	private static Map map;
	private static int width, height;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		width = 3;
		height = 3;
	}

	@Before
	public void setUp() throws Exception {
		map = new Map(width, height,".BB!BRB!BBB");
	}

	@Test
	public void testMap() {
		assertNotNull("Should instantiate a Map.", map);
	}

	@Test
	public void testGetEntity() {
		assertTrue("Should return an entity.", map.getEntity(0, 0) instanceof Entity);
		assertTrue("Should return the right entity.", map.getEntity(0, 0) instanceof Dirt);
	}
	
	@Test(expected = OutOfMapException.class)
	public void testGetEntityOutOfTheMap() {
		map.getEntity(-50, 0);
		map.getEntity(0,890);
		fail("Map should return an exception when trying to getting an entity out of the map.");
	}

	@Test
	public void testGetHeight() {
		assertEquals("Should return the right value of the map's height.", height, map.getHeight());
	}

	@Test
	public void testGetWidth() {
		assertEquals("Should return the right value of the map's height.", height, map.getWidth());
	}

	@Test
	public void testRefresh() {
		String descriptionOfMap="", descriptionOfMapAfterRefresh="";
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		map.changeEntityPosition(map.getEntity(0, 0), map.getEntity(1, 1));
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Refresh method should refresh the map and move entities on it.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}

	@Test
	public void testChangeEntityPosition() {
		String descriptionOfMap="", descriptionOfMapAfterRefresh="";
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		map.changeEntityPosition(map.getEntity(0, 0), map.getEntity(1, 0));
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Should change the entity positions on the map.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}

	@Test
	public void testGetEntityList() {
		assertTrue("Should return a list.", map.getEntityList() instanceof List);
	}

	@Test
	public void testReplaceEntityByBackgroundDirtOrDiamond() {
		map.replaceEntityByBackgroundDirtOrDiamond(map.getEntity(0, 0), "Diamond");
		assertTrue("Should replace an entity.", map.getEntity(0, 0) instanceof Diamond);
	}

}
