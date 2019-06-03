package entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class BatTest {

	private static Bat bat;
	private static Map mapBefore, mapAfter;
	private static String descriptionOfMap ="", descriptionOfMap2="";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bat = new Bat();
		mapBefore = new Map(3,3,"BBB!BCB!BBB");
		mapAfter = new Map(3,3,"BBB!BCB!BBB");
	}

	@Test
	public void testBehaviour() {
		((Bat)mapAfter.getEntity(1, 1)).behaviour(mapAfter);
		mapAfter.refresh();
		for(int x = 0; x<mapBefore.getWidth(); x++) {
			for(int y = 0; y<mapBefore.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+mapBefore.getEntity(x, y).getSprite().getConsoleImage();
				descriptionOfMap2 = descriptionOfMap2+mapAfter.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Behaviour should change the position of the Bat on the map.", descriptionOfMap.equals(descriptionOfMap2));
	}

	@Test
	public void testBat() {
		assertNotNull("Constructor should instantiate a Bat.", bat);
	}

}
