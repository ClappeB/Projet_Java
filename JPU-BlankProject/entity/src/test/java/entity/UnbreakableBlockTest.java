package entity;
/**
 * UnbreakableBlock Test
 */
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class UnbreakableBlockTest {
	/** An unbreakableBlock  */
	private static UnbreakableBlock unbreakableBlock;
	
	/** New unbreakableBlock */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		unbreakableBlock = new UnbreakableBlock();
	}

	/** Test UnbreakableBlock existence */
	@Test
	public void testUnbreakableBlock() {
		assertNotNull("Constructor should instantiate an Unbreakablelock.", unbreakableBlock);
	}
	/** Sprite test */
	@Test
	public void testBatSprite() {
		assertTrue("Unbreakablelock sprite should be unbreakableBlock.png.", unbreakableBlock.getSprite().getImageName().equals("unbreakableBlock.png"));
	}
	/** Permeability test */
	@Test
	public void testBatPermeability() {
		assertTrue("Unbreakablelock permeability should be blocking.", unbreakableBlock.getPermeability()==Permeability.BLOCKING);
	}

}
