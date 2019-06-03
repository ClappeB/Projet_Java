package entity;
/**
 * MotionLessElements Test
 */
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class MotionLessElementsTest {
	/** A MotionLessElements entity*/
	private static MotionLessElements motionlessElements;
	
	/** New Dirt */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		motionlessElements = new Dirt();
	}

	/** Test the MotionLessElements existence*/
	@Test
	public void testMotionLessElements() {
		assertNotNull("Should instantiate a motionless element.", motionlessElements);
	}

}
