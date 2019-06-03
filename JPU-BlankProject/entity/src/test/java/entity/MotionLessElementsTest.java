package entity;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class MotionLessElementsTest {

	private static MotionLessElements motionlessElements;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		motionlessElements = new Dirt();
	}

	@Test
	public void testMotionLessElements() {
		assertNotNull("Should instantiate a motionless element.", motionlessElements);
	}

}
