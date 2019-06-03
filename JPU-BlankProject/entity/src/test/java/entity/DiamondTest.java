package entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class DiamondTest {

	private static Diamond diamond;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		diamond = new Diamond();
	}

	@Test
	public void testDiamond() {
		assertNotNull("Constructor should instantiate a Diamond.", diamond);
	}
	
	@Test
	public void testDiamondSprite() {
		assertTrue("Diamond sprite should be diamond.png.",diamond.getSprite().getImageName().equals("diamond.png"));
	}
	
	@Test
	public void testDiamondPermeability() {
		assertTrue("Diamond permeability should be unblocking.", diamond.getPermeability()==Permeability.UNBLOCKING);
	}

}
