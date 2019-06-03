package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {

	private static Player player;
	private static Map map;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map = new Map(3,3,"BBB!BPB!BBB");
	}

	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.setPosX(1);
		player.setPosY(1);
	}

	@Test
	public void testPlayer() {
		assertNotNull("Constructor should instantiate a Player.", player);
	}
	
	@Test
	public void testPlayerSprite() {
		assertTrue("Player sprite should be face1.png.", player.getSprite().getImageName().equals("face1.png"));
	}
	/** Permeability test */
	@Test
	public void testPlayerPermeability() {
		assertTrue("Player permeability should be unblocking.", player.getPermeability()==Permeability.UNBLOCKING);
	}
	
	@Test
	public void testGetDiamondNumber() {
		assertEquals("Should return the right number of diamonds.", 0, player.getDiamondNumber());
	}

	@Test
	public void testSetDiamondNumber() {
		player.setDiamondNumber(4);
		assertEquals("Should set the right diamond number.", 4, player.getDiamondNumber());
	}

	@Test
	public void testCheckMonster() {
		assertTrue("Player shouldn't detect monsters.", player.isAlive());
		map = new Map(3,3,"BBB!OPB!BBB");
		player.checkMonster(map);
		assertFalse("Player should detect monsters.", player.isAlive());
	}

}
