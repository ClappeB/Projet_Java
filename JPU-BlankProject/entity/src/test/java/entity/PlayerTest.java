package entity;
/**
 * Player Test
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
	/** a Player */
	private static Player player;
	/** a Map */
	private static Map map;
	
	/** New map */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map = new Map(3,3,"BBB!BPB!BBB");
	}

	/** New player */
	@Before
	public void setUp() throws Exception {
		player = new Player();
	}

	/** Test player existence */
	@Test
	public void testPlayer() {
		assertNotNull("Constructor should instantiate a Player.", player);
	}
	
	/** Sprite test */
	@Test
	public void testPlayerSprite() {
		assertTrue("Player sprite should be face1.png.", player.getSprite().getImageName().equals("face1.png"));
	}
	/** Permeability test */
	@Test
	public void testPlayerPermeability() {
		assertTrue("Player permeability should be unblocking.", player.getPermeability()==Permeability.UNBLOCKING);
	}
	/**  Test the get diamong */
	@Test
	public void testGetDiamondNumber() {
		assertEquals("Should return the right number of diamonds.", 0, player.getDiamondNumber());
	}
	/** Test set diamond number */
	@Test
	public void testSetDiamondNumber() {
		player.setDiamondNumber(4);
		assertEquals("Should set the right diamond number.", 4, player.getDiamondNumber());
	}

	/** Test player detects monster */
	@Test
	public void testCheckMonster() {
		assertTrue("Player shouldn't detect monsters.", player.isAlive());
		map = new Map(3,3,"BBB!OPB!BBB");
		((Player)map.getEntity(1, 1)).checkMonster(map);
		assertFalse("Player should detect monsters.", ((Player)map.getEntity(1, 1)).isAlive());
	}

}
