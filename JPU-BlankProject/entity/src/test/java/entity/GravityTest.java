package entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GravityTest {

	private static Gravity gravity;
	private static Map mapBefore, mapAfter;
	private static String descriptionOfMap, descriptionOfMap2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gravity = new Rock();
	}

	@Before
	public void setUp() throws Exception {
		descriptionOfMap="";
		descriptionOfMap2="";
	}

	@Test
	public void testGravity() {
		assertNotNull("Should instantiate a gravity typed entity",gravity);
	}

	@Test
	public void testFall() {
		mapBefore = new Map(3,3,"BBB!BRB!BBB");
		mapAfter = new Map(3,3,"BBB!BRB!BBB");
		((Gravity)mapAfter.getEntity(1, 1)).fall(mapAfter);
		mapAfter.refresh();
		for(int x = 0; x<mapBefore.getWidth(); x++) {
			for(int y = 0; y<mapBefore.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+mapBefore.getEntity(x, y).getSprite().getConsoleImage();
				descriptionOfMap2 = descriptionOfMap2+mapAfter.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Fall should change the position of the gravity typed object on the map.", descriptionOfMap.equals(descriptionOfMap2));
	}

	@Test
	public void testKill() {
		mapBefore = new Map(3,3,"BRB!BBB!BPB");
		mapAfter = new Map(3,3,"BRB!BBB!BPB");
		int posY = 0;
		for(int i = 0; i<2; i++) { //Rock fall onto the player
			((Gravity)mapAfter.getEntity(1, posY)).fall(mapAfter);
			mapAfter.refresh();
			posY++;
		}
		for(int x = 0; x<mapBefore.getWidth(); x++) { //Translation of map in a string style
			for(int y = 0; y<mapBefore.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+mapBefore.getEntity(x, y).getSprite().getConsoleImage();
				descriptionOfMap2 = descriptionOfMap2+mapAfter.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Kill should erase the killable on the map.", descriptionOfMap.equals(descriptionOfMap2));
	}

}
