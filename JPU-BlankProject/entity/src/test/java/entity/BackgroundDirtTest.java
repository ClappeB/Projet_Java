package entity;
/**
 * BackgroundDirt Test
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/** Background object */
public class BackgroundDirtTest {
	
	private static BackgroundDirt backgroundDirt;
	/** New BackGround Dirt*/
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		backgroundDirt = new BackgroundDirt();
	}
	/** Test Constructor*/
	@Test
	public void testBackgroundDirt() {
		assertNotNull("Constructor must instanciate a BackgroundDirt.", backgroundDirt);
	}

}
