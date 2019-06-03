package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BackgroundDirtTest {

	private static BackgroundDirt backgroundDirt;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		backgroundDirt = new BackgroundDirt();
	}

	@Test
	public void testBackgroundDirt() {
		assertNotNull("Constructor must instanciate a BackgroundDirt.", backgroundDirt);
	}

}
