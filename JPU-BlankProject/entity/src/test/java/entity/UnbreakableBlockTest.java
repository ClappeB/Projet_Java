package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnbreakableBlockTest {

	private static UnbreakableBlock unbreakableBlock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		unbreakableBlock = new UnbreakableBlock();
	}

	@Before
	public void setUp() throws Exception {
	}

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
