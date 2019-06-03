package entity;
/**
 * Exit test
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExitTest {
	/**An exit */
	private static Exit exit;
	/** a Map */
	private static Map map;

	/** New exit and New map */
	@Before
	public void setUp() throws Exception {
		exit = new Exit();
		exit.setSprite(new Sprite('E', "exit.png"));
		map = new Map(1,2, "E!P");
	}
	/** Test exit existence */
	@Test
	public void testExit() {
		assertNotNull("Exit should be instantiated.", exit);
	}
	/** Sprite test */
	@Test
	public void testExitSprite() {
		assertTrue("Exit sprite should be diamond.png.", exit.getSprite().getImageName().equals("exit.png"));
	}
	/** Permeability test */
	@Test
	public void testExitPermeability() {
		assertTrue("Exit permeability should be blocking.", exit.getPermeability()==Permeability.BLOCKING);
	}
	/** Diamond check when false */
	@Test
	public void testDiamondCheckFalse() {
		assertFalse("Should return false when diamond number is smaller than 5.", exit.diamondCheck(2));
	}
	/** Diamond check when true */
	@Test
	public void testDiamondCheckTrue() {
		assertTrue("Should return false when diamond number is bigger than 5.", exit.diamondCheck(8));
	}
	/** Test if exit can detect the player  */
	@Test
	public void testPlayerCheck() {
		exit.playerCheck(map);
		assertTrue("Should detect the player.", exit.getExitReached());
	}
	/** Test if the player have reach the exit */
	@Test
	public void testGetExitReached() {
		assertFalse("Should return the right value of exitReached.", exit.getExitReached());
	}

}
