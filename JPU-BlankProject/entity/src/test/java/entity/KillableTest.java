package entity;
/**
 * Killable test 
 */
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class KillableTest {
	/** Killable entity */
	private Killable killable; 
	
	/** New player */ 
	@Before
	public void setUp() throws Exception {
		killable = new Player(); //Arbitrary choice
	}
	/** Test that the entity is killable*/ 
	@Test
	public void testKillable() {
		assertNotNull("Constructor should instantiate a killable typed entity.", killable);
	}
	/** Test that the entity is Alive */
	@Test
	public void testIsAlive() {
		assertTrue("Should return the right value of isAlive.", killable.isAlive());
	}
	/** Test of the set */
	@Test
	public void testSetIsAlive() {
		killable.setIsAlive(false);
		assertFalse("Should change the isAlive state.", killable.isAlive());
		killable.setIsAlive(true);
		assertTrue("Should change the isAlive state.", killable.isAlive());
	}

}
