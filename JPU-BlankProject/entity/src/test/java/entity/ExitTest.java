package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExitTest {

	private static Exit exit;
	private static Map map;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		exit = new Exit();
		exit.setSprite(new Sprite('E', "exit.png"));
		map = new Map(1,2, "E!P");
	}

	@Test
	public void testExit() {
		assertNotNull("Exit should be instantiated.", exit);
	}
	
	@Test
	public void testExitSprite() {
		assertTrue("Exit sprite should be diamond.png.", exit.getSprite().getImageName().equals("exit.png"));
	}
	
	@Test
	public void testExitPermeability() {
		assertTrue("Exit permeability should be blocking.", exit.getPermeability()==Permeability.BLOCKING);
	}

	@Test
	public void testDiamondCheckFalse() {
		assertFalse("Should return false when diamond number is smaller than 5.", exit.diamondCheck(2));
	}
	
	@Test
	public void testDiamondCheckTrue() {
		assertTrue("Should return false when diamond number is bigger than 5.", exit.diamondCheck(8));
	}

	@Test
	public void testPlayerCheck() {
		exit.playerCheck(map);
		assertTrue("Should detect the player.", exit.getExitReached());
	}

	@Test
	public void testGetExitReached() {
		assertFalse("Should return the right value of exitReached.", exit.getExitReached());
	}

}
