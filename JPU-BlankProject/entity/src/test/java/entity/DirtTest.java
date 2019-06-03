package entity;
/**
 * Dirt test
 */
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class DirtTest {
	/** Dirt object */
	private static Dirt dirt;
	/** New Dirt */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dirt = new Dirt();
	}
	/** Constructor test */
	@Test
	public void testDirt() {
		assertNotNull("Dirt constructor should instantiate a dirt.", dirt);
	}
	/** Sprite test */
	@Test
	public void testDirtSprite() {
		assertTrue("Dirt sprite should be diamond.png.", dirt.getSprite().getImageName().equals("dirt.png"));
	}
	/** Permeability test */
	@Test
	public void testDirtPermeability() {
		assertTrue("Dirt permeability should be unblocking.", dirt.getPermeability()==Permeability.UNBLOCKING);
	}
}
