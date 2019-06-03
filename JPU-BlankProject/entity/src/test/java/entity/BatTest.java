package entity;
/**
 * Bat Test
 */
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class BatTest {
	/** Bat object */
	private static Bat bat;
	/** Variable mapBefore and mapAfter */
	private static Map mapBefore, mapAfter;
	/** Variable for comparaison */
	private static String descriptionOfMap ="", descriptionOfMap2="";
	/** New Bat */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bat = new Bat();
		mapBefore = new Map(3,3,"BBB!BCB!BBB");
		mapAfter = new Map(3,3,"BBB!BCB!BBB");
	}
	/** Movement test */
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
	/** Constructor test */
	@Test
	public void testBat() {
		assertNotNull("Constructor should instantiate a Bat.", bat);
	}
	/** Sprite test */
	@Test
	public void testBatSprite() {
		assertTrue("Bat sprite should be diamond.png.", bat.getSprite().getImageName().equals("bat.png"));
	}
	/** Permeability test */
	@Test
	public void testBatPermeability() {
		assertTrue("Bat permeability should be unblocking.", bat.getPermeability()==Permeability.UNBLOCKING);
	}

}
