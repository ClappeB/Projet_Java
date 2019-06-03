package entity;
/**
 * Octopus Test
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OctopusTest {
	/** A Map */
	private static Map map;
	/** An octopus */
	private static Octopus octopus;
	
	/**New octopus and new map */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		octopus = new Octopus();
		map = new Map(3,3,"BBB!BOB!BBB");
	}

	
	/** Movement test */
	@Test
	public void testBehaviour() {
		String descriptionOfMap="", descriptionOfMapAfterRefresh="";
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMap = descriptionOfMap+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		((Monster)map.getEntity(1, 1)).behaviour(map);
		map.refresh();
		for(int x = 0; x<map.getWidth(); x++) {
			for(int y = 0; y<map.getHeight();y++) {
				descriptionOfMapAfterRefresh = descriptionOfMapAfterRefresh+map.getEntity(x, y).getSprite().getConsoleImage();
			}
		}
		assertFalse("Monster should move.", descriptionOfMap.equals(descriptionOfMapAfterRefresh));
	}
	/** Constructor test */
	@Test
	public void testOctopus() {
		assertNotNull("Constructor should instantiate a Octopus.", octopus);
	}
	/** Sprite test */
	@Test
	public void testBatSprite() {
		assertTrue("Octopus sprite should be octopus.png.", octopus.getSprite().getImageName().equals("octopus.png"));
	}
	
	/** Permeability test */
	@Test
	public void testBatPermeability() {
		assertTrue("Octopus permeability should be unblocking.", octopus.getPermeability()==Permeability.UNBLOCKING);
	}
}
