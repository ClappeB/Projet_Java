package entity;
/**
 * Diamond test
 */
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class DiamondTest {
	/** Diamond object */
	private static Diamond diamond;
	/** New diamond */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		diamond = new Diamond();
	}
	/** Constuctor test */
	@Test
	public void testDiamond() {
		assertNotNull("Constructor should instantiate a Diamond.", diamond);
	}
	/** Sprite test */
	@Test
	public void testDiamondSprite() {
		assertTrue("Diamond sprite should be diamond.png.",diamond.getSprite().getImageName().equals("diamond.png"));
	}
	/** Permeability test */
	@Test
	public void testDiamondPermeability() {
		assertTrue("Diamond permeability should be unblocking.", diamond.getPermeability()==Permeability.UNBLOCKING);
	}

}
