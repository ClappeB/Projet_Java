package entity;
/**
 * Map Test
 */
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
	/** a Map */
	private static Map map;
	/** Map's attribute*/
	private static int width, height;
	
	/** Set the map's atribute */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		width = 3;
		height = 3;
	}

	/** New Map */
	@Before
	public void setUp() throws Exception {
		map = new Map(width, height,".BB!BRB!BBB");
	}
	
	/** Test map existence */
	@Test
	public void testMap() {
		assertNotNull("Should instantiate a Map.", map);
	}

	/** Test entity presence */
	@Test
	public void testGetEntity() {
		assertTrue("Should return an entity.", map.getEntity(0, 0) instanceof Entity);
		assertTrue("Should return the right entity.", map.getEntity(0, 0) instanceof Dirt);
	}
	
	/** Out of the map exception */
	@Test(expected = OutOfMapException.class)
	public void testGetEntityOutOfTheMap() {
		map.getEntity(-50, 0);
		map.getEntity(0,890);
		fail("Map should return an exception when trying to getting an entity out of the map.");
	}
	/** Test the get of the Height */
	@Test
	public void testGetHeight() {
		assertEquals("Should return the right value of the map's height.", height, map.getHeight());
	}
	/** Test the get of the width */
	@Test
	public void testGetWidth() {
		assertEquals("Should return the right value of the map's height.", height, map.getWidth());
	}
	/** Test the map refresh */
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
	/** Test the entity changement of position*/
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
	/** Test the get of the list of entities on the map */
	@Test
	public void testGetEntityList() {
		assertTrue("Should return a list.", map.getEntityList() instanceof List);
	}
	/** Test the replacement of the BackGroundDirt by Diamond */
	@Test
	public void testReplaceEntityByBackgroundDirtOrDiamond() {
		map.replaceEntityByBackgroundDirtOrDiamond(map.getEntity(0, 0), "Diamond");
		assertTrue("Should replace an entity.", map.getEntity(0, 0) instanceof Diamond);
	}

}
