package entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class KillableTest {

	private Killable killable;
	
	@Before
	public void setUp() throws Exception {
		killable = new Player(); //Arbitrary choice
	}

	@Test
	public void testKillable() {
		assertNotNull("Constructor should instantiate a killable typed entity.", killable);
	}

	@Test
	public void testIsAlive() {
		assertTrue("Should return the right value of isAlive.", killable.isAlive());
	}

	@Test
	public void testSetIsAlive() {
		killable.setIsAlive(false);
		assertFalse("Should change the isAlive state.", killable.isAlive());
	}

}
