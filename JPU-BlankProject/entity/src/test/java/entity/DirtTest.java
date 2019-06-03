package entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class DirtTest {
	
	private static Dirt dirt;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dirt = new Dirt();
	}

	@Test
	public void testDirt() {
		assertNotNull("Dirt constructor should instantiate a dirt.", dirt);
	}
	
	@Test
	public void testDirtSprite() {
		assertTrue("Dirt sprite should be diamond.png.", dirt.getSprite().getImageName().equals("dirt.png"));
	}
	
	@Test
	public void testDirtPermeability() {
		assertTrue("Dirt permeability should be unblocking.", dirt.getPermeability()==Permeability.UNBLOCKING);
	}
}
